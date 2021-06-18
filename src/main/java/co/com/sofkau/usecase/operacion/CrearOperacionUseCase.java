package co.com.sofkau.usecase.operacion;


import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.operacion.Operacion;
import co.com.sofkau.operacion.OperacionId;
import co.com.sofkau.operacion.commands.CrearOperacion;
import co.com.sofkau.unidadmilitar.UnidadMilitar;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;
import co.com.sofkau.unidadmilitar.commands.CrearUnidadMilitar;
import co.com.sofkau.unidadmilitar.entitys.militar.Militar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CrearOperacionUseCase extends UseCase<RequestCommand<CrearOperacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearOperacion> crearUnidadMilitarRequestCommand){
        var command = crearUnidadMilitarRequestCommand.getCommand();
        var operacion = new Operacion(command.getOperacionId(),command.getUnidadesMilitares(),command.getLider(),
                command.getDescripcion(),command.getRegion(),command.getPais(),command.getNombre(),command.getPrisioneros());

        if (command.getLider().edad().value()<30)
            throw new BusinessException(command.getOperacionId().value(),"Ningun encargado de operacion puede tener menos de 30 anos de edad");

        if (command.getUnidadesMilitares().size()<1)
            throw new BusinessException(command.getOperacionId().value(),"No pueden existir operacions sin unidades militares asignadas");

        emit().onResponse(new ResponseEvents(operacion.getUncommittedChanges()));
    }
}
