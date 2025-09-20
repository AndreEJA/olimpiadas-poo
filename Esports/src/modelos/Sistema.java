package modelos;

import java.util.ArrayList;

public class Sistema {
    public ArrayList<Categoria> categorias = new ArrayList<Categoria>();
    public ArrayList<Juego> juegos = new ArrayList<Juego>();
    public ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    public ArrayList<Equipo> equipos = new ArrayList<Equipo>();
    public ArrayList<Arbitro> arbitros = new ArrayList<Arbitro>();
    public ArrayList<Torneo> torneos = new ArrayList<Torneo>();


    public void imprimirEstado() {
        System.out.println("Categorias: "+categorias);
        System.out.println("Juegos: "+juegos);
        System.out.println("Jugadores: "+jugadores);
        System.out.println("Equipos: "+equipos);
        System.out.println("Arbitros: "+arbitros);
        System.out.println("Torneos: "+torneos);
        for(Torneo t: torneos){
            System.out.println(" Partidas en "+t.getNombre()+": "+t.getPartidas());
        }
    }
}
