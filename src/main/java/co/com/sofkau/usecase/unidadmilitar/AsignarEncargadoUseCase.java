package co.com.sofkau.usecase.unidadmilitar;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.operacion.events.UnidadMilitarAsignada;
import co.com.sofkau.unidadmilitar.UnidadMilitar;
import co.com.sofkau.unidadmilitar.commands.AsignarEncargado;

public class AsignarEncargadoUseCase extends UseCase<RequestCommand<AsignarEncargado>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarEncargado> asignarEncargadoRequestCommand){
        var command = asignarEncargadoRequestCommand.getCommand();
        var unidadMilitar = UnidadMilitar.from(command.getUnidadMilitarId(),retrieveEvents(command.getMilitarId().value()));

        unidadMilitar.AsignarEncargado(command.getMilitarId(),command.getNombre(), command.getNacionalidad(),
                command.getEdad(),command.getAutoridad(),command.getGenero());
        emit().onResponse(new ResponseEvents((unidadMilitar.getUncommittedChanges())));
    }
}
