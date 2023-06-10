package wumpus;

import java.util.ArrayList;
import java.util.List;

public class Memoria_raciocinio {

	List<List<List<String>>> mapa;
	List<List<Integer>> casas_poss_seguras;

	public Memoria_raciocinio() {
		casas_poss_seguras = new ArrayList<>();

		mapa = new ArrayList<>();
		List<List<String>> linha = new ArrayList<>();
		List<String> casa = new ArrayList<>();

		mapa.add(linha);
		mapa.get(0).add(casa);

		linha = new ArrayList<>();
		casa = new ArrayList<>();
		mapa.add(linha);
		mapa.get(1).add(casa);

		casa = new ArrayList<>();
		mapa.get(0).add(casa);

	}

	public void adicionarCasa(int lin, int col) {

		List<List<String>> linha;
		List<String> casa;

		if (lin >= mapa.size()) {

			for (int i = mapa.size() - 1; i < lin; i++) {

				linha = new ArrayList<>();
				mapa.add(linha);
				casa = new ArrayList<>();
				mapa.get(i).add(casa);

			}

		}
		if (col >= mapa.get(lin).size()) {

			for (int i = mapa.get(lin).size() - 1; i < col; i++) {

				casa = new ArrayList<>();
				mapa.get(lin).add(casa);
			}

		}

	}

	public void movimentar(int lin, int col, List<String> s) {

		if (mapa.get(lin).get(col).contains("X")) {

			mapa.get(lin).get(col).remove("X");
		}
		if (!mapa.get(lin).get(col).contains("*")) {

			mapa.get(lin).get(col).add("*");
		}

		adicionaCasasAdjacentes(lin, col);

		if (s.isEmpty()) {
			adicionaSupostoSeguro(lin, col);

		}
		if (s.isEmpty()) {

			removeSupostos(lin, col);

		} else {
			analisaSensacoes(lin, col, s);
		
		}
		mostrarMapa();
	}
	
	public void analisaSensacoes(int lin, int col, List<String> s) {
		if (s.contains("b")) {

			if (!mapa.get(lin).get(col).contains("b")) {
				mapa.get(lin).get(col).add("b");
			}

			adicionaSupostoPoco(lin, col);
		}

		if (s.contains("f")) {
			if (!mapa.get(lin).get(col).contains("f")) {
				mapa.get(lin).get(col).add("f");
			}

			adicionaSupostoWumpus(lin, col);
		}
	}

	public void adicionaSupostoSeguro(int lin, int col) {

		try {
			if (!mapa.get(lin + 1).get(col).contains("*") && !mapa.get(lin + 1).get(col).contains("X")) {
				mapa.get(lin + 1).get(col).clear();
				
				mapa.get(lin + 1).get(col).add("X");

			}
		} catch (Exception e) {
		}
		try {
			if (!mapa.get(lin - 1).get(col).contains("*") && !mapa.get(lin - 1).get(col).contains("X")) {
				mapa.get(lin - 1).get(col).clear();
				mapa.get(lin - 1).get(col).add("X");
			}
		} catch (Exception e) {
		}
		try {
			if (!mapa.get(lin).get(col + 1).contains("*") && !mapa.get(lin).get(col + 1).contains("X")) {
				mapa.get(lin).get(col + 1).clear();
				mapa.get(lin).get(col + 1).add("X");
			}
		} catch (Exception e) {
		}
		try {
			if (!mapa.get(lin).get(col - 1).contains("*") && !mapa.get(lin).get(col - 1).contains("X")) {
				mapa.get(lin).get(col - 1).clear();;
				mapa.get(lin).get(col - 1).add("X");
			}
		} catch (Exception e) {
		}

	}

