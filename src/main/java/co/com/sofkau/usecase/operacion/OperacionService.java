package co.com.sofkau.usecase.operacion;

import co.com.sofkau.operacion.OperacionId;
import co.com.sofkau.operacion.entitys.lider.Lider;
import co.com.sofkau.operacion.entitys.lider.LiderId;

public interface OperacionService {
    String getLiderNameByOperacionId(LiderId liderId);

}
