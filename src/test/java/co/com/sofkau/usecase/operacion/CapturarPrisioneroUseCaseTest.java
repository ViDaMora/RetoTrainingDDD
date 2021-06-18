package co.com.sofkau.usecase.operacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.operacion.OperacionId;
import co.com.sofkau.operacion.commands.CapturarPrisionero;
import co.com.sofkau.operacion.entitys.lider.Lider;
import co.com.sofkau.operacion.entitys.lider.LiderId;
import co.com.sofkau.operacion.entitys.prisionero.Prisionero;
import co.com.sofkau.operacion.entitys.prisionero.PrisioneroId;
import co.com.sofkau.operacion.entitys.values.*;
import co.com.sofkau.operacion.events.OperacionCreada;
import co.com.sofkau.operacion.events.PrisioneroCapturado;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CapturarPrisioneroUseCaseTest {

    private CapturarPrisioneroUseCase capturarPrisioneroUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        capturarPrisioneroUseCase = new CapturarPrisioneroUseCase();
        repository = mock(DomainEventRepository.class);
        capturarPrisioneroUseCase.addRepository(repository);
    }


    @Test
    void CapturarPrisioneroCorrectamente(){
        //Arage
        var command = new CapturarPrisionero(OperacionId.of("123"), PrisioneroId.of("1"),new Nombre("Jaimito"),
                new Nacionalidad("Colombiano"),new EdadPrisionero(40),new Genero('H'));

        when(repository.getEventsBy(any())).thenReturn(eventPrisioneroAsignado());

        //act
        var response= UseCaseHandler.getInstance()
                .setIdentifyExecutor(("123"))
                .syncExecutor(capturarPrisioneroUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        //Assert
        PrisioneroCapturado prisioneroCapturado = (PrisioneroCapturado) events.get(0);
        Assertions.assertEquals("sofkau.operacion.prisionerocapturado",prisioneroCapturado.type);
        Assertions.assertEquals("Jaimito", prisioneroCapturado.nombre().value());
        Assertions.assertEquals(40,prisioneroCapturado.edad().value());

    }

    private List<DomainEvent> eventPrisioneroAsignado() {

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