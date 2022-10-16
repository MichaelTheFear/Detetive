package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteJogador {
	
	private Carta[] cartasGenericasHelper() {
		Carta cartas[] = new Carta[3];
		cartas[0] = new CartaArma("Corda");
		cartas[1] = new CartaLocal("Cozinha");
		cartas[2] = new CartaSuspeito("Coronel Mustarda");
		return cartas;
	}

	private Jogador jogadorGenericoHelper() {
		Carta cartas[] = cartasGenericasHelper();
		Posicao p = new Posicao(10,10);
		Jogador j = new Jogador("Reverendo Green",cartas,p);
		return j;
	}
	
	private void posicaoHelper(int x, int y, String msg, Jogador j) {
		Posicao p = j.getPos();
		Posicao esperado = new Posicao(x,y);
		assertTrue(msg,esperado.equals(p));
	}
	
	@Test
	public void testeConstrutor() {
		Jogador j = jogadorGenericoHelper();
		assertNotNull("Testando Jogador Null",j);
	}
	
	@Test
	public void testeGetPos() {
		Jogador j = jogadorGenericoHelper();
		posicaoHelper(10,10,"Testando getPos",j);
	}
	
	/*
	 * TODO : Teste Acusar e Dar Palpite pois necessitam do Jogo
	 */
	
	/*
	@Test
	public void testeMover() {
		int x = 20, y = 20;
		Jogador j = jogadorGenericoHelper();
		j.mover(x,y);
		posicaoHelper(x,y,"Testando Mover de 10,10 para 20,20",j);
	}
	*/
	@Test
	public void testeAddAndSetCartasVistas() {
		Jogador j = jogadorGenericoHelper();
		Carta c = new CartaArma("Chave Inglesa");
		j.addCartasVista(c);
		Carta cartas[] = j.getCartasVistas();
		assertEquals("Checando getCartasVistas e addCartasVistas",cartas.length,4);
	}
	
	@Test
	public void testeGetCartasIniciais() {
		Jogador j = jogadorGenericoHelper();
		Carta esperado[] = cartasGenericasHelper();
		Carta cartasJogador[] = getCartasIniciais();
		assertEquals("Tamanho de cartas do getCartasIniciais Invalida",esperado.length,cartasJogador.length);
		for(int i = 0; i<esperado.length;i++) {
			assertTrue("Checando se Cartas do getCartasIniciais sao iguais",esperado[i].equals(cartasJogador[i]));
		}
		//escrever teste para verificar que duas cartas nao sao do mesmo tipo
	}
	

}
