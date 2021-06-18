package co.com.sofkau.operacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.operacion.entitys.lider.LiderId;
import co.com.sofkau.operacion.entitys.values.*;

import java.util.UUID;

public class LiderAsignado extends DomainEvent {
    private final LiderId liderId;
    private final  Nombre nombre;
    private final Nacionalidad nacionalidad;
    private final Edad edad;
    private final Autoridad autoridad;
    private final Genero genero;

    public LiderAsignado(LiderId liderId, Nombre nombre, Nacionalidad nacionalidad, Edad edad, Autoridad autoridad, Genero genero) {
        super("sofkau.operacion.liderasignado");
        this.liderId = liderId;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.autoridad = autoridad;
        this.genero = genero;
    }

    public LiderId liderId() {
        return liderId;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Nacionalidad nacionalidad() {
        return nacionalidad;
    }

    public Edad edad() {
        return edad;
    }

    public Autoridad autoridad() {
        return autoridad;
    }

    public Genero genero() {
        return genero;
    }
}
