package algoritmo_genetico;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {

		
		double ti =System.currentTimeMillis();
		double soma=0;
		for (int i = 0; i < 10; i++) {

			Run run = new Run(50, 5);
			run.start();
			double t= System.currentTimeMillis()-ti;
			soma+=t;

		}
		System.out.println(soma/10/1000);
	}

}
