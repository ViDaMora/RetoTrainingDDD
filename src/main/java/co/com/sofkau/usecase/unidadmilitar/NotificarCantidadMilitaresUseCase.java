package co.com.sofkau.usecase.unidadmilitar;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.unidadmilitar.events.MilitarAsignado;

public class NotificarCantidadMilitaresUseCase extends UseCase<TriggeredEvent<MilitarAsignado>, ResponseEvents> {

    @Override
    public void  executeUseCase(TriggeredEvent<MilitarAsignado> militarAsignadoTriggeredEvent){
        var event = militarAsignadoTriggeredEvent.getDomainEvent();
        var unidadMilitarService= getService(UnidadMilitarService.class).orElseThrow();
        var sender = getService(SenderEmailService.class).orElseThrow();

        var email = unidadMilitarService.militarNameById(event.militarId());
        sender.sendEmail(email,"Content body");

    }
}
