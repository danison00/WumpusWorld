package interfaceJogo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {


	BufferedImage imagem = null;
	private Cacador cacador;
	private Wumpus wumpus;
	private Poco poco1, poco2;
	private Ouro ouro;

	private Timer timer;

	public Fase(ArrayList<Integer> passosLin, ArrayList<Integer> passosCol) {
		
		
		setFocusable(true);
		setDoubleBuffered(true);
		try {
			imagem = ImageIO.read(new File("src/interfaceJogo/resource/background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		wumpus = new Wumpus();
		wumpus.load();
		
		poco1 = new Poco(1,2);
		poco1.load();
		
		poco2 = new Poco(2,0);
		poco2.load();
		
		
		cacador = new Cacador();
		cacador.load();
		
		ouro = new Ouro(1,3);
		ouro.load();
		
		
		
	
		addKeyListener(new TecladoAdapter());
		timer = new Timer(90, this);
		timer.start();
	

	}

	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(imagem, 0, 0, null);
		g2d.drawImage(cacador.getImagem(), cacador.getX(), cacador.getY(), this);
		
		g2d.drawImage(wumpus.getWumpus(), wumpus.getX(), wumpus.getY(), this);
		g2d.drawImage(poco1.getWumpus(), poco1.getX(), poco1.getY(), this);
		g2d.drawImage(poco2.getWumpus(), poco2.getX(), poco2.getY(), this);
		g2d.drawImage(ouro.getWumpus(), ouro.getX(), ouro.getY(), this);



		g.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		cacador.update();
		repaint();

	}
	
	

	private class TecladoAdapter extends KeyAdapter {
		@Override
		public void  keyPressed(KeyEvent e) {
			cacador.keyPressed(e);
		
		
		}
		@Override
		public void  keyReleased(KeyEvent e) {
			cacador.keyRelease(e);
		}
	
	
}
}
