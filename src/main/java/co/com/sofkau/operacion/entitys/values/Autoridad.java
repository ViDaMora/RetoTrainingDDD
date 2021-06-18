package co.com.sofkau.operacion.entitys.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.*;

public class Autoridad implements ValueObject<String> {
    private final String value;

    public Autoridad(String value) {
        this.value = this.rules(value);
    }

    public String value() {
        return value;
    }

    public String rules(String value){
        Set<String> cadenaDeMando = new HashSet<>();
        cadenaDeMando.add("general");
        cadenaDeMando.add("teniente");
        cadenaDeMando.add("mayor");
        cadenaDeMando.add("brigadier");
        cadenaDeMando.add("coronel");
        cadenaDeMando.add("comandante");
        cadenaDeMando.add("capitan");
        cadenaDeMando.add("sargento");
        cadenaDeMando.add("soldado");
        cadenaDeMando.add("cabo");

        if (!cadenaDeMando.contains(value.toLowerCase(Locale.ROOT)))
            throw new IllegalArgumentException("Mando incorrecto, revise la cadena de mandos.");
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autoridad)) return false;
        Autoridad autoridad = (Autoridad) o;
        return Objects.equals(value, autoridad.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
