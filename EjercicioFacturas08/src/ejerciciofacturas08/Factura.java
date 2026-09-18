package ejerciciofacturas08;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Locale;

public class Factura {

    private int idFactura;
    private String cliente;
    private double monto;

    public Factura(int idFactura, String cliente, double monto) {
        this.idFactura = idFactura;
        this.cliente = cliente;
        this.monto = monto;
    }

    public static void mostrarResumen(ArrayList<Factura> facturas) {
        LinkedHashMap<String, Double> totales = new LinkedHashMap<>();

        for (Factura factura : facturas) {
            double acumulado = totales.getOrDefault(factura.cliente, 0.0);
            totales.put(factura.cliente, acumulado + factura.monto);
        }

        System.out.println("\nRESUMEN POR CLIENTE:");

        for (Map.Entry<String, Double> registro : totales.entrySet()) {
            System.out.printf(
                Locale.US,
                "Cliente: %s | Total facturado: Q%.2f%n",
                registro.getKey(),
                registro.getValue()
            );
        }
    }

    public static void main(String[] args) {
        ArrayList<Factura> facturas = new ArrayList<>();

        facturas.add(new Factura(1, "Ana", 150.00));
        facturas.add(new Factura(2, "Luis", 200.00));
        facturas.add(new Factura(3, "Ana", 350.00));
        facturas.add(new Factura(4, "Maria", 400.00));
        facturas.add(new Factura(5, "Luis", 100.00));
        facturas.add(new Factura(6, "Ana", 50.00));

        System.out.println("FACTURAS REGISTRADAS:");

        for (Factura factura : facturas) {
            System.out.printf(
                Locale.US,
                "Factura: %d | Cliente: %s | Monto: Q%.2f%n",
                factura.idFactura,
                factura.cliente,
                factura.monto
            );
        }

        mostrarResumen(facturas);
    }
}