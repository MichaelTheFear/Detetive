package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteQuadrado {

	@Test
	public void testeConstrutorQuadrado() {
		Posicao q1 = new Quadrado(10,10,"Biblioteca");
		Posicao q2 = new Quadrado(10,10);
		assertNotNull("Testando construtor com porta",q1);
		assertNotNull("Testando construtor sem porta",q2);
	}
	
	@Test
	public void testeGetPorta() {
		Posicao q1 = new Quadrado(10,10,"Biblioteca");
		Posicao q2 = new Quadrado(10,10);	
		assertEquals("Testando get Porta sendo porta",q1.getPorta(),"Biblioteca");
		assertTrue("Testando get Porta sem ser porta",q2.getPorta()=="nenhum");
	}

}
