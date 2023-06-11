package wumpus;

import java.util.ArrayList;
import java.util.List;

public class teste {

	public static void main(String[] args) {
		int tamanho = 5;
		Matriz mat = new Matriz(tamanho, true);
		List<List<List<String>>> matrizSensacoes = new ArrayList<>();

		
		for (int i = 0; i < tamanho; i++) {
			List<List<String>> linha = new ArrayList<>();
			for (int j = 0; j < tamanho; j++) {
				
				List<String> sens = new ArrayList<>(mat.getMatrizSensacoes().get(i).get(j));
			
				linha.add(sens);
			}
			matrizSensacoes.add(linha);
		}

	
		for (int i = 0; i < tamanho; i++) {
			if (matrizSensacoes.get(1).get(i).contains("b")) {
				matrizSensacoes.get(1).get(i).remove("b");

			}
			if (matrizSensacoes.get(1).get(i).contains("f")) {
				matrizSensacoes.get(1).get(i).remove("f");

			}

		}

		mat.imprimeMatriz();

	}

}
