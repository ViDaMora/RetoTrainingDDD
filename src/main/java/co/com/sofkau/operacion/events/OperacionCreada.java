package co.com.sofkau.operacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.operacion.entitys.lider.Lider;
import co.com.sofkau.operacion.entitys.prisionero.Prisionero;
import co.com.sofkau.operacion.entitys.values.Descripcion;
import co.com.sofkau.operacion.entitys.values.Nombre;
import co.com.sofkau.operacion.entitys.values.Pais;
import co.com.sofkau.operacion.entitys.values.Region;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;

import java.util.Set;
import java.util.UUID;

public class OperacionCreada extends DomainEvent {
    private final Set<UnidadMilitarId> unidadesMilitares;
    private final Lider lider;
    private final Descripcion descripcion;
    private final Region region;
    private final Pais pais;
    private final Nombre nombre;
    private final Set<Prisionero> prisioneros;

    public OperacionCreada(Set<UnidadMilitarId> unidadesMilitares, Lider lider, Descripcion descripcion,
                           Region region, Pais pais, Nombre nombre, Set<Prisionero> prisioneros) {
        super("sofkau,operacion.operacioncreada");
        this.unidadesMilitares = unidadesMilitares;
        this.lider = lider;
        this.descripcion = descripcion;
        this.region = region;
        this.pais = pais;
        this.nombre = nombre;
        this.prisioneros = prisioneros;
    }

    public Set<UnidadMilitarId> unidadesMilitares() {
        return unidadesMilitares;
    }

    public Lider lider() {
        return lider;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Region region() {
        return region;
    }

    public Pais pais() {
        return pais;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Set<Prisionero> prisioneros() {
        return prisioneros;
    }
}
