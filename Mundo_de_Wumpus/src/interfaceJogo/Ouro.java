package interfaceJogo;

import java.awt.Image;

import javax.swing.ImageIcon;


public class Ouro {
	private int x, y;
	private Image ouro;

	private int altura, largura;

	public Ouro(int x, int y) {

		this.x = 30+(x*172);
		this.y = 30+(y*161);
	}

	public void load() {

		ImageIcon caminho_ouro = new ImageIcon("src/interfaceJogo/resource/ouro.png");
		ouro = caminho_ouro.getImage();

		largura = ouro.getWidth(null);
		altura = ouro.getHeight(null);

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
		return ouro;
	}

	public void setWumpus(Image wumpus) {
		this.ouro = wumpus;
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
