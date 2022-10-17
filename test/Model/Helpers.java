package Model;

import static org.junit.Assert.assertTrue;

public class Helpers {
	
	//esta classe foi criada pois havia testes em duas classes de testes que precisavam do mesmo helper
	protected static Carta[] cartasGenericasHelper() {
		Carta cartas[] = new Carta[3];
		cartas[0] = new CartaArma("Corda");
		cartas[1] = new CartaLocal("Cozinha");
		cartas[2] = new CartaSuspeito("Coronel Mustarda");
		return cartas;
	}
	
	protected static Posicao[] posicoesArrayHelper() {
		Posicao pos[] = new Posicao[Tabuleiro.size];
		for(int i = 0, j;i<Tabuleiro.numPorLinha;i++) {
			for(j = 0;j<Tabuleiro.numPorLinha;j++) {
				pos[j+i*Tabuleiro.numPorLinha] = new Quadrado(j,i);
			}
			
		}
		return pos;
	}
	
	protected static Jogador jogadorGenericoHelper() {
		Carta cartas[] = cartasGenericasHelper();
		Posicao p = new Quadrado(10,10);
		Jogador j = new Jogador("Reverendo Green",cartas,p);
		return j;
	}
	
	protected static void posicaoHelper(int x, int y, String msg, Jogador j) {
		Posicao p = j.getPos();
		Posicao esperado = new Quadrado(x,y);
		assertTrue(msg,esperado.equals(p));
	}
}
