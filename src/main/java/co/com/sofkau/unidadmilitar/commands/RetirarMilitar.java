package co.com.sofkau.unidadmilitar.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;
import co.com.sofkau.unidadmilitar.entitys.militar.MilitarId;

public class RetirarMilitar implements Command {
    private final UnidadMilitarId unidadMilitarId;
    private final MilitarId militarId;

    public RetirarMilitar(UnidadMilitarId unidadMilitarId, MilitarId militarId) {
        this.unidadMilitarId = unidadMilitarId;
        this.militarId = militarId;
    }

    public UnidadMilitarId getUnidadMilitarId() {
        return unidadMilitarId;
    }

    public MilitarId getMilitarId() {
        return militarId;
    }
}
