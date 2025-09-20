package modelos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Equipo {
    private static long nextId = 1;
    private long id;
    private String nombre;
    private Set<Jugador> jugadores = new HashSet<>();


    public Equipo(String nombre) {
        this.id = nextId++;
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return id == equipo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public boolean agregarJugador(Jugador j) {
        if (j.getEquipo() != null) {
            j.getEquipo().quitarJugador(j);
        }
        j.setEquipo(this);
        return jugadores.add(j);
    }

    public boolean quitarJugador(Jugador j) {
        if (jugadores.remove(j)) {
            j.setEquipo(null);
            return true;
        }
        return false;
    }

    public long getId() { return id; }
    public String getNombre() { return nombre; }
    public Set<Jugador> getJugadores() { return jugadores; }

    @Override
    public String toString() {
        return "Equipo{" + id + ", " + nombre + ", jugadores=" + jugadores + "}";
    }
}
