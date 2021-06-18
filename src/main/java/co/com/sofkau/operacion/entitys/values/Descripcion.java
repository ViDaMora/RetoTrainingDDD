package co.com.sofkau.operacion.entitys.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {
    private final String value;

    public Descripcion(String value) {
        this.value = this.rules(value);
    }

    public String value() {
        return value;
    }

    private String rules(String value){
        if (value.length() < 10)
            throw new IllegalArgumentException("No se permiten descripciones con menos de 10 caracteres");
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Descripcion)) return false;
        Descripcion that = (Descripcion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
