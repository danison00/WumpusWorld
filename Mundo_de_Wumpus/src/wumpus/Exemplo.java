package wumpus;


public class Exemplo {
	public static void main(String[] args) throws InterruptedException {

		Memoria_raciocinio m = new Memoria_raciocinio();
		Sensacoes s = new Sensacoes();
		int l = 0; int c = 0; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		l = 1; c = 0; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		l = 2; c = 0; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		l = 3; c = 0; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		l = 2; c = 0; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		l = 2; c = 1; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		l = 2; c = 0; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		l = 1; c = 0; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		l = 0; c = 0; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		l = 0; c = 1; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		l = 0; c = 2; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		l = 1; c = 2; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		l = 2; c = 2; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();		
		l = 3; c = 2; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		
		l = 2; c = 2; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		l = 2; c = 3; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		l = 3; c = 3; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		l = 4; c = 3; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		l = 4; c = 2; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		l = 1; c = 3; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		l =2; c = 4; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		l = 4; c = 4; 
		m.movimentar(l, c, s.matrizSensacoes.get(l).get(c));
		Thread.sleep(2000);
		m.analiseMapeamento();
		
		
		m.mostrarMapa();

		
		
		

		
	}
	public void movimentar(int l, int c) {
		
	}
}
