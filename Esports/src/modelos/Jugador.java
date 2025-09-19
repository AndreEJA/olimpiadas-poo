package modelos;

public class Jugador extends Persona {
    String alias;
    int ranking;

    public Jugador(String id, String nombre, String alias, int ranking) {
        super(id, nombre);
        this.alias = alias;
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "Jugadores{" +
                "id='" + super.getId() + '\'' +
                "nombre='" + super.getNombre() + '\'' +
                ", alias='" + alias + '\'' +
                ", ranking=" + ranking +
                '}';
    }
}
