package co.com.sofkau.operacion;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.operacion.entitys.lider.Lider;
import co.com.sofkau.operacion.entitys.prisionero.Prisionero;
import co.com.sofkau.operacion.events.*;

public class OperacionChange extends EventChange {
    public OperacionChange(Operacion operacion) {
        apply((DescripcionActualizada event)->{
            operacion.descripcion = event.descripcion();
        });

        apply((LiderAsignado event)->{
            operacion.lider= new Lider(event.liderId(), event.nombre(), event.nacionalidad(), event.edad(), event.autoridad(), event.genero());
        });

        apply((NombreActualizado event)->{
            operacion.nombre= event.nombre();
        });
        apply((OperacionCreada event)->{
            operacion.nombre= event.nombre();
            operacion.prisioneros = event.prisioneros();
            operacion.pais = event.pais();
            operacion.region= event.region();
            operacion.lider=event.lider();
            operacion.descripcion = event.descripcion();
            operacion.unidadesMilitares= event.unidadesMilitares();
        });

        apply((PrisioneroCapturado event)->{
            if (event.edad().value()<=18)
                throw new IllegalArgumentException("No se pueden caputar personas menores de 18 años");
            operacion.prisioneros.add(new Prisionero(event.prisioneroId(), event.nombre(),
                    event.nacionalidad(), event.edad(), event.genero()));
        });

        apply((UnidadMilitarAsignada event)->{
            operacion.unidadesMilitares.add(event.unidadMilitarId());
        });


        apply((UnidadMilitarRetirada event)->{
            var numeroUnidades = operacion.unidadesMilitares.size();
            if (numeroUnidades <=1)
                throw new IllegalArgumentException("Una operacion no puede quedarse sin unidades");
            operacion.unidadesMilitares.removeIf(unidadMilitarId -> unidadMilitarId.equals(event.unidadMilitarId()));
        });
    }
}
