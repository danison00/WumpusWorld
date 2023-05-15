package wumpus;

import java.util.ArrayList;
import java.util.Random;

import interfaceJogo.Conteiner;

public class WumpussWorld {

	// cria e inicia todas as constantes do ambiente
	final static int POCO = 1;
	final static int WUMPUS = 2;
	final static int OURO = 3;

	final static int CSE = 1;
	final static int CSD = 2;
	final static int CIE = 3;
	final static int CID = 4;
	final static int PE = 5;
	final static int PD = 6;
	final static int PS = 7;
	final static int PI = 8;
	final static int C = 9;

	final static int NORTE = 1;
	final static int SUL = 2;
	final static int LESTE = 3;
	final static int OESTE = 4;


	// cria as variaveis do ambiente
	int regiao;
	int contVenceu;
	int contDevorado;
	int contCaiuPoco;
	int contPegouOuro;
	int sentido_mover;
	int contPartida=0;
	Random random = new Random();
	Agente agente;
	Matriz matriz;
	ArrayList<Integer> passosCol = new ArrayList<>();
	ArrayList<Integer> passosLin = new ArrayList<>();

	
	public WumpussWorld(int tamanho) {
		
		matriz = new Matriz(tamanho);
	}

	public void imprimeMatriz() {

		matriz.imprimeMatriz();


	}

	public int localizaRegiao(int lin, int col) {

		int[][] cie = matriz.getCie();
		if (lin == cie[0][0] && col == cie[1][0])
			return CIE;

		int[][] cse = matriz.getCse();
		if (lin == cse[0][0] && col == cse[1][0])
			return CSE;

		int[][] csd = matriz.getCsd();
		if (lin == csd[0][0] && col == csd[1][0])
			return CSD;

		int[][] cid = matriz.getCid();
		if (lin == cid[0][0] && col == cid[1][0])
			return CID;

		int[][] c = matriz.getC();
		for (int i = 0; i < c[0].length; i++) {
			if (lin == c[0][i] && col == c[1][i])
				return C;
		}

		int[][] pe = matriz.getPe();
		for (int i = 0; i < pe[0].length; i++) {
			if (pe[0][i] == lin && pe[1][i] == col)
				return PE;
		}
		int[][] pd = matriz.getPd();
		for (int i = 0; i < pd[0].length; i++) {
			if (pd[0][i] == lin && pd[1][i] == col)
				return PD;
		}

		int[][] ps = matriz.getPs();
		for (int i = 0; i < ps[0].length; i++) {
			if (ps[0][i] == lin && ps[1][i] == col)
				return PS;
		}

		int[][] pi = matriz.getPi();
		for (int i = 0; i < pi[0].length; i++) {
			if (pi[0][i] == lin && pi[1][i] == col)
				return PI;
		}

		return 10;

	}

	public void iniciaPartida() {

		agente = new Agente();
		

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

	public void run() {

		do {

			passosLin = new ArrayList<>();
			passosCol = new ArrayList<>();

			passosLin.add(0);
			passosCol.add(0);
			
			contPartida++;

			iniciaPartida();

			while (!agente.isVenceu() && !agente.isPerdeu()) {

				regiao = localizaRegiao(agente.getLocLin(), agente.getLocCol());

				movimenta(regiao);
				//System.out.println(agente.getLocLin()+" "+ agente.getLocCol()+", "+matriz.getMatriz()[agente.getLocLin()][agente.getLocCol()]);
				
				if (matriz.getMatriz()[agente.getLocLin()][agente.getLocCol()] == WUMPUS) {
					agente.setDevorado(true);
					contDevorado++;
				}
				if (matriz.getMatriz()[agente.getLocLin()][agente.getLocCol()] == OURO && !agente.isPegouOuro()) {
					agente.setPegouOuro(true);
					//matriz.getMatriz()[agente.getLocLin()][agente.getLocCol()]=0;
					contPegouOuro++;
				}
				if (matriz.getMatriz()[agente.getLocLin()][agente.getLocCol()] == POCO) {
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

				passosLin.add(agente.getLocLin());
				passosCol.add(agente.getLocCol());

			}
			
		

		} while (contVenceu < 1);

		new Conteiner(passosLin, passosCol);
		imprimeMatriz();
		System.out.println("Venceu: " + contVenceu);
		System.out.println("Caiu no poco: " + contCaiuPoco);
		System.out.println("Foi devorado: " + contDevorado);
		System.out.println("Pegou o ouro: " + contPegouOuro);
		System.out.println("Total de passos: " + passosLin.size());
		System.out.println("Partidas: "+contPartida);
//
//		for (int i = 0; i < passosLin.size(); i++)
//			System.out.println(passosLin.get(i) + "," + passosCol.get(i));

	}

}