	public void adicionaSupostoWumpus(int lin, int col) {
		try {
			if (!mapa.get(lin + 1).get(col).contains(".w") && (!mapa.get(lin + 1).get(col).contains("*") && !mapa.get(lin + 1).get(col).contains("X"))) {

				mapa.get(lin + 1).get(col).add(".w");

			}
		} catch (Exception e) {
		}
		try {
			if (!mapa.get(lin - 1).get(col).contains(".w") && (!mapa.get(lin + 1).get(col).contains("*") && !mapa.get(lin + 1).get(col).contains("X"))) {
				mapa.get(lin - 1).get(col).add(".w");
			}
		} catch (Exception e) {
		}
		try {
			if (!mapa.get(lin).get(col + 1).contains(".w") && (!mapa.get(lin).get(col+1).contains("*") && !mapa.get(lin).get(col+1).contains("X"))) {
				mapa.get(lin).get(col + 1).add(".w");
			}
		} catch (Exception e) {
		}
		try {
			if (!mapa.get(lin).get(col - 1).contains(".w") && (!mapa.get(lin).get(col-1).contains("*") && !mapa.get(lin).get(col-1).contains("X"))) {
				mapa.get(lin).get(col - 1).add(".w");
			}
		} catch (Exception e) {
		}
	}

	public void adicionaSupostoPoco(int lin, int col) {
		try {
			if (!mapa.get(lin + 1).get(col).contains(".p") && !mapa.get(lin + 1).get(col).contains("*")
					&& !mapa.get(lin + 1).get(col).contains("P")) {
				mapa.get(lin + 1).get(col).add(".p");
			}
		} catch (Exception e) {
		}
		try {
			if (!mapa.get(lin - 1).get(col).contains(".p") && !mapa.get(lin - 1).get(col).contains("*")
					&& !mapa.get(lin - 1).get(col).contains("P")) {
				mapa.get(lin - 1).get(col).add(".p");
			}
		} catch (Exception e) {
		}
		try {
			if (!mapa.get(lin).get(col + 1).contains(".p") && !mapa.get(lin).get(col + 1).contains("*")
					&& !mapa.get(lin).get(col + 1).contains("P")) {
				mapa.get(lin).get(col + 1).add(".p");
			}
		} catch (Exception e) {
		}
		try {
			if (!mapa.get(lin).get(col - 1).contains(".p") && !mapa.get(lin).get(col - 1).contains("*")
					&& !mapa.get(lin).get(col - 1).contains("P")) {
				mapa.get(lin).get(col - 1).add(".p");
			}
		} catch (Exception e) {
		}

	}

	public void removeSupostos(int lin, int col) {
		try {

			if (mapa.get(lin + 1).get(col).contains(".w")) {
				mapa.get(lin + 1).get(col).remove(".w");
			}

			if (mapa.get(lin + 1).get(col).contains(".p")) {
				mapa.get(lin + 1).get(col).remove(".p");
			}

		} catch (Exception e) {

		}
		try {
			if (mapa.get(lin - 1).get(col).contains(".w")) {
				mapa.get(lin - 1).get(col).remove(".w");
			}

			if (mapa.get(lin - 1).get(col).contains(".p")) {
				mapa.get(lin - 1).get(col).remove(".p");
			}

		} catch (Exception e) {
		}
		try {
			if (mapa.get(lin).get(col + 1).contains(".w")) {
				mapa.get(lin).get(col + 1).remove(".w");
			}

			if (mapa.get(lin).get(col + 1).contains(".p")) {
				mapa.get(lin).get(col + 1).remove(".p");
			}

		} catch (Exception e) {
		}

		try {

			if (mapa.get(lin).get(col - 1).contains(".w")) {
				mapa.get(lin).get(col - 1).remove(".w");
			}

			if (mapa.get(lin).get(col - 1).contains(".p")) {
				mapa.get(lin).get(col - 1).remove(".p");
			}

		} catch (Exception e) {
		}
	}

	public void adicionaCasasAdjacentes(int lin, int col) {
		adicionarCasa(lin + 1, col);
		adicionarCasa(lin, col + 1);

		try {
			adicionarCasa(lin - 1, col);

		} catch (Exception e) {
		}
		try {
			adicionarCasa(lin, col - 1);

		} catch (Exception e) {
		}

	}

	public void analiseMapeamento() {

		for (int i = 0; i < mapa.size(); i++) {
			for (int j = 0; j < mapa.get(i).size(); j++) {

				if (mapa.get(i).get(j).contains(".p")) {

					int cont_brisa = contaBrisasAdjacentes(i, j);
					int cont_fedor = contaFedorAdjacentes(i, j);

					if (cont_brisa >= 2 && (temDiagonalSeg(i, j) || temDiagonalDiferenteDoElemento(i, j, "P"))) {

						mapa.get(i).get(j).remove(".p");
						mapa.get(i).get(j).add("P");
						removeSensacao(i, j, "b");

					}

				}
				if (mapa.get(i).get(j).contains(".w")) {

					
					int cont_fedor = contaFedorAdjacentes(i, j);

					if (cont_fedor >= 2 && (temDiagonalSeg(i, j) || temDiagonalDiferenteDoElemento(i, j, "W"))) {

						mapa.get(i).get(j).remove(".w");
						mapa.get(i).get(j).add("W");
						removeSensacao(i, j, "f");

					}

				}

			}

		}

	}

