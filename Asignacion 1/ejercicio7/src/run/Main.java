package run;

import models.Course;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre del curso: ");
        String courseName = scanner.nextLine();

        int numberOfStudents;
        while (true) {
            System.out.print("Número de estudiantes (debe ser mayor a 0): ");
            if (scanner.hasNextInt()) {
                numberOfStudents = scanner.nextInt();
                scanner.nextLine();
                if (numberOfStudents > 0) {
                    break;
                } else {
                    System.out.println("Error: El número de estudiantes debe ser positivo.");
                }
            } else {
                System.out.println("Por favor ingresa un número entero válido.");
                scanner.nextLine();
            }
        }

        int numberOfEvaluations;
        while (true) {
            System.out.print("Número de evaluaciones (debe ser mayor a 0): ");
            if (scanner.hasNextInt()) {
                numberOfEvaluations = scanner.nextInt();
                scanner.nextLine();
                if (numberOfEvaluations > 0) {
                    break;
                } else {
                    System.out.println("Error: El número de evaluaciones debe ser positivo.");
                }
            } else {
                System.out.println("Por favor ingresa un número entero válido.");
                scanner.nextLine();
            }
        }

        Course course = new Course(courseName, numberOfStudents, numberOfEvaluations);

        System.out.println();
        for (int i = 0; i < course.getNumberOfStudents(); i++) {
            System.out.println("-> Notas para el Estudiante " + (i + 1) + ":");
            for (int j = 0; j < course.getNumberOfEvaluations(); j++) {
                double grade;
                while (true) {
                    System.out.print("   - Evaluación " + (j + 1) + ": ");
                    if (scanner.hasNextDouble()) {
                        grade = scanner.nextDouble();
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println("   Error: Por favor ingresa una nota válida (número).");
                        scanner.nextLine();
                    }
                }
                course.getGrades()[i][j] = grade;
            }
        }

        System.out.println("\n--- Estadísticas del Curso: " + course.getName() + " ---");

        System.out.println("\nPromedio por estudiante:");
        for (int i = 0; i < course.getNumberOfStudents(); i++) {
            System.out.printf("Estudiante %d: %.2f%n", i + 1, course.getStudentAverage(i));
        }

        System.out.println("\nPromedio por evaluación:");
        for (int j = 0; j < course.getNumberOfEvaluations(); j++) {
            System.out.printf("Evaluación %d: %.2f%n", j + 1, course.getEvaluationAverage(j));
        }

        int topStudentIndex = course.getTopStudentIndex();
        System.out.printf("%nEl estudiante con mejor rendimiento es el Estudiante %d con un promedio de %.2f%n",
                topStudentIndex + 1, course.getStudentAverage(topStudentIndex));

        scanner.close();
    }
}