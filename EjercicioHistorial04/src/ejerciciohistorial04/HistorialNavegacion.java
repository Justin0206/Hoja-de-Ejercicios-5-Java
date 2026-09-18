package ejerciciohistorial04;

import java.util.ArrayList;

public class HistorialNavegacion {

    private ArrayList<String> historial = new ArrayList<>();

    public void visitarPagina(String url) {
        historial.add(url);

        if (historial.size() > 10) {
            historial.remove(0);
        }
    }

    public void mostrarHistorial() {
        System.out.println("Paginas guardadas: " + historial.size());

        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". " + historial.get(i));
        }
    }

    public static void main(String[] args) {
        HistorialNavegacion navegador = new HistorialNavegacion();

        for (int i = 1; i <= 10; i++) {
            navegador.visitarPagina("https://example.com/pagina" + i);
        }

        System.out.println("HISTORIAL CON 10 PAGINAS:");
        navegador.mostrarHistorial();

        navegador.visitarPagina("https://example.com/pagina11");

        System.out.println("\nHISTORIAL DESPUES DE AGREGAR LA PAGINA 11:");
        navegador.mostrarHistorial();
    }
}