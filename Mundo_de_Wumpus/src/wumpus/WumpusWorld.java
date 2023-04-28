package wumpus;

import java.util.Random;

public class WumpusWorld {
	
	 	
	    
	    public WumpusWorld(int size) {
	        // cria uma matriz de tamanho size x size
	        world = new int[size][size];
	        
	        // inicializa o objeto Random
	        random = new Random();
	        
	        // escolhe uma posição aleatória para o agente
	        currentX = random.nextInt(size);
	        currentY = random.nextInt(size);
	    }
	    
	    public void run() {
	        // loop principal do agente
	        while (true) {
	            // executa uma ação aleatória
	            int action = random.nextInt(4);
	            
	            switch (action) {
	                case 0: // mover para cima
	                    if (currentY > 0) {
	                        currentY--;
	                    }
	                    break;
	                    
	                case 1: // mover para baixo
	                    if (currentY < world.length - 1) {
	                        currentY++;
	                    }
	                    break;
	                    
	                case 2: // mover para a esquerda
	                    if (currentX > 0) {
	                        currentX--;
	                    }
	                    break;
	                    
	                case 3: // mover para a direita
	                    if (currentX < world.length - 1) {
	                        currentX++;
	                    }
	                    break;
	            }
	            
	            // imprime a posição atual do agente
	            System.out.println("Agente está em: (" + currentX + ", " + currentY + ")");
	            
	            // espera um segundo antes de executar a próxima ação
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    public static void main(String[] args) {
	        WumpusWorld world = new WumpusWorld(10);
	        world.run();
	    }


}
