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
	public void testeGetSetPoscicoesProximas() {
		Posicao pos = new Quadrado(10,10);
		Coordenadas posicoesAdjacentes[] = new Coordenadas[4];
		for(int i = 0;i<4;i++) {
			posicoesAdjacentes[i] = new Coordenadas(10+i,10+i);
		}
		pos.setPosicoesProximas(posicoesAdjacentes);
		
		Coordenadas res[] = pos.getPosicoesProximas();
		assertEquals("Testando se tamnho do getPosicoesProx",res.length,posicoesAdjacentes.length);
		
		for(int i = 0; i<4;i++) { 
			assertTrue("Testando se getPosicoesProximas retornam o esperado",posicoesAdjacentes[i].equals(res[i]));
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
		
		assertTrue("Testando se Construtor de jogador muda o estado de jogadorAqui",j.getPos().getJogadorAqui());
	}
	
	@Test
	public void testeGetCoordenadas() {
		Posicao p = new Quadrado(15,15);
		int coordenadasEsperadas[] = {15,15};
		Coordenadas c = p.getCoordenadas();
		assertTrue("Testando getCoordenadas",
				c.getX()==coordenadasEsperadas[0] &&
				c.getY()==coordenadasEsperadas[1]);
	}
	

}
