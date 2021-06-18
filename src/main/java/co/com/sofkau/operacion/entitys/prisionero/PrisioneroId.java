package co.com.sofkau.operacion.entitys.prisionero;

import co.com.sofka.domain.generic.Identity;

public class PrisioneroId  extends Identity {
    public PrisioneroId(String uuid) {
        super(uuid);
    }

    public PrisioneroId() {
    }
    public static PrisioneroId of(String id){
        return new PrisioneroId(id);
    }
}
