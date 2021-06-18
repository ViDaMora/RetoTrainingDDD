package co.com.sofkau.operacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.operacion.OperacionId;
import co.com.sofkau.operacion.entitys.lider.Lider;
import co.com.sofkau.operacion.entitys.prisionero.Prisionero;
import co.com.sofkau.operacion.entitys.values.Descripcion;
import co.com.sofkau.operacion.entitys.values.Nombre;
import co.com.sofkau.operacion.entitys.values.Pais;
import co.com.sofkau.operacion.entitys.values.Region;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;

import java.util.Set;

public class CrearOperacion implements Command {
    private final OperacionId operacionId;
    private final Set<UnidadMilitarId> unidadesMilitares;
    private final Lider lider;
    private final Descripcion descripcion;
    private final Region region;
    private final Pais pais;
    private final Nombre nombre;
    private final Set<Prisionero> prisioneros;

    public CrearOperacion(OperacionId operacionId, Set<UnidadMilitarId> unidadesMilitares, Lider lider,
                          Descripcion descripcion, Region region, Pais pais, Nombre nombre, Set<Prisionero> prisioneros) {
        this.operacionId = operacionId;
        this.unidadesMilitares = unidadesMilitares;
        this.lider = lider;
        this.descripcion = descripcion;
        this.region = region;
        this.pais = pais;
        this.nombre = nombre;
        this.prisioneros = prisioneros;
    }

    public OperacionId getOperacionId() {
        return operacionId;
    }

    public Set<UnidadMilitarId> getUnidadesMilitares() {
        return unidadesMilitares;
    }

    public Lider getLider() {
        return lider;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Region getRegion() {
        return region;
    }

    public Pais getPais() {
        return pais;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Set<Prisionero> getPrisioneros() {
        return prisioneros;
    }
}
