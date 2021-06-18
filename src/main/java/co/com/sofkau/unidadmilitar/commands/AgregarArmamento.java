package co.com.sofkau.unidadmilitar.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;
import co.com.sofkau.unidadmilitar.entitys.armamento.ArmamentoId;
import co.com.sofkau.unidadmilitar.values.TipoArma;

public class AgregarArmamento implements Command {
    private final UnidadMilitarId unidadMilitarId;
    private final ArmamentoId armamentoId;
    private final TipoArma tipoArma;

    public AgregarArmamento(UnidadMilitarId unidadMilitarId, ArmamentoId armamentoId, TipoArma tipoArma) {
        this.unidadMilitarId = unidadMilitarId;
        this.armamentoId = armamentoId;
        this.tipoArma = tipoArma;
    }

    public UnidadMilitarId getUnidadMilitarId() {
        return unidadMilitarId;
    }

    public ArmamentoId getArmamentoId() {
        return armamentoId;
    }

    public TipoArma getTipoArma() {
        return tipoArma;
    }
}
