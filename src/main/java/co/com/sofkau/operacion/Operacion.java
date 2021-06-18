package co.com.sofkau.operacion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.operacion.entitys.lider.Lider;
import co.com.sofkau.operacion.entitys.lider.LiderId;
import co.com.sofkau.operacion.entitys.prisionero.Prisionero;
import co.com.sofkau.operacion.entitys.prisionero.PrisioneroId;
import co.com.sofkau.operacion.entitys.values.*;

import co.com.sofkau.operacion.events.*;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Operacion extends AggregateEvent<OperacionId> {
    protected Set<UnidadMilitarId> unidadesMilitares;
    protected Lider lider;
    protected Descripcion descripcion;
    protected Region region;
    protected Pais pais;
    protected Nombre nombre;
    protected Set<Prisionero> prisioneros;

    public Operacion(OperacionId entityId, Set<UnidadMilitarId> unidadesMilitares, Lider lider,
                     Descripcion descripcion, Region region, Pais pais, Nombre nombre, Set<Prisionero> prisioneros) {
        super(entityId);
        this.unidadesMilitares = unidadesMilitares;
        this.lider = lider;
        this.descripcion = descripcion;
        this.region = region;
        this.pais = pais;
        this.nombre = nombre;
        this.prisioneros = prisioneros;
        appendChange(new OperacionCreada(unidadesMilitares,lider,descripcion,region,pais,nombre,prisioneros));
    }

    private Operacion(OperacionId operacionId){
        super(operacionId);
        subscribe(new OperacionChange(this));
    }
    public static Operacion from(OperacionId operacionId, List<DomainEvent> events){
        var operacion= new Operacion(operacionId);
        events.forEach(operacion::applyEvent);
        return operacion;
    }



    public void capturarPrisionero(PrisioneroId prisioneroId, Nombre nombre, Nacionalidad nacionalidad, EdadPrisionero edad, Genero genero){
        Objects.requireNonNull(prisioneroId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(nacionalidad);
        Objects.requireNonNull(edad);
        Objects.requireNonNull(genero);
        appendChange(new PrisioneroCapturado(prisioneroId,nombre,nacionalidad,edad,genero));
    }

    public void actualizarDescripcion(Descripcion descripcion){
        Objects.requireNonNull(descripcion);
        appendChange(new DescripcionActualizada(descripcion));
    }

    public void asignarLider(LiderId liderId, Nombre nombre, Nacionalidad nacionalidad, Edad edad, Autoridad autoridad, Genero genero){
        Objects.requireNonNull(liderId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(nacionalidad);
        Objects.requireNonNull(edad);
        Objects.requireNonNull(autoridad);
        Objects.requireNonNull(genero);
        appendChange(new LiderAsignado(liderId,nombre,nacionalidad,edad,autoridad,genero));

    }

    public void asignarUnidad(UnidadMilitarId unidadMilitarId){
        Objects.requireNonNull(unidadMilitarId);
        appendChange(new UnidadMilitarAsignada(unidadMilitarId));
    }

    public void retirarUnidad(UnidadMilitarId unidadMilitarId){
        Objects.requireNonNull(unidadMilitarId);
        appendChange(new UnidadMilitarRetirada(unidadMilitarId));
    }

    public void actualizarNombre(Nombre nombre){
        Objects.requireNonNull(nombre);
        appendChange(new NombreActualizado(nombre));
    }


}
