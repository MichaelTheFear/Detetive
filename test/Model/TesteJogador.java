package Model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TesteJogador {

	
	
	@Test
	public void testeConstrutor() {
		Jogador j = Helpers.jogadorGenericoHelper();
		assertNotNull("Testando Jogador Null",j);
	}
	
	/*
	 * TODO : Teste Acusar e Dar Palpite pois necessitam do Jogo
	 */
	
	
	@Test
	public void testeAddAndSetCartasVistas() {
		Jogador j = Helpers.jogadorGenericoHelper();
		Carta c = new CartaArma("Chave Inglesa");
		j.addCartasVista(c);
		List<Carta> cartas = j.getCartasVistas();
		assertTrue("Checando getCartasVistas e addCartasVistas",c.equals(cartas.get(3)));
	}
	
	@Test
	public void testeGetCartasIniciais() {
		Jogador j = Helpers.jogadorGenericoHelper();
		Carta esperado[] = Helpers.cartasGenericasHelper();
		/*
		Carta cartasJogador[] = j.getCartasIniciais();
		assertEquals("Tamanho de cartas do getCartasIniciais Invalida",esperado.length,cartasJogador.length);
		for(int i = 0; i<esperado.length;i++) {
			assertTrue("Checando se Cartas do getCartasIniciais sao iguais",esperado[i].equals(cartasJogador[i]));
		}
		*/
		//escrever teste para verificar que duas cartas nao sao do mesmo tipo
	}
	

}
