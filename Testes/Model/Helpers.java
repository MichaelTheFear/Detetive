package Model;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import Util.Personagem;

public class Helpers {

	//esta classe foi criada pois havia testes em duas classes de testes que precisavam do mesmo helper
	static ArrayList<Carta> cartasGenericasHelper() {
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new CartaArma("Corda"));
		cartas.add(new CartaLocal("Cozinha"));
		cartas.add(new CartaSuspeito("Coronel Mustarda"));
		return cartas;
	}
	
	static Jogador jogadorGenericoHelper() {
		Tabuleiro t = new Tabuleiro();
		t.setPosicoes(t.setupTabuleiro());
		return new Jogador(Personagem.Scarlet, true, t);
	}
	

	private static int mod(int a, int b) {
		int res = a % b;
		if (res < 0)
			res += b;
		return res;
	}


	protected static void posicaoHelper(int x, int y, String msg, Jogador j) {
		Posicao p = j.getPos();
		Posicao esperado = new Posicao(x, y);
		assertTrue(msg, esperado.equals(p));
	}


}
