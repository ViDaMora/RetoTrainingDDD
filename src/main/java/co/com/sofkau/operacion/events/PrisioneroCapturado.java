package co.com.sofkau.operacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.operacion.entitys.prisionero.PrisioneroId;
import co.com.sofkau.operacion.entitys.values.EdadPrisionero;
import co.com.sofkau.operacion.entitys.values.Genero;
import co.com.sofkau.operacion.entitys.values.Nacionalidad;
import co.com.sofkau.operacion.entitys.values.Nombre;

import java.util.UUID;

public class PrisioneroCapturado extends DomainEvent {
    private final PrisioneroId prisioneroId;
    private final Nombre nombre;
    private final Nacionalidad nacionalidad;
    private final EdadPrisionero edad;
    private final Genero genero;

    public PrisioneroCapturado(PrisioneroId prisioneroId, Nombre nombre, Nacionalidad nacionalidad, EdadPrisionero edad, Genero genero) {
        super("sofkau.operacion.prisionerocapturado");
        this.prisioneroId = prisioneroId;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.genero = genero;
    }

    public PrisioneroId prisioneroId() {
        return prisioneroId;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Nacionalidad nacionalidad() {
        return nacionalidad;
    }

    public EdadPrisionero edad() {
        return edad;
    }

    public Genero genero() {
        return genero;
    }
}
