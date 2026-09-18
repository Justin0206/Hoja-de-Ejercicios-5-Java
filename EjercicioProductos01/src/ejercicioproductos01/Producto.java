package ejercicioproductos01;

import java.util.ArrayList;

public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public static void aumentarPrecios(
            ArrayList<Producto> productos, double porcentaje) {

        for (Producto producto : productos) {
            if (producto.stock < 10) {
                producto.precio += producto.precio * porcentaje / 100;
            }
        }
    }

    public static void mostrarProductos(ArrayList<Producto> productos) {
        for (Producto producto : productos) {
            System.out.printf(
                java.util.Locale.US,
                "ID: %d | %s | Precio: Q%.2f | Stock: %d%n",
                producto.id, producto.nombre,
                producto.precio, producto.stock
            );
        }
    }

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Producto(1, "Cuaderno", 20.00, 5));
        productos.add(new Producto(2, "Lapicero", 5.00, 15));
        productos.add(new Producto(3, "Mochila", 100.00, 9));
        productos.add(new Producto(4, "Regla", 10.00, 10));

        System.out.println("ANTES DEL AUMENTO:");
        mostrarProductos(productos);

        aumentarPrecios(productos, 10);

        System.out.println("\nDESPUES DEL AUMENTO DEL 10%:");
        mostrarProductos(productos);
    }
}