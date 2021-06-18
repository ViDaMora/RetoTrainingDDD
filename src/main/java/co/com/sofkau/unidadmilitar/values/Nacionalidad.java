package co.com.sofkau.unidadmilitar.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nacionalidad implements ValueObject<String> {
        private final String value;

    public Nacionalidad(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nacionalidad)) return false;
        Nacionalidad that = (Nacionalidad) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
