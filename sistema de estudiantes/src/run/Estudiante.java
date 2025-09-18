package run;
//Objetivo: Crear una clase Estudiante con nombre, edad y notas (arreglo de double).
//Implementa métodos para calcular el promedio y mostrar los datos.
//Usa una clase principal para registrar varios estudiantes (arreglo de objetos).
//Muestra los estudiantes con promedio mayor a 8.0.
public class Estudiante {
    private String nombre;
    private int edad;
    private double[] notas;

    public Estudiante(String nombre, int edad, double[] notas) {
        this.nombre = nombre;
        this.edad = edad;
        this.notas = notas;
    }

    public double calcularPromedio() {
        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        return suma / notas.length;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.print("Notas: ");
        for (double n : notas) {
            System.out.print(n + " ");
        }
        System.out.println("\nPromedio: " + calcularPromedio());
        System.out.println("-----------------------------");
    }
}






