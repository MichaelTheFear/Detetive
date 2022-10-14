package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteComodo {

	@Test
	public void testeConstrutor() {
		Posicao p = new Comodo("Cozinha");
		assertNotNull("Testando construtor de Comodo",p);
	}
	
	@Test
	public void testeGetNome() {
		Posicao p = new Comodo("Cozinha");
		assertEquals("Testando getNome",p.getComodo(),"Cozinha")e 
	}

}
