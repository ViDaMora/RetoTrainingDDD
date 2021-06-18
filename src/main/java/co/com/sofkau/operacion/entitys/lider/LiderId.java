package co.com.sofkau.operacion.entitys.lider;

import co.com.sofka.domain.generic.Identity;

public class LiderId extends Identity {
    public LiderId(String uuid) {
        super(uuid);
    }

    public LiderId() {
    }

    public static LiderId of(String id){
        return new LiderId(id);
    }
}
