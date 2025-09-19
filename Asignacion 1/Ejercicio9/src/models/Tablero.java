package models;

public class Tablero {
    private char[][] tablero;

    public Tablero() {
        tablero = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    // Colocar ficha en una posición
    public boolean colocarFicha(int fila, int col, char ficha) {
        if (fila < 0 || fila >= 3 || col < 0 || col >= 3) {
            System.out.println("Posición fuera de rango.");
            return false;
        }
        if (tablero[fila][col] != ' ') {
            System.out.println("Esa casilla ya está ocupada.");
            return false;
        }
        tablero[fila][col] = ficha;
        return true;
    }

    public char verificarGanador() {
        // Filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != ' ' &&
                    tablero[i][0] == tablero[i][1] &&
                    tablero[i][1] == tablero[i][2]) {
                return tablero[i][0];
            }
        }

        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] != ' ' &&
                    tablero[0][j] == tablero[1][j] &&
                    tablero[1][j] == tablero[2][j]) {
                return tablero[0][j];
            }
        }

        if (tablero[0][0] != ' ' &&
                tablero[0][0] == tablero[1][1] &&
                tablero[1][1] == tablero[2][2]) {
            return tablero[0][0];
        }

        if (tablero[0][2] != ' ' &&
                tablero[0][2] == tablero[1][1] &&
                tablero[1][1] == tablero[2][0]) {
            return tablero[0][2];
        }

        return ' '; // No hay ganador todavía
    }

    public void mostrarTablero() {
        System.out.println("  0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println(" ---+---+---");
        }
    }

    public boolean estaLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}