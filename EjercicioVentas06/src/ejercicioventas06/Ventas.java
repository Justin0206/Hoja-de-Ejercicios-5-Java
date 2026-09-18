package ejercicioventas06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Ventas {

    public static double calcularPromedio(ArrayList<Double> ventas) {
        double suma = 0;

        for (double venta : ventas) {
            suma += venta;
        }

        return suma / ventas.size();
    }

    public static double calcularMaximo(ArrayList<Double> ventas) {
        double maximo = ventas.get(0);

        for (double venta : ventas) {
            if (venta > maximo) {
                maximo = venta;
            }
        }

        return maximo;
    }

    public static double calcularMinimo(ArrayList<Double> ventas) {
        double minimo = ventas.get(0);

        for (double venta : ventas) {
            if (venta < minimo) {
                minimo = venta;
            }
        }

        return minimo;
    }

    public static int contarDiasSobrePromedio(ArrayList<Double> ventas) {
        double promedio = calcularPromedio(ventas);
        int cantidad = 0;

        for (double venta : ventas) {
            if (venta > promedio) {
                cantidad++;
            }
        }

        return cantidad;
    }

    public static void main(String[] args) {
        ArrayList<Double> ventas = new ArrayList<>(Arrays.asList(
            100.0, 200.0, 300.0, 400.0, 500.0,
            600.0, 700.0, 800.0, 900.0, 1000.0,
            100.0, 200.0, 300.0, 400.0, 500.0,
            600.0, 700.0, 800.0, 900.0, 1000.0,
            100.0, 200.0, 300.0, 400.0, 500.0,
            600.0, 700.0, 800.0, 900.0, 1000.0
        ));

        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }

        System.out.println("RESUMEN DE VENTAS DEL MES");
        System.out.println("Dias registrados: " + ventas.size());

        System.out.printf(Locale.US,
                "Promedio diario del mes: Q%.2f%n",
                calcularPromedio(ventas));

        System.out.printf(Locale.US,
                "Venta maxima: Q%.2f%n",
                calcularMaximo(ventas));

        System.out.printf(Locale.US,
                "Venta minima: Q%.2f%n",
                calcularMinimo(ventas));

        System.out.println("Dias con ventas superiores al promedio: "
                + contarDiasSobrePromedio(ventas));
    }
}