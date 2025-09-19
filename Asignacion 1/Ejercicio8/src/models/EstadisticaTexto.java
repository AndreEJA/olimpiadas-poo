package models;
import java.util.HashSet;
import java.util.Set;

public class EstadisticaTexto {
    private String[] palabras;

    // Constructor
    public EstadisticaTexto(String[] palabras) {
        this.palabras = palabras;
    }

    // Método: contar cuántas palabras hay
    public int contarPalabras() {
        return palabras.length;
    }

    // Método: mostrar palabras únicas
    public Set<String> palabrasUnicas() {
        Set<String> unicas = new HashSet<>();
        for (String p : palabras) {
            unicas.add(p);
        }
        return unicas;
    }

    // Método: palabra más larga
    public String palabraMasLarga() {
        if (palabras.length == 0) return null;
        String larga = palabras[0];
        for (String p : palabras) {
            if (p.length() > larga.length()) {
                larga = p;
            }
        }
        return larga;
    }

    // Método: palabra más corta
    public String palabraMasCorta() {
        if (palabras.length == 0) return null;
        String corta = palabras[0];
        for (String p : palabras) {
            if (p.length() < corta.length()) {
                corta = p;
            }
        }
        return corta;
    }
}
