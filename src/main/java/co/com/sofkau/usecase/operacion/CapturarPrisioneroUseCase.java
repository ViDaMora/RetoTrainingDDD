package co.com.sofkau.usecase.operacion;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.operacion.Operacion;
import co.com.sofkau.operacion.commands.CapturarPrisionero;

public class CapturarPrisioneroUseCase extends UseCase<RequestCommand<CapturarPrisionero>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CapturarPrisionero> capturarPrisioneroRequestCommand){
        var command =capturarPrisioneroRequestCommand.getCommand();
        var operacion = Operacion.from(command.getOperacionId(),retrieveEvents(command.getOperacionId().value()));

        if(command.getEdad().value()<18)
            throw new BusinessException(command.getOperacionId().value(),"No se pueden capturar menores de edad");

        operacion.capturarPrisionero(command.getPrisioneroId(),command.getNombre(),command.getNacionalidad(),
                command.getEdad(),command.getGenero());
        emit().onResponse(new ResponseEvents(operacion.getUncommittedChanges()));

    }
}
