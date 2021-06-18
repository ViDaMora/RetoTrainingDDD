package co.com.sofkau.unidadmilitar.entitys.vehiculo;

import co.com.sofka.domain.generic.Identity;

public class VehiculoId extends Identity {

    public VehiculoId(String uuid) {
        super(uuid);
    }

    public VehiculoId() {
    }

    public static VehiculoId of(String id){
        return new VehiculoId(id);
    }

}
