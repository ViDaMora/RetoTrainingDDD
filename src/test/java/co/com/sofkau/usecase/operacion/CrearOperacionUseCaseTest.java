package co.com.sofkau.usecase.operacion;


import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.operacion.OperacionId;
import co.com.sofkau.operacion.commands.CrearOperacion;

import co.com.sofkau.operacion.entitys.lider.Lider;
import co.com.sofkau.operacion.entitys.lider.LiderId;
import co.com.sofkau.operacion.entitys.prisionero.Prisionero;
import co.com.sofkau.operacion.entitys.values.*;
import co.com.sofkau.operacion.entitys.values.Autoridad;
import co.com.sofkau.operacion.entitys.values.Edad;
import co.com.sofkau.operacion.entitys.values.Genero;
import co.com.sofkau.operacion.entitys.values.Nacionalidad;
import co.com.sofkau.operacion.entitys.values.Nombre;
import co.com.sofkau.operacion.events.OperacionCreada;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;
import co.com.sofkau.unidadmilitar.entitys.militar.Militar;
import co.com.sofkau.unidadmilitar.entitys.militar.MilitarId;
import co.com.sofkau.unidadmilitar.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


class CrearOperacionUseCaseTest {

    private CrearOperacionUseCase crearOperacionUseCase;

    @BeforeEach
    private void  setUp(){
        crearOperacionUseCase = new CrearOperacionUseCase();
    }


    @Test
    public void crearOperacionCorrectamente(){
        //arrage
        Set<UnidadMilitarId> unidadesMilitares =new HashSet<>();
        unidadesMilitares.add(UnidadMilitarId.of("541"));
        Set<Prisionero> prisioneros = new HashSet<>();
        Lider lider = new Lider(LiderId.of("123"),new Nombre("Victor"),new Nacionalidad("Colombiano"),
                new Edad(35),new Autoridad("General"),new Genero('M'));
        var command = new CrearOperacion(OperacionId.of("1"),unidadesMilitares,lider,new Descripcion("Liberar rapidamente a  Colombia"),
                new Region("Sureste Antioqueno"),new Pais("Colombia"),new Nombre("Libertad Colombia"),prisioneros);


        //act
        var response = UseCaseHandler.getInstance()
                .syncExecutor(crearOperacionUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var events = response.getDomainEvents();

        //Asserts

        OperacionCreada operacionCreada = (OperacionCreada) events.get(0);
        Assertions.assertEquals("sofkau,operacion.operacioncreada", operacionCreada.type);
        Assertions.assertEquals("Victor",operacionCreada.lider().nombre().value());
        Assertions.assertEquals(0,operacionCreada.prisioneros().size());


    }


}