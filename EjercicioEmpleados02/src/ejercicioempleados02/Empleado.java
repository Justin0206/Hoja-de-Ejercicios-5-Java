package ejercicioempleados02;

import java.util.ArrayList;

public class Empleado {

    private String nombre;
    private String departamento;
    private double salario;

    public Empleado(String nombre, String departamento, double salario) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
    }

    public static ArrayList<Empleado> filtrarEmpleados(
            ArrayList<Empleado> empleados, String departamento) {

        ArrayList<Empleado> resultado = new ArrayList<>();

        for (Empleado empleado : empleados) {
            if (empleado.departamento.equalsIgnoreCase(departamento)
                    && empleado.salario > 5000) {
                resultado.add(empleado);
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();

        empleados.add(new Empleado("Ana", "Ventas", 6000));
        empleados.add(new Empleado("Luis", "Ventas", 4500));
        empleados.add(new Empleado("Carlos", "Contabilidad", 7000));
        empleados.add(new Empleado("Maria", "Ventas", 7500));
        empleados.add(new Empleado("Pedro", "Ventas", 5000));

        String departamentoBuscado = "Ventas";

        ArrayList<Empleado> filtrados =
                filtrarEmpleados(empleados, departamentoBuscado);

        System.out.println("Departamento: " + departamentoBuscado);
        System.out.println("Empleados con salario mayor a Q5000:");

        if (filtrados.isEmpty()) {
            System.out.println("No se encontraron empleados.");
        } else {
            for (Empleado empleado : filtrados) {
                System.out.printf(
                    java.util.Locale.US,
                    "Nombre: %s | Departamento: %s | Salario: Q%.2f%n",
                    empleado.nombre,
                    empleado.departamento,
                    empleado.salario
                );
            }
        }
    }
}