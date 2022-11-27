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
		assertNotNull("Testando construtor jogador", j);
	}
	
	@Test
	public void testeEhNpc() {
		Jogador j = Helpers.jogadorGenericoHelper();
		assertTrue("Testando ehNpc jogador", j.ehNpc());
	}
	
	@Test
	public void testeSetEstaJogando() {
		Jogador j = Helpers.jogadorGenericoHelper();
		j.setJogando(true);
		assertTrue("Testando setJogando e estaJogando jogador", j.estaJogando());
	}
	
	@Test
	public void testeSetGetCartasIniciais() {
		Jogador j = Helpers.jogadorGenericoHelper();
		List<Carta> cartas = Helpers.cartasGenericasHelper();
		j.setCartasIniciais(cartas);
		List<Carta> cartasJogador = j.getCartasIniciais();
		assertEquals("Testando tamanho do array de cartas iniciais", cartasJogador.size(), cartas.size());
		for(int i=0; i<cartas.size(); i++) {
			assertEquals("Testando set e get cartas iniciais jogador", cartas.get(i), cartasJogador.get(i));
		}
	}
	
	@Test
	public void testeSetGetPos() {
		Jogador j = Helpers.jogadorGenericoHelper();
		Posicao pos = new Posicao(3, 10);
		j.setPos(pos);
		assertEquals("Testando setPos e getPos jogador", j.getPos(), pos);
	}
	
	@Test
	public void testeGetPersonagem() {
		Jogador j = Helpers.jogadorGenericoHelper();
		Personagem p = Personagem.Scarlet;
		assertEquals("Testando getPersonagem jogador", j.getPersonagem(), p);
	}
	
	@Test
	public void testeSetGetPodeDarPalpite() {
		Jogador j = Helpers.jogadorGenericoHelper();
		j.setPodeDarPalpite(true);
		assertTrue("Testando setPodeDarPalpite e getPodeDarPalpite jogador", j.getPodeDarPalpite());
	}
	
	@Test
	public void testeSetGetErrouAcusacao() {
		Jogador j = Helpers.jogadorGenericoHelper();
		j.setErrouAcusacao(true);
		assertTrue("Testando setErrouAcusacao e getErrouAcusacao jogador", j.getErrouAcusacao());
	}
	
	@Test
	public void testeTemCarta() {
		Jogador j = Helpers.jogadorGenericoHelper();
		List<Carta> c = Helpers.cartasGenericasHelper();
		j.setCartasIniciais(c);
		assertNotNull("Testando temCarta jogador", j.temCarta(c));
	}
	
	@Test
	public void testeSetGetRolouDado() {
		Jogador j = Helpers.jogadorGenericoHelper();
		j.setRolouDado(true);
		assertTrue("Testando set e getRolouDado jogador", j.getRolouDado());
	}
	
	@Test
	public void testeToString() {
		Jogador j = Helpers.jogadorGenericoHelper();
		List<Carta> c = Helpers.cartasGenericasHelper();
		j.setCartasIniciais(c);
		j.addCartasVista(new CartaArma("Cano"));
		String esperado = "Scarlet,(9,26),false,false,true,false,Corda_Cozinha_Coronel Mustarda_,Corda_Cozinha_Coronel Mustarda_Cano_";
		assertEquals("Testando toString jogador", j.toString(), esperado);
	}
}
