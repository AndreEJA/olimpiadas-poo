package modelos;

public class Jugador {
    private static long nextId = 1;
    private long id;
    private String nombre;
    private String alias;
    private int ranking;


    public Jugador(String nombre, String alias, int ranking) {
        this.id = nextId++;
        this.nombre = nombre;
        this.alias = alias;
        this.ranking = ranking;
    }


    public long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }
    public int getRanking() { return ranking; }
    public void setRanking(int ranking) { this.ranking = ranking; }
    public String toString() { return "Jugador{"+id+":"+alias+" ("+nombre+")}"; }
}
