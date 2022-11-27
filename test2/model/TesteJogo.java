package Model;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import Util.Personagem;

import javax.swing.JFileChooser;

import org.junit.Test;

public class TesteJogo {

	@Test
	public void testeConstrutorDefault() {
		Jogo j = new Jogo();
		assertNotNull("Teste construtor default Jogador", j);
	}
	/*
	@Test
	public void testeConstrutorFile() throws FileNotFoundException {
		JFileChooser filePicker = new JFileChooser();
		filePicker.setFileSelectionMode(JFileChooser.FILES_ONLY);
		File f = filePicker.getSelectedFile();
		Jogo j = new Jogo(f);
		assertNotNull("Teste construtor default Jogador", j);
	}
*/
	/*
	@Test
	public void testeSetCartasAssassino() {
		Jogo j = new Jogo();
		j.setCartasAssasino();
		ArrayList<CartasEmJogo> = j.getCartasEmJogo();
	}
	*/
	
	@Test
	public void testeSetupJogadores() {
		Jogo j = new Jogo();
		ArrayList<Personagem> players = new ArrayList<Personagem>();
		players.add(Personagem.Green);
		players.add(Personagem.Scarlet);
		j.setupJogadores(players);
		assertEquals("Testando setupJogadores Jogo", j.qtdEmJogo, players.size());
	}
	
	@Test
	public void testeAcusar() {
		Jogo j = new Jogo();
		j.setCartasAssasino();
		String[] cartas = new String[3];
		for(int i=0; i<3; i++) {
			cartas[i] = j.cartasAssassino[i].getNome();
		}
		assertTrue("Testando acusar Jogo", j.acusar(cartas));
	}
	
}
