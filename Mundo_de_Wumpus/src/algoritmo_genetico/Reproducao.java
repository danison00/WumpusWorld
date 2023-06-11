package algoritmo_genetico;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Reproducao {
	
	int geracao_corrente = 0;
	List<String> lista_genes = new ArrayList<>();
	Random random = new Random();
	
	public Reproducao() {
		
		lista_genes.add("N");
		lista_genes.add("S");
		lista_genes.add("L");
		lista_genes.add("O");
		lista_genes.add("P");
	
		
	}
	
	public List<Individuo> geracaoZero(int num_individuos, int min_cromossomos, int max_cromossomos) {

		List<Individuo> individuos = new ArrayList<>();

		for (int i = 0; i < num_individuos; i++) {
			List<String> cromossomos = new ArrayList<>();
			
			int num_genes = random.nextInt(max_cromossomos-min_cromossomos+1)+min_cromossomos;
	
			
			for (int j = 0; j < num_genes; j++) {
				int index = random.nextInt(lista_genes.size());
				cromossomos.add(lista_genes.get(index));
			}

			Individuo individuo = new Individuo(geracao_corrente, num_genes, String.valueOf(i+1), cromossomos);
			
			System.out.println(individuo.id+": "+individuo.cromossomos+"-> "+num_genes);
			
			individuos.add(individuo);

		}
		return individuos;
	}
	
	

}
