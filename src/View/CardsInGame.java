package View;

import javax.swing.JFrame;

import Util.Armas;
import Util.Comodos;
import Util.Personagem;

public class CardsInGame extends JFrame {

	CardsInGame() { // ps ngm nunca vai ter essa quantidade de cartas, ent o tamanho esta certo
		Armas arm[] = Armas.values();
		Comodos com[] = Comodos.values();
		Personagem sus[] = Personagem.values();
		String armas[] = new String[arm.length];
		String comodos[] = new String[com.length];
		String personagem[] = new String[sus.length];
		for (int i = 0; i < armas.length; i++) {
			armas[i] = arm[i].name();
		}
		for (int i = 0; i < com.length; i++) {
			comodos[i] = com[i].name();
		}
		for (int i = 0; i < personagem.length; i++) {
			personagem[i] = sus[i].name();
		}
		this.add(new Cards(armas, comodos, personagem));
		this.pack();
		this.setSize(Canvas.SIZE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
	}
}
