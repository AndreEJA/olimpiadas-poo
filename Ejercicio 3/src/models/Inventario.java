package models;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    // Constructor que inicializa la lista
    public Inventario() {
        this.productos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "productos=" + productos +
                '}';
    }

    // Método para agregar productos
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    // Método para buscar un producto por código
    public Producto buscarProducto(String codigo) {
        for (Producto producto : this.productos) {
            if (producto.getCodigo().equalsIgnoreCase(codigo)) {
                return producto;
            }
        }
        return null; // si no encuentra nada
    }

    // Mostrar todos los productos
    public void mostrarProductos() {
        for (Producto producto : this.productos) {
            System.out.println("----------------------------------------------------------");
            System.out.println(producto);
            System.out.println("----------------------------------------------------------");
        }
    }

    // Mostrar productos con stock menor a 5
    public void mostrarProductosMenosCinco() {
        for (Producto producto : this.productos) {
            if (producto.getCantidad() < 5) { // estrictamente menor
                System.out.println("----------------------------------------------------------");
                System.out.println(producto);
                System.out.println("----------------------------------------------------------");
            }
        }
    }
}