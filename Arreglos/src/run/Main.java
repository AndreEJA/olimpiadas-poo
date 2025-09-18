package run;

import modelos.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        EstudianteDAO manager = new EstudianteDAO();

        int opcion = 0;
        while(opcion != 5)
        {
            System.out.println("--- Estudiantes CRUD ---");
            System.out.println("1. Añadir Estudiante");
            System.out.println("2. Remover Estudiante");
            System.out.println("3. Actualizar Estudiante");
            System.out.println("4. Mostrar Estudiantes");
            System.out.println("5. <- Salir");

            System.out.print("\n> ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch(opcion)
            {
                case(1):
                {
                    System.out.print("Escriba el nombre del estudiante: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Escriba la edad del estudiante: ");
                    int edad = Integer.parseInt(scanner.nextLine());

                    manager.AgregarEstudiante(nombre, edad);
                    System.out.println("Estudiante añadido exitosamente");
                    break;
                }

                case(2):
                {
                    manager.MostrarEstudiantes();
                    if(manager.CantidadEstudiantes() == 0)
                        break;
                    System.out.print("Indique el numero del estudiante a eliminar: ");
                    int indice = Integer.parseInt(scanner.nextLine());

                    manager.RemoverEstudiante(indice);
                    break;
                }

                case(3):
                {
                    manager.MostrarEstudiantes();
                    if(manager.CantidadEstudiantes() == 0)
                        break;

                    System.out.print("Indique el numero del estudiante a eliminar: ");
                    int indice = Integer.parseInt(scanner.nextLine());

                    System.out.print("Escriba el nuevo nombre del estudiante: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Escriba la nueva edad del estudiante: ");
                    int edad = Integer.parseInt(scanner.nextLine());

                    manager.ActualizarEstudiante(indice, nombre, edad);
                    break;
                }

                case(4):
                {
                    manager.MostrarEstudiantes();
                    break;
                }

                case(5):
                {
                    // Aca solo para no incluirlo en default
                    break;
                }

                default: {
                    System.out.println("La opcion ingresada no existe.");
                }
            }
        }
    }
}
