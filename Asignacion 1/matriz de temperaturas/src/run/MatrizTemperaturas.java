package run;

public class MatrizTemperaturas {
    public static void main(String[] args) {
        // 7 días x 4 semanas
        double[][] datos = {
                {30, 31, 32, 29}, // Día 1
                {28, 30, 31, 27}, // Día 2
                {29, 28, 30, 26}, // Día 3
                {32, 33, 31, 30}, // Día 4
                {27, 29, 28, 25}, // Día 5
                {26, 27, 29, 24}, // Día 6
                {31, 32, 33, 30}  // Día 7
        };

        Ciudad ciudad = new Ciudad(datos);

        for (int semana = 0; semana < 4; semana++) {
            System.out.println("Promedio semana " + (semana + 1) + ": " + ciudad.promedioSemanal(semana));
        }

        System.out.println("Temperatura máxima del mes: " + ciudad.maximoMes() + "°C");
        ciudad.diaMasFrio();
    }
}
