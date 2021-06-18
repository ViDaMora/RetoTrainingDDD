package co.com.sofkau.operacion.entitys.values;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EdadPrisionero implements ValueObject<Integer> {
    private final Integer value;

    public EdadPrisionero(Integer value) {
        this.value = this.rules(value);
    }

    public Integer value() {
        return value;
    }

    private Integer rules(Integer value){
        if(value< 18)
            throw new IllegalArgumentException("No se pueden capturar menores de edad.");
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EdadPrisionero)) return false;
        EdadPrisionero that = (EdadPrisionero) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
