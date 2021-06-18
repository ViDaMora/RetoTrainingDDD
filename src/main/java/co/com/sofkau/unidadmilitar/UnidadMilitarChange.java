package co.com.sofkau.unidadmilitar;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.unidadmilitar.entitys.armamento.Armamento;
import co.com.sofkau.unidadmilitar.entitys.militar.Militar;
import co.com.sofkau.unidadmilitar.entitys.vehiculo.Vehiculo;
import co.com.sofkau.unidadmilitar.events.*;

public class UnidadMilitarChange extends EventChange {
    public UnidadMilitarChange(UnidadMilitar unidadMilitar) {
        apply((ArmamentoAgregado event)->{
            unidadMilitar.armamentos.add(new Armamento(event.armamentoId(),event.tipoArma()));
        });

        apply((EncargadoAsignado event)->{
            unidadMilitar.encargado= new Militar(event.militarId(),event.nombre(), event.nacionalidad(), event.edad(), event.autoridad(), event.genero());
        });
        apply((MilitarAsignado event)->{
            unidadMilitar.militares.add(new Militar(event.militarId(),event.nombre(), event.nacionalidad(), event.edad(), event.autoridad(), event.genero()));
        });
        apply((MilitarRetirado event)->{
            var numeroMilitares = unidadMilitar.militares.size();
            if (numeroMilitares<=1)
                throw new IllegalArgumentException("No puedes dejar una unidad sin militares");
            unidadMilitar.militares.removeIf(militar -> militar.identity().equals(event.militarId()));
        });
        apply((TipoUnidadActualizada event)->{
            unidadMilitar.tipoUnidad= event.tipoUnidad();
        });
        apply((UnidadMilitarCreada event)->{
            unidadMilitar.tipoUnidad= event.tipoUnidad();
            unidadMilitar.militares= event.militares();
            unidadMilitar.encargado=event.encargado();
            unidadMilitar.armamentos=event.armamentos();
            unidadMilitar.vehiculos=event.vehiculos();
        });
        apply((VehiculoAsignado event)->{
            unidadMilitar.vehiculos.add(new Vehiculo(event.vehiculoId(), event.tipoVehiculo(),event.proposito()));
        });
    }
}
