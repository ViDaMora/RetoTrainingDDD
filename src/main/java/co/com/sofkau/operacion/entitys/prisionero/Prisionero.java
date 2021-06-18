package co.com.sofkau.operacion.entitys.prisionero;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.operacion.entitys.values.EdadPrisionero;
import co.com.sofkau.operacion.entitys.values.*;


public class Prisionero extends Entity<PrisioneroId> {
    private Nombre nombre;
    private Nacionalidad nacionalidad;
    private EdadPrisionero edad;
    private Genero genero;

    public Prisionero(PrisioneroId entityId, Nombre nombre, Nacionalidad nacionalidad, EdadPrisionero edad, Genero genero) {
        super(entityId);
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.genero = genero;
    }

    public Nombre nombre() {
        return nombre;
    }

    public void actualizarNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public Nacionalidad nacionalidad() {
        return nacionalidad;
    }

    public void actualizarNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public EdadPrisionero edad() {
        return edad;
    }

    public void actualizarEdad(EdadPrisionero edad) {
        this.edad = edad;
    }

    public Genero genero() {
        return genero;
    }

    public void actualizarGenero(Genero genero) {
        this.genero = genero;
    }
}
