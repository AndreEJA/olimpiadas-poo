package models;

public class Agenda {

    // Atributos
    private Contacto[] agenda;
    private int contador;

    // Constructor
    public Agenda(int capacidad) {
        agenda = new Contacto[capacidad];
        contador = 0;
    }

    // Metodo para agregar un contacto
    public void agregarContacto(Contacto contacto) {
        if (contador < agenda.length) {
            agenda[contador] = contacto;
            contador++;
            System.out.println("Contacto agregado con éxito.");
        } else {
            System.out.println("La agenda está llena, no se pueden agregar más contactos.");
        }
    }

    // Metodo para mostrar todos los contactos
    public void mostrarContactos() {
        if (contador == 0) {
            System.out.println("No hay contactos en la agenda.");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println(agenda[i]); // usa el toString() de Contacto
            }
        }
    }

    // Metodo para buscar un contacto por nombre
    public Contacto buscarPorNombre(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (agenda[i].getNombre().equalsIgnoreCase(nombre)) {
                return agenda[i];
            }
        }
        return null; // si no lo encuentra
    }

    // Metodo para buscar un contacto por domino de correo
    public void buscarPorDominio(String dominio) {
        boolean encontrado = false;
        for (int i = 0; i < contador; i++) {
            if (agenda[i].getEmail().toLowerCase().endsWith(dominio.toLowerCase())) {
                System.out.println(agenda[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron contactos con el dominio " + dominio);
        }
    }

    // Verificar si la agenda está llena
    public boolean estaLlena() {
        return contador == agenda.length;
    }
}
