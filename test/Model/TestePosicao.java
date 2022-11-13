package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestePosicao {

	@Test
	public void testeConstrutorPosicao() {
		Posicao p = new Porta(10,10);
		assertNotNull("Testando Construtor Posicao ",p);
	}
	

	
	
}
