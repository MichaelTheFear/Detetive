package Model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestePosicao {

	@Test
	public void testeConstrutorPosicao() {
		Posicao p = new Posicao(10,10);
		assertNotNull("Testando Construtor Posicao ",p);
	}
	
	@Test
	public void testeSetGetMudadoNoTurno() {
		Posicao p = new Posicao(10,10);
		p.setMudadoNoTurno(0);
		assertTrue("Testando setGetMudadoNoTurno Posicao ",p.getMudadoNoTurno()==0);
	}
	
	@Test
	public void testeSetAddGetPosicoesProximas() {
		Posicao p = new Posicao(10,10);
		ArrayList<Posicao> ArrayPosSet = new ArrayList<Posicao>();
		ArrayPosSet.add(new Posicao(9,9));
		p.setPosicoesProximas(ArrayPosSet);
		ArrayList<Posicao> ArrayPosAdd = new ArrayList<Posicao>();
		ArrayPosAdd.add(new Posicao(8,8));
		p.addPosicoesProximas(ArrayPosAdd);
		ArrayPosSet.addAll(ArrayPosAdd);
		assertEquals("Testando tamanho dos arrays", p.getPosicoesProximas().size(), ArrayPosSet.size());
		for(int i=0; i<p.getPosicoesProximas().size(); i++) {
			assertEquals("Testando setAddGetPosicoesProximas", p.getPosicoesProximas().get(i),ArrayPosSet.get(i));
		}
	}
	
	@Test
	public void testeGetLinha() {
		Posicao p = new Porta(10,10);
		assertTrue("Testando getLinha Posicao ",p.getLinha()==10);
	}
	
	@Test
	public void testeGetColuna() {
		Posicao p = new Porta(10,10);
		assertTrue("Testando getColuna Posicao ",p.getColuna()==10);
	}
	
	@Test
	public void testeSetGetPassouAqui() {
		Posicao p = new Porta(10,10);
		p.setPassouAqui(true);
		assertTrue("Testando setGetJogadorAqui Posicao ",p.getPassouAqui());
	}

	@Test
	public void testeSetGetJogadorAqui() {
		Posicao p = new Porta(10,10);
		p.setJogadorAqui(true);
		assertTrue("Testando setGetJogadorAqui Posicao ",p.getJogadorAqui());
	}

	@Test
	public void testeToString() {
		Posicao p = new Porta(10,10);
		String esperado = "(10,10)";
		assertEquals("Testando toString Posicao ",p.toString(), esperado);
	}

	
	
}
