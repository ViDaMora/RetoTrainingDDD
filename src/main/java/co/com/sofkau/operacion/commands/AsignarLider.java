package co.com.sofkau.operacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.operacion.OperacionId;
import co.com.sofkau.operacion.entitys.lider.LiderId;
import co.com.sofkau.operacion.entitys.values.*;

public class AsignarLider implements Command {
    private final OperacionId operacionId;
    private final LiderId liderId;
    private final Nombre nombre;
    private final Nacionalidad nacionalidad;
    private final Edad edad;
    private final Autoridad autoridad;
    private final Genero genero;

    public AsignarLider(OperacionId operacionId, LiderId liderId, Nombre nombre, Nacionalidad nacionalidad, Edad edad, Autoridad autoridad, Genero genero) {
        this.operacionId = operacionId;
        this.liderId = liderId;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.autoridad = autoridad;
        this.genero = genero;
    }

    public OperacionId getOperacionId() {
        return operacionId;
    }

    public LiderId getLiderId() {
        return liderId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public Edad getEdad() {
        return edad;
    }

    public Autoridad getAutoridad() {
        return autoridad;
    }

    public Genero getGenero() {
        return genero;
    }
}
