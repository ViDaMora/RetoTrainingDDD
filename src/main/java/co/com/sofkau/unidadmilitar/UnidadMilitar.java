package co.com.sofkau.unidadmilitar;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.unidadmilitar.events.*;
import co.com.sofkau.unidadmilitar.entitys.armamento.Armamento;
import co.com.sofkau.unidadmilitar.entitys.armamento.ArmamentoId;
import co.com.sofkau.unidadmilitar.entitys.militar.Militar;
import co.com.sofkau.unidadmilitar.entitys.militar.MilitarId;
import co.com.sofkau.unidadmilitar.entitys.vehiculo.Vehiculo;
import co.com.sofkau.unidadmilitar.entitys.vehiculo.VehiculoId;
import co.com.sofkau.unidadmilitar.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class UnidadMilitar extends AggregateEvent<UnidadMilitarId> {

  protected TipoUnidad tipoUnidad;
  protected Set<Militar> militares;
  protected Set<Vehiculo> vehiculos;
  protected Set<Armamento> armamentos;
  protected Militar encargado;


    public UnidadMilitar(UnidadMilitarId entityId, TipoUnidad tipoUnidad, Set<Militar> militares, Set<Vehiculo> vehiculos,
                         Set<Armamento> armamentos, Militar encargado) {
        super(entityId);
        this.tipoUnidad = tipoUnidad;
        this.militares = militares;
        this.vehiculos = vehiculos;
        this.armamentos = armamentos;
        this.encargado = encargado;
        appendChange(new UnidadMilitarCreada(tipoUnidad,militares,vehiculos,armamentos,encargado)).apply();
    }

    private UnidadMilitar(UnidadMilitarId unidadMilitarId){
        super(unidadMilitarId);
        subscribe(new UnidadMilitarChange(this));
    }

    public static UnidadMilitar from(UnidadMilitarId unidadMilitarId, List<DomainEvent> events){
        var unidadMilitar= new UnidadMilitar(unidadMilitarId);
        events.forEach(unidadMilitar::applyEvent);
        return unidadMilitar;
    }

    public void ActualizarTipoUnidad(TipoUnidad tipoUnidad){
        Objects.requireNonNull(tipoUnidad);
        appendChange(new TipoUnidadActualizada(tipoUnidad));
    }

    public void AsignarMilitar(MilitarId militarId, Nombre nombre, Nacionalidad nacionalidad, Edad edad, Autoridad autoridad, Genero genero){
        Objects.requireNonNull(militarId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(nacionalidad);
        Objects.requireNonNull(edad);
        Objects.requireNonNull(autoridad);
        Objects.requireNonNull(genero);
        appendChange(new MilitarAsignado(militarId,nombre,nacionalidad,edad,autoridad,genero));
    }

    public void AsignarVehiculo(VehiculoId vehiculoId, TipoVehiculo tipoVehiculo, Proposito proposito){
        Objects.requireNonNull(vehiculoId);
        Objects.requireNonNull(tipoVehiculo);
        Objects.requireNonNull(proposito);
        appendChange(new VehiculoAsignado(vehiculoId,tipoVehiculo,proposito));
    }

    public void AsignarEncargado(MilitarId militarId, Nombre nombre, Nacionalidad nacionalidad, Edad edad, Autoridad autoridad, Genero genero){
        Objects.requireNonNull(militarId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(nacionalidad);
        Objects.requireNonNull(edad);
        Objects.requireNonNull(autoridad);
        Objects.requireNonNull(genero);
        appendChange(new EncargadoAsignado(militarId,nombre,nacionalidad,edad,autoridad,genero));
    }

    public void RetirarMilitar(MilitarId militarId){
        Objects.requireNonNull(militarId);
        appendChange(new MilitarRetirado(militarId));
    }

    public void AgregarArmamento(ArmamentoId armamentoId, TipoArma tipoArma){
        Objects.requireNonNull(armamentoId);
        Objects.requireNonNull(tipoArma);
        appendChange(new ArmamentoAgregado(armamentoId,tipoArma));
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

    public Set<Armamento> amamentos() {
        return armamentos;
    }

    public Militar encargado() {
        return encargado;
    }
}
