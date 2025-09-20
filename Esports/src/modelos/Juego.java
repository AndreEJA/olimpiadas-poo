package modelos;

import java.util.Objects;

public class Juego {
    private static long nextId = 1;
    private long id;
    private String nombre;
    private Categoria categoria;


    public Juego(String nombre, Categoria categoria) {
        this.id = nextId++;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Juego juego = (Juego) o;
        return id == juego.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public long getId() {return id;}
    public String getNombre() {return nombre;}

    @Override
    public String toString() { return "Juego{"+id+":"+nombre+" cat="+categoria.getNombre()+"}"; }
}
