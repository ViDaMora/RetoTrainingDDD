package co.com.sofkau.operacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.operacion.OperacionId;
import co.com.sofkau.operacion.entitys.prisionero.PrisioneroId;
import co.com.sofkau.operacion.entitys.values.EdadPrisionero;
import co.com.sofkau.operacion.entitys.values.Genero;
import co.com.sofkau.operacion.entitys.values.Nacionalidad;
import co.com.sofkau.operacion.entitys.values.Nombre;

public class CapturarPrisionero implements Command {
    private final OperacionId operacionId;
    private final PrisioneroId prisioneroId;
    private final Nombre nombre;
    private final Nacionalidad nacionalidad;
    private final EdadPrisionero edad;
    private final Genero genero;

    public CapturarPrisionero(OperacionId operacionId, PrisioneroId prisioneroId, Nombre nombre, Nacionalidad nacionalidad, EdadPrisionero edad, Genero genero) {
        this.operacionId = operacionId;
        this.prisioneroId = prisioneroId;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.genero = genero;
    }

    public OperacionId getOperacionId() {
        return operacionId;
    }

    public PrisioneroId getPrisioneroId() {
        return prisioneroId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public EdadPrisionero getEdad() {
        return edad;
    }

    public Genero getGenero() {
        return genero;
    }
}
