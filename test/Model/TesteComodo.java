package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteComodo {

	@Test
	public void testeConstrutor() {
		Posicao p = new Comodo(10,10,"Cozinha");
		assertNotNull("Testando construtor de Comodo",p);
	}
	
	@Test
	public void testeGetNome() {
		Comodo p = new Comodo(10,10,"Cozinha");
		assertEquals("Testando getNome",p.getComodo(),"Cozinha");
	}

}
