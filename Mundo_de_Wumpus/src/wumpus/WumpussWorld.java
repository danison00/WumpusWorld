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

	final static int[][] cie = { { 3 },{ 0 } };
	
	final static int[][] cid = { { 3 }, { 3 } };
	
	final static int[][] cse = { { 0 },{ 0 } };
	
	final static int[][] csd = { { 0 },{ 3 } };
	
	final static int[][] pe = { { 1, 2 },{ 0, 0 } };
	
	final static int[][] pd = { { 1, 2 },{ 3, 3 } };
	
	final static int[][] ps = { { 0, 0 },{ 1, 2 } };
	
	final static int[][] pi = { { 3, 3 }, { 1, 2 } };
	
	final static int[][] c = { { 1, 1, 2, 2 },{ 1, 2, 1, 2 } };

	// cria as variaveis do ambiente
	int regiao;
	int contVenceu;
	int contDevorado;
	int contCaiuPoco;
	int contPegouOuro;
	int sentido_mover;
	Random random = new Random();
	Agente agente;
	Matriz matriz = new Matriz(random.nextInt(100));
	ArrayList<Integer> passosCol = new ArrayList<>();
	ArrayList<Integer> passosLin = new ArrayList<>();
	
	int[][] world = new int[4][4];

	

	public void mapeiaMatriz() {
		
		
		
	}
	public void imprimeMatriz() {

		for (int i = 0; i < world[0].length; i++) {
			for (int j = 0; j < world[0].length; j++) {
				System.out.print(world[i][j] + "  ");

			}
			System.out.println();

		}

	}

	public static int localizaRegiao(int lin, int col) {

		if (cie[0][0] == lin && cie[1][0] == col)
			return CIE;
		if (cid[0][0] == lin && cid[1][0] == col)
			return CID;
		if (cse[0][0] == lin && cse[1][0] == col)
			return CSE;
		if (csd[0][0] == lin && csd[1][0] == col)
			return CSD;

		if (pe[0][0] == lin && pe[1][0] == col || pe[0][1] == lin && pe[1][1] == col)
			return PE;

		if (pd[0][0] == lin && pd[1][0] == col || pd[0][1] == lin && pd[1][1] == col)
			return PD;

		if (ps[0][0] == lin && ps[1][0] == col || ps[0][1] == lin && ps[1][1] == col)
			return PS;

		if (pi[0][0] == lin && pi[1][0] == col || pi[0][1] == lin && pi[1][1] == col)
			return PI;

		if (c[0][0] == lin && c[1][0] == col || c[0][1] == lin && c[1][1] == col || c[0][2] == lin && c[1][2] == col
				|| c[0][3] == lin && c[1][3] == col)
			return C;

		return 10;

	}

	public void iniciaPartida() {
		
		agente = new Agente();
		matriz = new Matriz(4);
		

		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				world[i][j] = 0;

		world[2][0] = WUMPUS;
		world[0][2] = POCO;
		world[2][1] = POCO;
		world[3][1] = OURO;

	}

	public void movimenta(int regiao) {

		switch (regiao) {

		case CSE:
			sentido_mover = random.nextInt(2);
			
			
			if (sentido_mover == 0)
				agente.setLocLin(agente.getLocLin()+1); // MOVER SUL
			if (sentido_mover == 1)
				agente.setLocCol(agente.getLocCol()+1); // MOVER LESTE
			break;

		case CSD:
			sentido_mover = random.nextInt(2);
			if (sentido_mover == 0)
				agente.setLocLin(agente.getLocLin()+1); // MOVER SUL
			if (sentido_mover == 1)
				agente.setLocCol(agente.getLocCol()-1); // MOVER OESTE
			break;

		case CIE:
			sentido_mover = random.nextInt(2);
			if (sentido_mover == 0)
				agente.setLocLin(agente.getLocLin()-1); // MOVER NORTE
			if (sentido_mover == 1)
				agente.setLocCol(agente.getLocCol()+1);  // MOVER LESTE
			break;

		case CID:
			sentido_mover = random.nextInt(2);
			if (sentido_mover == 0)
				agente.setLocLin(agente.getLocLin()-1); // MOVER NORTE
			if (sentido_mover == 1)
				agente.setLocCol(agente.getLocCol()-1); // MOVER OESTE
			break;

		case PE:
			sentido_mover = random.nextInt(3);
			if (sentido_mover == 0)
				agente.setLocCol(agente.getLocCol()+1);  // MOVER LESTE
			if (sentido_mover == 1)
				agente.setLocLin(agente.getLocLin()-1); // MOVER NORTE
			if (sentido_mover == 2)
				agente.setLocLin(agente.getLocLin()+1); // MOVER SUL
			break;

		case PD:
			sentido_mover = random.nextInt(3);
			if (sentido_mover == 0) 
				agente.setLocCol(agente.getLocCol()-1); // MOVER OESTE
			if (sentido_mover == 1) 
				agente.setLocLin(agente.getLocLin()-1); // MOVER NORTE
			if (sentido_mover == 2) 
				agente.setLocLin(agente.getLocLin()+1);  // MOVER SUL
			break;

		case PS:
			sentido_mover = random.nextInt(3);
			if (sentido_mover == 0)
				agente.setLocCol(agente.getLocCol()+1);  // MOVER LESTE
			if (sentido_mover == 1)
				agente.setLocLin(agente.getLocLin()+1);  // MOVER SUL
			if (sentido_mover == 2)
				agente.setLocCol(agente.getLocCol()-1); // MOVER OESTE
			break;

		case PI:
			sentido_mover = random.nextInt(3);
			if (sentido_mover == 0)
				agente.setLocCol(agente.getLocCol()-1); // MOVER OESTE
			if (sentido_mover == 1)
				agente.setLocLin(agente.getLocLin()-1); // MOVER NORTE
			if (sentido_mover == 2)
				agente.setLocCol(agente.getLocCol()+1);  // MOVER LESTE
			break;

		case C:
			sentido_mover = random.nextInt(4);
			if (sentido_mover == 0)
				agente.setLocLin(agente.getLocLin()-1); // MOVER NORTE
			if (sentido_mover == 1)
				agente.setLocLin(agente.getLocLin()+1);  // MOVER SUL
			if (sentido_mover == 2)
				agente.setLocCol(agente.getLocCol()+1);  // MOVER LESTE
			if (sentido_mover == 3)
				agente.setLocCol(agente.getLocCol()-1); // MOVER OESTE

			break;
		}

	}

	public void run() {
	
		do {
			
			passosLin = new ArrayList<>();
			passosCol = new ArrayList<>();
			
			
			
			passosLin.add(0);
			passosCol.add(0);
			
			iniciaPartida();
			

			while (!agente.isVenceu() && !agente.isPerdeu()) {
				

				regiao = localizaRegiao(agente.getLocLin(), agente.getLocCol());

				movimenta(regiao);

				if (world[agente.getLocLin()][agente.getLocCol()] == WUMPUS) {
					agente.setDevorado(true);
					contDevorado++;
				}
				if (world[agente.getLocLin()][agente.getLocCol()] == POCO) {
					agente.setCaiuPoco(true);
					contCaiuPoco++;
				}
				if (world[agente.getLocLin()][agente.getLocCol()] == OURO) {
					agente.setPegouOuro(true);
					contPegouOuro++;
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

		
		for(int i=0; i<passosLin.size(); i++)
			System.out.println(passosLin.get(i)+","+passosCol.get(i));
			
		

	}

	

}
