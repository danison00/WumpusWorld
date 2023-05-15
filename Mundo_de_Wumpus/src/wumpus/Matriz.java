package wumpus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Matriz {

	Random random = new Random();
	private int[][] matriz;
	private int tamanho;
	private int[][] cse;
	private int[][] csd;
	private int[][] cid;
	private int[][] cie;
	private int[][] pe;
	private int[][] ps;
	private int[][] pd;
	private int[][] pi;
	private int[][] c;
	int num_pocos;
	int num_wumpus;

	List<List<List<String>>> matrizSensacoes;
	List<String> sensacoes;

	Poco poco = new Poco();
	Wumpus wumpus = new Wumpus();
	Ouro ouro = new Ouro();

	public Matriz(int tamanho) {

		this.matriz = new int[tamanho][tamanho];
		this.tamanho = tamanho;
		this.sensacoes = new ArrayList<>();
		this.matrizSensacoes = new ArrayList<>();
		mapeiaMatriz();
		adicionaElementos();

	}

	public void mapeiaMatriz() {

		cse = new int[][] { { 0 }, { 0 } };
		csd = new int[][] { { 0 }, { tamanho - 1 } };
		cid = new int[][] { { tamanho - 1 }, { tamanho - 1 } };
		cie = new int[][] { { tamanho - 1 }, { 0 } };

		pe = new int[2][tamanho - 2];
		ps = new int[2][tamanho - 2];
		pd = new int[2][tamanho - 2];
		pi = new int[2][tamanho - 2];
		c = new int[2][(tamanho - 2) * (tamanho - 2)];
		int cont1 = 0;
		for (int i = 1; i < tamanho - 1; i++) {

			pe[0][i - 1] = i;
			pe[1][i - 1] = 0;
			// System.out.println(pe[0][i-1]+" "+pe[1][i-1]);

			ps[0][i - 1] = 0;
			ps[1][i - 1] = i;

			pd[0][i - 1] = i;
			pd[1][i - 1] = tamanho - 1;

			pi[0][i - 1] = tamanho - 1;
			pi[1][i - 1] = i;

			for (int j = 1; j < tamanho - 1; j++) {

				c[0][cont1] = i;
				c[1][cont1] = j;
				cont1++;

			}
		}

	}

	public void adicionaElementos() {

		for (int i = 0; i < tamanho; i++) {
			List<List<String>> linha = new ArrayList<>();
			for (int j = 0; j < tamanho; j++) {
				matriz[i][j] = 0;
				linha.add(new ArrayList<>());
			}
			matrizSensacoes.add(linha);
		}
		num_pocos = 2;
		num_wumpus = 1;

		calcElementos();

		addPocos();

		addWumpus();

		addOuro();

	}

	public void calcElementos() {

		if (tamanho <= 5) {
			num_pocos = (int) (tamanho / 1.4);
		}
		if (tamanho < 4) {
			num_pocos = 1;
		}

		if (tamanho > 5) {
			num_pocos = (int) (tamanho / 1.4);
			num_wumpus = (int) (tamanho / 2) - 1;
		}

	}

	public void addPocos() {

		for (int i = 0; i < num_pocos; i++) {

			while (true) {

				int lin = random.nextInt(tamanho);
				int col = random.nextInt(tamanho);

				if (condicaoElementos(lin, col)) {

					matriz[lin][col] = poco.addPoco();

					if (matrizSensacoes.get(lin).get(col).contains(wumpus.getSensacao())) {

						matrizSensacoes.get(lin).get(col).remove(wumpus.getSensacao());
					}
					if (matrizSensacoes.get(lin).get(col).contains(poco.getSensacao())) {

						matrizSensacoes.get(lin).get(col).remove(poco.getSensacao());
					}

					if (col > 0) {
						if (matriz[lin][col - 1] != 1 && matriz[lin][col - 1] != 2 && matriz[lin][col - 1] != 2
								&& !matrizSensacoes.get(lin).get(col - 1).contains(poco.getSensacao()))
							matrizSensacoes.get(lin).get(col - 1).add(poco.getSensacao());
					}

					if (col + 1 < 5) {
						if (matriz[lin][col + 1] != 1 && matriz[lin][col + 1] != 2 && matriz[lin][col + 1] != 2
								&& !matrizSensacoes.get(lin).get(col + 1).contains(poco.getSensacao()))
							matrizSensacoes.get(lin).get(col + 1).add(poco.getSensacao());
					}

					if (lin + 1 < 5) {
						if (matriz[lin + 1][col] != 1 && matriz[lin + 1][col] != 2 && matriz[lin + 1][col] != 2
								&& !matrizSensacoes.get(lin + 1).get(col).contains(poco.getSensacao()))
							matrizSensacoes.get(lin + 1).get(col).add(poco.getSensacao());
					}

					if (lin > 0) {
						if (matriz[lin - 1][col] != 1 && matriz[lin - 1][col] != 2 && matriz[lin - 1][col] != 2
								&& !matrizSensacoes.get(lin - 1).get(col).contains(poco.getSensacao()))
							matrizSensacoes.get(lin - 1).get(col).add(poco.getSensacao());
					}

					break;

				}
			}

		}

	}

	public void addWumpus() {

		for (int i = 0; i < num_wumpus; i++) {

			int lin = random.nextInt(tamanho);
			int col = random.nextInt(tamanho);

			while (true) {

				lin = random.nextInt(tamanho);
				col = random.nextInt(tamanho);
				if (condicaoElementos(lin, col)) {

					matriz[lin][col] = wumpus.addWumpus();
					if (matrizSensacoes.get(lin).get(col).contains(wumpus.getSensacao())) {

						matrizSensacoes.get(lin).get(col).remove(wumpus.getSensacao());
					}
					if (matrizSensacoes.get(lin).get(col).contains(poco.getSensacao())) {

						matrizSensacoes.get(lin).get(col).remove(poco.getSensacao());
					}
					if (col > 0) {
						if (matriz[lin][col - 1] != 1 && matriz[lin][col - 1] != 2
								&& !matrizSensacoes.get(lin).get(col - 1).contains(wumpus.getSensacao()))
							matrizSensacoes.get(lin).get(col - 1).add(wumpus.getSensacao());
					}

					if (col + 1 < 5) {
						if (matriz[lin][col + 1] != 1 && matriz[lin][col + 1] != 2
								&& !matrizSensacoes.get(lin).get(col + 1).contains(wumpus.getSensacao()))
							matrizSensacoes.get(lin).get(col + 1).add(wumpus.getSensacao());
					}

					if (lin + 1 < 5) {
						if (matriz[lin + 1][col] != 1 && matriz[lin + 1][col] != 2
								&& !matrizSensacoes.get(lin + 1).get(col).contains(wumpus.getSensacao()))
							matrizSensacoes.get(lin + 1).get(col).add(wumpus.getSensacao());
					}

					if (lin > 0) {
						if (matriz[lin - 1][col] != 1 && matriz[lin - 1][col] != 2
								&& !matrizSensacoes.get(lin - 1).get(col).contains(wumpus.getSensacao()))
							matrizSensacoes.get(lin - 1).get(col).add(wumpus.getSensacao());
					}
					break;
				}
			}

		}

	}

	public void addOuro() {
		while (true) {
			int lin = random.nextInt(tamanho);
			int col = random.nextInt(tamanho);

			if (condicaoElementos(lin, col)) {

				matriz[lin][col] = ouro.addOuro();
				matrizSensacoes.get(lin).get(col).add(ouro.getSensacao());
				break;
			}
		}
	}

	public void addSensacoes() {

	}

	public boolean condicaoElementos(int lin, int col) {
		boolean cond = true;

		if (matriz[lin][col] != 0 || (lin == 0 && col == 0)) {
			return false;
		}

		if (lin == 1 && col == 0 && matriz[0][1] != 0 && matriz[0][1] != 3) {
			return false;
		}
		if (lin == 0 && col == 1 && matriz[1][0] != 0 && matriz[1][0] != 3) {
			return false;
		}

		return cond;

	}

	public void imprimeMatriz() {

		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}

	}

	public int getTamanho() {
		return tamanho;
	}

	public int[][] getCse() {
		return cse;
	}

	public int[][] getCsd() {
		return csd;
	}

	public int[][] getCid() {
		return cid;
	}

	public int[][] getCie() {
		return cie;
	}

	public int[][] getPe() {
		return pe;
	}

	public int[][] getPs() {
		return ps;
	}

	public int[][] getPd() {
		return pd;
	}

	public int[][] getPi() {
		return pi;
	}

	public int[][] getC() {
		return c;
	}

	public int[][] getMatriz() {
		return matriz;
	}

}
