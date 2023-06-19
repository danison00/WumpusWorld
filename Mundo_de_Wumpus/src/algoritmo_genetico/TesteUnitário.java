package algoritmo_genetico;

import java.util.ArrayList;
import java.util.List;

public class TesteUnitário {
	public static void main(String[] args) {

		List<List<Individuo>> l = new ArrayList<>();

		AmbienteDeTesteSelecao teste = new AmbienteDeTesteSelecao(5);
		Reproducao r = new Reproducao();

		l.add(r.geracaoZero(10, 4, 25));

		List<Individuo> melhores = teste.testaIndividuos(l.get(0)); // testa geração 0
		int i = 0;

		while (i <= 100) {

			l.add(r.reproduz(melhores)); // geração 1
			melhores = teste.testaIndividuos(l.get(i));// testa geração 1

			i++;



		}
	}

}
