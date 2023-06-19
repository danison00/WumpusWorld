package algoritmo_genetico;

public class A {
	public static void main(String[] args) {

		Caneta c = new Caneta();
		
		c.getA();

		//System.out.println(c);

	}

	public class Caneta {
		private int a;

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

	}
}
