package co.com.sofkau.operacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.operacion.OperacionId;
import co.com.sofkau.operacion.entitys.values.Descripcion;

public class ActualizarDescripcion implements Command {
    private final OperacionId operacionId;
    private final Descripcion descripcion;

    public ActualizarDescripcion(OperacionId operacionId, Descripcion descripcion) {
        this.operacionId = operacionId;
        this.descripcion = descripcion;
    }

    public OperacionId getOperacionId() {
        return operacionId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
