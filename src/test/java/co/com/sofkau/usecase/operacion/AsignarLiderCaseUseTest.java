package co.com.sofkau.usecase.operacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.operacion.OperacionId;
import co.com.sofkau.operacion.commands.AsignarLider;
import co.com.sofkau.operacion.entitys.lider.Lider;
import co.com.sofkau.operacion.entitys.lider.LiderId;
import co.com.sofkau.operacion.entitys.prisionero.Prisionero;
import co.com.sofkau.operacion.entitys.prisionero.PrisioneroId;
import co.com.sofkau.operacion.entitys.values.*;
import co.com.sofkau.operacion.events.LiderAsignado;
import co.com.sofkau.operacion.events.OperacionCreada;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;
import co.com.sofkau.usecase.unidadmilitar.ActualizarTipoUnidadUseCase;
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

class AsignarLiderCaseUseTest {

    private AsignarLiderCaseUse asignarLiderCaseUse;
    private DomainEventRepository repository;


    @BeforeEach
    public void setUp(){
        asignarLiderCaseUse = new AsignarLiderCaseUse();
        repository=mock(DomainEventRepository.class);
        asignarLiderCaseUse.addRepository(repository);
    }



    @Test
    void ActualizarTipoUnidadCorrectamente() {
        //arrage
        var command = new AsignarLider(OperacionId.of("1"), LiderId.of("12"), new Nombre("Juan Jose"), new Nacionalidad("Argentino"),
                new Edad(50), new Autoridad("Comandante"), new Genero('M'));

                when(repository.getEventsBy(any())).thenReturn(eventsLiderAsignado());

         //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(asignarLiderCaseUse,new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        //Assert

        LiderAsignado asignarLiderUseCase = (LiderAsignado) events.get(0);
        Assertions.assertEquals("sofkau.operacion.liderasignado",asignarLiderUseCase.type);
        Assertions.assertEquals("Argentino",asignarLiderUseCase.nacionalidad().value());
        Assertions.assertEquals("Juan Jose",asignarLiderUseCase.nombre().value());

    }

    private List<DomainEvent> eventsLiderAsignado() {

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