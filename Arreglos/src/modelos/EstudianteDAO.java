package modelos;

import java.util.ArrayList;
import modelos.Estudiante;

public class EstudianteDAO {
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();

    public EstudianteDAO() {}

    public void AgregarEstudiante(String nombre, int edad)
    {
        estudiantes.add(new Estudiante(nombre, edad));
    }

    public void RemoverEstudiante(int numero)
    {
        if(numero < 0 || numero >= estudiantes.size()) {
            System.out.print("El indice esta fuera de los limites.");
        }
        estudiantes.remove(numero);
    }

    public void ActualizarEstudiante(int numero, String nombre, int edad)
    {
        if(numero < 0 || numero >= estudiantes.size()) {
            System.out.print("El indice esta fuera de los limites.");
        }
        estudiantes.get(numero).setNombre(nombre);
        estudiantes.get(numero).setEdad(edad);
    }

    public void MostrarEstudiantes()
    {
        if(estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes!");
            return;
        }
        for(int i = 0; i < estudiantes.size(); i++)
            System.out.printf("#%d: %s\n", i, estudiantes.get(i));
    }

    public int CantidadEstudiantes()
    {
        return estudiantes.size();
    }
}
