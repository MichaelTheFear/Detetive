package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteCartaSuspeito {

	@Test
	public void testeConstrutorCartaSuspeito() {
		Carta c = new CartaSuspeito("Srta. Scarlet");
		assertNotNull("Testando Carta Suspeito Null",c);
	}
	
	@Test
	public void testeGetCartaSuspeito() {
		Carta c = new CartaSuspeito("Coronel Mustarda");
		assertEquals("Testando Get Nome de Carta Suspeito","Coronel Mustarda",c.getNome());
	}

}
