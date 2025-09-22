package modelos;

public class Persona {
    public static long nextId = 1;
    public long id;
    public String nombre;

    public Persona(String nombre) {
        this.id = nextId++;
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
