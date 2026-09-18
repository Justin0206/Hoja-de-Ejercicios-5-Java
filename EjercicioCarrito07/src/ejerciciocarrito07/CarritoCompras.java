package ejerciciocarrito07;

import java.util.ArrayList;
import java.util.Locale;

public class CarritoCompras {

    private ArrayList<ItemCarrito> items = new ArrayList<>();

    public void agregarItem(String producto, int cantidad,
            double precioUnitario) {

        for (ItemCarrito item : items) {
            if (item.getProducto().equalsIgnoreCase(producto)) {
                item.aumentarCantidad(cantidad);
                return;
            }
        }

        items.add(new ItemCarrito(producto, cantidad, precioUnitario));
    }

    public void eliminarItem(String producto) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProducto().equalsIgnoreCase(producto)) {
                items.remove(i);
                return;
            }
        }
    }

    public void vaciarCarrito() {
        items.clear();
    }

    public double calcularTotal() {
        double total = 0;

        for (ItemCarrito item : items) {
            total += item.calcularSubtotal();
        }

        return total;
    }

    public void mostrarCarrito() {
        if (items.isEmpty()) {
            System.out.println("El carrito esta vacio.");
        } else {
            for (ItemCarrito item : items) {
                System.out.printf(
                    Locale.US,
                    "%s | Cantidad: %d | Precio: Q%.2f | Subtotal: Q%.2f%n",
                    item.getProducto(),
                    item.getCantidad(),
                    item.getPrecioUnitario(),
                    item.calcularSubtotal()
                );
            }
        }

        System.out.printf(Locale.US, "Total: Q%.2f%n", calcularTotal());
    }

    public static void main(String[] args) {
        CarritoCompras carrito = new CarritoCompras();

        carrito.agregarItem("Cuaderno", 2, 20.00);
        carrito.agregarItem("Lapicero", 3, 5.00);

        System.out.println("CARRITO INICIAL:");
        carrito.mostrarCarrito();

        carrito.agregarItem("Cuaderno", 1, 20.00);

        System.out.println("\nDESPUES DE AGREGAR OTRO CUADERNO:");
        carrito.mostrarCarrito();

        carrito.eliminarItem("Lapicero");

        System.out.println("\nDESPUES DE ELIMINAR EL LAPICERO:");
        carrito.mostrarCarrito();

        carrito.vaciarCarrito();

        System.out.println("\nDESPUES DE VACIAR EL CARRITO:");
        carrito.mostrarCarrito();
    }
}