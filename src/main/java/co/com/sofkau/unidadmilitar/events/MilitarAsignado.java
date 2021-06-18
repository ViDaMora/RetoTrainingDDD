package co.com.sofkau.unidadmilitar.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.unidadmilitar.entitys.militar.MilitarId;
import co.com.sofkau.unidadmilitar.values.*;

public class MilitarAsignado extends DomainEvent {
    private final MilitarId militarId;
    private final  Nombre nombre;
    private final  Nacionalidad nacionalidad;
    private final  Edad edad;
    private final Autoridad autoridad;
    private final Genero genero;

    public MilitarAsignado(MilitarId militarId, Nombre nombre, Nacionalidad nacionalidad, Edad edad, Autoridad autoridad, Genero genero) {
        super("sofkau.events.militaragregado");
        this.militarId=militarId;
        this.nombre=nombre;
        this.nacionalidad=nacionalidad;
        this.edad=edad;
        this.autoridad=autoridad;
        this.genero=genero;
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

    public MilitarId militarId() {
        return militarId;
    }
}
