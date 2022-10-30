package Model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TesteJogo {

	@Test
	public void testeConstrutor() {
		Jogo j = new Jogo();
		assertNotNull("Testando Jogador Null",j);
	}
	
	@Test
	public void testeAcusar() {
		Jogo j = new Jogo();
		ArrayList<Carta> cartas = Helpers.cartasGenericasHelper();
		j.setCartasAssasino((Carta[]) cartas.toArray());
		assertTrue("testando acusação" ,j.acusar((Carta[]) cartas.toArray()));
	}
	

}
