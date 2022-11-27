package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteCartaLocal {

	@Test
	public void testeConstrutorCartaLocal() {
		Carta c = new CartaLocal("Cozinha");
		assertNotNull("Testando Carta Local Null",c);
	}
	
	@Test
	public void testeGetCartaLocal() {
		Carta c = new CartaLocal("Biblioteca");
		assertEquals("Testando Get Nome de Carta Local","Biblioteca",c.getNome());
	}
}
