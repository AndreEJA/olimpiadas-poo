package modelos;

import java.util.Objects;

public class Jugador extends Persona {
    private String alias;
    private int ranking;
    private Equipo equipo;

    public Jugador(String nombre, String alias, int ranking) {
        super(nombre);
        this.alias = alias;
        this.ranking = ranking;
    }

    public Equipo getEquipo() { return equipo; }
    protected void setEquipo(Equipo e) { this.equipo = e; }
    public long getId() { return super.getId(); }
    public String getNombre() { return super.getNombre(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return this.id == jugador.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        String eqName = (equipo == null ? "Libre" : equipo.getNombre());
        return "Jugador{" + id + ", " + alias + "/" + nombre
                + ", rank=" + ranking + ", equipo=" + eqName + "}";
    }
}