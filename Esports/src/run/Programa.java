package run;

import modelos.DAOs.*;
import modelos.*;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // DAOs
        JugadorDAO jugadorDAO = new JugadorDAO();
        EquipoDAO equipoDAO = new EquipoDAO();
        TorneoDAO torneoDAO = new TorneoDAO();

        boolean running = true;
        while (running) {
            System.out.println("\n=== Sistema de Gestión de Torneos de eSports ===");
            System.out.println("1. Crear Jugador");
            System.out.println("2. Crear Equipo");
            System.out.println("3. Crear Torneo");
            System.out.println("4. Registrar Equipo en Torneo");
            System.out.println("5. Crear Juego y Partida");
            System.out.println("6. Ver Torneos");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case(1): {
                    System.out.print("ID del jugador: ");
                    String id = sc.nextLine();
                    System.out.print("Nombre del jugador: ");
                    String nombre = sc.nextLine();
                    System.out.print("Alias: ");
                    String alias = sc.nextLine();
                    System.out.print("Ranking: ");
                    int ranking = sc.nextInt();
                    sc.nextLine();
                    Jugador j = new Jugador(id, nombre, alias, ranking);
                    jugadorDAO.Add(j);
                    System.out.println("Jugador creado: " + j);
                    break;
                }
                case(2): {
                    System.out.print("ID del equipo: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre del equipo: ");
                    String nombre = sc.nextLine();
                    Equipo e = new Equipo(id, nombre);

                    System.out.println("¿Cuántos jugadores desea añadir?");
                    int num = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < num; i++) {
                        System.out.print("Alias del jugador a añadir: ");
                        String alias = sc.nextLine();
                        Jugador j = jugadorDAO.EncontrarPorAlias(alias);
                        if (j != null) {
                            e.AñadirJugador(j);
                            System.out.println("Añadido: " + j);
                        } else {
                            System.out.println("Jugador no encontrado.");
                        }
                    }
                    equipoDAO.Add(e);
                    System.out.println("Equipo creado: " + e);
                    break;
                }
                case(3): {
                    System.out.print("ID del torneo: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre del torneo: ");
                    String nombre = sc.nextLine();
                    Torneo t = new Torneo(id, nombre);
                    torneoDAO.Add(t);
                    System.out.println("Torneo creado: " + t);
                    break;
                }
                case(4): {
                    System.out.print("ID del torneo: ");
                    int idTorneo = sc.nextInt();
                    System.out.print("ID del equipo: ");
                    int idEquipo = sc.nextInt();
                    sc.nextLine();
                    Torneo t = torneoDAO.EncontrarPorID(idTorneo);
                    Equipo e = equipoDAO.EncontrarPorID(idEquipo);
                    if (t != null && e != null) {
                        t.RegistrarEquipo(e);
                        System.out.println("Equipo registrado en torneo.");
                    } else {
                        System.out.println("Error: torneo o equipo no encontrado.");
                    }

                }
                case(5): {
                    System.out.print("Nombre del juego: ");
                    String nombreJuego = sc.nextLine();
                    System.out.print("Categoría del juego: ");
                    String nombreCategoria = sc.nextLine();
                    Categoria cat = new Categoria(nombreCategoria);
                    Juego juego = new Juego(nombreJuego, cat);

                    System.out.print("ID del torneo: ");
                    int idTorneo = sc.nextInt();
                    System.out.print("ID del equipo 1: ");
                    int idE1 = sc.nextInt();
                    System.out.print("ID del equipo 2: ");
                    int idE2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("ID del árbitro: ");
                    String idArbitro = sc.nextLine();
                    System.out.print("Nombre del árbitro: ");
                    String nombreArbitro = sc.nextLine();
                    Arbitro arbitro = new Arbitro(idArbitro, nombreArbitro);

                    Torneo t = torneoDAO.EncontrarPorID(idTorneo);
                    if (t != null) {
                        t.AñadirPartida(idE1, idE2, juego, arbitro);
                        System.out.println("Partida creada.");
                    } else {
                        System.out.println("Torneo no encontrado.");
                    }
                }
                case(6): {
                    torneoDAO.ImprimirTorneos();
                }
                case(0): {
                    running = false;
                    System.out.println("Saliendo...");
                }
                default: System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }
}
