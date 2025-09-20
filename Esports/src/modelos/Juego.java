package modelos;

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


    public long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria c) { this.categoria = c; }
    public String toString() { return "Juego{"+id+":"+nombre+" cat="+categoria.getNombre()+"}"; }
}
