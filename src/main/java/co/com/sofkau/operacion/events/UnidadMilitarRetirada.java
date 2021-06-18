package co.com.sofkau.operacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;

public class UnidadMilitarRetirada extends DomainEvent {
    private final UnidadMilitarId unidadMilitarId;
    public UnidadMilitarRetirada(UnidadMilitarId unidadMilitarId) {
        super("sofkau.operacion.unidadmilitarretirada");
        this.unidadMilitarId=unidadMilitarId;
    }

    public UnidadMilitarId unidadMilitarId() {
        return unidadMilitarId;
    }
}
