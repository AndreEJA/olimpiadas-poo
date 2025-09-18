package modelos;

/*
    Clase Carro que hereda de la clase abstracta Vehiculo
    e implementa la interfaz ICombustible.

    Al heredar de Vehiculo, debe sobrescribir el método abstracto Mover().
    Al implementar ICombustible, debe definir el método Recargar().

    De esta manera, Carro tiene todas las características de un Vehiculo,
    pero además puede "recargar combustible".
 */
public class Carro extends Vehiculo implements ICombustible {

    /*
        Constructor que recibe los parámetros marca y modelo,
        y los pasa a la clase padre (Vehiculo) usando super().
     */
    public Carro(String marca, String modelo) {
        super(marca, modelo);
    }

    /*
        Implementación del método abstracto Mover() definido en Vehiculo.
        Aquí especificamos cómo se mueve un Carro en particular.
     */
    @Override
    public void Mover() {
        System.out.println("El carro " + Atributos() + " se mueve por la carretera.");
    }

    /*
        Implementación del método Recargar() de la interfaz ICombustible.
        Aquí se define cómo un Carro recarga combustible.
     */
    public void Recargar() {
        System.out.println("El carro está recargando combustible");
    }
}
