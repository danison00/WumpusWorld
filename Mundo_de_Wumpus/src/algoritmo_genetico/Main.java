package algoritmo_genetico;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	
	public static void main(String[] args) {
		
		Newclass  a = new Newclass(10, 6);
		
		a.criaGeração();
		
		AmbienteDeTeste teste_ambiente = new AmbienteDeTeste();
		ArrayList<Individuo> melhores = teste_ambiente.testaIndividuos(a.geracoes.get(0));
		
		for (Individuo individuo : melhores) {
			
			System.out.println(individuo.id+": "+individuo.pontuacao+" pts");
			
		}
		
	
	}

}
