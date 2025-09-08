import models.Jugador;
import models.Tablero;

public class Main {
    public static void main(String[] args) {
        Jugador j1 = new Jugador("Harry", 'X');
        Jugador j2 = new Jugador("Andre", 'O');

        Tablero tablero = new Tablero();

        tablero.colocarFicha(0, 0, j1.getFicha());
        tablero.colocarFicha(1, 1, j2.getFicha());
        tablero.colocarFicha(0, 1, j1.getFicha());
        tablero.colocarFicha(2, 2, j2.getFicha());
        tablero.colocarFicha(0, 2, j1.getFicha());

        tablero.mostrarTablero();

        char ganador = tablero.verificarGanador();
        if (ganador != ' ') {
            System.out.println("¡El ganador es: " + ganador + "!");
        } else if (tablero.estaLleno()) {
            System.out.println("Es un empate.");
        } else {
            System.out.println("El juego continúa...");
        }
    }
}