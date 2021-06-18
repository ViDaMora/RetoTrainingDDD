package co.com.sofkau.unidadmilitar.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.unidadmilitar.entitys.armamento.ArmamentoId;
import co.com.sofkau.unidadmilitar.values.TipoArma;
import co.com.sofkau.unidadmilitar.values.TipoVehiculo;

public class ArmamentoAgregado extends DomainEvent {
    private final ArmamentoId armamentoId;
    private final TipoArma tipoArma;
    public ArmamentoAgregado(ArmamentoId armamentoId, TipoArma tipoArma) {
        super("sofkau.unidadmilitar.armamentoagregado");
        this.armamentoId=armamentoId;
        this.tipoArma=tipoArma;
    }

    public ArmamentoId armamentoId() {
        return armamentoId;
    }

    public TipoArma tipoArma() {
        return tipoArma;
    }
}
