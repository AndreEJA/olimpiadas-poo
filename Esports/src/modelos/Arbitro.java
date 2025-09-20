package modelos;

import java.util.Objects;

public class Arbitro {
    private static long nextId = 1;
    private long id;
    private String nombre;


    public Arbitro(String nombre) {
        this.id = nextId++;
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Arbitro arbitro = (Arbitro) o;
        return id == arbitro.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public long getId() { return id; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() { return "Arbitro{"+id+":"+nombre+"}"; }

}
