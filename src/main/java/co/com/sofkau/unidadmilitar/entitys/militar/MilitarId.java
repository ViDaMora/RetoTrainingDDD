package co.com.sofkau.unidadmilitar.entitys.militar;

import co.com.sofka.domain.generic.Identity;

public class MilitarId extends Identity {

    public MilitarId(String uuid) {
        super(uuid);
    }

    public MilitarId() {
    }

    public static MilitarId of(String id){
        return new MilitarId(id);
    }
}
