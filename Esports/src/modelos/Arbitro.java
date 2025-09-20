package modelos;

public class Arbitro {
    private static long nextId = 1;
    private long id;
    private String nombre;


    public Arbitro(String nombre) {
        this.id = nextId++;
        this.nombre = nombre;
    }


    public long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String n) { this.nombre = n; }
    public String toString() { return "Arbitro{"+id+":"+nombre+"}"; }
}
