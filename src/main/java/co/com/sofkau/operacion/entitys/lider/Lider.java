package co.com.sofkau.operacion.entitys.lider;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.operacion.entitys.values.*;

import java.util.Objects;

public class Lider extends Entity<LiderId> {


    private Nombre nombre;
    private Nacionalidad nacionalidad;
    private Edad edad;
    private Autoridad autoridad;
    private Genero genero;

    public Lider(LiderId entityId, Nombre nombre, Nacionalidad nacionalidad, Edad edad, Autoridad autoridad, Genero genero) {
        super(entityId);
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.autoridad = autoridad;
        this.genero = genero;
    }

    public Nombre nombre() {
        return nombre;
    }

    public void actualizarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public Nacionalidad nacionalidad() {
        return nacionalidad;
    }

    public void actualizarNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = Objects.requireNonNull(nacionalidad);
    }

    public Edad edad() {
        return edad;
    }

    public void actualizarEdad(Edad edad) {
        this.edad = Objects.requireNonNull(edad);
    }

    public Autoridad autoridad() {
        return autoridad;
    }

    public void actualizarAutoridad(Autoridad autoridad) {
        this.autoridad = Objects.requireNonNull(autoridad);
    }

    public Genero genero() {
        return genero;
    }

    public void actualizarGenero(Genero genero) {
        this.genero = Objects.requireNonNull(genero);
    }
}
