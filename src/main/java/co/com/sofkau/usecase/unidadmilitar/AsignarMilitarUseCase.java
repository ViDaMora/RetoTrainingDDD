package co.com.sofkau.usecase.unidadmilitar;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.unidadmilitar.UnidadMilitar;
import co.com.sofkau.unidadmilitar.commands.AsignarMilitar;

public class AsignarMilitarUseCase extends UseCase<RequestCommand<AsignarMilitar>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarMilitar> asignarMilitarRequestCommand){
        var command = asignarMilitarRequestCommand.getCommand();
        var unidadMilitar = UnidadMilitar.from(command.getUnidadMilitarId(),retrieveEvents(command.getUnidadMilitarId().value()));

        if (command.getEdad().value()<18)
            throw new BusinessException(command.getUnidadMilitarId().value(),"No pueden haber militares menores de 18 años");


        unidadMilitar.AsignarMilitar(command.getMilitarId(), command.getNombre(), command.getNacionalidad(),
                command.getEdad(), command.getAutoridad(), command.getGenero());


        emit().onResponse(new ResponseEvents(unidadMilitar.getUncommittedChanges()));

    }
}
