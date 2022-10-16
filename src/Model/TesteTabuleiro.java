package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteTabuleiro {
	
	//Mudou
	private Posicao[] posicoesArrayHelper() {
		Posicao pos[] = new Posicao[Tabuleiro.size];
		for(int i = 0, j = 0,k =0;i<Tabuleiro.size;k++) {
			pos[k] = new Posicao(i,j);
			if(i%2==0) {
				i++;
			}else {
				j++;
			}
		}
	}
	
	//Mudou
	@Test
	public void testeContrutorTabuleiro() {
		Tabuleiro t = new Tabuleiro(posicoesArrayHelper());
		assertNotNull("Testando Construtor Tabuleiro",t);
	}
	
	public void testeAchaCaminhos() {
		Tabuleiro t = new Tabuleiro(posicoesArrayHelper());
		Posicao p[] = new Posicao[10];
		
		
	}

}
