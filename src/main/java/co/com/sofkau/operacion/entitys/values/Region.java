package co.com.sofkau.operacion.entitys.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Region implements ValueObject<String> {
    private final String value;

    public Region(String value) {
        this.value = this.rules(value);
    }

    public String rules(String value){
        if (value.length()<4)
            throw new IllegalArgumentException("Ingrese una region valida, debe tener mas de 4 caracteres");
        return value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Region)) return false;
        Region region = (Region) o;
        return Objects.equals(value(), region.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }
}
