package co.com.sofkau.unidadmilitar.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;
import co.com.sofkau.unidadmilitar.entitys.armamento.Armamento;
import co.com.sofkau.unidadmilitar.entitys.militar.Militar;
import co.com.sofkau.unidadmilitar.entitys.vehiculo.Vehiculo;
import co.com.sofkau.unidadmilitar.values.TipoUnidad;

import java.util.Set;

public class CrearUnidadMilitar implements Command {
    private final UnidadMilitarId unidadMilitarId;
    private final TipoUnidad tipoUnidad;
    private final Set<Militar> militares;
    private final  Set<Vehiculo> vehiculos;
    private final Set<Armamento> armamentos;
    private final Militar encargado;

    public CrearUnidadMilitar(UnidadMilitarId unidadMilitarId, TipoUnidad tipoUnidad, Set<Militar> militares,
                              Set<Vehiculo> vehiculos, Set<Armamento> armamentos, Militar encargado) {
        this.unidadMilitarId = unidadMilitarId;
        this.tipoUnidad = tipoUnidad;
        this.militares = militares;
        this.vehiculos = vehiculos;
        this.armamentos = armamentos;
        this.encargado = encargado;
    }

    public UnidadMilitarId unidadMilitarId() {
        return unidadMilitarId;
    }

    public TipoUnidad tipoUnidad() {
        return tipoUnidad;
    }

    public Set<Militar> militares() {
        return militares;
    }

    public Set<Vehiculo> vehiculos() {
        return vehiculos;
    }

    public Set<Armamento> armamentos() {
        return armamentos;
    }

    public Militar encargado() {
        return encargado;
    }
}
