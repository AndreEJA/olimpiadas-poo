package run;

import modelos.Equipo;
import modelos.Partida;
import modelos.Torneo;

public class Programa {
    public static void main(String[] args) {
        Equipo jaguares = new Equipo("jaguares");
        Equipo leonas = new Equipo("leonas");

        if(true) {
            Torneo torneo = new Torneo();
            torneo.AñadirPartida(jaguares, leonas);
        }
        // Ya esta destruido torneo
    }
}
