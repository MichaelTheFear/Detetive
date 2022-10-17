package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteJogador {

	
	
	@Test
	public void testeConstrutor() {
		Carta cartas[] = new Carta[3];
		cartas[0] = new CartaArma("Corda");
		cartas[1] = new CartaLocal("Cozinha");
		cartas[2] = new CartaSuspeito("Coronel Mustarda");
		Posicao p = new Quadrado(10,10);
		Jogador j = new Jogador("Coronel Mustarda",cartas,p);
		assertNotNull("Testando Jogador Null",j);
	}
	
	@Test
	public void testeGetPos() {
		Carta cartas[] = new Carta[3];
		cartas[0] = new CartaArma("Corda");
		cartas[1] = new CartaLocal("Cozinha");
		cartas[2] = new CartaSuspeito("Coronel Mustarda");
		Posicao p = new Quadrado(10,10);
		Jogador j = new Jogador("Coronel Mustarda",cartas,p);
		Helpers.posicaoHelper(10,10,"Testando getPos",j);
	}
	
	/*
	 * TODO : Teste Acusar e Dar Palpite pois necessitam do Jogo
	 */
	
	
	@Test
	public void testeAddAndSetCartasVistas() {
		Carta cartas[] = new Carta[3];
		cartas[0] = new CartaArma("Corda");
		cartas[1] = new CartaLocal("Cozinha");
		cartas[2] = new CartaSuspeito("Coronel Mustarda");
		Posicao p = new Quadrado(10,10);
		Jogador j = new Jogador("Coronel Mustarda",cartas,p);
		Carta c = new CartaArma("Chave Inglesa");
		j.addCartasVista(c);
		Carta cartas2[] = j.getCartasVistas();
		assertTrue("Checando getCartasVistas e addCartasVistas",c.equals(cartas2[3]));
	}
	
	@Test
	public void testeGetCartasIniciais() {
		Jogador j = Helpers.jogadorGenericoHelper();
		Carta esperado[] = Helpers.cartasGenericasHelper();
		Carta cartasJogador[] = j.getCartasIniciais();
		assertEquals("Tamanho de cartas do getCartasIniciais Invalida",esperado.length,cartasJogador.length);
		for(int i = 0; i<esperado.length;i++) {
			assertTrue("Checando se Cartas do getCartasIniciais sao iguais",esperado[i].equals(cartasJogador[i]));
		}
		//escrever teste para verificar que duas cartas nao sao do mesmo tipo
	}
	

}
