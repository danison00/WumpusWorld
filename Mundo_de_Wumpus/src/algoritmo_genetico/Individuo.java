package algoritmo_genetico;

import java.util.List;
import java.util.ArrayList;

public class Individuo implements Comparable<Individuo>{
	
	int geracao;
	int num_genes;
	boolean vence;
	boolean caiu;
	boolean saiu;
	boolean devorado;
	boolean pegouOuro=false;
	boolean voltou=false;
	boolean morreu=false;
	boolean ultGeneCasaZero =false;
	boolean ideal=false;
	String id;
	float pontuacao = 0;
	List<String> cromossomos;
	

	public Individuo(int geracao, int num_genes, String id, List<String> cromossomos) {
		this.geracao = geracao;
		this.num_genes = num_genes;
		this.id = id;
		devorado=false;
		caiu = false;
		saiu = false;
		this.vence=false;
		this.cromossomos = new ArrayList<>(cromossomos);
	}


	@Override
	public int compareTo(Individuo o) {
		// TODO Auto-generated method stub
		return 0;
	}


//	@Override
//	public int compareTo(Individuo o) {
//		return o.pontuacao - this.pontuacao;
//	}
	
	
	
	

}
