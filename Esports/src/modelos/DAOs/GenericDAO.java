package modelos.DAOs;

import java.util.ArrayList;

public abstract class GenericDAO<T> {
    protected ArrayList<T> data = new ArrayList<>();

    public void Añadir(T item) {
        data.add(item);
    }

    public void Remover(T item) {
        data.remove(item);
    }

    public abstract void ImprimirDatos();
}
