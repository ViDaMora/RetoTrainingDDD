package co.com.sofkau.unidadmilitar.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.unidadmilitar.entitys.militar.MilitarId;

public class MilitarRetirado extends DomainEvent {
    private final MilitarId militarId;
    public MilitarRetirado(MilitarId militarId) {
        super("sofkau.unidadmilitar.militaragregado");
        this.militarId=militarId;
    }

    public MilitarId militarId() {
        return militarId;
    }
}
