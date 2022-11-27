package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteCartaArma {

	@Test
	public void testeConstrutorCartaArma() {
		Carta c = new CartaArma("Corda");
		assertNotNull("Testando Carta Arma Null",c);
	}
	
	@Test
	public void testeGetCartaArma() {
		Carta c = new CartaArma("Revolver");
		assertEquals("Testando Get Nome de Carta Arma","Revolver",c.getNome());
	}

}
