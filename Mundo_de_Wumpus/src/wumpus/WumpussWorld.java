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

	final static int[][] cie = { { 3 },
								 { 0 } };
	
	final static int[][] cid = { { 3 }, 
								 { 3 } };
	
	final static int[][] cse = { { 0 },
								 { 0 } };
	
	final static int[][] csd = { { 0 },
								 { 3 } };
	
	final static int[][] pe = { { 1, 2 },
			    				{ 0, 0 } };
	
	final static int[][] pd = { { 1, 2 }, 
								{ 3, 3 } };
	
	final static int[][] ps = { { 0, 0 }, 
			  				    { 1, 2 } };
	
	final static int[][] pi = { { 3, 3 }, 
							 	{ 1, 2 } };
	
	final static int[][] c = { { 1, 1, 2, 2 },
							   { 1, 2, 1, 2 } };

	// cria as variaveis do ambiente
	int[][] world = new int[4][4];
	int locLin;
	int locCol;
	int regiao;
	int contVenceu;
	int contDevorado;
	int contCaiuPoco;
	int contPegouOuro;
	boolean venceu;
	boolean pegouOuro;
	boolean caiuPoco;
	boolean devorado;
	boolean perdeu;
	int mover;
	
	ArrayList<Integer> passosCol = new ArrayList<>();
	
	ArrayList<Integer> passosLin = new ArrayList<>();


	Random random = new Random();

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

		locLin = 0;
		locCol = 0;
		devorado = false;
		caiuPoco = false;
		pegouOuro = false;
		venceu = false;
		perdeu = false;

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
			mover = random.nextInt(2);
			if (mover == 0)
				locLin++; // MOVER SUL
			if (mover == 1)
				locCol++; // MOVER LESTE
			break;

		case CSD:
			mover = random.nextInt(2);
			if (mover == 0)
				locLin++; // MOVER SUL
			if (mover == 1)
				locCol--; // MOVER OESTE
			break;

		case CIE:
			mover = random.nextInt(2);
			if (mover == 0)
				locLin--; // MOVER NORTE
			if (mover == 1)
				locCol++; // MOVER LESTE
			break;

		case CID:
			mover = random.nextInt(2);
			if (mover == 0)
				locLin--; // MOVER NORTE
			if (mover == 1)
				locCol--; // MOVER OESTE
			break;

		case PE:
			mover = random.nextInt(3);
			if (mover == 0)
				locCol++; // MOVER LESTE
			if (mover == 1)
				locLin--; // MOVER NORTE
			if (mover == 2)
				locLin++; // MOVER SUL
			break;

		case PD:
			mover = random.nextInt(3);
			if (mover == 0) locCol--; // MOVER OESTE
			if (mover == 1) locLin--; // MOVER NORTE
			if (mover == 2) locLin++; // MOVER SUL
			break;

		case PS:
			mover = random.nextInt(3);
			if (mover == 0)
				locCol++; // MOVER LESTE
			if (mover == 1)
				locLin++; // MOVER SUL
			if (mover == 2)
				locCol--; // MOVER OESTE
			break;

		case PI:
			mover = random.nextInt(3);
			if (mover == 0)
				locCol--; // MOVER OESTE
			if (mover == 1)
				locLin--; // MOVER NORTE
			if (mover == 2)
				locCol++; // MOVER LESTE
			break;

		case C:
			mover = random.nextInt(4);
			if (mover == 0)
				locLin--; // MOVER NORTE
			if (mover == 1)
				locLin++; // MOVER SUL
			if (mover == 2)
				locCol++; // MOVER LESTE
			if (mover == 3)
				locCol--; // MOVER OESTE

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
			

			while (!venceu && !perdeu) {
				

				regiao = localizaRegiao(locLin, locCol);

				movimenta(regiao);

				if (world[locLin][locCol] == WUMPUS) {
					devorado = true;
					contDevorado++;
				}
				if (world[locLin][locCol] == POCO) {
					caiuPoco = true;
					contCaiuPoco++;
				}
				if (world[locLin][locCol] == OURO) {
					pegouOuro = true;
					contPegouOuro++;
				}

				if (pegouOuro && locLin == 0 && locCol == 0) {
					venceu = true;
					contVenceu++;
				}
				if (caiuPoco || devorado) {
					perdeu = true;
				
				}
				
				passosLin.add(locLin);
				passosCol.add(locCol);

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

	public static void main(String[] args) {

		WumpussWorld wumpussWorld = new WumpussWorld();

		wumpussWorld.run();

	}

}
