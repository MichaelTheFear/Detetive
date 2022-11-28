package Model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TesteTabuleiro {
	
	@Test
	public void testeContrutorTabuleiro() {
		Tabuleiro t = new Tabuleiro();
		assertNotNull("Testando Construtor Tabuleiro",t);
	}
	
	@Test
	public void setGetPosicoes() {
		Tabuleiro t = new Tabuleiro();
		Posicao[][] p = { { new Posicao(10,10), new Posicao(8,8) }, { new Posicao(9,9), new Posicao(7,7) } };
		t.setPosicoes(p);
		assertEquals("Testando", p.length, t.getPosicoes().length);
		for(int i=0; i<p.length; i++) {
			for(int j=0; j<p[i].length; j++) {
				assertEquals("Testando setGetPosicoes Tabuleiro", p[i][j], t.getPosicoes()[i][j]);
			}
		}
	}

	@Test
	public void testeSetupTabuleiro() {
		Tabuleiro t = new Tabuleiro();
		Posicao[][] p = t.setupTabuleiro();
		assertEquals("Testanto setupTabuleiro", p.length, 28);
	}
	
	@Test
	public void testeGetPosicaoAt() {
		Tabuleiro t = new Tabuleiro();
		t.setPosicoes(t.setupTabuleiro());
		Posicao p = t.getPosicaoAt(10, 10);
		assertEquals("Testanto getPosicaoAt Tabuleiro", p, t.getPosicoes()[10][10]);
	}
	
	
}
