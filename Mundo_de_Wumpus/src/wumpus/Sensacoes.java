package wumpus;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Sensacoes {

	List<List<List<String>>> matrizSensacoes = new ArrayList<>();
	List<List<String>> linha;
	List<String> casa;

	public Sensacoes() {
		for (int i = 0; i < 5; i++) {
			linha = new ArrayList<>();
			matrizSensacoes.add(linha);
			for (int j = 0; j < 5; j++) {
				casa = new ArrayList<>();
				matrizSensacoes.get(i).add(casa);
				if(i==0 && j==4) {
					matrizSensacoes.get(i).get(j).add("f");
				}
				if(i==1 && j==3) {
					matrizSensacoes.get(i).get(j).add("f");
				}
				if(i==2 && j==4) {
					matrizSensacoes.get(i).get(j).add("f");
				}
				if(i==2 && j==1) {
					matrizSensacoes.get(i).get(j).add("b");
				}
				if(i==4 && j==1) {
					matrizSensacoes.get(i).get(j).add("b");
				}
				if(i==3 && j==0) {
					matrizSensacoes.get(i).get(j).add("b");
				}
				if(i==3 && j==2) {
					matrizSensacoes.get(i).get(j).add("b");
				}

				


			}
		}
		imprimeSenscoes();
	}

	public void imprimeSenscoes() {

		System.out.println();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("\t"+matrizSensacoes.get(i).get(j));

			}
			System.out.println();
		}
	}

}
