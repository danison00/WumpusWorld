package wumpus;

public class Agente {

	private int locLin;
	private int locCol;
	private boolean venceu;
	private boolean pegouOuro;
	private boolean caiuPoco;
	private boolean devorado;
	private boolean perdeu;

	public Agente() {

		this.locLin = 0;
		this.locCol = 0;
		this.venceu = false;
		this.pegouOuro = false;
		this.caiuPoco = false;
		this.devorado = false;
		this.perdeu = false;

	}
	
	
	
	
	public void mover() {
		
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
