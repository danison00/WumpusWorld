package wumpus;

import java.util.ArrayList;
import java.util.List;

public class teste {

	public static void main(String[] args) {
		int tamanho = 7;
		Matriz mat = new Matriz(7);
		List<List<List<String>>> matrizSensacoes = new ArrayList<>();

		
		for (int i = 0; i < 7; i++) {
			List<List<String>> linha = new ArrayList<>();
			for (int j = 0; j < 7; j++) {
				
				List<String> sens = new ArrayList<>(mat.matrizSensacoes.get(i).get(j));
			
				linha.add(sens);
			}
			matrizSensacoes.add(linha);
		}

	
		for (int i = 0; i < 7; i++) {
			if (matrizSensacoes.get(1).get(i).contains("b")) {
				matrizSensacoes.get(1).get(i).remove("b");

			}
			if (matrizSensacoes.get(1).get(i).contains("f")) {
				matrizSensacoes.get(1).get(i).remove("f");

			}

		}

		System.out.println(mat.matrizSensacoes.get(1));
		System.out.println(matrizSensacoes.get(1));

	}

}
