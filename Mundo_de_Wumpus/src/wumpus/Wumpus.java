package wumpus;

public class Wumpus extends Util{
	
	private final static int id = 2;
	private final static String sensacao = SENSACAO_WUMPUS;
	int lin[];
	int col[];
	
	
	public int addWumpus() {
		return id;
	}
	public int getId() {
		return id;
	}
	public  String getSensacao() {
		return sensacao;
	}	
	
}
