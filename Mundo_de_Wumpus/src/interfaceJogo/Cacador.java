package interfaceJogo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Cacador {

	private int x, y, dx, dy, cont = 0;
	private Image cacador;
	private ArrayList<Integer> passosLin;
	private ArrayList<Integer> passosCol;
	private int altura, largura;
	private ArrayList<Integer> posicaoCacador;

	public Cacador(ArrayList<Integer> passosLin, ArrayList<Integer> passosCol){

		this.x = 30;
		this.y = 25;
		
		this.passosCol = passosCol;
		this.passosLin = passosLin;
		
	}

	public void load(){

		ImageIcon caminho_cacador = new ImageIcon("src/interfaceJogo/resource/cacador.png");
		cacador = caminho_cacador.getImage();
		
		altura = cacador.getHeight(null);
		largura = cacador.getWidth(null);
		
	}

	public void update(){

		this.x = dx;
		this.y = dy;
	}

	public ArrayList<Integer> keyPressed(KeyEvent tecla) {
		
		posicaoCacador = new ArrayList<>();
		
		int codigo = tecla.getKeyCode();
		if (codigo == KeyEvent.VK_UP || codigo == KeyEvent.VK_DOWN ||
			codigo == KeyEvent.VK_LEFT || codigo == KeyEvent.VK_RIGHT){
			
			this.dy = 25+(161*passosLin.get(cont));
			this.dx = 50+(172*passosCol.get(cont));
			
			this.posicaoCacador.add(dy);
			this.posicaoCacador.add(dx);
		}
	
		System.out.println(cont+": "+passosLin.get(cont)+","+passosCol.get(cont));
		if(cont<passosCol.size()-1){
			
			cont++;
		}
		return this.posicaoCacador;
	}

	public void keyRelease(KeyEvent tecla){
		
		

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
