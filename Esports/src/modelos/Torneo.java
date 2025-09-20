package modelos;

import java.util.ArrayList;

public class Torneo {
    private static long nextId = 1;
    private long id;
    private String nombre;
    private ArrayList<Equipo> equipos = new ArrayList<Equipo>();
    private ArrayList<Partida> partidas = new ArrayList<Partida>();


    public Torneo(String nombre) {
        this.id = nextId++;
        this.nombre = nombre;
    }


    public long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String n) { this.nombre = n; }
    public void addEquipo(Equipo e) { equipos.add(e); }
    public void removeEquipo(Equipo e) { equipos.remove(e); }


    public Partida crearPartida(Equipo a, Equipo b, Juego j, Arbitro ar) {
        Partida p = new Partida(a,b,j,ar,this);
        partidas.add(p);
        return p;
    }


    public void eliminarPartida(Partida p) { partidas.remove(p); }
    public void eliminarTodasPartidas() { partidas.clear(); }


    public String toString() { return id+":"+nombre+" ("+equipos.size()+" equipos, "+partidas.size()+" partidas)"; }
    public ArrayList<Equipo> getEquipos() { return equipos; }
    public ArrayList<Partida> getPartidas() { return partidas; }
}
