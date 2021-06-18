package co.com.sofkau.unidadmilitar.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Edad implements ValueObject<Integer> {
    private final Integer value;

    public Edad(Integer value) {
        this.value = this.rules(value);
    }


    private Integer rules(Integer value){
        if (value < 18)
            throw new IllegalArgumentException("Ingrese una edad valida, no pueden haber militares menores de 18 anos");
        return value;
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edad)) return false;
        Edad edad = (Edad) o;
        return Objects.equals(value, edad.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
