package modelos;

/*
    Clase Camion que hereda de la clase abstracta Vehiculo
    e implementa la interfaz ICombustible.

    Igual que Carro, debe sobrescribir Mover() y definir Recargar().
    Representa vehículos de carga que se pueden mover y necesitan recargar combustible.
 */
public class Camion extends Vehiculo implements ICombustible {

    /*
        Constructor que recibe marca y modelo,
        y los pasa a la clase padre (Vehiculo) usando super().
     */
    public Camion(String marca, String modelo) {
        super(marca, modelo);
    }

    /*
        Implementación del método abstracto Mover().
        En este caso, definimos el comportamiento de un Camión al moverse.
     */
    @Override
    public void Mover() {
        System.out.println("El camión " + Atributos() + " se mueve por la carretera.");
    }

    /*
        Implementación del método Recargar() de ICombustible.
        Aquí se define cómo un Camión recarga combustible.
     */
    public void Recargar() {
        System.out.println("El camión está recargando combustible");
    }
}
