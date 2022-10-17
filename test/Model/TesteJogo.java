package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteJogo {

	@Test
	public void testeRolaDado() {
		assertTrue("Testando rolar dado",Jogo.NUM_MAX_DADO >= Jogo.rolarDado());
	}
	
	
	

}
