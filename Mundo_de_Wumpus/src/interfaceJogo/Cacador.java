package interfaceJogo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Cacador {

	private int x, y, dx, dy;
	private Image cacador;

	private int altura, largura;

	public Cacador() {

		this.x = 30;
		this.y = 25;
	}

	public void load() {

		ImageIcon caminho_cacador = new ImageIcon("src/interfaceJogo/resource/cacador.png");
		cacador = caminho_cacador.getImage();
		
		altura = cacador.getHeight(null);
		largura = cacador.getWidth(null);
		
	}

	public void update() {

		x += dx;
		y += dy;


	}

	public void keyPressed(KeyEvent tecla) {

		int codigo = tecla.getKeyCode();
		if (codigo == KeyEvent.VK_UP) {
			
			dy = -161;
		}
		if (codigo == KeyEvent.VK_DOWN) {

			dy = 161;
		}
		if (codigo == KeyEvent.VK_LEFT) {

			dx = -172;
		}
		if (codigo == KeyEvent.VK_RIGHT) {

			dx = 172;
		}

	}

	public void keyRelease(KeyEvent tecla) {

		int codigo = tecla.getKeyCode();
		if (codigo == KeyEvent.VK_UP) {

			dy = 0;
		}
		if (codigo == KeyEvent.VK_DOWN) {

			dy = 0;
		}
		if (codigo == KeyEvent.VK_LEFT) {

			dx = 0;
		}
		if (codigo == KeyEvent.VK_RIGHT) {

			dx = 0;
		}

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

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public Image getImagem() {
		return cacador;
	}

	public void setImagem(Image imagem) {
		this.cacador = (BufferedImage) imagem;
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
