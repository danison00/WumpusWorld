package algoritmo_genetico;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import wumpus.Agente;
import wumpus.Matriz;
import wumpus.Util;

public class AmbienteDeTeste extends Util {
	int tamanho = 5;
	Matriz ambiente = new Matriz(tamanho, true);
	Agente agente;

	public ArrayList<Individuo> testaIndividuos(List<Individuo> individuos) {

		for (Individuo individuo : individuos) {
			agente = new Agente();

			List<String> cromossomos = new ArrayList<String>(individuo.cromossomos);
			System.out.println("\n\n" + individuo.id);
			StringBuilder string = new StringBuilder();

			for (String acao : cromossomos) {

				int lin = agente.getLocLin();
				int col = agente.getLocCol();
				pontuaIndividuo(lin, col, acao, individuo, string);

				List<String> sensacoes = null;
				try 
				{
					sensacoes = ambiente.getMatrizSensacoes().get(lin).get(col);
				} catch (Exception e) {}
				
				agente.acao(acao, sensacoes);

			}
			System.out.println(string);

		}
		System.out.println("acabou");
		
		imprimePontuacoes(individuos);
		return new ArrayList<Individuo>(selecionaMelhores(individuos));
		
		
		

	}
	
	public List<Individuo> selecionaMelhores(List<Individuo> individuos) {
		
		 Collections.sort(individuos);
		 
		 List<Individuo> melhoresIndividuos = new ArrayList<>();
		 
		 for(int i =0; i<(int)(individuos.size()/2); i++) {
			 
			 melhoresIndividuos.add(individuos.get(i));
			 
		 }

		return melhoresIndividuos;
		
	}
	public void imprimePontuacoes(List<Individuo> individuos) {
		
		for(Individuo individuo: individuos) {
			System.out.println("individuo "+individuo.id+": "+individuo.pontuacao+" pts");
	
		}
		
	}

	public void pontuaIndividuo(int lin, int col, String acao, Individuo individuo, StringBuilder string) {
		if (lin >= 0 && lin < tamanho && col >= 0 && col < tamanho) {

			string.append("\nesta dentro");
			individuo.pontuacao+=500;
			
			if (ambiente.getMatriz()[lin][col] == OURO && !agente.isPegouOuro()) {
				individuo.pontuacao+=800;
				agente.setPegouOuro(true);
				string.append(" -> pegou ouro");

			} else {
				if (!agente.isPegouOuro() && acao.equals("P")) {
					string.append(" -> não pegou");
				}
			}

			if (ambiente.getMatriz()[lin][col] == POCO) {
				individuo.pontuacao-=300;
				string.append("\nCaiu poco");
			}
		} else {
			individuo.pontuacao-=500;
			string.append("\nsaiu");
			
		}
		
	}
}
