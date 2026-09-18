package ejerciciocarrito07;

public class ItemCarrito {

    private String producto;
    private int cantidad;
    private double precioUnitario;

    public ItemCarrito(String producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void aumentarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    public double calcularSubtotal() {
        return cantidad * precioUnitario;
    }
}