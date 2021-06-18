package co.com.sofkau.operacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.operacion.OperacionId;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;

public class AsignarUnidadMilitar implements Command {
    private final OperacionId operacionId;
    private final UnidadMilitarId unidadMilitarId;

    public AsignarUnidadMilitar(OperacionId operacionId, UnidadMilitarId unidadMilitarId) {
        this.operacionId = operacionId;
        this.unidadMilitarId = unidadMilitarId;
    }

    public OperacionId getOperacionId() {
        return operacionId;
    }

    public UnidadMilitarId getUnidadMilitarId() {
        return unidadMilitarId;
    }
}
