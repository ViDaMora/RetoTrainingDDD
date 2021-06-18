package co.com.sofkau.usecase.operacion;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.operacion.entitys.lider.LiderId;
import co.com.sofkau.operacion.entitys.values.*;
import co.com.sofkau.operacion.events.LiderAsignado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class NotificarCantidadMilitaresUseCase {

    private NotificarLiderAsignadoUseCase notificarLiderAsignadoUseCase;
    private OperacionService operacionService;
    private SenderEmailService senderEmailService;

    @BeforeEach
    public void setup() {

        notificarLiderAsignadoUseCase = new NotificarLiderAsignadoUseCase();
        operacionService = mock(OperacionService.class);
        senderEmailService = mock(SenderEmailService.class);
        ServiceBuilder builder = new ServiceBuilder()
                .addService(operacionService)
                .addService(senderEmailService);
        notificarLiderAsignadoUseCase.addServiceBuilder(builder);

    }

    @Test
    void senEmailCorrectamente(){
        //Arrage
        var event = new LiderAsignado(
                LiderId.of("12"),new Nombre("Victor Mora"), new Nacionalidad("Colombiano"),
                new Edad(35), new Autoridad("General"),new Genero('M'));
        when(operacionService.getLiderNameByOperacionId(any())).thenReturn("Victor Mora");
        doNothing().when(senderEmailService).sendEmail(anyString(),anyString());

        //act

        UseCaseHandler.getInstance()
                .syncExecutor(notificarLiderAsignadoUseCase,new TriggeredEvent<>(event));

        //Assert
        verify(operacionService).getLiderNameByOperacionId(any());
        verify(senderEmailService).sendEmail(anyString(),anyString());
    }
}
