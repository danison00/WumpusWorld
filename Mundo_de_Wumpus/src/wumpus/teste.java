package wumpus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class teste {

	public static void main(String[] args) {

		Matriz mat = new Matriz(7);

		mat.imprimeMatriz();
		
		limparConsole();

	}

	public static void limparConsole() {

		try {
			final String os = System.getProperty("os.name");

			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").start().waitFor();
			} else {
				final ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", "-c", "clear");
				processBuilder.inheritIO().start().waitFor();
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (Exception e) {
			return;
		}

	}
}

//	
//	
//	
//	
//	
//	int cont=0;
//	for(int i =0; i<mat.getTamanho();i++) {
//		for(int j =0; j<mat.getTamanho();j++) {
//			
//			System.out.print(mat.matrizSensacoes.get(i).get(j)+"\t");
//			
//			cont++;
//			
//		}
//		System.out.println();
//	}
//	
//	List<List<List<String>>> a = new ArrayList<>();
//	
