package ejerciciofusion09;

import java.util.ArrayList;
import java.util.Arrays;

public class FusionListas {

    public static ArrayList<Integer> combinarListas(
            ArrayList<Integer> lista1, ArrayList<Integer> lista2) {

        ArrayList<Integer> resultado =
                new ArrayList<>(lista1.size() + lista2.size());

        int i = 0;
        int j = 0;

        // Comparar mientras ambas listas tengan elementos pendientes.
        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i) <= lista2.get(j)) {
                resultado.add(lista1.get(i));
                i++;
            } else {
                resultado.add(lista2.get(j));
                j++;
            }
        }

        // Agregar los elementos restantes de la primera lista.
        while (i < lista1.size()) {
            resultado.add(lista1.get(i));
            i++;
        }

        // Agregar los elementos restantes de la segunda lista.
        while (j < lista2.size()) {
            resultado.add(lista2.get(j));
            j++;
        }

        return resultado;
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista1 =
                new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));

        ArrayList<Integer> lista2 =
                new ArrayList<>(Arrays.asList(2, 3, 6, 8, 10, 12));

        ArrayList<Integer> resultado = combinarListas(lista1, lista2);

        System.out.println("Primera lista: " + lista1);
        System.out.println("Segunda lista: " + lista2);
        System.out.println("Lista combinada: " + resultado);
    }
}