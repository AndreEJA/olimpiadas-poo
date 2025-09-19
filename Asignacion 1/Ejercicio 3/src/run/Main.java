package run;

import models.Inventario;
import models.Producto;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        inventario.agregarProducto(new Producto("Laptop", "P001", 10));
        inventario.agregarProducto(new Producto("Mouse", "P002", 3));
        inventario.agregarProducto(new Producto("Teclado", "P003", 7));
        inventario.agregarProducto(new Producto("USB", "P004", 2));

        System.out.println("🔹 Todos los productos:");
        inventario.mostrarProductos();

        System.out.println("\n🔹 Productos con stock menor a 5:");
        inventario.mostrarProductosMenosCinco();

        System.out.println("\n🔹 Buscar producto con código P002:");
        System.out.println(inventario.buscarProducto("P002"));
    }
}
