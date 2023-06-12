package algoritmo_genetico;

import java.util.List;
import java.util.ArrayList;

public class Individuo implements Comparable<Individuo>{
	
	int geracao;
	int num_genes;
	String id;
	int pontuacao = 0;
	List<String> cromossomos;
	

	public Individuo(int geracao, int num_genes, String id, List<String> cromossomos) {
		this.geracao = geracao;
		this.num_genes = num_genes;
		this.id = id;
		this.cromossomos = new ArrayList<>(cromossomos);
	}


	@Override
	public int compareTo(Individuo o) {
		return o.pontuacao - this.pontuacao;
	}
	
	
	
	

}
