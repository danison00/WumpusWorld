package wumpus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class teste {

public static void main(String[] args) {
	
	Matriz mat = new Matriz(7);
	
	mat.imprimeMatriz();
	
	int cont=0;
	for(int i =0; i<mat.getTamanho();i++) {
		for(int j =0; j<mat.getTamanho();j++) {
			
			System.out.print(mat.matrizSensacoes.get(i).get(j)+"\t");
			
			cont++;
			
		}
		System.out.println();
	}
	
	List<List<List<String>>> a = new ArrayList<>();
	
}

}
