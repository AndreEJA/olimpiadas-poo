package modelos.DAOs;

import modelos.Equipo;

public class EquipoDAO extends GenericDAO<Equipo> {
    public Equipo EncontrarPorID(int id) {
        for (Equipo e : data) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    public void ImprimirDatos() {
        for(int i = 0; i < data.size(); i++)
            System.out.println("#" + (i + 1) + ". " + data.get(i).toString());
    }

}
