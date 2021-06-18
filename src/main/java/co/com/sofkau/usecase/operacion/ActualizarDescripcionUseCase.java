package co.com.sofkau.usecase.operacion;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.operacion.Operacion;
import co.com.sofkau.operacion.commands.ActualizarDescripcion;

public class ActualizarDescripcionUseCase extends UseCase <RequestCommand<ActualizarDescripcion>, ResponseEvents>{

    @Override
    public void executeUseCase(RequestCommand<ActualizarDescripcion> actualizarDescripcionRequestCommand){
        var command = actualizarDescripcionRequestCommand.getCommand();
        var operacion = Operacion.from(command.getOperacionId(),retrieveEvents(command.getOperacionId().value()));

        if (command.getDescripcion().value().length()<10 )
            throw new BusinessException(command.getOperacionId().value(),"Una descripcion no puede ser menor de 10 caracteres");

        operacion.actualizarDescripcion(command.getDescripcion());
        emit().onResponse(new ResponseEvents(operacion.getUncommittedChanges()));
    }
}
