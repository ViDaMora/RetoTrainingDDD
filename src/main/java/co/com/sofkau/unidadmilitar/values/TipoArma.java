package co.com.sofkau.unidadmilitar.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoArma implements ValueObject<String> {
    private final String tipoArma;

    public TipoArma(String tipoArma) {
        this.tipoArma = tipoArma;
    }

    @Override
    public String value() {
        return tipoArma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoArma)) return false;
        TipoArma tipoArma1 = (TipoArma) o;
        return Objects.equals(tipoArma, tipoArma1.tipoArma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoArma);
    }
}
