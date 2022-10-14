package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestePosicao {

	@Test
	public void testeConstrutorPosicao() {
		Posicao p = new Quadrado(10,10);
		assertNotNull("Testando Construtor Posicao ",p);
	}
	
	@Test
	public void testeGetSetSPoscicoesProximas() {
		Posicao pos = new Quadrado(10,10);
		Posicao posicoesAdjacentes[] = new Posicao[4];
		
		for(int i = 0;i<4;i++) {
			posicoesAdjacentes[i] = new Posicao(10+i,10+i);
		}
		pos.setPosicoesProximas(posicoesAdjacentes);
		Posicao res[] = pos.getPosicoesProximas();
		assertEquals("Testando se tamnho do getPosicoesProx",res.length,posicoesAdjacentes.length);
		
		for(int i = 0; i<4;i++) {
			assertTrue("Testando se getPosicoesProximas retornam o esperado",posicoesAdjacentes[i].equals(res));
		}
	}
	
	@Test
	public void testeJogadorAqui() {
		Posicao p = new Quadrado(10,10);
		Carta cartas[] = new Carta[3];
		cartas[0] = new CartaArma("Corda");
		cartas[1] = new CartaLocal("Cozinha");
		cartas[2] = new CartaSuspeito("Coronel Mustarda");
		Jogador j = new Jogador("Reverendo Green",cartas,p);
		assertTrue("Testando se Construtor de jogador muda o estado de jogadorAqui",p.getJogadorAqui());
	//talvez devesse ficar em jogo em vez de tabuleiro
	//TODO MUDARRRRR
	}
	
	@Test
	public void testeGetCoordenadas() {
		Posicao p = new Quadrado(15,15);
		int coordenadasEsperadas[] = {15,15};
		int res[] = p.getCoordenadas();
		assertTrue("Testando getCoordenadas",
				res[0]==coordenadasEsperadas[0] &&
				res[1]==coordenadasEsperadas[1]);
	}
	

}
