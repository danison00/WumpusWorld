package algoritmo_genetico;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import wumpus.Agente;
import wumpus.Matriz;
import wumpus.Util;

public class AmbienteDeTesteSelecao extends Util {
	int tamanho;
	Matriz ambiente;
	Agente agente;

	
	public AmbienteDeTesteSelecao(int tamanho) {
	
		this.tamanho = tamanho;
		ambiente = new Matriz(tamanho, true);
	
	}
	public List<Individuo> testaIndividuos(List<Individuo> individuos) {
		
		//System.out.print("\nTestando Geração "+individuos.get(0).geracao+"... ");
		
		for (Individuo individuo : individuos) {
			agente = new Agente();
			
			List<String> cromossomos = new ArrayList<String>(individuo.cromossomos);
			

			for (String acao : cromossomos) {

				int lin = agente.getLocLin();
				int col = agente.getLocCol();
				pontuaIndividuo(lin, col, acao, individuo);

				List<String> sensacoes = null;
				try 
				{
					sensacoes = ambiente.getMatrizSensacoes().get(lin).get(col);
				} catch (Exception e) {}
				
				agente.acao(acao, sensacoes);

			}
			
			if(individuo.cromossomos.size()<(tamanho*tamanho)) {
				individuo.pontuacao+=120;
			}
	

		}
	//	System.out.println("fim\n");
		
		//imprimePontuacoes(individuos);
		List<Individuo> melhores = selecionaMelhores(individuos);
		//imprimeMelhores(melhores);
		//ambiente.imprimeMatriz();
		
		return melhores;
	
	}
	public void pontuaIndividuo(int lin, int col, String acao, Individuo individuo) {
		if (lin >= 0 && lin < tamanho && col >= 0 && col < tamanho) {

			
			individuo.pontuacao+=80;
			
			if(lin==0 && col==0 && agente.isPegouOuro()) {
				individuo.pontuacao+=100;
			}
			if (ambiente.getMatriz()[lin][col] == OURO && !agente.isPegouOuro()) {
				individuo.pontuacao+=70;
				agente.setPegouOuro(true);
				
				
			

			} else {
				if (acao.equals("P") && ambiente.getMatriz()[lin][col] != OURO) {
					individuo.pontuacao-=30;
					
				}
			}

			if (ambiente.getMatriz()[lin][col] == POCO) {
				individuo.pontuacao-=50;
				
			}
		} else {
			individuo.pontuacao-=80;
			
		}
		
		
	}
	public void imprimePontuacoes(List<Individuo> individuos) {
		
		
		for(Individuo individuo: individuos) {
			System.out.println("individuo "+individuo.id+": "+individuo.pontuacao+" pts"+"    "+individuo.cromossomos);
	
		}
		
	}
	public List<Individuo> selecionaMelhores(List<Individuo> individuos) {
		
		 Collections.sort(individuos);
		 
		 List<Individuo> melhoresIndividuos = new ArrayList<>();
		
		 for(int i =0; i< 5; i++) {
			 
			 melhoresIndividuos.add(individuos.get(i));
			 
		 }

		return melhoresIndividuos;
		
	}

	public void imprimeMelhores(List<Individuo> melhores) {
		System.out.println("\n*** 5 Melhores Individuos da geração "+melhores.get(0).geracao+" ***");
		for(Individuo individuo: melhores) {
			System.out.println("individuo "+individuo.id+": "+individuo.pontuacao+" pts"+"    "+individuo.cromossomos);
	
		}
		
	}

}
