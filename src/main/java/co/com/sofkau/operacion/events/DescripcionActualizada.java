package co.com.sofkau.operacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.operacion.entitys.values.Descripcion;

public class DescripcionActualizada extends DomainEvent {
    private final Descripcion descripcion;
    public DescripcionActualizada(Descripcion descripcion) {
        super("sofkau.operacion.descripcionactualizada");
        this.descripcion=descripcion;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
