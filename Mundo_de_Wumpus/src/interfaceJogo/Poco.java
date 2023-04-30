package interfaceJogo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Poco {
	private int x, y;
	private Image poco;

	private int altura, largura;

	public Poco(int x, int y) {

		this.x = 50+(x*172);
		this.y = 50+(y*161);
	}

	public void load() {

		ImageIcon caminho_wumpus = new ImageIcon("src/interfaceJogo/resource/poco.png");
		poco = caminho_wumpus.getImage();

		largura = poco.getWidth(null);
		altura = poco.getHeight(null);

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
		return poco;
	}

	public void setWumpus(Image wumpus) {
		this.poco = wumpus;
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
