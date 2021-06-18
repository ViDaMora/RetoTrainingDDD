package co.com.sofkau.usecase.operacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.operacion.OperacionId;
import co.com.sofkau.operacion.commands.ActualizarDescripcion;
import co.com.sofkau.operacion.entitys.lider.Lider;
import co.com.sofkau.operacion.entitys.lider.LiderId;
import co.com.sofkau.operacion.entitys.prisionero.Prisionero;
import co.com.sofkau.operacion.entitys.prisionero.PrisioneroId;
import co.com.sofkau.operacion.entitys.values.*;
import co.com.sofkau.operacion.events.DescripcionActualizada;
import co.com.sofkau.operacion.events.OperacionCreada;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ActualizarDescripcionUseCaseTest {

    private ActualizarDescripcionUseCase actualizarDescripcionUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        actualizarDescripcionUseCase= new ActualizarDescripcionUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarDescripcionUseCase.addRepository(repository);
    }
    @Test
    void ActualizarDescripcionCorrectamente(){
        //arrage
        var command = new ActualizarDescripcion(OperacionId.of("125"),new Descripcion("Operacion aerea que busca acabar con el enemigo"));

        when(repository.getEventsBy(any())).thenReturn(eventsDescripcionActualizado());

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("123")
                .syncExecutor(actualizarDescripcionUseCase,new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        //assert

        DescripcionActualizada actualizarDescripcionUseCase = (DescripcionActualizada) events.get(0);
        Assertions.assertEquals("sofkau.operacion.descripcionactualizada",actualizarDescripcionUseCase.type);
        Assertions.assertEquals("Operacion aerea que busca acabar con el enemigo",actualizarDescripcionUseCase.descripcion().value());
    }

    private List<DomainEvent> eventsDescripcionActualizado() {
        Set<UnidadMilitarId> unidadesMilitares = new HashSet<>();
        unidadesMilitares.add(UnidadMilitarId.of("32"));
        Lider lider = new Lider(LiderId.of("123"),new Nombre("Victor"),new Nacionalidad("Colombiano"),
                new Edad(35),new Autoridad("General"),new Genero('M'));
        Set<Prisionero> prisioneros = new HashSet<>();
        Prisionero prisionero = new Prisionero(PrisioneroId.of("45"),new Nombre("Juan Fernando"),
                new Nacionalidad("Colombiano"),new EdadPrisionero(50),new Genero('M'));

        return  List.of(new OperacionCreada(unidadesMilitares,lider, new Descripcion("Control de microtrafico"),
                new Region("Valle"),new Pais("Colombia"),new Nombre("Operacion angel caido"),
                prisioneros));
    }


}