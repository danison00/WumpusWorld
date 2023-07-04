package wumpus;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		double soma = 0;
		for (int i = 0; i < 10; i++) {

			double tempInicial = System.currentTimeMillis();
			WumpussWorld wumpussWorld = new WumpussWorld(6);
			wumpussWorld.run();

			double tempo = (System.currentTimeMillis() - tempInicial);
				soma += tempo;

		}
		
		System.out.println(soma/1000/10);
	}

}
