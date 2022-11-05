package Model;

import java.util.ArrayList;

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

	public void rolarDados() {
		jogo.rolarDado();
	}

	public int[] getDados() {
		return jogo.getDados();
	}

	public void setupJogadores(ArrayList<String> players) {
		jogo.setupJogadores(players);
	}
}
