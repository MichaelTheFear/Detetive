package Model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TesteTabuleiro {
	
	@Test
	public void testeContrutorTabuleiro() {
		Tabuleiro t = new Tabuleiro(Helpers.posicoesArrayHelper());
		assertNotNull("Testando Construtor Tabuleiro",t);
	}
	
	
	@Test
	public void testeInitCaminho() {
		Tabuleiro t = Helpers.initCaminhoHelpers();
		Posicao posicoes[][] = t.getPosicoes();
		assertTrue("Testando se o tamanho do array nao e zero", posicoes.length > 0);
		
		for(Posicao posis[] : posicoes) {
			for(Posicao pos:posis) {
				
				Coordenadas[] adjacentes = pos.getPosicoesProximas();
			
				assertNotNull("Verificando se posicao possui array de adjacencia",adjacentes);
				assertEquals("Verificando que possui numero certo de posicoes",adjacentes.length,4);
			}
		}
		
		return;
	}
	
	

}
