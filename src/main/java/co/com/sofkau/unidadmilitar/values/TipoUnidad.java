package co.com.sofkau.unidadmilitar.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Locale;
import java.util.Objects;

public class TipoUnidad  implements ValueObject<String> {
    private final String value;

    public String value() {
        return value;
    }

    public TipoUnidad(String value) {
        this.value = this.rules(value);
    }
    public String rules(String value){
        value = value.toLowerCase(Locale.ROOT);
        if (value.equals("maritimo") ||value.equals("aereo")||value.equals("terrestre") )
            return value;
        throw new IllegalArgumentException("Las unidades solo pueden ser, maritimas, aereas o terrestres");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoUnidad)) return false;
        TipoUnidad that = (TipoUnidad) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
