package co.com.sofkau.unidadmilitar.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.unidadmilitar.entitys.vehiculo.VehiculoId;
import co.com.sofkau.unidadmilitar.values.Proposito;
import co.com.sofkau.unidadmilitar.values.TipoUnidad;
import co.com.sofkau.unidadmilitar.values.TipoVehiculo;

public class VehiculoAsignado extends DomainEvent {
    private final VehiculoId vehiculoId;
    private final TipoVehiculo tipoVehiculo;
    private final Proposito proposito;

    public VehiculoAsignado(VehiculoId vehiculoId, TipoVehiculo tipoVehiculo, Proposito proposito) {
        super("sofkau.unidadmilitar.vehiculoasignado");
        this.vehiculoId=vehiculoId;
        this.tipoVehiculo=tipoVehiculo;
        this.proposito=proposito;
    }

    public VehiculoId vehiculoId() {
        return vehiculoId;
    }

    public TipoVehiculo tipoVehiculo() {
        return tipoVehiculo;
    }

    public Proposito proposito() {
        return proposito;
    }
}
