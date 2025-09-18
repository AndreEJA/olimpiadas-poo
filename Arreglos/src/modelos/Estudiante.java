package modelos;

public class Estudiante {
    private String nombre;
    private int edad;

    public Estudiante() {}

    public Estudiante(String nombre, int edad)
    {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean mayorDeEdad()
    {
        return edad >= 18;
    }

    @Override
    public String toString()
    {
        return String.format("Estudiante<nombre=%s, edad=%d> (%s)", this.nombre, this.edad, (this.mayorDeEdad()) ? "Mayor de Edad" : "Menor de Edad");
    }
}
