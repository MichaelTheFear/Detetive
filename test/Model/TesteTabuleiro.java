package Model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TesteTabuleiro {
	
	@Test
	public void testeContrutorTabuleiro() {
		Tabuleiro t = new Tabuleiro(Helpers.posicoesArrayHelper());
		assertNotNull("Testando Construtor Tabuleiro",t);
	}
	

	

}
