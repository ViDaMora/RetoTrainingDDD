package co.com.sofkau.usecase.operacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.operacion.OperacionId;
import co.com.sofkau.operacion.commands.AsignarLider;
import co.com.sofkau.operacion.commands.AsignarUnidadMilitar;
import co.com.sofkau.operacion.events.UnidadMilitarAsignada;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;
import co.com.sofkau.unidadmilitar.entitys.armamento.Armamento;
import co.com.sofkau.unidadmilitar.entitys.armamento.ArmamentoId;
import co.com.sofkau.unidadmilitar.entitys.militar.Militar;
import co.com.sofkau.unidadmilitar.entitys.militar.MilitarId;
import co.com.sofkau.unidadmilitar.entitys.vehiculo.Vehiculo;
import co.com.sofkau.unidadmilitar.entitys.vehiculo.VehiculoId;
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

class AsignarUnidadCaseUseTest {

    private AsignarUnidadCaseUse asignarUnidadCaseUse;
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        asignarUnidadCaseUse = new AsignarUnidadCaseUse();
        repository=mock(DomainEventRepository.class);
        asignarUnidadCaseUse.addRepository(repository);
    }

    @Test
    void ActualizarTipoUnidadCorrectamente(){
        //arrage
        var command = new AsignarUnidadMilitar(OperacionId.of("50"), UnidadMilitarId.of("2"));

        when(repository.getEventsBy(any())).thenReturn(eventsUnidadMilitarAsignada());

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("50")
                .syncExecutor(asignarUnidadCaseUse,new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        //Assert
        UnidadMilitarAsignada asignadaUnidadMilitarUseCase = (UnidadMilitarAsignada) events.get(0);
        Assertions.assertEquals("sofkau.operacion.unidadmilitarasignada",asignadaUnidadMilitarUseCase.type);

    }

    private List<DomainEvent> eventsUnidadMilitarAsignada() {

        Set<Militar> militares = new HashSet<Militar>();
        militares.add(new Militar(MilitarId.of("primero"),new Nombre("Victor Mora"),new Nacionalidad("Colombiano"),
                new Edad(19),new Autoridad("General"), new Genero('M')));
        Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();
        vehiculos.add(new Vehiculo(new VehiculoId().of("154"),new TipoVehiculo("Camion"), new Proposito("Desplazamiento")));
        Set<Armamento> armamentos = new HashSet<Armamento>();
        armamentos.add(new Armamento(new ArmamentoId(),new TipoArma("rifle") ));
        Militar encargado = new Militar(MilitarId.of("segundo"),new Nombre("Alejandro"),new Nacionalidad("Colombiano"),
                new Edad(30),new Autoridad("cabo"), new Genero('M'));


        return List.of(new UnidadMilitarCreada(new TipoUnidad("terrestre"),
                militares,vehiculos,armamentos,encargado));
    }
}