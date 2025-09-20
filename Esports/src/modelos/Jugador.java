package modelos;

import java.util.Objects;

public class Jugador {
    private static long nextId = 1;
    private long id;
    private String nombre;
    private String alias;
    private int ranking;
    private Equipo equipo;


    public Jugador(String nombre, String alias, int ranking) {
        this.id = nextId++;
        this.nombre = nombre;
        this.alias = alias;
        this.ranking = ranking;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return id == jugador.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public long getId() {return id;}
    public Equipo getEquipo() { return equipo; }
    protected void setEquipo(Equipo e) { this.equipo = e; }

    @Override
    public String toString() {
        String eqName = (equipo == null ? "Libre" : equipo.getNombre());
        return "Jugador{" + id + ", " + alias + "/" + nombre + ", rank=" + ranking + ", equipo=" + eqName + "}";
    }
}
