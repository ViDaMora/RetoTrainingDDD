package co.com.sofkau.unidadmilitar.entitys.armamento;

import co.com.sofka.domain.generic.Identity;

public class ArmamentoId extends Identity {
    public ArmamentoId(String uuid) {
        super(uuid);
    }

    public ArmamentoId() {
    }

    public static ArmamentoId of(String id){
        return new  ArmamentoId(id);
    }
}
