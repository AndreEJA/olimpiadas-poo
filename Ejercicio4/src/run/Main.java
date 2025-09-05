package run;

import models.Agenda;
import models.Contacto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int opcion;
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda(15);

        do {
            System.out.println("------ MENU ------");
            System.out.println("1. Agregar un contacto");
            System.out.println("2. Mostrar todos los contactos");
            System.out.println("3. Buscar contacto por nombre");
            System.out.println("4. Buscar contacto por email");
            System.out.println("0. Salir");
            System.out.print("Digite la opción deseada: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    nuevoContacto(agenda);
                    break;
                case 2:
                    agenda.mostrarContactos();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre a buscar: ");
                    String nombre = sc.nextLine();
                    Contacto encontradoNombre = agenda.buscarPorNombre(nombre);
                    if (encontradoNombre != null) {
                        System.out.println("Contacto encontrado: " + encontradoNombre);
                    } else {
                        System.out.println("No se encontró un contacto con ese nombre.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el dominio a buscar (ej: @gmail.com): ");
                    String dominio = sc.nextLine();
                    agenda.buscarPorDominio(dominio);
                    break;
                case 0:
                    System.out.println("Saliendo de la agenda...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void nuevoContacto(Agenda agenda) {
        boolean continuar = true;
        Scanner sc = new Scanner(System.in);

        while (continuar) {
            Contacto contacto = new Contacto();

            System.out.print("Ingresa el nombre del contacto: ");
            contacto.setNombre(sc.nextLine());

            System.out.print("Ingresa el teléfono del contacto: ");
            contacto.setTelefono(sc.nextLine());

            System.out.print("Ingresa el email del contacto: ");
            contacto.setEmail(sc.nextLine());

            agenda.agregarContacto(contacto);

            if (agenda.estaLlena()) {
                System.out.println("La agenda está llena, no puede agregar más contactos.");
                break;
            }

            String respuesta;
            while (true) {
                System.out.print("¿Desea agregar otro contacto? (s/n): ");
                respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("s") || respuesta.equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.println("Entrada no válida. Por favor, escriba 's' o 'n'.");
                }
            }

            if (respuesta.equalsIgnoreCase("n")) {
                continuar = false;
            }
        }
    }
}
