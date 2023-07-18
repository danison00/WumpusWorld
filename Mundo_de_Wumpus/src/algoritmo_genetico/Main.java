package algoritmo_genetico;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {

		
		double ti =System.currentTimeMillis();
	
	
			Run run = new Run(50, 6);
			run.start();
			double t= System.currentTimeMillis()-ti;
		

		
		System.out.println(t/1000+"s");
	}

}
