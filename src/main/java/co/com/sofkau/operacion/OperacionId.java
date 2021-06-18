package co.com.sofkau.operacion;

import co.com.sofka.domain.generic.Identity;

public class OperacionId extends Identity {
    public OperacionId(String uuid) {
        super(uuid);
    }

    public OperacionId() {
    }

    public static OperacionId of(String id){
        return new OperacionId(id);
    }

}
