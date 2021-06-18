package co.com.sofkau.unidadmilitar.entitys.vehiculo;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.unidadmilitar.values.Proposito;
import co.com.sofkau.unidadmilitar.values.TipoVehiculo;

import java.util.Objects;

public class Vehiculo extends Entity<VehiculoId> {
    private TipoVehiculo tipoVehiculo;
    private Proposito proposito;

    public Vehiculo(VehiculoId entityId, TipoVehiculo tipoVehiculo, Proposito proposito) {
        super(entityId);
        this.tipoVehiculo = tipoVehiculo;
        this.proposito = proposito;
    }

    public TipoVehiculo tipoVehiculo() {
        return tipoVehiculo;
    }

    public void asignarTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = Objects.requireNonNull(tipoVehiculo);
    }

    public Proposito proposito() {
        return proposito;
    }

    public void AsignarProposito(Proposito proposito) {
        this.proposito = Objects.requireNonNull(proposito);
    }
}
