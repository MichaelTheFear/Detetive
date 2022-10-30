package Model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Util.Personagem;

public class TesteJogador {

	
	
	@Test
	public void testeConstrutor() {
		Jogador j = Helpers.jogadorGenericoHelper();
		assertNotNull("Testando Jogador Null",j);
	}

	
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
		ArrayList<Carta> cartas = Helpers.cartasGenericasHelper();
		List<Carta> esperado = j.getCartasIniciais();
		Carta[] cartasArr = new Carta[3];
		assertEquals("Tamanho de cartas do getCartasIniciais Invalida",esperado.size(),cartas.size());
		for(int i = 0; i<esperado.size();i++) {
			cartasArr[i] = esperado.get(i);
			assertTrue("Checando se Cartas do getCartasIniciais sao iguais",esperado.get(i).equals(cartas.get(i)));
		}
		assertTrue("Checando se as cartas são de tipos diferentes",Carta.mesmoTipoDeCarta(cartasArr));
		//escrever teste para verificar que duas cartas nao sao do mesmo tipo
	}
	
	@Test
	public void testeSetGetJogando() {
		Jogador j = Helpers.jogadorGenericoHelper();
		j.setJogando(false);
		assertTrue("Testando estaJogando",!j.estaJogando());
	}
	@Test
	public void testeGetPersonagem() {
		Jogador j = Helpers.jogadorGenericoHelper();
		assertEquals("Testando GetPersonagem", j.getPersonagem(), Personagem.Green); 
	}
	@Test
	public void testeSetGetPodeDarPalpite() {
		Jogador j = Helpers.jogadorGenericoHelper();
		j.setPodeDarPalpite(false);
		assertTrue("Testando PodeDarPalpite", !j.getPodeDarPalpite());
	}
	@Test
	public void testeSetGetErrouAcusacao() {
		Jogador j = Helpers.jogadorGenericoHelper();
		j.setErrouAcusacao(false);
		assertTrue("Testando ErrouAcusacao", !j.getErrouAcusacao());
	}
	@Test
	public void testeTemCarta() {
		Jogador j = Helpers.jogadorGenericoHelper();
		List<Carta> c = Helpers.cartasGenericasHelper();
		assertTrue("Testando TemCarta", j.temCarta(c));
	}
	


}
