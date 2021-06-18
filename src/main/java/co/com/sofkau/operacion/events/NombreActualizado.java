package co.com.sofkau.operacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.operacion.entitys.values.Nombre;

public class NombreActualizado extends DomainEvent {
    private final Nombre nombre;

    public NombreActualizado(Nombre nombre) {
        super("sofkau.operacion.nombreactualizado");
        this.nombre=nombre;
    }

    public Nombre nombre() {
        return nombre;
    }
}
