package co.com.sofkau.usecase.unidadmilitar;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.unidadmilitar.UnidadMilitar;
import co.com.sofkau.unidadmilitar.commands.ActualizadaTipoUnidad;

public class ActualizarTipoUnidadUseCase extends UseCase<RequestCommand<ActualizadaTipoUnidad>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizadaTipoUnidad> actualizadaTipoUnidadRequestCommand){
        var command = actualizadaTipoUnidadRequestCommand.getCommand();
        var unidadMilitar = UnidadMilitar.from(command.unidadMilitarId(),retrieveEvents(command.unidadMilitarId().value()));

        unidadMilitar.ActualizarTipoUnidad(command.tipoUnidad());
        emit().onResponse(new ResponseEvents(unidadMilitar.getUncommittedChanges()));
    }
}
