package Model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Util.Personagem;

public class TesteJogador {
	
	Jogador j = null;
	
	@Before
	public void newJogador() {
		j = new Jogador(Personagem.Green, false, Helpers.tabHelper());
	}
	
	
	@Test
	public void testeConstrutor() {
	
		assertNotNull("Testando construtor jogador", j);
	}
	
	@Test
	public void testeEhNpc() {

		assertTrue("Testando ehNpc jogador", !j.ehNpc());
	}
	
	@Test
	public void testeSetEstaJogando() {

		
		j.setJogando(true);
		assertTrue("Testando setJogando e estaJogando jogador", j.estaJogando());
	}
	
	@Test
	public void testeSetGetCartasIniciais() {

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

		Posicao pos = new Posicao(3, 10);
		j.setPos(pos);
		assertEquals("Testando setPos e getPos jogador", j.getPos(), pos);
	}
	
	@Test
	public void testeGetPersonagem() {

		Personagem p = Personagem.Green;
		assertEquals("Testando getPersonagem jogador", j.getPersonagem(), p);
	}
	
	@Test
	public void testeSetGetPodeDarPalpite() {

		j.setPodeDarPalpite(true);
		assertTrue("Testando setPodeDarPalpite e getPodeDarPalpite jogador", j.getPodeDarPalpite());
	}
	
	@Test
	public void testeSetGetErrouAcusacao() {

		j.setErrouAcusacao(true);
		assertTrue("Testando setErrouAcusacao e getErrouAcusacao jogador", j.getErrouAcusacao());
	}
	
	@Test
	public void testeTemCarta() {

		List<Carta> c = Helpers.cartasGenericasHelper();
		j.setCartasIniciais(c);
		assertNotNull("Testando temCarta jogador", j.temCarta(c));
	}
	
	@Test
	public void testeSetGetRolouDado() {

		j.setRolouDado(true);
		assertTrue("Testando set e getRolouDado jogador", j.getRolouDado());
	}
	
	@Test
	public void testeToString() {

		List<Carta> c = Helpers.cartasGenericasHelper();
		j.setCartasIniciais(c);
		j.addCartasVista(new CartaArma("Cano"));
		String esperado = "Scarlet,(9,26),false,false,true,false,Corda_Cozinha_Coronel Mustarda_,Corda_Cozinha_Coronel Mustarda_Cano_";
		assertEquals("Testando toString jogador", j.toString(), esperado);
	}
}
