package co.com.sofkau.unidadmilitar.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.unidadmilitar.UnidadMilitarId;
import co.com.sofkau.unidadmilitar.entitys.militar.MilitarId;
import co.com.sofkau.unidadmilitar.values.*;

public class AsignarEncargado implements Command {
    private final UnidadMilitarId unidadMilitarId;
    private final MilitarId militarId;
    private final Nombre nombre;
    private final Nacionalidad nacionalidad;
    private final Edad edad;
    private final Autoridad autoridad;
    private final Genero genero;

    public AsignarEncargado(UnidadMilitarId unidadMilitarId, MilitarId militarId, Nombre nombre, Nacionalidad nacionalidad, Edad edad, Autoridad autoridad, Genero genero) {
        this.unidadMilitarId = unidadMilitarId;
        this.militarId = militarId;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.autoridad = autoridad;
        this.genero = genero;
    }

    public UnidadMilitarId getUnidadMilitarId() {
        return unidadMilitarId;
    }

    public MilitarId getMilitarId() {
        return militarId;
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
