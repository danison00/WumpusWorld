package interfaceJogo;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class Ouro {
	private int xx, yy, dx, dy;
	private Image ouro;

	private int altura, largura;

	public Ouro(int x, int y) {

		this.xx = 30+(x*172);
		this.yy = 30+(y*161);
	}

	public void load() {

		ImageIcon caminho_ouro = new ImageIcon("src/interfaceJogo/resource/ouro.png");
		ouro = caminho_ouro.getImage();

		largura = ouro.getWidth(null);
		altura = ouro.getHeight(null);
	}
	
	public void update() {

		this.xx = dx;
		this.yy = dy;

	}

	public void keyPressed(int y, int x) {
		
		this.dy = y;
		this.dx = x;
	
	
	}
	
	public void keyRelease(KeyEvent tecla) {

		

	}
	public void redimensionaOuro() {
		
		ouro = ouro.getScaledInstance(60, 60, Image.SCALE_SMOOTH);

	}


	public int getX() {
		return xx;
	}

	public void setX(int x) {
		this.xx = x;
	}

	public int getY() {
		return yy;
	}

	public void setY(int y) {
		this.yy = y;
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
