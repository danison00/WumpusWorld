package interfaceJogo;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Conteiner extends JFrame {
	
	public Conteiner(ArrayList<Integer> passosLin, ArrayList<Integer> passosCol) {
		
		Fase fase = new Fase(passosLin, passosCol);
		add(fase);
		setTitle("Wumpus World");
		setSize(701,690);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}


}
