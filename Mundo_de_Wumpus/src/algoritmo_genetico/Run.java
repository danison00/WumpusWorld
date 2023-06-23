package algoritmo_genetico;

import java.io.IOException;
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

	public void start() throws IOException, InterruptedException {

		int i = 0;
		boolean cond = true;
		geracoes.add(reproducao.geracaoZero(num_individuos, min_cromossomos, max_cromossomos)); // geração 0
		List<Individuo> melhores = ambienteDeTeste.testaIndividuos(geracoes.get(0)); // testa geração 0

		while (cond) {
			
			if(i%100==0) {
				geracoes = new ArrayList<>();;
				i=0;
				System.out.println("################# Limpou memória ####################");
			}
			
			geracoes.add(reproducao.reproduz(melhores)); // geração 1
			melhores = ambienteDeTeste.testaIndividuos(geracoes.get(i));// testa geração 1

			i++;
			

			for(Individuo in : melhores){
				
				if (in.vence && !in.caiu && !in.devorado && !in.saiu) {
					
					System.out.println(in.vence+" "+in.caiu+" "+in.devorado+" "+in.saiu);
					cond=false;
					
					
				}
				
			}
			
		}

		  Process process = Runtime.getRuntime().exec("clear");
            
            // Aguarda a conclusão do comando
            process.waitFor();
		ambienteDeTeste.ambiente.imprimeMatriz();
		for (Individuo individuo : melhores) {
			System.out.println(
					"individuo " + individuo.id + ": " + individuo.pontuacao + " pts" + "    " + individuo.cromossomos);

		}
	

	}

}