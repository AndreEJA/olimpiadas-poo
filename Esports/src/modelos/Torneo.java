package modelos;

import java.util.*;

public class Torneo {
    private static long nextId = 1;
    private long id;
    private String nombre;
    private Set<Equipo> equipos = new HashSet<>();
    private ArrayList<Partida> partidas = new ArrayList<Partida>();


    public Torneo(String nombre) {
        this.id = nextId++;
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Torneo torneo = (Torneo) o;
        return id == torneo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public boolean inscribirEquipo(Equipo e) {
        return equipos.add(e);
    }

    public boolean desinscribirEquipo(Equipo e) {
        return equipos.remove(e);
    }

    public Partida crearPartida(Equipo a, Equipo b, Juego juego, Arbitro arbitro) {
        if (!equipos.contains(a) || !equipos.contains(b)) {
            throw new IllegalStateException("Los equipos deben estar inscritos en el torneo");
        }
        Partida p = new Partida(a, b, juego, arbitro, this);
        partidas.add(p);
        return p;
    }

    public void eliminar() {
        partidas.clear();
        equipos.clear();
    }

    public boolean estaInscrito(Equipo e) {
        return equipos.contains(e);
    }

    public long getId() { return id; }
    public String getNombre() { return nombre; }
    public List<Partida> getPartidas() {return Collections.unmodifiableList(partidas);}

    @Override
    public String toString() {
        return "Torneo{" + id + ", " + nombre + ", equipos=" + equipos.size() +
                ", partidas=" + partidas.size() + "}";
    }
}
