package co.com.sofkau.usecase.unidadmilitar;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;
import co.com.sofkau.unidadmilitar.commands.CrearUnidadMilitar;
import co.com.sofkau.unidadmilitar.entitys.armamento.Armamento;
import co.com.sofkau.unidadmilitar.entitys.armamento.ArmamentoId;
import co.com.sofkau.unidadmilitar.entitys.militar.Militar;
import co.com.sofkau.unidadmilitar.entitys.militar.MilitarId;
import co.com.sofkau.unidadmilitar.entitys.vehiculo.Vehiculo;
import co.com.sofkau.unidadmilitar.entitys.vehiculo.VehiculoId;
import co.com.sofkau.unidadmilitar.events.UnidadMilitarCreada;
import co.com.sofkau.unidadmilitar.values.*;
import co.com.sofkau.usecase.unidadmilitar.CrearUnidadMilitarUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class CrearUnidadMilitarUseCaseTest {
    private CrearUnidadMilitarUseCase crearUnidadMilitarUseCase;


    @BeforeEach
    public void setup(){
        crearUnidadMilitarUseCase = new CrearUnidadMilitarUseCase();
    }




    @Test
    public void crearUnidadMilitarHappyPath(){
        //arrange

        Set<Militar> militares = new HashSet<Militar>();
        militares.add(new Militar(MilitarId.of("primero"),new Nombre("Victor Mora"),new Nacionalidad("Colombiano"),
                new Edad(19),new Autoridad("General"), new Genero('M')));

        Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();
        vehiculos.add(new Vehiculo(new VehiculoId().of("154"),new TipoVehiculo("Camion"), new Proposito("Desplazamiento")));

        Set<Armamento> armamentos = new HashSet<Armamento>();
        armamentos.add(new Armamento(new ArmamentoId(),new TipoArma("rifle") ));


        Militar encargado = new Militar(MilitarId.of("segundo"),new Nombre("Alejandro"),new Nacionalidad("Colombiano"),
                new Edad(30),new Autoridad("cabo"), new Genero('M'));




        var command = new CrearUnidadMilitar(UnidadMilitarId.of("123456"), new TipoUnidad("Terrestre"),
                militares,vehiculos,armamentos,encargado);


        //act
        var response = UseCaseHandler.getInstance()
                .syncExecutor(crearUnidadMilitarUseCase, new RequestCommand<>(command))
                .orElseThrow();


        var events = response.getDomainEvents();

        //Asserts

        UnidadMilitarCreada unidadMilitarCreada= (UnidadMilitarCreada) events.get(0);
        Assertions.assertEquals("Alejandro",unidadMilitarCreada.encargado().nombre().value());
        Assertions.assertEquals('M', unidadMilitarCreada.encargado().genero().value());
        Assertions.assertEquals(1,militares.size());
        }

    }
