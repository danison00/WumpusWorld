package algoritmo_genetico;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Run {

	private int num_individuos;
	private int min_cromossomos;
	private int max_cromossomos;
	private int geracão_corrente;
	Random random = new Random();
	Reproducao reproducao = new Reproducao();
	List<List<Individuo>> geracoes = new ArrayList<>();
	AmbienteDeTesteSelecao ambienteDeTeste;

	public Run(int num_individuos, int tam_ambiente) {
		this.min_cromossomos = 4;
		this.num_individuos = num_individuos;
		this.max_cromossomos = tam_ambiente * tam_ambiente;
		this.ambienteDeTeste = new AmbienteDeTesteSelecao(tam_ambiente);
		this.geracão_corrente = 0;
	}

	public void start() {

		int i = 1;
		int index=0;
		geracoes.add(reproducao.geracaoZero(num_individuos, min_cromossomos, max_cromossomos)); // geração 0
		List<Individuo> melhores = ambienteDeTeste.testaIndividuos(geracoes.get(0)); // testa geração 0

		while (i <= 10000) {
			
			geracoes.add(reproducao.reproduz(melhores)); // geração 1
			melhores = ambienteDeTeste.testaIndividuos(geracoes.get(index));// testa geração 1

			i++;
			index++;
			if(i%100==0) {
				System.out.print("\r" + i);

				System.out.flush();
				
			}
			if(index==800) {
				geracoes= new ArrayList<>();
				System.out.println("limpou");
				System.out.println(geracoes.size());
				index=0;
				System.out.print("\r" + i);
			}
			
			
		}

		for (Individuo individuo : melhores) {
			System.out.println(
					"individuo " + individuo.id + ": " + individuo.pontuacao + " pts" + "    " + individuo.cromossomos);

		}

	}

}
