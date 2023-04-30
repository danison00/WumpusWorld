package interfaceJogo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Wumpus {

	private int x, y;
	private Image wumpus;

	private int altura, largura;

	public Wumpus() {

		this.x = 50;
		this.y = 50+(161*2);
	}

	public void load() {

		ImageIcon caminho_wumpus = new ImageIcon("src/interfaceJogo/resource/wumpus.png");
		wumpus = caminho_wumpus.getImage();

		largura = wumpus.getWidth(null);
		altura = wumpus.getHeight(null);

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getWumpus() {
		return wumpus;
	}

	public void setWumpus(Image wumpus) {
		this.wumpus = wumpus;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}
	
}
