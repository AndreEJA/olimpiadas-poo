package modelos;

public class Partida {
    Equipo equipo1;
    Equipo equipo2;
    Juego juego;

    public Partida(Equipo equipo1, Equipo equipo2, Juego juego) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.juego = juego;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "equipo1=" + equipo1 +
                ", equipo2=" + equipo2 +
                ", juego=" + juego +
                '}';
    }
}
