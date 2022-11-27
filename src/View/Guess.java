package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;

import Controller.Observer;
import Util.Armas;
import Util.Comodos;
import Util.Events;
import Util.Personagem;

class Guess extends JFrame {

	private static Guess guess = null;

	ArrayList<CheckBox> sus = new ArrayList<>();
	ArrayList<CheckBox> weapons = new ArrayList<>();
	ArrayList<CheckBox> places = new ArrayList<>();

	String per = null;
	String arma = null;

	int x = 50;

	private int indexOf(String s, ArrayList<CheckBox> ar) {
		for (int i = 0; i < ar.size(); i++) {
			if (ar.get(i).getText() == s)
				return i;
		}
		return -1;
	}

	static public Guess newGuess(String comodo) {
		if (guess == null)
			guess = new Guess(comodo);
		return guess;
	}

	private Guess(String comodo) {

		Personagem personagens[] = Personagem.values();
		Armas armas[] = Armas.values();
		Comodos comodos[] = Comodos.values();

		for (int i = 0; i < personagens.length; i++) {
			CheckBox b = new CheckBox(personagens[i], 0, i * x);
			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (per != null) {
						sus.get(indexOf(per, sus)).setSelected(false);
					}
					per = b.getText();
				}
			});
			sus.add(b);
			this.add(b);
		}

		for (int i = 0; i < armas.length; i++) {
			CheckBox b = new CheckBox(armas[i], 300, i * x);
			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (arma != null) {
						weapons.get(indexOf(arma, weapons)).setSelected(false);
					}
					arma = b.getText();
				}
			});
			weapons.add(b);
			this.add(b);
		}

		this.add(new CheckBox(comodo, 600, true));
		
		this.add(new Button("Confirmar", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (per != null && arma != null) {
					Observer.getObserver().callEvent(Events.confirmGuess, new String[] { per, arma, comodo });
					guess = null;
					// guess.dispose();
				}
			}
		}, 1000, 600));

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				guess.dispose();
				guess = null;
			}
		});
		this.setLayout(new BorderLayout());
		this.pack();
		this.setSize(Canvas.SIZE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}
