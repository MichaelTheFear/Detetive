package Model;

import java.util.ArrayList;
import Util.Personagem;

public class JogoFacade {
	private static JogoFacade facade = null;
	private Jogo jogo = new Jogo();

	private JogoFacade() {
	}

	public static JogoFacade getJogoFacade() {
		if (facade == null) {
			facade = new JogoFacade();
		}
		return facade;
	}
	
	public void setupJogadores(ArrayList<Personagem> players) {
		jogo.setupJogadores(players);
		
		System.out.println("Personagens em Jogo:");
		for(Jogador j : jogo.jogadores) {
			if(!j.ehNpc()) {
				System.out.println(j.getPersonagem().name());
			}
		}
	}
	
	public void distribuiCartas() {
		jogo.distribuiCartas();
	}

	public void rolarDados() {
		jogo.rolarDado();
	}

	public int[] getDados() {
		return jogo.getDados();
	} 
	
	public void passaVez() {
		jogo.passaVez();
	}
	
	public Personagem getJogadorVez() {
		return jogo.jogadores.get(jogo.vezDe).getPersonagem();
	}
}
