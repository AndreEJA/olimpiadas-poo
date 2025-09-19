import modelos.Cadena;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una cadena para procesar:");
        String texto = scanner.nextLine();

        Cadena cadena = new Cadena(texto);

        if(cadena.IsPalindrome())
            System.out.println("La cadena es un palindromo");
        else
            System.out.println("La cadena no es un palindromo");

        cadena.Invertir();
        System.out.println("La cadena invertida es: " + cadena.getTexto());
        cadena.Invertir();

        cadena.Mayusculas();
        System.out.println("La cadena en mayusculas es: " + cadena.getTexto());

        cadena.Minusculas();
        System.out.println("La cadena en minusculas es: " + cadena.getTexto());

        cadena.VocalesConsonantes();
    }
}