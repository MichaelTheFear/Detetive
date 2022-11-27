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
	
	static Posicao[][] posicoesArrayHelper() {
		Posicao pos[][] = new Posicao[Tabuleiro.numPorLinha][Tabuleiro.numPorLinha];
		for (int i = 0, j; i < Tabuleiro.numPorLinha; i++) {
			for (j = 0; j < Tabuleiro.numPorLinha; j++) {
				pos[i][j] = new Porta(i, j);
			}
		}
		return pos;
	}

	private static int mod(int a, int b) {
		int res = a % b;
		if (res < 0)
			res += b;
		return res;
	}


	protected static void posicaoHelper(int x, int y, String msg, Jogador j) {
		Posicao p = j.getPos();
		Posicao esperado = new Porta(x, y);
		assertTrue(msg, esperado.equals(p));
	}


}
