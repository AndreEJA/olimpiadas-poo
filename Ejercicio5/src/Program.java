import java.util.ArrayList;
import java.util.Scanner;

/* Clase Tuple porque java no tiene tuples??? Hijos de puta??? DEvuelvanme a c# */
/* Usa genericos si tiene alguna pregunta pregunteme a mi */
class Tuple<T1, T2>
{
    public T1 item1;
    public T2 item2;

    public Tuple(T1 item1, T2 item2)
    {
        this.item1 = item1;
        this.item2 = item2;
    }
}

class AnalizadorTexto
{
    private ArrayList<Tuple<TipoToken, String>> Tokens = new ArrayList<>();

    public AnalizadorTexto(String texto)
    {
        this.Tokens = tokenizar(texto);
    }

    enum TipoToken {
        PALABRA,
        CARACTERES
    }

    /*
    Decidi hacer una funcion para tokenizar y procesar el texto de manera mas rapida
    en general, los tokens son o palabras o una secuencia de caracteres.

    Por ejemplo, el string "  Hola,, a todos"
    va a tener 7 tokens:

    " "
    "Hola"
    ",,"
    " "
    "a"
    " "
    "todos"

    de esta manera es mucho mas facil analizar y editar el texto
     */
    public ArrayList<Tuple<TipoToken,String>> tokenizar(String texto)
    {
        /* Si el texto esta vacío, retornamos una lista vacía */
        if (texto.isEmpty())
            return new ArrayList<>();

        int posicion = 0;

        ArrayList<Tuple<TipoToken,String>> tokens = new ArrayList<>();
        while(posicion < texto.length())
        {
            StringBuilder token = new StringBuilder();

            while(posicion < texto.length() && Character.isLetter(texto.charAt(posicion)))
            {
                token.append(texto.charAt(posicion));
                posicion++;
            }

            if(!token.isEmpty())
                tokens.add(new Tuple<TipoToken, String>(TipoToken.PALABRA, token.toString()));

            /* Reseteamos el string builder */
            token.setLength(0);

            while(posicion < texto.length() && !Character.isLetter(texto.charAt(posicion))) {
                token.append(texto.charAt(posicion));
                posicion++;
            }

            if(!token.isEmpty())
                tokens.add(new Tuple<TipoToken, String>(TipoToken.CARACTERES, token.toString()));
        }
        return tokens;
    }

    public boolean is_valid(String palabra)
    {
        for(int i = 0; i < palabra.length(); i++)
            if(Character.isLetter(palabra.charAt(i)))
                return true;
        return false;
    }

    public void borrarTexto()
    {
        this.Tokens.clear();
    }

    public void agregarLinea(String texto)
    {
        ArrayList<Tuple<TipoToken, String>> tokens = tokenizar(texto + "\n");
        this.Tokens.addAll(tokens);
    }

    public String obtenerTexto()
    {
        /* Descomprimimos los tokens */
        StringBuilder texto = new StringBuilder();
        for(Tuple<TipoToken, String> token : this.Tokens)
            texto.append(token.item2);

        return texto.toString();
    }

    public int CountWords()
    {
        int palabras = 0;
        for(Tuple<TipoToken, String> token : this.Tokens)
            if(token.item1 == TipoToken.PALABRA)
                palabras++;

        return palabras;
    }

    public int CountWord(String palabra)
    {
        if(!is_valid(palabra)) {
            System.out.printf("'%s' no es una palabra valida.\n", palabra);
            return -1;
        }

        int coincidencias = 0;
        for(Tuple<TipoToken, String> token : this.Tokens)
            if(token.item1 == TipoToken.PALABRA && token.item2.equalsIgnoreCase(palabra))
                coincidencias += 1;

        return coincidencias;
    }

    public void ReplaceWord(String palabra, String reemplazo)
    {
        if(!is_valid(palabra)) {
            System.out.printf("'%s' no es una palabra valida.\n", palabra);
            return;
        }

        if(!is_valid(reemplazo)) {
            System.out.printf("'%s' no es una palabra valida.\n", reemplazo);
            return;
        }

        for(Tuple<TipoToken, String> token : this.Tokens)
            if(token.item1 == TipoToken.PALABRA && token.item2.equalsIgnoreCase(palabra))
                token.item2 = reemplazo;
    }
}

public class Program {
    public static void main(String[] args)
    {
        System.out.println("CAMPO DE TEXTO, puede ir linea por linea con ENTER, para finalizar su input, escriba #FIN.");

        Scanner input = new Scanner(System.in);
        AnalizadorTexto analizador = new AnalizadorTexto("");

        String line;
        while(!(line = input.nextLine()).equals("#FIN."))
        {
            analizador.agregarLinea(line);
        }

        while(true)
        {
            System.out.println("-- Analizador de texto! --");
            System.out.println("#1. Mostrar texto");
            System.out.println("#2. Agregar texto");
            System.out.println("#3. Resetear analizador");
            System.out.println("#4. Conteo de palabras");
            System.out.println("#5. Conteo de palabra (busqueda y coincidencia)");
            System.out.println("#6. Reemplazo de palabra");
            System.out.print("\n> ");

            int opcion = Integer.parseInt(input.nextLine());
            switch(opcion)
            {
                case(1):
                    System.out.printf("Texto:\n%s", analizador.obtenerTexto());
                    break;
                case(2):
                    analizador.agregarLinea(input.nextLine());
                    break;
                case(3):
                    System.out.println("Ingrese la linea a añadir:");
                    analizador.borrarTexto();
                    break;
                case(4):
                    System.out.printf("Conteo de palabras: %d palabras\n", analizador.CountWords());
                    break;
                case(5):
                    System.out.print("Ingrese la palabra a buscar: ");
                    String palabra = input.nextLine().trim();
                    int coincidencias = analizador.CountWord(palabra);

                    if(coincidencias != -1) {
                        System.out.printf("Ocurrencias de la palabra '%s' en el texto: %d\n", palabra, coincidencias);
                    }
                    break;
                case(6):
                    System.out.println("Indique la palabra a reemplazar: ");
                    String palabra_original = input.nextLine().trim();
                    System.out.println("Indique el reemplazo a usar: ");
                    String reemplazo = input.nextLine().trim();
                    analizador.ReplaceWord(palabra_original, reemplazo);
                    break;
            }
            System.out.println("Presione enter para continuar...");
            input.nextLine();

            /* Como no va a existir un puto metodo para borrar la pantalla cross-platform */
            /* ESTO SI EXISTE EN C# */
            System.out.print("\033[H\033[2J");
        }
    }
}
