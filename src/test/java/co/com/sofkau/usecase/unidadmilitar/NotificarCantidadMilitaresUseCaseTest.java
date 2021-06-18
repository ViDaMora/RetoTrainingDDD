package co.com.sofkau.usecase.unidadmilitar;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.unidadmilitar.entitys.militar.MilitarId;
import co.com.sofkau.unidadmilitar.events.MilitarAsignado;
import co.com.sofkau.unidadmilitar.values.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class NotificarCantidadMilitaresUseCaseTest {

    private NotificarCantidadMilitaresUseCase notificarCantidadMilitaresUseCase;
    private UnidadMilitarService unidadMilitarService;
    private  SenderEmailService senderEmailService;

    @BeforeEach
    public void setUp(){
        notificarCantidadMilitaresUseCase = new NotificarCantidadMilitaresUseCase();
        unidadMilitarService = mock(UnidadMilitarService.class);
        senderEmailService = mock(SenderEmailService.class);
        ServiceBuilder builder = new ServiceBuilder()
                .addService(unidadMilitarService)
                .addService(senderEmailService);
        notificarCantidadMilitaresUseCase.addServiceBuilder(builder);
    }


    @Test
    void sendEmailCorrectamente(){
        //Arrage
        var event = new MilitarAsignado(MilitarId.of("565"),new Nombre("Felipe Granados"),
                new Nacionalidad("Colombiano"), new Edad(20),new Autoridad("Cabo"),new Genero('M'));

        when(unidadMilitarService.militarNameById(any())).thenReturn("Felipe Granados");
        doNothing().when(senderEmailService).sendEmail(anyString(),anyString());


        //act
        UseCaseHandler.getInstance()
                .syncExecutor(notificarCantidadMilitaresUseCase,new TriggeredEvent<>(event));

        //act

        verify(unidadMilitarService).militarNameById(any());
        verify(senderEmailService).sendEmail(anyString(),anyString());
    }

}