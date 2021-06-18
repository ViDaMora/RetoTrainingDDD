package co.com.sofkau.unidadmilitar.entitys.armamento;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.unidadmilitar.values.TipoArma;

public class Armamento extends Entity<ArmamentoId> {
    private TipoArma value;

    public Armamento(ArmamentoId entityId, TipoArma tipoArma) {
        super(entityId);
        this.value = tipoArma;
    }

    public TipoArma tipoArma() {
        return value;
    }

    public void actualizarTipoArma(TipoArma tipoArma) {
        this.value = tipoArma;
    }
}
