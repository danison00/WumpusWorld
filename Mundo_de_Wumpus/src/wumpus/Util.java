package wumpus;

public class Util {
	
	public final static int POCO = 1;
	final static int WUMPUS = 2;
	public final static int OURO = 3;

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
	
	
	final static String SENSACAO_WUMPUS = "f";
	final static String SENSACAO_OURO = "o";

	
	public class Tiro{
		int lin;
		int col;
		boolean atirou;
		
		public Tiro(boolean atirou, int lin, int col) {
			
			this.lin = lin;
			this.col = col;
			this.atirou = atirou;
			
		}
	}

}
