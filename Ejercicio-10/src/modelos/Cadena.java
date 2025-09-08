package modelos;

public class Cadena {

    private String Texto = "";

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String texto) {
        if(texto == null) {
            System.out.println("El texto no puede estar nulo");
            return;
        }
        if(texto.isEmpty()) {
            System.out.println("El texto no puede estar vacío");
            return;
        }
        this.Texto = texto;
    }

    public Cadena(String texto)
    {
        setTexto(texto);
    }

    public void Mayusculas()
    {
        this.Texto = this.Texto.toUpperCase();
    }

    public void Minusculas()
    {
        this.Texto = this.Texto.toLowerCase();
    }

    private String ReversedText(String texto)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = texto.length() - 1; i >= 0; i--)
        {
            stringBuilder.append(texto.charAt(i));
        }
        return stringBuilder.toString();
    }

    public void Invertir()
    {
        this.Texto = ReversedText(this.Texto);
    }

    public Boolean IsPalindrome()
    {
        return this.Texto.equalsIgnoreCase(ReversedText(this.Texto));
    }

    public void VocalesConsonantes()
    {
        Character[] vocales = {'a', 'e', 'i', 'o', 'u'};
        int n_consonantes = 0;
        int n_vocales = 0;

        for(int i = 0; i < this.Texto.length(); i++)
        {
            Character c = this.Texto.charAt(i);
            if(Character.isLetter(c))
            {
                Boolean found = false;
                for(Character vocal : vocales)
                {
                    if(c == vocal) {
                        found = true;
                        break;
                    }
                }

                if(found)
                    n_vocales += 1;
                else
                    n_consonantes += 1;
            }
        }

        System.out.println("Numero de vocales: " + n_vocales);
        System.out.println("Numero de consonantes: " + n_consonantes);
    }

}
