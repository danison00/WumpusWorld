package wumpus;

import java.util.Random;

public class WumpussWorld {
	
	final static int POCO = 1;
	final static int WUMPUS = 2;
	final static  int OURO = 3;
	
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

	
	
	
	static void imprimeMatriz(int[][] world) {

		for (int i = 0; i < world[0].length; i++) {
			for (int j = 0; j < world[0].length; j++) {
				System.out.print(world[i][j] + "  ");

			}
			System.out.println();

		}

	}

	public static int localizaRegiao(int lin, int col) {
		
		int[][] cie = { { 3 }, 
						{ 0 } };
		
		int[][] cid = { { 3 }, 
						{ 3 } };
		
		int[][] cse = { { 0 }, 
						{ 0 } };
		
		int[][] csd = { { 0 }, 
						{ 3 } };
		
		int[][] pe = { { 1, 2 },
					   { 0, 0 } };
		
		int[][] pd = { { 1, 2 }, 
					   { 3, 3 } };
		
		int[][] ps = { { 0, 0 }, 
					   { 1, 2 } };
		
		int[][] pi = { { 3, 3 }, 
					   { 1, 2 } };
		
		int[][] c = { { 1, 1, 2, 2 }, 
				      { 1, 2, 1, 2 }};
		
		
		
		if(cie[0][0] == lin && cie[1][0] == col ) return CIE;
		if(cid[0][0] == lin && cid[1][0] == col ) return CID;
		if(cse[0][0] == lin && cse[1][0] == col) return CSE;
		if(csd[0][0] == lin && csd[1][0] == col ) return CSD;
		
		if(pe[0][0] == lin && pe[1][0] == col ||
		   pe[0][1] == lin && pe[1][1] == col) return PE;
		
		if(pd[0][0] == lin && pd[1][0] == col ||
		   pd[0][1] == lin && pd[1][1] == col) return PD;
		
		if(ps[0][0] == lin && ps[1][0] == col ||
		   ps[0][1] == lin && ps[1][1] == col) return PS;
		
		if(pi[0][0] == lin && pi[1][0] == col ||
		   pi[0][1] == lin && pi[1][1] == col) return PI;

		if(c[0][0] == lin && c[1][0] == col ||
		   c[0][1] == lin && c[1][1] == col ||
		   c[0][2] == lin && c[1][2] == col ||
		   c[0][3] == lin && c[1][3] == col) return C;
		

		
		
		return 10;
	
		
	}
	
	
	public static void main(String[] args) {

	
		
		int[][] world = new int[4][4];
		int locLin = 0; 
		int locCol = 0; 
		int regiao = 0;
		int contVenceu = 0;
		int contDevorado = 0;
		int contCaiuPoco = 0;
		int contPegouOuro = 0;
		boolean venceu = false;
		boolean pegouOuro = false;
		boolean caiuPoco = false;
		boolean devorado = false;
		boolean perdeu = false;

		Random random = new Random();
		int mover;


		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				world[i][j] = 0;

		world[2][0] = WUMPUS;
		world[0][2] = POCO;
		world[2][1] = POCO;
		world[3][1] = OURO;


		do {
			
			locLin = 0; 
			locCol = 0; 
			devorado = false;
			caiuPoco = false;
			pegouOuro = false;
			venceu = false;
			perdeu = false;


			while (!venceu && !perdeu) {
				
				System.out.println(locLin+","+locCol);
				
				regiao = localizaRegiao(locLin, locCol);
				
				switch(regiao) {
					
					case CSE:
						mover = random.nextInt(2);
						if(mover == 0) locLin++; //MOVER SUL
						if(mover == 1) locCol++; //MOVER LESTE
						break;
					
					case CSD:
						mover = random.nextInt(2);
						if(mover == 0) locLin++; //MOVER SUL
						if(mover == 1) locCol--; //MOVER OESTE
						break;
						
					case CIE:
						mover = random.nextInt(2);
						if(mover == 0) locLin--; //MOVER NORTE
						if(mover == 1) locCol++; //MOVER LESTE
						break;
						
					case CID:
						mover = random.nextInt(2);
						if(mover == 0) locLin--; //MOVER NORTE
						if(mover == 1) locCol--; //MOVER OESTE
						break;
						
					case PE:
						mover = random.nextInt(3);
						if(mover == 0) locCol++; //MOVER LESTE
						if(mover == 1) locLin--; //MOVER NORTE
						if(mover == 2) locLin++; //MOVER SUL
						break;
						
					case PD:
						mover = random.nextInt(3);
						if(mover == 0) locCol--; //MOVER OESTE
						if(mover == 1) locLin--; //MOVER NORTE
						if(mover == 2) locLin++; //MOVER SUL
						break;
						
					case PS:
						mover = random.nextInt(3);
						if(mover == 0) locCol++; //MOVER LESTE
						if(mover == 1) locLin++; //MOVER SUL
						if(mover == 2) locCol--; //MOVER OESTE
						break;	
						
					case PI:
						mover = random.nextInt(3);
						if(mover == 0) locCol--; //MOVER OESTE
						if(mover == 1) locLin--; //MOVER NORTE
						if(mover == 2) locCol++; //MOVER LESTE
						break;		
			
					case C:
						mover = random.nextInt(4);
						if(mover == 0) locLin--; //MOVER NORTE
						if(mover == 1) locLin++; //MOVER SUL
						if(mover == 2) locCol++; //MOVER LESTE
						if(mover == 3) locCol--; //MOVER OESTE
						
						break;	
				}
				
				if(world[locLin][locCol] == WUMPUS) { devorado = true; contDevorado++;}
				if(world[locLin][locCol] == POCO) {caiuPoco = true; contCaiuPoco++;}
				if(world[locLin][locCol] == OURO) {pegouOuro = true; contPegouOuro++;}

				
		
				if(pegouOuro && locLin==0 && locCol==0) {venceu = true; contVenceu++;}
				if(caiuPoco || devorado) { perdeu = true;}

					
			}
		

		} while (contVenceu<10);
		
		imprimeMatriz(world);
		
		System.out.println("Venceu: "+contVenceu);
		System.out.println("Caiu no poco: "+contCaiuPoco);
		System.out.println("Pegou o ouro: "+contPegouOuro);
		System.out.println("Foi devorado: "+contDevorado);
		


	}

}
