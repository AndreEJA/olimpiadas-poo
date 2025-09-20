package modelos;

import java.util.Objects;

public class Categoria {
    private static long nextId = 1;
    private long id;
    private String nombre;


    public Categoria(String nombre) {
        this.id = nextId++;
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id == categoria.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public long getId() {return id;}
    public String getNombre() {return nombre;}

    @Override
    public String toString() { return "Categoria{"+id+":"+nombre+"}"; }
}
