package modelos;

import java.util.Objects;

public class Arbitro extends Persona {

    public Arbitro(String nombre) {
        super(nombre);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arbitro arbitro = (Arbitro) o;
        return this.id == arbitro.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public String toString() {
        return "Arbitro{" + id + ":" + nombre + "}";
    }
}