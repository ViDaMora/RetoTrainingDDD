package co.com.sofkau.usecase.operacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.operacion.events.LiderAsignado;

public class NotificarLiderAsignadoUseCase extends UseCase<TriggeredEvent<LiderAsignado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<LiderAsignado> liderAsignadoTriggeredEvent){
        var event = liderAsignadoTriggeredEvent.getDomainEvent();
        var operacionService = getService(OperacionService.class).orElseThrow();
        var sender = getService(SenderEmailService.class).orElseThrow();

        var email= operacionService.getLiderNameByOperacionId(event.liderId());
        sender.sendEmail(email,"Content body");

    }
}
