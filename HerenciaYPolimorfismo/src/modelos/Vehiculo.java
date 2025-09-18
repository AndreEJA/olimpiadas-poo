package modelos;

/*
    Aquí esta la clase abstracta Vehiculo,

    Que una clase sea abstracta quiere decir que no se puede instanciar por si sola,
    o sea, las clases que se van a derivar de ella como Carro o Camion se pueden instanciar asi:
    new Carro("KIA", "2015");
    o
    new Camion("Ford", "2022");

    pero no se podría instanciar un vehiculo asi:
    new Vehiculo("Mitsubishi", "2014");

    Intentenlo, les va a dar error
 */
public abstract class Vehiculo {
    /*
        Atributos del vehículo, que serán usados por todas las subclases
     */
    private String marca;
    private String modelo;

    /*
        Constructor base, es lo que se ejecuta cuando en las subclases se hace super()
     */
    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    /*
        Pequeña función para imprimir los atributos del vehículo
     */
    public String Atributos() {
        return "(Marca: " + marca + ", Modelo: " + modelo + ")";
    }

    /*
        Función abstracta para mover el vehículo, en este caso, es como la clase abstracta
        solo que las funciones abstractas no tienen cuerpo y tienen que ser definidas por las subclases.
     */
    public abstract void Mover();
}
