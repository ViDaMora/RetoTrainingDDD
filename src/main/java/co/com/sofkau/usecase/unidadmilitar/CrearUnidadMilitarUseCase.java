package co.com.sofkau.usecase.unidadmilitar;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.unidadmilitar.UnidadMilitar;
import co.com.sofkau.unidadmilitar.commands.CrearUnidadMilitar;

public class CrearUnidadMilitarUseCase extends UseCase<RequestCommand<CrearUnidadMilitar>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearUnidadMilitar> crearUnidadMilitarRequestCommand){
        var command = crearUnidadMilitarRequestCommand.getCommand();
        var unidadMilitar = new UnidadMilitar(command.unidadMilitarId(), command.tipoUnidad(), command.militares(),
                command.vehiculos(),command.armamentos(),command.encargado());

        if (command.militares().contains(command.encargado()))
            throw new IllegalArgumentException("El encagado no puede estar entre los militares de la unidad, asegurese de retirarlo de las filas primero.");

        emit().onResponse(new ResponseEvents(unidadMilitar.getUncommittedChanges()));
    }
}
