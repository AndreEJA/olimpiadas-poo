package run;

public class Ciudad {
    private double[][] temperaturas; // 7 días x 4 semanas

    public Ciudad(double[][] temperaturas) {
        this.temperaturas = temperaturas;
    }

    // Promedio de una semana
    public double promedioSemanal(int semana) {
        double suma = 0;
        for (int dia = 0; dia < 7; dia++) {
            suma += temperaturas[dia][semana];
        }
        return suma / 7;
    }

    // Temperatura máxima del mes
    public double maximoMes() {
        double max = temperaturas[0][0];
        for (int semana = 0; semana < 4; semana++) {
            for (int dia = 0; dia < 7; dia++) {
                if (temperaturas[dia][semana] > max) {
                    max = temperaturas[dia][semana];
                }
            }
        }
        return max;
    }

    // Día más frío
    public void diaMasFrio() {
        double min = temperaturas[0][0];
        int diaMin = 0, semanaMin = 0;
        for (int semana = 0; semana < 4; semana++) {
            for (int dia = 0; dia < 7; dia++) {
                if (temperaturas[dia][semana] < min) {
                    min = temperaturas[dia][semana];
                    diaMin = dia;
                    semanaMin = semana;
                }
            }
        }
        System.out.println("Día más frío: Semana " + (semanaMin + 1) + ", Día " + (diaMin + 1) + " con " + min + "°C");
    }
}

