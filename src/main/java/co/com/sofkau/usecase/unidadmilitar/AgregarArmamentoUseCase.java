package co.com.sofkau.usecase.unidadmilitar;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.unidadmilitar.UnidadMilitar;
import co.com.sofkau.unidadmilitar.commands.AgregarArmamento;
import co.com.sofkau.unidadmilitar.entitys.armamento.ArmamentoId;

public class AgregarArmamentoUseCase extends UseCase<RequestCommand<AgregarArmamento>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarArmamento> agregarArmamentoRequestCommand){
        var command = agregarArmamentoRequestCommand.getCommand();
        var unidadMilitar = UnidadMilitar.from(command.getUnidadMilitarId(),retrieveEvents(command.getArmamentoId().value()));

        unidadMilitar.AgregarArmamento(ArmamentoId.of("587"),command.getTipoArma());
        emit().onResponse(new ResponseEvents(unidadMilitar.getUncommittedChanges()));
    }
}
