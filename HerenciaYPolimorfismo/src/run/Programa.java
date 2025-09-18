package run;

import modelos.*;

import java.util.Objects;

public class Programa {
    public static void main(String[] args) {
        /*
            Inicializamos el arreglo de vehiculos
         */
        Vehiculo[] vehiculos = {
                new Carro("Kia", "2015"),
                new Camion("Ford", "2022"),
                new Moto("Yamaha", "2014")
        };

        /*
            Ciclamos por todos los vehiculos
         */
        for(Vehiculo vehiculo : vehiculos)
        {
            /*
                Movemos el vehículo, metodo que existe en la superclase 'Vehículo'
             */
            vehiculo.Mover();
            /*
                Revisamos que el vehículo actual sea una instancia de ICombustible,
                o sea, que implemente la interfaz
             */
            if(vehiculo instanceof ICombustible vehiculo_combustible)
            {
                /*
                    Okk, esta pasando bastante aca, pero creo que esta es la manera mas comprensible de escribirlo,
                    Ahora, recordemos que vehiculo no contiene la funcion recargar, sino la interfaz ICombustible,
                    debido a esto, para poder acceder a la funcion, necesitamos convertir el vehiculo actual a un
                    vehiculo combustible, que es precisamente lo que hacemos arriba, declaramos una variable tipo
                    ICombustible y usamos esta variable para acceder al metodo, aun asi, sigue conteniendo la informacion
                    del vehiculo
                 */
                vehiculo_combustible.Recargar();
            }
        }
    }
}
