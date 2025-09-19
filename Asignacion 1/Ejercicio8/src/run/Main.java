package run;
import models.EstadisticaTexto;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir cantidad de palabras
        System.out.print("¿Cuántas palabras quieres ingresar?: ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        String[] listaPalabras = new String[cantidad];

        // Ingreso de palabras
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingresa la palabra " + (i + 1) + ": ");
            listaPalabras[i] = sc.nextLine();
        }

        // Crear objeto EstadisticaTexto
        EstadisticaTexto estadistica = new EstadisticaTexto(listaPalabras);

        // Resultados
        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Total de palabras: " + estadistica.contarPalabras());
        System.out.println("Palabras únicas: " + estadistica.palabrasUnicas());
        System.out.println("Palabra más larga: " + estadistica.palabraMasLarga());
        System.out.println("Palabra más corta: " + estadistica.palabraMasCorta());

        sc.close();
    }
}

