package modelos.DAOs;

import modelos.Jugador;

public class JugadorDAO extends GenericDAO<Jugador> {
    public Jugador EncontrarPorAlias(String alias) {
        for (Jugador j : data) {
            if (j.toString().contains(alias)) return j;
        }
        return null;
    }

    public void ImprimirDatos() {
        for(int i = 0; i < data.size(); i++)
            System.out.println("#" + (i + 1) + ". " + data.get(i).toString());
    }
}
