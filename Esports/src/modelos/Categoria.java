package modelos;

public class Categoria {
    private static long nextId = 1;
    private long id;
    private String nombre;


    public Categoria(String nombre) {
        this.id = nextId++;
        this.nombre = nombre;
    }


    public long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String toString() { return "Categoria{"+id+":"+nombre+"}"; }
}
