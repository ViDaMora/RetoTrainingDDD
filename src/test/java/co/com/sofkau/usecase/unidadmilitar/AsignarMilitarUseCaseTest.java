package co.com.sofkau.usecase.unidadmilitar;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.operacion.commands.AsignarUnidadMilitar;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;
import co.com.sofkau.unidadmilitar.commands.AsignarMilitar;
import co.com.sofkau.unidadmilitar.entitys.armamento.Armamento;
import co.com.sofkau.unidadmilitar.entitys.armamento.ArmamentoId;
import co.com.sofkau.unidadmilitar.entitys.militar.Militar;
import co.com.sofkau.unidadmilitar.entitys.militar.MilitarId;
import co.com.sofkau.unidadmilitar.entitys.vehiculo.Vehiculo;
import co.com.sofkau.unidadmilitar.entitys.vehiculo.VehiculoId;
import co.com.sofkau.unidadmilitar.events.MilitarAsignado;
import co.com.sofkau.unidadmilitar.events.UnidadMilitarCreada;
import co.com.sofkau.unidadmilitar.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Sets;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AsignarMilitarUseCaseTest {

    private AsignarMilitarUseCase asignarMilitarUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        asignarMilitarUseCase = new AsignarMilitarUseCase();
        repository = mock(DomainEventRepository.class);
        asignarMilitarUseCase.addRepository(repository);
    }

    @Test
    void AsignarMilitarUnidadCorrectamente(){

        //arrage
        var command = new AsignarMilitar(UnidadMilitarId.of("123"),MilitarId.of("123"),
                new Nombre("victor"),new Nacionalidad("Colombiano"),
                new Edad(19),new Autoridad("General"), new Genero('M'));

        when(repository.getEventsBy(any())).thenReturn(eventsMilitarAsignado());

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("123")
                .syncExecutor(asignarMilitarUseCase,new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        //assert
        MilitarAsignado militarAsignadoUseCase =(MilitarAsignado)events.get(0);
        Assertions.assertEquals("victor",militarAsignadoUseCase.nombre().value());
        Assertions.assertEquals(19,militarAsignadoUseCase.edad().value());


    }

    private List<DomainEvent> eventsMilitarAsignado() {
        Set<Militar> militares = new HashSet<Militar>();
        militares.add(new Militar(MilitarId.of("1211"),new Nombre("Daniel Mora"),new Nacionalidad("Argentino"),
                new Edad(19),new Autoridad("Cabo"), new Genero('M')));
        Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();
        vehiculos.add(new Vehiculo(new VehiculoId().of("154"),new TipoVehiculo("Camion"), new Proposito("Desplazamiento")));
        Set<Armamento> armamentos = new HashSet<Armamento>();
        armamentos.add(new Armamento(new ArmamentoId(),new TipoArma("rifle") ));
        Militar encargado = new Militar(MilitarId.of("segundo"),new Nombre("Alejandro"),new Nacionalidad("Colombiano"),
                new Edad(30),new Autoridad("Cabo"), new Genero('M'));

        return List.of(new UnidadMilitarCreada(new TipoUnidad("aereo"),
                militares,vehiculos,armamentos,encargado));
    }

}