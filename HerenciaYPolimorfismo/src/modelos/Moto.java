package modelos;

/*
    Clase Moto que hereda de la clase abstracta Vehiculo.

    A diferencia de Carro y Camion, NO implementa la interfaz ICombustible.
    Esto quiere decir que las Motos no cuentan con el método Recargar() en este diseño.
    Solo sobrescriben Mover(), ya que es obligatorio por heredar de Vehiculo.
 */
public class Moto extends Vehiculo {

    /*
        Constructor que recibe marca y modelo,
        y los pasa a la clase padre (Vehiculo) usando super().
     */
    public Moto(String marca, String modelo) {
        super(marca, modelo);
    }

    /*
        Implementación del método abstracto Mover().
        Aquí se define el comportamiento de una Moto al moverse.
     */
    @Override
    public void Mover() {
        System.out.println("La moto " + Atributos() + " se mueve por la carretera.");
    }
}
