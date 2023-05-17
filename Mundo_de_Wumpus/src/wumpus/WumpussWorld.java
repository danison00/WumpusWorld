package wumpus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import interfaceJogo.Conteiner;

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
	
	Random random = new Random();
	Agente agente;
	Matriz matrizPrincipal;
	int[][] matriz;
	List<List<List<String>>> matrizSensacoes = new ArrayList<>();

	ArrayList<Integer> passosCol = new ArrayList<>();
	ArrayList<Integer> passosLin = new ArrayList<>();

	public WumpussWorld(int tamanho) {
		this.tamanho = tamanho;
		matrizPrincipal = new Matriz(tamanho);

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
		for (int i = 0; i < tamanho; i++) {
			List<List<String>> linha = new ArrayList<>();
			for (int j = 0; j < tamanho; j++) {

				List<String> sens = new ArrayList<>(matrizPrincipal.matrizSensacoes.get(i).get(j));

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
		System.out.println();

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

		agente = new Agente();
		copiaMatrizPrincipal(tamanho);
		copiaMatrizSesancoes(tamanho);
		

	}

	public void movimenta(int regiao) {

		switch (regiao) {

		case CSE:
			sentido_mover = random.nextInt(2);

			if (sentido_mover == 0)
				agente.setLocLin(agente.getLocLin() + 1); // MOVER SUL
			if (sentido_mover == 1)
				agente.setLocCol(agente.getLocCol() + 1); // MOVER LESTE
			break;

		case CSD:
			sentido_mover = random.nextInt(2);
			if (sentido_mover == 0)
				agente.setLocLin(agente.getLocLin() + 1); // MOVER SUL
			if (sentido_mover == 1)
				agente.setLocCol(agente.getLocCol() - 1); // MOVER OESTE
			break;

		case CIE:
			sentido_mover = random.nextInt(2);
			if (sentido_mover == 0)
				agente.setLocLin(agente.getLocLin() - 1); // MOVER NORTE
			if (sentido_mover == 1)
				agente.setLocCol(agente.getLocCol() + 1); // MOVER LESTE
			break;

		case CID:
			sentido_mover = random.nextInt(2);
			if (sentido_mover == 0)
				agente.setLocLin(agente.getLocLin() - 1); // MOVER NORTE
			if (sentido_mover == 1)
				agente.setLocCol(agente.getLocCol() - 1); // MOVER OESTE
			break;

		case PE:
			sentido_mover = random.nextInt(3);
			if (sentido_mover == 0)
				agente.setLocCol(agente.getLocCol() + 1); // MOVER LESTE
			if (sentido_mover == 1)
				agente.setLocLin(agente.getLocLin() - 1); // MOVER NORTE
			if (sentido_mover == 2)
				agente.setLocLin(agente.getLocLin() + 1); // MOVER SUL
			break;

		case PD:
			sentido_mover = random.nextInt(3);
			if (sentido_mover == 0)
				agente.setLocCol(agente.getLocCol() - 1); // MOVER OESTE
			if (sentido_mover == 1)
				agente.setLocLin(agente.getLocLin() - 1); // MOVER NORTE
			if (sentido_mover == 2)
				agente.setLocLin(agente.getLocLin() + 1); // MOVER SUL
			break;

		case PS:
			sentido_mover = random.nextInt(3);
			if (sentido_mover == 0)
				agente.setLocCol(agente.getLocCol() + 1); // MOVER LESTE
			if (sentido_mover == 1)
				agente.setLocLin(agente.getLocLin() + 1); // MOVER SUL
			if (sentido_mover == 2)
				agente.setLocCol(agente.getLocCol() - 1); // MOVER OESTE
			break;

		case PI:
			sentido_mover = random.nextInt(3);
			if (sentido_mover == 0)
				agente.setLocCol(agente.getLocCol() - 1); // MOVER OESTE
			if (sentido_mover == 1)
				agente.setLocLin(agente.getLocLin() - 1); // MOVER NORTE
			if (sentido_mover == 2)
				agente.setLocCol(agente.getLocCol() + 1); // MOVER LESTE
			break;

		case C:
			sentido_mover = random.nextInt(4);
			if (sentido_mover == 0)
				agente.setLocLin(agente.getLocLin() - 1); // MOVER NORTE
			if (sentido_mover == 1)
				agente.setLocLin(agente.getLocLin() + 1); // MOVER SUL
			if (sentido_mover == 2)
				agente.setLocCol(agente.getLocCol() + 1); // MOVER LESTE
			if (sentido_mover == 3)
				agente.setLocCol(agente.getLocCol() - 1); // MOVER OESTE

			break;
		}

	}

	public void verificaEstadoJogo() {
		if (matriz[agente.getLocLin()][agente.getLocCol()] == WUMPUS) {
			agente.setDevorado(true);
			contDevorado++;
		}

		if (matriz[agente.getLocLin()][agente.getLocCol()] == POCO) {
			agente.setCaiuPoco(true);
			contCaiuPoco++;
		}

		if (agente.isPegouOuro() && agente.getLocLin() == 0 && agente.getLocCol() == 0) {
			agente.setVenceu(true);
			contVenceu++;
		}
		if (agente.isCaiuPoco() || agente.isDevorado()) {
			agente.setPerdeu(true);

		}

	}

	public void pegaOuro() {
		if (matriz[agente.getLocLin()][agente.getLocCol()] == OURO && !agente.isPegouOuro()) {
			agente.setPegouOuro(true);
			matriz[agente.getLocLin()][agente.getLocCol()] = 0;
			contPegouOuro++;
		}

	}

	public void atira(int regiao) {

		if (matrizSensacoes.get(agente.getLocLin()).get(agente.getLocCol())
				.contains(matrizPrincipal.wumpus.getSensacao())) {

			agente.atira(regiao);

			if (matriz[agente.linTiro][agente.colTiro] == WUMPUS && agente.qtd_fl > 0) {
				matriz[agente.linTiro][agente.colTiro] = 0;
				contMatouWumpus++;
				agente.qtd_fl--;
				if (agente.qtd_fl == 0)
					System.out.println("acabou as flechas\n");
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

				regiao = localizaRegiao(agente.getLocLin(), agente.getLocCol());

				realizaAcao(regiao);

				verificaEstadoJogo();

				passosLin.add(agente.getLocLin());
				passosCol.add(agente.getLocCol());

			} while (!agente.isVenceu() && !agente.isPerdeu());

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
	}

}
