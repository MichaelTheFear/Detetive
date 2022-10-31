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
		Carta cartasArr[] = new Carta[3];
		for(int i = 0;i<cartas.size();i++) {
			cartasArr[i] = cartas.get(i);
		}
		j.setCartasAssasino(cartasArr);
		assertTrue("testando acusação" ,j.acusar(cartasArr));
	}
	

}
