package co.com.sofkau.unidadmilitar.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Proposito implements ValueObject<String> {
    private final String value;

    public Proposito(String proposito) {
        this.value = proposito;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Proposito)) return false;
        Proposito proposito1 = (Proposito) o;
        return Objects.equals(value, proposito1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
