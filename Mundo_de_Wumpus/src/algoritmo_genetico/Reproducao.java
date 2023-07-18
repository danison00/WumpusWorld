package algoritmo_genetico;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Reproducao {

	public static int id=1;
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

	public List<Individuo> reproduz(List<Individuo> individuos) {

		System.out.print("\nReporduzindo melhores individuos da geração "+(geracao_corrente)+"... ");
		geracao_corrente++;
		
		List<Individuo> novos_individuos = new ArrayList<>();
		for (int i = 0; i < individuos.size(); i++) {

			for (int j = i + 1; j < individuos.size(); j++) {

				Individuo pai1 = individuos.get(i);
				Individuo pai2 = individuos.get(j);
				List<Individuo> filhos = cruzaIndividuos(pai1, pai2);
				novos_individuos.add(filhos.get(0));
				novos_individuos.add(filhos.get(1));;

			}

		}

	
		
		novos_individuos = elimina_prematuros(novos_individuos);
		System.out.println("fim");
		
		//imprimeGeracao(novos_individuos);

		return novos_individuos;

	}

	public List<Individuo> cruzaIndividuos(Individuo pai1, Individuo pai2) {

		int[] cortes = realizaCorte(pai1.cromossomos);
		int corte1 = cortes[0];
		int corte3 = cortes[1];

		cortes = realizaCorte(pai2.cromossomos);
		int corte2 = cortes[0];
		int corte4 = cortes[1];

		List<String> cromossomoFilho1 = new ArrayList<>();
		List<String> cromossomoFilho2 = new ArrayList<>();

		cromossomoFilho1.addAll(pai1.cromossomos.subList(0, corte1));
		cromossomoFilho2.addAll(pai2.cromossomos.subList(0, corte2));

		cromossomoFilho1.addAll(pai2.cromossomos.subList(corte2, corte4 + 1));
		cromossomoFilho2.addAll(pai1.cromossomos.subList(corte1, corte3 + 1));

		cromossomoFilho1.addAll(pai1.cromossomos.subList(corte3 + 1, pai1.cromossomos.size()));
		cromossomoFilho2.addAll(pai2.cromossomos.subList(corte4 + 1, pai2.cromossomos.size()));

		int indexMutacao1 = random.nextInt(cromossomoFilho1.size());
		int indexMutacao2 = random.nextInt(cromossomoFilho1.size());

		while (indexMutacao1 == indexMutacao2) {

			indexMutacao2 = random.nextInt(cromossomoFilho1.size());

		}

		String mutacao1 = lista_genes.get(random.nextInt(5));
		String mutacao2 = lista_genes.get(random.nextInt(5));

	
		cromossomoFilho1.add(indexMutacao2, mutacao1);
		cromossomoFilho1.add(indexMutacao1, mutacao2);

		indexMutacao1 = random.nextInt(cromossomoFilho2.size());
		indexMutacao2 = random.nextInt(cromossomoFilho2.size());
		;

		while (indexMutacao1 == indexMutacao2) {

			indexMutacao2 = random.nextInt(cromossomoFilho2.size());

		}

		mutacao1 = lista_genes.get(random.nextInt(4));
		mutacao2 = lista_genes.get(random.nextInt(4));

		cromossomoFilho2.add(indexMutacao2, mutacao1);
		cromossomoFilho2.add(indexMutacao1, mutacao2);

		Individuo filho1 = new Individuo(geracao_corrente, cromossomoFilho1.size(), Integer.toString(id), cromossomoFilho1);
		id++;
		
		Individuo filho2 = new Individuo(geracao_corrente, cromossomoFilho2.size(), Integer.toString(id),
				cromossomoFilho2);
		id++;
		
		List<Individuo> filhos = new ArrayList<>();
		
		filhos.add(filho1);
		filhos.add(filho2);
		
		return filhos;

	}

	public List<Individuo> elimina_prematuros(List<Individuo> individuos) {

		int cont_prematuros = 0;
		List<Individuo> nao_prematuros = new ArrayList<>();
		for (int i = 0; i < individuos.size(); i++) {
			if (individuos.get(i).cromossomos.size() > 4) {

				nao_prematuros.add(individuos.get(i));
			} else {
				cont_prematuros++;
			}

		}

		//System.out.println(cont_prematuros);
		return new ArrayList<>(nao_prematuros);

	}

	public int[] realizaCorte(List<String> cromossomos) {

		int corte1 = random.nextInt(cromossomos.size() - 1);
		int corte2 = random.nextInt(cromossomos.size() - 1);

		if (corte1 > corte2) {
			int aux = corte2;
			corte2 = corte1;
			corte1 = aux;
		}

		return new int[] { corte1, corte2 };

	}

	public List<Individuo> geracaoZero(int num_individuos, int min_cromossomos, int max_cromossomos) {
		System.out.println("### Geração: 0 ###########################");
		List<Individuo> individuos = new ArrayList<>();

		for (int i = 0; i < num_individuos; i++) {
			
			List<String> cromossomos = new ArrayList<>();

			int num_genes = random.nextInt(max_cromossomos - min_cromossomos + 1) + min_cromossomos;

			for (int j = 0; j < num_genes; j++) {
				int index = random.nextInt(lista_genes.size());
				cromossomos.add(lista_genes.get(index));
			}

			Individuo individuo = new Individuo(geracao_corrente, num_genes, Integer.toString(id), cromossomos);
			id++;
			System.out.println(individuo.id + ": " + individuo.cromossomos + "-> " + num_genes);

			individuos.add(individuo);

		}
		return individuos;
	}

	public void imprimeGeracao(List<Individuo> geracao) {
		System.out.println("\n\n### Geração: "+geracao_corrente+" ###########################");
		
		for(Individuo individuo: geracao) {

			System.out.println(individuo.id + ": " + individuo.cromossomos + "-> " + individuo.num_genes);
			
		}
		

	}
}
