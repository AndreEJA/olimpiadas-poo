package modelos;

import java.util.ArrayList;

public class Torneo {
    private int id;
    private String nombre;
    private ArrayList<Partida> partidas = new ArrayList<>();
    private ArrayList<Equipo> equipos = new ArrayList<>();

    public Torneo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void RegistrarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public Equipo ObtenerEquipoPorID(int id) {
        for(Equipo equipo : equipos) {
            if(equipo.getId() == id)
                return equipo;
        }
        return null;
    }

    public void AñadirPartida(int idEquipo1, int idEquipo2, Juego juego, Arbitro arbitro) {
        Equipo equipo1 = ObtenerEquipoPorID(idEquipo1);
        Equipo equipo2 = ObtenerEquipoPorID(idEquipo2);

        if(equipo1 == null || equipo2 == null) {
            System.out.println("Error agregando partida: Uno o ambos equipos no estan registrados en el torneo.");
            return;
        }

        // Aca existe composición, porque la propia clase crea la partida, por lo que, a la hora de
        // ser destruida, todas las partidas creadas son destruidas con la clase.
        partidas.add(new Partida(equipo1, equipo2, juego, arbitro));
    }

    @Override
    public String toString() {
        return "Torneo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
