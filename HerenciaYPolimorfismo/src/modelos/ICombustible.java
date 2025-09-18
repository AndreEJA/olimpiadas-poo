package modelos;

/*
    Pueden pensar en las interfaces como un 'contrato'
    básicamente, cuando una clase implementa una interfaz,
    se está comprometiendo a implementar todos sus atributos y funciones,

    en este caso, las clases Carro y Camion, como implementan ICombustible,
    tienen que implementar la función 'recargar', algo asi como las funciones abstractas.

    La I es porque es convención empezar una interfaz siempre con una I, si tu interfaz
    es Animal, la llamarás IAnimal
 */
public interface ICombustible {
    /*
        Esta función debe ser implementada por todas las clases que implementen
        la interfaz
     */
    public void Recargar();
}