	public int contaFedorAdjacentes(int i, int j) {
		int cont_fedor = 0;
		try {
			if (mapa.get(i + 1).get(j).contains("f")) {
				cont_fedor++;
			}

		} catch (Exception e) {
		}
		try {
			if (mapa.get(i - 1).get(j).contains("f")) {
				cont_fedor++;
			}

		} catch (Exception e) {
		}
		try {
			if (mapa.get(i).get(j + 1).contains("f")) {
				cont_fedor++;
			}

		} catch (Exception e) {
		}
		try {
			if (mapa.get(i).get(j - 1).contains("f")) {
				cont_fedor++;
			}

		} catch (Exception e) {
		}
		return cont_fedor;

	}
	
	public void removeSensacao(int i, int j, String s) {

		try {
			if (mapa.get(i + 1).get(j).contains(s)) {
				mapa.get(i + 1).get(j).remove(s);
			}

		} catch (Exception e) {
		}
		try {
			if (mapa.get(i - 1).get(j).contains(s)) {
				mapa.get(i - 1).get(j).remove(s);
			}

		} catch (Exception e) {
		}
		try {
			if (mapa.get(i).get(j + 1).contains(s)) {
				mapa.get(i).get(j + 1).remove(s);
			}

		} catch (Exception e) {
		}
		try {
			if (mapa.get(i).get(j - 1).contains(s)) {
				mapa.get(i).get(j - 1).remove(s);
			}

		} catch (Exception e) {
		}

	}

	public int contaBrisasAdjacentes(int i, int j) {
		int cont_brisa = 0;
		try {
			if (mapa.get(i + 1).get(j).contains("b")) {
				cont_brisa++;
			}

		} catch (Exception e) {
		}
		try {
			if (mapa.get(i - 1).get(j).contains("b")) {
				cont_brisa++;
			}

		} catch (Exception e) {
		}
		try {
			if (mapa.get(i).get(j + 1).contains("b")) {
				cont_brisa++;
			}

		} catch (Exception e) {
		}
		try {
			if (mapa.get(i).get(j - 1).contains("b")) {
				cont_brisa++;
			}

		} catch (Exception e) {
		}
		return cont_brisa;
	}

	public boolean temDiagonalDiferenteDoElemento(int i, int j, String e) {

		try {
			if (!mapa.get(i + 1).get(j + 1).contains(e)) {
				return true;
			}

		} catch (Exception ex) {
		}
		try {
			if (!mapa.get(i - 1).get(j - 1).contains(e)) {
				return true;
			}

		} catch (Exception ex) {
		}
		try {
			if (!mapa.get(i - 1).get(j + 1).contains(e)) {
				return true;
			}

		} catch (Exception ex) {
		}
		try {
			if (!mapa.get(i + 1).get(j - 1).contains(e)) {
				return true;
			}
		} catch (Exception ex) {
		}
		return false;
	}

	public boolean temDiagonalSeg(int i, int j) {

		try {
			if (mapa.get(i + 1).get(j + 1).contains("*")) {
				return true;
			}

		} catch (Exception e) {
		}
		try {
			if (mapa.get(i - 1).get(j - 1).contains("*")) {
				return true;
			}

		} catch (Exception e) {
		}
		try {
			if (mapa.get(i - 1).get(j + 1).contains("*")) {
				return true;
			}

		} catch (Exception e) {
		}
		try {
			if (mapa.get(i + 1).get(j - 1).contains("*")) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;

	}

	public void mostrarMapa() {
		for (int i = 0; i < 25; i++) {
			System.out.println();

		}
		System.out.println();
		for (int i = 0; i < mapa.size(); i++) {
			for (int j = 0; j < mapa.get(i).size(); j++) {
				System.out.print("\t" + mapa.get(i).get(j));

			}
			System.out.println();
		}
	}

}
