package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteCoordenadas {

	@Test
	public void testeConstrutor() {
		Coordenadas c = new Coordenadas(10,10);
		assertNotNull("Testando construtor coordenadas",c);
	}
	
	@Test
	public void testeGetSetJogadorAqui() {
		Coordenadas c = new Coordenadas(10,10);
		c.setJogadorAqui(false);
		assertTrue("Testando get set jogadorAqui",!c.getJogadorAqui());
	}

	@Test
	public void testeGetSetPassouAqui() {
		Coordenadas c = new Coordenadas(10,10);
		c.setPassouAqui(false);
		assertTrue("Testando get set jogadorAqui",!c.getPassouAqui());
	}
}
