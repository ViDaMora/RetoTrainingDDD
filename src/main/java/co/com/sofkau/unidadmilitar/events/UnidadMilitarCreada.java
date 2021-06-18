package co.com.sofkau.unidadmilitar.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;
import co.com.sofkau.unidadmilitar.entitys.armamento.Armamento;
import co.com.sofkau.unidadmilitar.entitys.militar.Militar;
import co.com.sofkau.unidadmilitar.entitys.vehiculo.Vehiculo;
import co.com.sofkau.unidadmilitar.values.TipoUnidad;

import java.util.Set;
import java.util.UUID;

public class UnidadMilitarCreada extends DomainEvent {
    private final TipoUnidad tipoUnidad;
    private final Set<Militar> militares;
    private final  Set<Vehiculo> vehiculos;
    private final Set<Armamento> armamentos;
    private final Militar encargado;

    public UnidadMilitarCreada(TipoUnidad tipoUnidad, Set<Militar> militares, Set<Vehiculo> vehiculos, Set<Armamento> armamentos, Militar encargado) {
        super("sofkau.unidadmilitar.unidadmilitarcreada");

        this.tipoUnidad = tipoUnidad;
        this.militares = militares;
        this.vehiculos = vehiculos;
        this.armamentos = armamentos;
        this.encargado = encargado;
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
