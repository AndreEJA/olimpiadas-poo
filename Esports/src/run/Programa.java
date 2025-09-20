package run;

import modelos.*;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        Sistema s = new Sistema();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== SISTEMA eSports ===");
            System.out.println("1) Torneos");
            System.out.println("2) Categorías");
            System.out.println("3) Juegos");
            System.out.println("4) Jugadores");
            System.out.println("5) Equipos");
            System.out.println("6) Árbitros");
            System.out.println("7) Imprimir estado completo");
            System.out.println("0) Salir");
            System.out.print("Opción: ");

            int op = leerEntero(sc);
            switch (op) {
                case 1 -> submenuTorneos(sc, s);
                case 2 -> submenuCategorias(sc, s);
                case 3 -> submenuJuegos(sc, s);
                case 4 -> submenuJugadores(sc, s);
                case 5 -> submenuEquipos(sc, s);
                case 6 -> submenuArbitros(sc, s);
                case 7 -> s.imprimirEstado();
                case 0 -> { System.out.println("Ciao Ciao"); return; }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    // ===================== SUBMENÚS =====================

    private static void submenuTorneos(Scanner sc, Sistema s) {
        while (true) {
            System.out.println("\n--- Torneos ---");
            System.out.println("1) Listar");
            System.out.println("2) Crear");
            System.out.println("3) Borrar por ID (elimina sus Partidas)");
            System.out.println("4) Inscribir equipo en torneo");
            System.out.println("5) Desinscribir equipo de torneo");
            System.out.println("6) Listar partidas de un torneo");
            System.out.println("7) Crear partida en un torneo");
            System.out.println("0) Volver");
            System.out.print("Opción: ");
            int op = leerEntero(sc);

            switch (op) {
                case 1 -> listar(s.torneos, "No hay torneos.");
                case 2 -> {
                    String nombre = pedirTexto(sc, "Nombre del torneo: ");
                    s.torneos.add(new Torneo(nombre));
                    System.out.println("Torneo creado.");
                }
                case 3 -> {
                    if (s.torneos.isEmpty()) { System.out.println("No hay torneos."); break; }
                    listar(s.torneos, "");
                    long id = pedirId(sc, "ID de torneo a borrar: ");
                    Torneo t = findTorneo(s, id);
                    if (t == null) System.out.println("No existe torneo con ese ID.");
                    else {
                        t.eliminar();
                        s.torneos.remove(t);
                        System.out.println("Torneo eliminado.");
                    }
                }
                case 4 -> {
                    if (s.torneos.isEmpty() || s.equipos.isEmpty()) {
                        System.out.println("Necesitas al menos 1 torneo y 1 equipo.");
                        break;
                    }
                    listar(s.torneos, ""); listar(s.equipos, "");
                    long idT = pedirId(sc, "ID torneo: ");
                    long idE = pedirId(sc, "ID equipo: ");
                    Torneo t = findTorneo(s, idT);
                    Equipo e = findEquipo(s, idE);
                    if (t == null || e == null) { System.out.println("ID inválido."); break; }
                    boolean ok = t.inscribirEquipo(e);
                    System.out.println(ok ? "Equipo inscrito." : "El equipo ya estaba inscrito.");
                }
                case 5 -> {
                    if (s.torneos.isEmpty() || s.equipos.isEmpty()) {
                        System.out.println("No hay datos suficientes.");
                        break;
                    }
                    listar(s.torneos, ""); listar(s.equipos, "");
                    long idT = pedirId(sc, "ID torneo: ");
                    long idE = pedirId(sc, "ID equipo: ");
                    Torneo t = findTorneo(s, idT);
                    Equipo e = findEquipo(s, idE);
                    if (t == null || e == null) { System.out.println("ID inválido."); break; }
                    boolean ok = t.desinscribirEquipo(e);
                    System.out.println(ok ? "Equipo desinscrito." : "Ese equipo no estaba inscrito.");
                }
                case 6 -> {
                    if (s.torneos.isEmpty()) { System.out.println("No hay torneos."); break; }
                    listar(s.torneos, "");
                    long idT = pedirId(sc, "ID torneo: ");
                    Torneo t = findTorneo(s, idT);
                    if (t == null) { System.out.println("Torneo no existe."); break; }
                    List<Partida> ps = t.getPartidas();
                    if (ps.isEmpty()) System.out.println("Ese torneo no tiene partidas.");
                    else ps.forEach(p -> System.out.println(" - " + p));
                }
                case 7 -> {
                    if (s.torneos.isEmpty()) { System.out.println("No hay torneos."); break; }
                    if (s.equipos.size() < 2) { System.out.println("Necesitas al menos 2 equipos."); break; }
                    if (s.juegos.isEmpty()) { System.out.println("Necesitas al menos 1 juego."); break; }
                    if (s.arbitros.isEmpty()) { System.out.println("Necesitas al menos 1 árbitro."); break; }

                    listar(s.torneos, "");
                    long idT = pedirId(sc, "ID torneo: ");
                    Torneo t = findTorneo(s, idT);
                    if (t == null) { System.out.println("Torneo no existe."); break; }

                    listar(s.equipos, "");
                    long idA = pedirId(sc, "ID equipo A: ");
                    long idB = pedirId(sc, "ID equipo B: ");
                    Equipo a = findEquipo(s, idA);
                    Equipo b = findEquipo(s, idB);
                    if (a == null || b == null || a == b) { System.out.println("Equipos inválidos."); break; }

                    listar(s.juegos, "");
                    long idJ = pedirId(sc, "ID juego: ");
                    Juego juego = findJuego(s, idJ);
                    if (juego == null) { System.out.println("Juego no existe."); break; }

                    listar(s.arbitros, "");
                    long idAr = pedirId(sc, "ID árbitro: ");
                    Arbitro arb = findArbitro(s, idAr);
                    if (arb == null) { System.out.println("Árbitro no existe."); break; }

                    try {
                        Partida p = t.crearPartida(a, b, juego, arb); // usa tu método con nextId interno
                        System.out.println("Partida creada: " + p);
                    } catch (IllegalStateException ex) {
                        System.out.println("Error: " + ex.getMessage() + " (inscribe los equipos al torneo primero).");
                    }
                }
                case 0 -> { return; }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void submenuCategorias(Scanner sc, Sistema s) {
        while (true) {
            System.out.println("\n--- Categorías ---");
            System.out.println("1) Listar");
            System.out.println("2) Crear");
            System.out.println("3) Borrar por ID");
            System.out.println("0) Volver");
            System.out.print("Opción: ");
            int op = leerEntero(sc);

            switch (op) {
                case 1 -> listar(s.categorias, "No hay categorías.");
                case 2 -> {
                    String nombre = pedirTexto(sc, "Nombre categoría: ");
                    s.categorias.add(new Categoria(nombre));
                    System.out.println("Categoría creada.");
                }
                case 3 -> {
                    if (s.categorias.isEmpty()) { System.out.println("No hay categorías."); break; }
                    listar(s.categorias, "");
                    long id = pedirId(sc, "ID a borrar: ");
                    Categoria c = findCategoria(s, id);
                    if (c == null) System.out.println("No existe categoría con ese ID.");
                    else {
                        // (opcional) validar que ningún Juego la use
                        s.categorias.remove(c);
                        System.out.println("Categoría eliminada.");
                    }
                }
                case 0 -> { return; }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void submenuJuegos(Scanner sc, Sistema s) {
        while (true) {
            System.out.println("\n--- Juegos ---");
            System.out.println("1) Listar");
            System.out.println("2) Crear");
            System.out.println("3) Borrar por ID");
            System.out.println("0) Volver");
            System.out.print("Opción: ");
            int op = leerEntero(sc);

            switch (op) {
                case 1 -> listar(s.juegos, "No hay juegos.");
                case 2 -> {
                    if (s.categorias.isEmpty()) {
                        System.out.println("Primero crea al menos 1 categoría.");
                        break;
                    }
                    String nombre = pedirTexto(sc, "Nombre juego: ");
                    listar(s.categorias, "");
                    long idCat = pedirId(sc, "ID categoría: ");
                    Categoria cat = findCategoria(s, idCat);
                    if (cat == null) System.out.println("Categoría no encontrada.");
                    else {
                        s.juegos.add(new Juego(nombre, cat));
                        System.out.println("Juego creado.");
                    }
                }
                case 3 -> {
                    if (s.juegos.isEmpty()) { System.out.println("No hay juegos."); break; }
                    listar(s.juegos, "");
                    long id = pedirId(sc, "ID a borrar: ");
                    Juego g = findJuego(s, id);
                    if (g == null) System.out.println("No existe juego con ese ID.");
                    else {
                        // (opcional) validar que ninguna partida use este juego
                        s.juegos.remove(g);
                        System.out.println("Juego eliminado.");
                    }
                }
                case 0 -> { return; }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void submenuJugadores(Scanner sc, Sistema s) {
        while (true) {
            System.out.println("\n--- Jugadores ---");
            System.out.println("1) Listar");
            System.out.println("2) Crear");
            System.out.println("3) Borrar por ID");
            System.out.println("0) Volver");
            System.out.print("Opción: ");
            int op = leerEntero(sc);

            switch (op) {
                case 1 -> listar(s.jugadores, "No hay jugadores.");
                case 2 -> {
                    String nombre = pedirTexto(sc, "Nombre real: ");
                    String alias = pedirTexto(sc, "Alias: ");
                    int ranking = pedirEnteroRango(sc, "Ranking (entero >=0): ", 0, Integer.MAX_VALUE);
                    s.jugadores.add(new Jugador(nombre, alias, ranking));
                    System.out.println("Jugador creado.");
                }
                case 3 -> {
                    if (s.jugadores.isEmpty()) { System.out.println("No hay jugadores."); break; }
                    listar(s.jugadores, "");
                    long id = pedirId(sc, "ID a borrar: ");
                    Jugador j = findJugador(s, id);
                    if (j == null) System.out.println("No existe jugador con ese ID.");
                    else {
                        // quitar de cualquier equipo
                        for (Equipo e : s.equipos) e.quitarJugador(j);
                        s.jugadores.remove(j);
                        System.out.println("Jugador eliminado.");
                    }
                }
                case 0 -> { return; }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void submenuEquipos(Scanner sc, Sistema s) {
        while (true) {
            System.out.println("\n--- Equipos ---");
            System.out.println("1) Listar");
            System.out.println("2) Crear");
            System.out.println("3) Borrar por ID");
            System.out.println("4) Agregar jugador a equipo");
            System.out.println("5) Quitar jugador de equipo");
            System.out.println("0) Volver");
            System.out.print("Opción: ");
            int op = leerEntero(sc);

            switch (op) {
                case 1 -> listar(s.equipos, "No hay equipos.");
                case 2 -> {
                    String nombre = pedirTexto(sc, "Nombre equipo: ");
                    s.equipos.add(new Equipo(nombre));
                    System.out.println("Equipo creado.");
                }
                case 3 -> {
                    if (s.equipos.isEmpty()) { System.out.println("No hay equipos."); break; }
                    listar(s.equipos, "");
                    long id = pedirId(sc, "ID a borrar: ");
                    Equipo e = findEquipo(s, id);
                    if (e == null) System.out.println("No existe equipo con ese ID.");
                    else {
                        // desinscribir de torneos
                        for (Torneo t : s.torneos) {
                            if (t.estaInscrito(e)) t.desinscribirEquipo(e);
                        }
                        s.equipos.remove(e);
                        System.out.println("Equipo eliminado.");
                    }
                }
                case 4 -> {
                    if (s.equipos.isEmpty() || s.jugadores.isEmpty()) {
                        System.out.println("Necesitas al menos 1 equipo y 1 jugador.");
                        break;
                    }
                    listar(s.equipos, ""); listar(s.jugadores, "");
                    long idE = pedirId(sc, "ID equipo: ");
                    long idJ = pedirId(sc, "ID jugador: ");
                    Equipo e = findEquipo(s, idE);
                    Jugador j = findJugador(s, idJ);
                    if (e == null || j == null) { System.out.println("ID inválido."); break; }
                    boolean ok = e.agregarJugador(j); // si tu modelo mueve de equipo, esto ya lo maneja
                    System.out.println(ok ? "Jugador agregado (o movido) al equipo." : "El jugador ya estaba en el equipo.");
                }
                case 5 -> {
                    if (s.equipos.isEmpty()) { System.out.println("No hay equipos."); break; }
                    listar(s.equipos, "");
                    long idE = pedirId(sc, "ID equipo: ");
                    Equipo e = findEquipo(s, idE);
                    if (e == null) { System.out.println("Equipo no existe."); break; }
                    ArrayList<Jugador> listaJug = new ArrayList<>(e.getJugadores());
                    listar(listaJug, "Equipo sin jugadores.");
                    if (listaJug.isEmpty()) break;
                    long idJ = pedirId(sc, "ID jugador a quitar: ");
                    Jugador j = findJugador(s, idJ);
                    if (j == null) { System.out.println("Jugador no existe."); break; }
                    boolean ok = e.quitarJugador(j);
                    System.out.println(ok ? "Jugador quitado del equipo." : "Ese jugador no estaba en el equipo.");
                }
                case 0 -> { return; }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void submenuArbitros(Scanner sc, Sistema s) {
        while (true) {
            System.out.println("\n--- Árbitros ---");
            System.out.println("1) Listar");
            System.out.println("2) Crear");
            System.out.println("3) Borrar por ID");
            System.out.println("0) Volver");
            System.out.print("Opción: ");
            int op = leerEntero(sc);

            switch (op) {
                case 1 -> listar(s.arbitros, "No hay árbitros.");
                case 2 -> {
                    String nombre = pedirTexto(sc, "Nombre árbitro: ");
                    s.arbitros.add(new Arbitro(nombre));
                    System.out.println("Árbitro creado.");
                }
                case 3 -> {
                    if (s.arbitros.isEmpty()) { System.out.println("No hay árbitros."); break; }
                    listar(s.arbitros, "");
                    long id = pedirId(sc, "ID a borrar: ");
                    Arbitro a = findArbitro(s, id);
                    if (a == null) System.out.println("No existe árbitro con ese ID.");
                    else {
                        s.arbitros.remove(a);
                        System.out.println("Árbitro eliminado.");
                    }
                }
                case 0 -> { return; }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    // ===================== FINDERS POR ID (usando listas en Sistema) =====================

    private static Categoria findCategoria(Sistema s, long id) {
        for (Categoria c : s.categorias) if (c.getId() == id) return c;
        return null;
    }
    private static Juego findJuego(Sistema s, long id) {
        for (Juego g : s.juegos) if (g.getId() == id) return g;
        return null;
    }
    private static Jugador findJugador(Sistema s, long id) {
        for (Jugador j : s.jugadores) if (j.getId() == id) return j;
        return null;
    }
    private static Equipo findEquipo(Sistema s, long id) {
        for (Equipo e : s.equipos) if (e.getId() == id) return e;
        return null;
    }
    private static Arbitro findArbitro(Sistema s, long id) {
        for (Arbitro a : s.arbitros) if (a.getId() == id) return a;
        return null;
    }
    private static Torneo findTorneo(Sistema s, long id) {
        for (Torneo t : s.torneos) if (t.getId() == id) return t;
        return null;
    }

    // ===================== UTILIDADES DE INPUT =====================

    private static int leerEntero(Scanner sc) {
        while (!sc.hasNextInt()) { System.out.print("Ingresa un número válido: "); sc.next(); }
        int val = sc.nextInt(); sc.nextLine(); return val;
    }
    private static long leerLong(Scanner sc) {
        while (!sc.hasNextLong()) { System.out.print("Ingresa un número válido: "); sc.next(); }
        long val = sc.nextLong(); sc.nextLine(); return val;
    }
    private static long pedirId(Scanner sc, String prompt) {
        System.out.print(prompt);
        return leerLong(sc);
    }
    private static String pedirTexto(Scanner sc, String prompt) {
        System.out.print(prompt);
        String txt = sc.nextLine().trim();
        while (txt.isEmpty()) {
            System.out.print("No puede estar vacío. " + prompt);
            txt = sc.nextLine().trim();
        }
        return txt;
    }
    private static int pedirEnteroRango(Scanner sc, String prompt, int min, int max) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) { System.out.print("Ingresa un número válido: "); sc.next(); }
        int v = sc.nextInt(); sc.nextLine();
        while (v < min || v > max) {
            System.out.print("Fuera de rango. " + prompt);
            while (!sc.hasNextInt()) { System.out.print("Ingresa un número válido: "); sc.next(); }
            v = sc.nextInt(); sc.nextLine();
        }
        return v;
    }

    private static <T> void listar(List<T> lista, String msgVacio) {
        if (lista.isEmpty()) { if (!msgVacio.isEmpty()) System.out.println(msgVacio); return; }
        for (T x : lista) System.out.println(" - " + x);
    }


}



