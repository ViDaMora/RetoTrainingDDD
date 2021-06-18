package co.com.sofkau.operacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;

public class UnidadMilitarAsignada extends DomainEvent {
    private final UnidadMilitarId unidadMilitarId;
    public UnidadMilitarAsignada(UnidadMilitarId unidadMilitarId) {
        super("sofkau.operacion.unidadmilitarasignada");
        this.unidadMilitarId=unidadMilitarId;
    }

    public UnidadMilitarId unidadMilitarId() {
        return unidadMilitarId;
    }
}
