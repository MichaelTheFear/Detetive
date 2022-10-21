package Model;

import static org.junit.Assert.*;

import java.util.List;

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
		Posicao posicoes[] = t.getPosicoes();
		assertTrue("Testando se o tamanho do array nao e zero", posicoes.length > 0);
		for(Posicao p : posicoes) {
			Posicao adjacentes[] = p.getPosicoesProximas();
			assertNotNull("Verificando se posicao possui array de adjacencia",adjacentes);
			assertEquals("Verificando que possui numero certo de posicoes",adjacentes.length,4);
		}
	}
	
	@Test
	public void testeAchaDestinoFinal() {
		Tabuleiro t = Helpers.initCaminhoHelpers();
		List<Posicao> res = t.achaDesitnosFinais(2, 2, 2, -1);
		System.out.println(res.toArray().toString());
		for(Posicao p: res) {
			assertNotNull("Testando se elementos do array nao sao nulos",p);
		}
	}

}
