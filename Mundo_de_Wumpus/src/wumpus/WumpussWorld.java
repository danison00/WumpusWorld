package wumpus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//import interfaceJogo.Conteiner;

public class WumpussWorld extends Util {

	// cria as variaveis do ambiente
	int regiao;
	int contVenceu;
	int contDevorado;
	int contCaiuPoco;
	int contPegouOuro;
	int sentido_mover;
	int contPartida = 0;
	int posOuroL;
	int posOuroC;
	int contMatouWumpus = 0;
	int tamanho;
	int[][] matriz;

	Random random = new Random();
	Agente agente;
	Matriz matrizPrincipal;

	List<List<List<String>>> matrizSensacoes = new ArrayList<>();
	List<Integer> passosCol = new ArrayList<>();
	List<Integer> passosLin = new ArrayList<>();

	public WumpussWorld(int tamanho) {
		this.tamanho = tamanho;

		matrizPrincipal = new Matriz(tamanho, true);
	

		copiaMatrizPrincipal(tamanho);
		copiaMatrizSesancoes(tamanho);

	}

	public void copiaMatrizPrincipal(int tamanho) {
		matriz = new int[tamanho][tamanho];
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++)
				matriz[i][j] = matrizPrincipal.getMatriz()[i][j];

		}
	}

	public void copiaMatrizSesancoes(int tamanho) {
		matrizSensacoes = new ArrayList<>();
		for (int i = 0; i < tamanho; i++) {
			List<List<String>> linha = new ArrayList<>();
			for (int j = 0; j < tamanho; j++) {

				List<String> sens = new ArrayList<>(matrizPrincipal.getMatrizSensacoes().get(i).get(j));

				linha.add(sens);
			}
			matrizSensacoes.add(linha);
		}

	}

	public void imprimeMatriz() {
		System.out.println();
		for (int i = 0; i < matriz[0].length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}

	}

	public int localizaRegiao(int lin, int col) {

		int[][] cie = matrizPrincipal.getCie();
		if (lin == cie[0][0] && col == cie[1][0])
			return CIE;

		int[][] cse = matrizPrincipal.getCse();
		if (lin == cse[0][0] && col == cse[1][0])
			return CSE;

		int[][] csd = matrizPrincipal.getCsd();
		if (lin == csd[0][0] && col == csd[1][0])
			return CSD;

		int[][] cid = matrizPrincipal.getCid();
		if (lin == cid[0][0] && col == cid[1][0])
			return CID;

		int[][] c = matrizPrincipal.getC();
		for (int i = 0; i < c[0].length; i++) {
			if (lin == c[0][i] && col == c[1][i])
				return C;
		}

		int[][] pe = matrizPrincipal.getPe();
		for (int i = 0; i < pe[0].length; i++) {
			if (pe[0][i] == lin && pe[1][i] == col)
				return PE;
		}
		int[][] pd = matrizPrincipal.getPd();
		for (int i = 0; i < pd[0].length; i++) {
			if (pd[0][i] == lin && pd[1][i] == col)
				return PD;
		}

		int[][] ps = matrizPrincipal.getPs();
		for (int i = 0; i < ps[0].length; i++) {
			if (ps[0][i] == lin && ps[1][i] == col)
				return PS;
		}

		int[][] pi = matrizPrincipal.getPi();
		for (int i = 0; i < pi[0].length; i++) {
			if (pi[0][i] == lin && pi[1][i] == col)
				return PI;
		}

		return 10;

	}

	public void iniciaPartida() {

		agente = new Agente(matrizPrincipal.num_wumpus);
		copiaMatrizPrincipal(tamanho);
		copiaMatrizSesancoes(tamanho);
		contMatouWumpus = 0;

	}

	public void movimenta(int regiao) {

		//agente.movimenta(regiao);

	}

	public void verificaEstadoJogo() {
		if (matriz[agente.getLocLin()][agente.getLocCol()] == WUMPUS) {
			agente.setDevorado(true);
			contDevorado++;
		//	System.out.println("devorado "+agente.getLocLin()+" "+agente.getLocCol());
		}

		if (matriz[agente.getLocLin()][agente.getLocCol()] == POCO) {
			agente.setCaiuPoco(true);
			contCaiuPoco++;
		//	System.out.println("caiu no poco");

		}

		if (agente.isPegouOuro() && agente.getLocLin() == 0 && agente.getLocCol() == 0
				&& contMatouWumpus == matrizPrincipal.num_wumpus) {
			agente.setVenceu(true);
			contVenceu++;
		}
		if (agente.isCaiuPoco() || agente.isDevorado()
				|| (agente.qtd_fl == 0 && contMatouWumpus < matrizPrincipal.num_wumpus)) {
			agente.setPerdeu(true);

		}

	}

	public void pegaOuro() {

	/*	boolean pegouOuro = agente.pegaOuro(matrizSensacoes);

		if (pegouOuro) {

			matriz[agente.getLocLin()][agente.getLocCol()] = 0;
			matrizSensacoes.get(agente.getLocLin()).get(agente.getLocCol()).remove(SENSACAO_OURO);
			contPegouOuro++;

		}*/

	}

	public void atira(int regiao) {

		Tiro tiro = agente.atira(regiao, matrizSensacoes);

		if (tiro != null) {

			if (tiro.atirou && matriz[tiro.lin][tiro.col] == WUMPUS) {
			//	System.out.println("atirou e matou " + tiro.lin + " " + tiro.col);
				matriz[tiro.lin][tiro.col] = 0;
				
				
				try {
					matrizSensacoes.get(tiro.lin + 1).get(tiro.col).remove(SENSACAO_WUMPUS);

				} catch (Exception e) {
				}
				try {
					matrizSensacoes.get(tiro.lin - 1).get(tiro.col).remove(SENSACAO_WUMPUS);

				} catch (Exception e) {
				}
				try {
					matrizSensacoes.get(tiro.lin).get(tiro.col - 1).remove(SENSACAO_WUMPUS);

				} catch (Exception e) {
				}
				try {
					matrizSensacoes.get(tiro.lin).get(tiro.col + 1).remove(SENSACAO_WUMPUS);

				} catch (Exception e) {
				}

				contMatouWumpus++;

			}else {
			//	System.out.println("Atirou e não matou " + tiro.lin + " " + tiro.col);

			}

		}
	}

	public void realizaAcao(int regiao) {

		atira(regiao);

		pegaOuro();
		movimenta(regiao);

	}

	public void run() {

		imprimeMatriz();

		do {

			passosLin = new ArrayList<>();
			passosCol = new ArrayList<>();

			passosLin.add(0);
			passosCol.add(0);

			iniciaPartida();

			do {

			//	System.out.println(agente.getLocLin() + " " + agente.getLocCol());
				regiao = localizaRegiao(agente.getLocLin(), agente.getLocCol());
				realizaAcao(regiao);

				verificaEstadoJogo();

				passosLin.add(agente.getLocLin());
				passosCol.add(agente.getLocCol());

			} while (!agente.isVenceu() && !agente.isPerdeu());
			//System.out.println(agente.getLocLin() + " " + agente.getLocCol());

			//System.out.println();
			contPartida++;
		} while (contVenceu < 1);

		
		
		
		
		
		
		// new Conteiner(passosLin, passosCol);

		System.out.println("Venceu: " + contVenceu);
		System.out.println("Caiu no poco: " + contCaiuPoco);
		System.out.println("Foi devorado: " + contDevorado);
		System.out.println("Matou wumpus: " + contMatouWumpus);
		System.out.println("Pegou o ouro: " + contPegouOuro);
		System.out.println("Total de passos: " + (passosLin.size() - 1));
		System.out.println("Partidas: " + (contPartida));

		imprimeMatriz();
		System.out.println(passosLin);
		System.out.println(passosCol);

		for (int i = 0; i < matrizSensacoes.size(); i++) {
			for (int j = 0; j < matrizSensacoes.size(); j++) {

				System.out.print("\t" + matrizSensacoes.get(i).get(j));
			}
			System.out.println();

		}
		System.out.println();
		for (int i = 0; i < matrizPrincipal.getMatrizSensacoes().size(); i++) {
			for (int j = 0; j < matrizPrincipal.getMatrizSensacoes().size(); j++) {

				System.out.print("\t" + matrizPrincipal.getMatrizSensacoes().get(i).get(j));
			}
			System.out.println();

		}
	}

}
