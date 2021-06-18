package co.com.sofkau.unidadmilitar.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.unidadmilitar.values.TipoUnidad;

public class TipoUnidadActualizada extends DomainEvent {
    private final TipoUnidad tipoUnidad;
    public TipoUnidadActualizada(TipoUnidad tipoUnidad) {
        super("sofkau.unidadmilitar.tipounidadagregada");
        this.tipoUnidad= tipoUnidad;
    }

    public TipoUnidad tipoUnidad() {
        return tipoUnidad;
    }
}
