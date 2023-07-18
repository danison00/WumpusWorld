package wumpus;


public class Main {

	public static void main(String[] args) {
		double soma = 0;

		double tempInicial = System.currentTimeMillis();
		WumpussWorld wumpussWorld = new WumpussWorld(5);
		wumpussWorld.run();

		double tempo = (System.currentTimeMillis() - tempInicial);
	

		System.out.println(tempo / 1000 +"s");
	}

}
