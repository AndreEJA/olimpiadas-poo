package run;

public class SistemaEstudiantes {
    public static void main(String[] args) {
        Estudiante[] estudiantes = new Estudiante[3];

        estudiantes[0] = new Estudiante("Ana", 20, new double[]{9.0, 8.5, 9.2});
        estudiantes[1] = new Estudiante("Luis", 22, new double[]{7.0, 6.5, 8.0});
        estudiantes[2] = new Estudiante("María", 19, new double[]{8.5, 9.0, 9.5});

        System.out.println("== Lista de Estudiantes ==");
        for (Estudiante e : estudiantes) {
            e.mostrarDatos();
        }

        System.out.println("== Estudiantes con promedio > 8.0 ==");
        for (Estudiante e : estudiantes) {
            if (e.calcularPromedio() > 8.0) {
                System.out.println(e.calcularPromedio() + " - " + e);
                e.mostrarDatos();
            }
        }
    }
}

