package co.com.sofkau.unidadmilitar;

import co.com.sofka.domain.generic.Identity;

public class UnidadMilitarId extends Identity {
    public UnidadMilitarId(String uuid) {
        super(uuid);
    }

    public UnidadMilitarId() {
    }

    public static UnidadMilitarId of(String id){
        return new  UnidadMilitarId(id);
    }
}
