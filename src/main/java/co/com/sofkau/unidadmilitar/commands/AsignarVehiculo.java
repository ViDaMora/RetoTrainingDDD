package co.com.sofkau.unidadmilitar.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;
import co.com.sofkau.unidadmilitar.entitys.vehiculo.VehiculoId;
import co.com.sofkau.unidadmilitar.values.Proposito;
import co.com.sofkau.unidadmilitar.values.TipoVehiculo;

public class AsignarVehiculo implements Command {
    private final UnidadMilitarId unidadMilitarId;
    private final VehiculoId vehiculoId;
    private final TipoVehiculo tipoVehiculo;
    private final Proposito proposito;

    public AsignarVehiculo(UnidadMilitarId unidadMilitarId, VehiculoId vehiculoId, TipoVehiculo tipoVehiculo, Proposito proposito) {
        this.unidadMilitarId = unidadMilitarId;
        this.vehiculoId = vehiculoId;
        this.tipoVehiculo = tipoVehiculo;
        this.proposito = proposito;
    }

    public UnidadMilitarId getUnidadMilitarId() {
        return unidadMilitarId;
    }

    public VehiculoId getVehiculoId() {
        return vehiculoId;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public Proposito getProposito() {
        return proposito;
    }
}
