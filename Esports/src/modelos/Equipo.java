package modelos;

import java.util.ArrayList;

public class Equipo {
    private static long nextId = 1;
    private long id;
    private String nombre;
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();


    public Equipo(String nombre) {
        this.id = nextId++;
        this.nombre = nombre;
    }


    public long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public ArrayList<Jugador> getJugadores() { return jugadores; }
    public void addJugador(Jugador j) { jugadores.add(j); }
    public void removeJugador(Jugador j) { jugadores.remove(j); }
    public String toString() { return "Equipo{"+id+":"+nombre+" jugadores="+jugadores.size()+"}"; }
}
