package co.com.sofkau.usecase.operacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.operacion.Operacion;
import co.com.sofkau.operacion.commands.AsignarUnidadMilitar;

public class AsignarUnidadCaseUse extends UseCase<RequestCommand<AsignarUnidadMilitar>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarUnidadMilitar> asignarUnidadMilitarRequestCommand){
        var command =asignarUnidadMilitarRequestCommand.getCommand();
        var operacion = Operacion.from(command.getOperacionId(),retrieveEvents(command.getOperacionId().value()));



        operacion.asignarUnidad(command.getUnidadMilitarId());
        emit().onResponse(new ResponseEvents(operacion.getUncommittedChanges()));

    }
}
