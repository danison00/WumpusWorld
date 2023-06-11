package algoritmo_genetico;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Newclass {
	
	int num_individuos;
	int min_cromossomos = 4;
	int max_cromossomos;
	int geracão_corrente=0;
	Random random = new Random();
	Reproducao reproducao = new Reproducao();
	List<List<Individuo>> geracoes = new ArrayList<>();
	
	public Newclass(int num_individuos, int tam_ambiente) {
		
		this.num_individuos = num_individuos;
		max_cromossomos = tam_ambiente*tam_ambiente;
		
		geracoes.add(reproducao.geracaoZero(num_individuos, min_cromossomos, max_cromossomos));
		
		
	}
	
	public void criaGeração() {
		
		//geracoes.add();        
	}
	

}
