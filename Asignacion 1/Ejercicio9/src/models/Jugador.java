package models;

public class Jugador {
    private String nombre;
    private char ficha; // 'X' o 'O'

    public Jugador(String nombre, char ficha) {
        if (ficha != 'X' && ficha != 'O') {
            throw new IllegalArgumentException("La ficha debe ser X o O");
        }
        this.nombre = nombre;
        this.ficha = ficha;
    }

    public String getNombre() {
        return nombre;
    }

    public char getFicha() {
        return ficha;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", ficha=" + ficha +
                '}';
    }
}