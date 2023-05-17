package wumpus;

import java.util.ArrayList;
import java.util.List;

public class Exemplo {
    public static void main(String[] args) {
        // Criando a lista original
        List<String> listaOriginal = new ArrayList<>();
        listaOriginal.add("Item 1");
        listaOriginal.add("Item 2");
        listaOriginal.add("Item 3");

        // Fazendo uma cópia da lista
        List<String> listaCopia = new ArrayList<>(listaOriginal);

        // Alterando a cópia da lista
        listaCopia.set(0, "Item alterado");

        // Exibindo as listas
        System.out.println("Lista original: " + listaOriginal);
        System.out.println("Lista cópia: " + listaCopia);
    }
}
