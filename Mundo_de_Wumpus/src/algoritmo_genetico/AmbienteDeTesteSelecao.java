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
				
				if((geneP+geneA+1)==cromossomos.size()) {
					ultimo=true;
				}
				
				if (acao.equals("P")) {

					geneP++;
				} else {
					geneA++;
				}

				lin = agente.getLocLin();
				col = agente.getLocCol();

				List<String> sensacoes = null;
				agente.acao(acao, sensacoes);
				try {
					sensacoes = ambiente.getMatrizSensacoes().get(lin).get(col);
				} catch (Exception e) {
				}

				
				pontuaIndividuo(agente.getLocLin(), agente.getLocCol(), acao, individuo, ultimo);

			}
	
			
			
			float peso = (float) 0.1333;

			if (geneA > 0) {

				andouDentro = (float) (contAndouDentro) * (float) 100.0 / (float) geneA * (float) 0.18;
				naoCaiuPoco = (float) (geneA - contCaiuPoco) * (float) 100.0 / (float) geneA * (float) 0.18;
				naoDevorado = (float) (geneA - contDevorado) * (float) 100.0 / (float) geneA * (float) 0.18;
			
			}
			
			// (individuo.cromossomos.size()) * (float) (20.0);

		
			if (contPegouOuro > 0) {
			
				 pegou = (float)(100.0 *0.20) ;
				
			}
		
			if(geneP>0) {
				pegouEmVao = (float)((float)contPegouEmVao*100.0/geneP*0.05);
				
			
			}
			
			if (geneP > 0) {

			//	pegar = (float)((float) contPegar *100.0 / (float)(geneP+geneA) * 0.10);
				//System.out.println(pegar);

				// pegar -= (float)(contPegouEmVao/75);

			}

			individuo.pontuacao = andouDentro + naoCaiuPoco+naoDevorado+pegou-pegouEmVao;// + pegar+-pegouEmVao;
	
			if (venceu) {
				individuo.pontuacao += (float)100 * (float)0.25;
				
			}

			if (contCaiuPoco > 0) {
				individuo.caiu = true;
			}
			if (individuo.saiu) {
				// individuo.pontuacao -= 0.8;
			}

			if (individuo.cromossomos.size() > (tamanho * tamanho)) {
				 individuo.pontuacao -= 1.0;
			}
		

		}
		System.out.println("fim\n");
	//	System.out.println("maior: "+maiorCro);
		//System.out.println("menor: "+menorCro);

		// imprimePontuacoes(individuos);
		List<Individuo> melhores = selecionaMelhores(individuos);
		

		
		//
		
		imprimeMelhores(melhores);
		ambiente.imprimeMatriz();

		return melhores;

	}

	public void pontuaIndividuo(int lin, int col, String acao, Individuo individuo, boolean ultimo) {

			if(ultimo && lin == 0 && col==0) {
				individuo.pontuacao+=(float)2.0;
			}

			if (lin >= 0 && lin < tamanho && col >= 0 && col < tamanho && !acao.equals("P")) {
				contAndouDentro++;
				if (ambiente.getMatriz()[lin][col] == POCO) {
					 individuo.caiu = true;
					// agente.setCaiuPoco(true);
					contCaiuPoco++;
					// System.out.println("caiu poco: " + contCaiuPoco);

				}
				if (ambiente.getMatriz()[lin][col] == WUMPUS) {
					individuo.devorado=true;
					contDevorado++;

				}

				if (lin == 0 && col == 0 && agente.isPegouOuro() && !agente.isVenceu()) {
					
					individuo.vence=true;
					
					agente.setVenceu(true);
					venceu = true;
					
				}

			}

			if (lin >= 0 && lin < tamanho && col >= 0 && col < tamanho) {

				if (acao.equals("P")) {

					contPegar++;
					if (agente.isPegouOuro()) {
						
					}

					if (ambiente.getMatriz()[lin][col] == OURO && !agente.isPegouOuro()) {
						//System.out.println("Pegou");
						
					
						agente.setPegouOuro(true);
						contPegouOuro++;
					}else {
					
					}
					if(ambiente.getMatriz()[lin][col] != OURO || agente.isPegouOuro()) {
						contPegouEmVao++;
					}
					

				}

			} else {
				contSaiu++;
				individuo.saiu=true;
			}
		

	}

	public void imprimePontuacoes(List<Individuo> individuos) {

		for (Individuo individuo : individuos) {
			 System.out.println(
					"individuo " + individuo.id + ": " + individuo.pontuacao + " pts" + "    " + individuo.cromossomos);

		}

	}

	public List<Individuo> selecionaMelhores(List<Individuo> individuos) {



		Collections.sort(individuos, new Comparator<Individuo>() {
			@Override
			public int compare(Individuo i1, Individuo i2) {

				return -Float.compare(i1.pontuacao, i2.pontuacao);
			}
		});

		

		List<Individuo> melhoresIndividuos = new ArrayList<>();
		for (int i = 0; i < 15; i++) {

			melhoresIndividuos.add(individuos.get(i));
		}
		
		boolean primeiroIndividuo = true;
		for(Individuo individuo: melhoresIndividuos) {
			if(primeiroIndividuo) {
				maiorCro = menorCro = individuo.cromossomos.size();
				primeiroIndividuo = false;
							
			}
			if(individuo.cromossomos.size()>maiorCro) {
				maiorCro = individuo.cromossomos.size();
			}
			if(individuo.cromossomos.size()<menorCro) {
				menorCro = individuo.cromossomos.size();
			}
		}
		int cont=0;
		for(Individuo individuo: melhoresIndividuos) {
			if(individuo.cromossomos.size()<(tamanho*tamanho)) {
				individuo.pontuacao+=(float)1.5;
			}
			cont++;
			//if(cont>5) break;
		}
		
		Collections.sort(melhoresIndividuos, new Comparator<Individuo>() {
			@Override
			public int compare(Individuo i1, Individuo i2) {

				return -Float.compare(i1.pontuacao, i2.pontuacao);
			}
		});

		return melhoresIndividuos;

	}

	public void imprimeMelhores(List<Individuo> melhores) {
		System.out.println("\n*** 5 Melhores Individuos da geração " + melhores.get(0).geracao + " ***");
		for (Individuo individuo : melhores) {
			System.out.println(
					"individuo " + individuo.id + ": " + individuo.pontuacao + " pts" + "    " + individuo.cromossomos);

		}

	}

}
