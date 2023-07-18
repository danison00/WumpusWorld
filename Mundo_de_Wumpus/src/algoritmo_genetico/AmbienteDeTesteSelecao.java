package algoritmo_genetico;

import java.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import wumpus.Agente;
import wumpus.Matriz;
import wumpus.Util;

public class AmbienteDeTesteSelecao extends Util {
	int tamanho;
	Matriz ambiente;
	Agente agente;
	int contDevorado, contAndouDentro, contAndouFora, contCaiuPoco, contPegar, geneP, geneA, contPegouOuro, contSaiu,
			contPegouEmVao, maiorCro, menorCro;
	boolean venceu = false;

	public AmbienteDeTesteSelecao(int tamanho) {

		this.tamanho = tamanho;
		ambiente = new Matriz(tamanho, true);

	}

	public List<Individuo> testaIndividuos(List<Individuo> individuos) {

		System.out.print("\nTestando Geração " + individuos.get(0).geracao + "... ");
		maiorCro = menorCro = 0;

		for (Individuo individuo : individuos) {

			int lin = 0, col = 0;
			agente = new Agente();
			contDevorado = contAndouDentro = contCaiuPoco = contPegar = geneP = contPegouOuro = contSaiu = geneA = contPegouEmVao = 0;
			venceu = false;
			float pegouEmVao = 0, andouDentro = 0, pegar = 0, pegou = 0, naoCaiuPoco = 0, saiu = 0, naoDevorado = 0;

			List<String> cromossomos = new ArrayList<String>(individuo.cromossomos);
			boolean ultimo = false;
			for (String acao : cromossomos) {

				if ((geneP + geneA + 1) == cromossomos.size())
					ultimo = true;

				geneP += acao.equals("P") ? 1 : 0;
				geneA += !acao.equals("P") ? 1 : 0;

				lin = agente.getLocLin();
				col = agente.getLocCol();

				List<String> sensacoes = null;
				agente.acao(acao, sensacoes);

				if (lin >= 0 && lin < ambiente.getMatrizSensacoes().size() && col >= 0
						&& col < ambiente.getMatrizSensacoes().get(lin).size())
					sensacoes = ambiente.getMatrizSensacoes().get(lin).get(col);

				pontuaIndividuo(agente.getLocLin(), agente.getLocCol(), acao, individuo, ultimo);

			}

			if (geneA > 0) {

				andouDentro = (float) (contAndouDentro) * (float) 100.0 / (float) geneA * (float) 0.12;
				naoCaiuPoco = (float) (geneA - contCaiuPoco) * (float) 100.0 / (float) geneA * (float) 0.12;
				naoDevorado = (float) (geneA - contDevorado) * (float) 100.0 / (float) geneA * (float) 0.12;

			}

			if (individuo.pegouOuro)
				pegou = (float) (100.0 * 0.23);

			if (geneP > 0)
				pegouEmVao = (float)((float) contPegouEmVao * 100.0 / geneP * 0.05);

			individuo.pontuacao = andouDentro + naoCaiuPoco + naoDevorado + pegou - pegouEmVao;// + pegar+-pegouEmVao;

			if (individuo.pegouOuro && individuo.voltou && !individuo.saiu) {
				individuo.pontuacao += (float) 100 * (float) 0.126;

				if (!individuo.morreu) {
					individuo.pontuacao += (float) 100 * (float) 0.126;
					individuo.vence = true;
					if (individuo.ultGeneCasaZero)
						individuo.pontuacao += (float) 100 * (float) 0.126;

				}

			}

		}
		System.out.println("fim\n");

		// imprimePontuacoes(individuos);
		List<Individuo> melhores = selecionaMelhores(individuos);

		imprimeMelhores(melhores);
		ambiente.imprimeMatriz();

		return melhores;

	}

	public void pontuaIndividuo(int lin, int col, String acao, Individuo individuo, boolean ultimo) {

		if (ultimo && lin == 0 && col == 0)
			individuo.ultGeneCasaZero = true;

		if (lin >= 0 && lin < tamanho && col >= 0 && col < tamanho && !acao.equals("P")) {
			contAndouDentro++;
			if (ambiente.getMatriz()[lin][col] == POCO) {
				individuo.caiu = true;
				contCaiuPoco++;
			}

			if (ambiente.getMatriz()[lin][col] == WUMPUS) {
				individuo.devorado = true;
				contDevorado++;
			}

			if (lin == 0 && col == 0 && individuo.pegouOuro)
				individuo.voltou = true;

		}

		if (lin >= 0 && lin < tamanho && col >= 0 && col < tamanho) {

			if (acao.equals("P")) {
				contPegar++;

				if (ambiente.getMatriz()[lin][col] == OURO && !individuo.pegouOuro)
					individuo.pegouOuro = true;

				if (ambiente.getMatriz()[lin][col] != OURO || agente.isPegouOuro())
					contPegouEmVao++;
			}

		} else {
			contSaiu++;
			individuo.saiu = true;
		}
		if (individuo.caiu || individuo.devorado)
			individuo.morreu = true;

		if (!individuo.caiu && individuo.voltou && !individuo.morreu && individuo.ultGeneCasaZero && individuo.vence)
			individuo.ideal = true;

	}

	public void imprimePontuacoes(List<Individuo> individuos) {

		for (Individuo individuo : individuos)
			System.out.println(
					"individuo " + individuo.id + ": " + individuo.pontuacao + " pts" + "    " + individuo.cromossomos);

	}

	public List<Individuo> selecionaMelhores(List<Individuo> individuos) {

		Collections.sort(individuos, new Comparator<Individuo>() {
			@Override
			public int compare(Individuo i1, Individuo i2) {

				return Float.compare(i1.cromossomos.size(), i2.cromossomos.size());
			}
		});

		int cont = 0;
		for (Individuo individuo : individuos) {
			if (cont >= 25)
				break;

			individuo.pontuacao += (float) 3.2;
			cont++;
		}

		Collections.sort(individuos, new Comparator<Individuo>() {
			@Override
			public int compare(Individuo i1, Individuo i2) {

				return -Float.compare(i1.pontuacao, i2.pontuacao);
			}
		});

		List<Individuo> melhoresIndividuos = new ArrayList<>();
		for (int i = 0; i < 15; i++)
			melhoresIndividuos.add(individuos.get(i));

		return melhoresIndividuos;

	}

	public void imprimeMelhores(List<Individuo> melhores) {
		System.out.println("\n*** 15 Melhores Individuos da geração " + melhores.get(0).geracao + " ***");

		for (Individuo individuo : melhores)
			System.out.println("individuo " + individuo.id + ": " + individuo.pontuacao + " pts" + "    "
					+ individuo.cromossomos + individuo.cromossomos.size());

	}

}
