package View;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import Util.Armas;
import Util.Comodos;
import Util.Personagem;

class CardsInGame extends JFrame {

	CardsInGame(List<String> cards) { 
		
		Armas arm[] = Armas.values();
		Comodos com[] = Comodos.values();
		Personagem sus[] = Personagem.values();
		List<String> armas = new ArrayList<>();
		List<String> comodos = new ArrayList<>();
		List<String> personagens = new ArrayList<>();
		for (Armas a: arm) {
			if(cards.contains(a.name()))
				armas.add(a.name());
		}
		for (Comodos c: com) {
			if(cards.contains(c.name()))
				comodos.add(c.name());
		}
		for (Personagem s: sus) {
			if(cards.contains(s.name()))
				personagens.add(s.name());
		}
	
		this.add(new Cards(armas, comodos, personagens));
		this.pack();
		this.setSize(Canvas.SIZE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
	}
}
