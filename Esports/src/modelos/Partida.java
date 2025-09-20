package modelos;

public class Partida {
    private static long nextId = 1;
    private long id;
    private Equipo equipoA;
    private Equipo equipoB;
    private Juego juego;
    private Arbitro arbitro;
    private Torneo torneo;
    private String resultado;


    public Partida(Equipo a, Equipo b, Juego j, Arbitro ar, Torneo t) {
        this.id = nextId++;
        this.equipoA = a;
        this.equipoB = b;
        this.juego = j;
        this.arbitro = ar;
        this.torneo = t;
    }

    @Override
    public String toString() {
        return "Partida{" + id + ", " + equipoA.getNombre() + " vs " + equipoB.getNombre() +
                ", juego=" + juego.getNombre() + ", árbitro=" + arbitro.getNombre() +
                ", torneo=" + torneo.getNombre() + "}";
    }
}
