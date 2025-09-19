package modelos;

import java.util.ArrayList;

public class Equipo {
    private int id;
    private String nombre;

    ArrayList<Jugador> jugadores = new ArrayList<>();

    public Equipo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public void AñadirJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                "jugadores='" + jugadores + '\'' +
                '}';
    }
}
