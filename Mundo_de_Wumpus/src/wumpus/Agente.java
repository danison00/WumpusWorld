package wumpus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Agente extends Util {
	
	

	Random random = new Random();
	private int locLin;
	private int locCol;
	int linTiro;
	int colTiro;
	private boolean venceu;
	private boolean pegouOuro;
	private boolean caiuPoco;
	private boolean devorado;
	private boolean perdeu;
	int qtd_fl;
	Tiro tiro;

	public Agente(int qtd_flechas) {

		this.locLin = 0;
		this.locCol = 0;
		this.venceu = false;
		this.pegouOuro = false;
		this.caiuPoco = false;
		this.devorado = false;
		this.perdeu = false;
		this.qtd_fl = qtd_flechas;
		//System.out.println(qtd_flechas);
	}
	
	
	
	public Tiro atira(int regiao, List<List<List<String>>> matrizSensacoes) {

		if (matrizSensacoes.get(getLocLin()).get(getLocCol()).contains(SENSACAO_WUMPUS)) {

			if (qtd_fl > 0) {

				qtd_fl--;

				switch (regiao) {

				case CSE:
					int sentido_tiro = random.nextInt(2);

					if (sentido_tiro == 0) {
						linTiro = locLin +  1; // ATIRAR SUL
						colTiro = locCol;
					}
					if (sentido_tiro == 1) {
						colTiro = locCol + 1; // ATIRAR LESTE
						linTiro = locLin;
					}
					break;

				case CSD:
					sentido_tiro = random.nextInt(2);
					if (sentido_tiro == 0) {
						linTiro = locLin + 1; // ATIRAR SUL
						colTiro = locCol;
					}

					if (sentido_tiro == 1) {
						colTiro = locCol - 1; // ATIRAR OESTE
						linTiro = locLin;
					}
					break;

				case CIE:
					sentido_tiro = random.nextInt(2);
					if (sentido_tiro == 0) {
						linTiro = locLin - 1; // ATIRAR NORTE
						colTiro = locCol;
					}
					if (sentido_tiro == 1) {
						colTiro = locCol + 1; // ATIRAR LESTE
						linTiro = locLin;
					}
					break;

				case CID:
					sentido_tiro = random.nextInt(2);
					if (sentido_tiro == 0) {
						linTiro = locLin - 1; // ATIRAR NORTE
						colTiro = locCol;
					}
					if (sentido_tiro == 1) {
						colTiro = locCol - 1; // ATIRAR OESTE
						linTiro = locLin;
					}
					break;

				case PE:
					sentido_tiro = random.nextInt(3);
					if (sentido_tiro == 0) {
						colTiro = locCol + 1; // ATIRAR LESTE
						linTiro = locLin;
					}
					if (sentido_tiro == 1) {
						linTiro = locLin - 1; // ATIRAR NORTE
						colTiro = locCol;
					}
					if (sentido_tiro == 2) {
						linTiro = locLin + 1; // ATIRAR SUL
						colTiro = locCol;
					}
					break;

				case PD:
					sentido_tiro = random.nextInt(3);
					if (sentido_tiro == 0) {
						colTiro = locCol - 1; // ATIRAR OESTE
						linTiro = locLin;
					}
					if (sentido_tiro == 1) {
						linTiro = locLin - 1; // ATIRAR NORTE
						colTiro = locCol;
					}
					if (sentido_tiro == 2) {
						linTiro = locLin + 1; // ATIRAR SUL
						colTiro = locCol;
					}
					break;

				case PS:
					sentido_tiro = random.nextInt(3);
					if (sentido_tiro == 0) {
						colTiro = locCol + 1; // ATIRAR LESTE
						linTiro = locLin;
					}
					if (sentido_tiro == 1) {
						linTiro = locLin + 1; // ATIRAR SUL
						colTiro = locCol;
					}
					if (sentido_tiro == 2) {
						colTiro = locCol - 1; // ATIRAR OESTE
						linTiro = locLin;
					}
					break;

				case PI:
					sentido_tiro = random.nextInt(3);
					if (sentido_tiro == 0) {
						colTiro = locCol - 1; // ATIRAR OESTE
						linTiro = locLin;
					}
					if (sentido_tiro == 1) {
						linTiro = locLin - 1; // ATIRAR NORTE
						colTiro = locCol;
					}
					if (sentido_tiro == 2) {
						colTiro = locCol + 1; // ATIRAR LESTE
						linTiro = locLin;
					}
					break;

				case C:
					sentido_tiro = random.nextInt(4);
					if (sentido_tiro == 0) {
						linTiro = locLin - 1; // ATIRAR NORTE
						colTiro = locCol;
					}
					if (sentido_tiro == 1) {
						linTiro = locLin + 1; // ATIRAR SUL
						colTiro = locCol;
					}
					if (sentido_tiro == 2) {
						colTiro = locCol + 1; // ATIRAR LESTE
						linTiro = locLin;
					}
					if (sentido_tiro == 3) {
						colTiro = locCol - 1; // ATIRAR OESTE
						linTiro = locLin;
					}

					break;
				}
				tiro = new Tiro(true, linTiro, colTiro);

				return tiro;
				
			}

		}
		tiro = new Tiro(false, linTiro, colTiro);
		
		return null;

	}

	public boolean pegaOuro(List<List<List<String>>> matrizSensacoes) {
		
		if(matrizSensacoes.get(locLin).get(locCol).contains(SENSACAO_OURO)) {
			this.pegouOuro = true;
			return true;
		}
		return false;
		
	}

	public void movimenta(int regiao) {
		
		switch (regiao) {

		case CSE:
			int sentido_mover = random.nextInt(2);

			if (sentido_mover == 0)
				locLin++;// MOVER SUL
			if (sentido_mover == 1)
				locCol++; // MOVER LESTE
			break;

		case CSD:
			sentido_mover = random.nextInt(2);
			if (sentido_mover == 0)
				setLocLin(getLocLin() + 1); // MOVER SUL
			if (sentido_mover == 1)
				setLocCol(getLocCol() - 1); // MOVER OESTE
			break;

		case CIE:
			sentido_mover = random.nextInt(2);
			if (sentido_mover == 0)
				setLocLin(getLocLin() - 1); // MOVER NORTE
			if (sentido_mover == 1)
				setLocCol(getLocCol() + 1); // MOVER LESTE
			break;

		case CID:
			sentido_mover = random.nextInt(2);
			if (sentido_mover == 0)
				setLocLin(getLocLin() - 1); // MOVER NORTE
			if (sentido_mover == 1)
				setLocCol(getLocCol() - 1); // MOVER OESTE
			break;

		case PE:
			sentido_mover = random.nextInt(3);
			if (sentido_mover == 0)
				setLocCol(getLocCol() + 1); // MOVER LESTE
			if (sentido_mover == 1)
				setLocLin(getLocLin() - 1); // MOVER NORTE
			if (sentido_mover == 2)
				setLocLin(getLocLin() + 1); // MOVER SUL
			break;

		case PD:
			sentido_mover = random.nextInt(3);
			if (sentido_mover == 0)
				setLocCol(getLocCol() - 1); // MOVER OESTE
			if (sentido_mover == 1)
				setLocLin(getLocLin() - 1); // MOVER NORTE
			if (sentido_mover == 2)
				setLocLin(getLocLin() + 1); // MOVER SUL
			break;

		case PS:
			sentido_mover = random.nextInt(3);
			if (sentido_mover == 0)
				setLocCol(getLocCol() + 1); // MOVER LESTE
			if (sentido_mover == 1)
				setLocLin(getLocLin() + 1); // MOVER SUL
			if (sentido_mover == 2)
				setLocCol(getLocCol() - 1); // MOVER OESTE
			break;

		case PI:
			sentido_mover = random.nextInt(3);
			if (sentido_mover == 0)
				setLocCol(getLocCol() - 1); // MOVER OESTE
			if (sentido_mover == 1)
				setLocLin(getLocLin() - 1); // MOVER NORTE
			if (sentido_mover == 2)
				setLocCol(getLocCol() + 1); // MOVER LESTE
			break;

		case C:
			sentido_mover = random.nextInt(4);
			if (sentido_mover == 0)
				setLocLin(getLocLin() - 1); // MOVER NORTE
			if (sentido_mover == 1)
				setLocLin(getLocLin() + 1); // MOVER SUL
			if (sentido_mover == 2)
				setLocCol(getLocCol() + 1); // MOVER LESTE
			if (sentido_mover == 3)
				setLocCol(getLocCol() - 1); // MOVER OESTE

			break;
		}

	}
	public int getLocLin() {
		return locLin;
	}

	public void setLocLin(int locLin) {
		this.locLin = locLin;
	}

	public int getLocCol() {
		return locCol;
	}

	public void setLocCol(int locCol) {
		this.locCol = locCol;
	}

	public boolean isVenceu() {
		return venceu;
	}

	public void setVenceu(boolean venceu) {
		this.venceu = venceu;
	}

	public boolean isPegouOuro() {
		return pegouOuro;
	}

	public void setPegouOuro(boolean pegouOuro) {
		this.pegouOuro = pegouOuro;
	}

	public boolean isCaiuPoco() {
		return caiuPoco;
	}

	public void setCaiuPoco(boolean caiuPoco) {
		this.caiuPoco = caiuPoco;
	}

	public boolean isDevorado() {
		return devorado;
	}

	public void setDevorado(boolean devorado) {
		this.devorado = devorado;
	}

	public boolean isPerdeu() {
		return perdeu;
	}

	public void setPerdeu(boolean perdeu) {
		this.perdeu = perdeu;
	}

	
}
