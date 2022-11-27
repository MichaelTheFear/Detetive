package Model;

import static org.junit.Assert.*;
import Util.Comodos;

import org.junit.Test;

public class TesteComodo {

	@Test
	public void testeConstrutor() {
		Posicao p = new Comodo(10,10,Comodos.Cozinha);
		assertNotNull("Testando construtor de Comodo",p);
	}
	
	@Test
	public void testeGetNome() {
		Comodo p = new Comodo(10,10,Comodos.Cozinha);
		assertEquals("Testando getNome",p.getComodo(),"Cozinha");
	}

}
