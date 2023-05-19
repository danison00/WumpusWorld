package wumpus;

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
	int qtd_fl = QTD_FLECHAS;


	public Agente() {

		this.locLin = 0;
		this.locCol = 0;
		this.venceu = false;
		this.pegouOuro = false;
		this.caiuPoco = false;
		this.devorado = false;
		this.perdeu = false;

	}

	public int atira(int regiao) {
		
		qtd_fl--;

		switch (regiao) {

		case CSE:
			int sentido_tiro = random.nextInt(2);

			if (sentido_tiro == 0){
				linTiro = locLin++; // ATIRAR SUL
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
		return 0;

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
