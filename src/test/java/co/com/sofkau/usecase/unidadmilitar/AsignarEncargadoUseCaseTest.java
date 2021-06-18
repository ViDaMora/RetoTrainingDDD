package co.com.sofkau.usecase.unidadmilitar;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;
import co.com.sofkau.unidadmilitar.commands.AsignarEncargado;
import co.com.sofkau.unidadmilitar.entitys.armamento.Armamento;
import co.com.sofkau.unidadmilitar.entitys.armamento.ArmamentoId;
import co.com.sofkau.unidadmilitar.entitys.militar.Militar;
import co.com.sofkau.unidadmilitar.entitys.militar.MilitarId;
import co.com.sofkau.unidadmilitar.entitys.vehiculo.Vehiculo;
import co.com.sofkau.unidadmilitar.entitys.vehiculo.VehiculoId;
import co.com.sofkau.unidadmilitar.events.EncargadoAsignado;
import co.com.sofkau.unidadmilitar.events.UnidadMilitarCreada;
import co.com.sofkau.unidadmilitar.values.*;
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

class AsignarEncargadoUseCaseTest {

    private AsignarEncargadoUseCase asignarEncargadoUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        asignarEncargadoUseCase = new AsignarEncargadoUseCase();
        repository=mock(DomainEventRepository.class);
        asignarEncargadoUseCase.addRepository(repository);
    }

    @Test
    void AsignarEncargadoCorrectamente(){
        //arrage
        var command = new AsignarEncargado(UnidadMilitarId.of("999"),MilitarId.of("123"),
                new Nombre("victor"),new Nacionalidad("Colombiano"),
                new Edad(19),new Autoridad("General"), new Genero('M'));

        when(repository.getEventsBy(any())).thenReturn(eventsAsignarEncargado());

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("999")
                .syncExecutor(asignarEncargadoUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        //assert
        EncargadoAsignado encargadoAsignado = (EncargadoAsignado) events.get(0);
        Assertions.assertEquals("victor",encargadoAsignado.nombre().value() );
        Assertions.assertEquals("sofkau.unidadmilitar.encargadoasignado", encargadoAsignado.type);

    }

    private List<DomainEvent> eventsAsignarEncargado() {
        Set<Militar> militares = new HashSet<Militar>();
        militares.add(new Militar(MilitarId.of("primero"),new Nombre("Victor Mora"),new Nacionalidad("Colombiano"),
                new Edad(19),new Autoridad("General"), new Genero('M')));
        Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();
        vehiculos.add(new Vehiculo(new VehiculoId().of("154"),new TipoVehiculo("Camion"), new Proposito("Desplazamiento")));
        Set<Armamento> armamentos = new HashSet<Armamento>();
        armamentos.add(new Armamento(new ArmamentoId(),new TipoArma("rifle") ));
        Militar encargado = new Militar(MilitarId.of("segundo"),new Nombre("Alejandro"),new Nacionalidad("Colombiano"),
                new Edad(30),new Autoridad("cabo"), new Genero('M'));


        return List.of(new UnidadMilitarCreada(new TipoUnidad("maritimo"),
                militares,vehiculos,armamentos,encargado));
    }

}


