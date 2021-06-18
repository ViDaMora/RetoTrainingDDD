package co.com.sofkau.unidadmilitar.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;
import co.com.sofkau.unidadmilitar.values.TipoUnidad;

public class ActualizadaTipoUnidad implements Command {

    private final UnidadMilitarId unidadMilitarId;
    private final TipoUnidad tipoUnidad ;

    public ActualizadaTipoUnidad(UnidadMilitarId unidadMilitarId, TipoUnidad tipoUnidad) {
        this.unidadMilitarId = unidadMilitarId;
        this.tipoUnidad = tipoUnidad;
    }

    public TipoUnidad tipoUnidad() {
        return tipoUnidad;
    }

    public UnidadMilitarId unidadMilitarId() {
        return unidadMilitarId;
    }
}
