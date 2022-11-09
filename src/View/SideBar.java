package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Util.Events;

public class SideBar extends JPanel {

	int where = 700;
	int ratio = 50;
	String dice1 = "3";
	String dice2 = "3";
	ComboBox box1;
	ComboBox box2;
	Button prox;
	Button mostraCartas;
	Button notas;
	Button palpite;
	Button acusar;
	Button rolarDados;
	Button usarDados;
	String jogador;
	int numJogadasSobrando = 10;
	Text txtVezJogador;

	SideBar(String jogador, Board b) {
		String[] options = { "1", "2", "3", "4", "5", "6" };
		box1 = new ComboBox(options, where, ratio * 9, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dice1 = (String) box1.getSelectedItem();
			}
		});
		box2 = new ComboBox(options, where + 50, ratio * 9, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dice2 = (String) box2.getSelectedItem();
			}
		});
		this.add(prox = new Button("Proximo", where, 0));
		this.add(mostraCartas = new Button("Mostra Cartas", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Observer.getObserver().callEvent(Events.showCards, jogador);

			}

		}, where, ratio));
		this.add(notas = new Button("Notas", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Observer.getObserver().callEvent(Events.showNotes, jogador);
				//new Notes(new ArrayList<String>(Arrays.asList("Scarlet","Cordas")));
			}

		}, where, ratio * 2));
		this.setLayout(new BorderLayout());
		this.add(palpite = new Button("Palpite", where, ratio * 3));
		this.add(acusar = new Button("Acusar", where, ratio * 4));
		txtVezJogador = new Text(jogador, where + 80, ratio * 5, Player.getColorOf(jogador));
		this.add(txtVezJogador);
		this.add(rolarDados = new Button("Rolar dados", where, ratio * 6));
		this.add(usarDados = new Button("Usar esses dados", where, ratio * 7));
		this.add(new Text("Dado1     Dado2", where, ratio * 8));
		this.add(box2);
		this.add(box1);
		this.add(new Text("Jogadas Sobrando: " + numJogadasSobrando, 200, where, ratio * 10));
		this.setBounds(where, where, 200, 700);
	}

	void setJogador(String jogador) {
		this.jogador = jogador;
		this.remove(txtVezJogador);
		txtVezJogador = new Text(jogador, where + 80, ratio * 5, Player.getColorOf(jogador));
		this.add(txtVezJogador);
		repaint();
	}

	void setDados(int numJogadasSobrando) {
		this.numJogadasSobrando = numJogadasSobrando;
		//this.remove(txtJogadasSobrando);
		//this.add(new Text("Jogadas Sobrando: " + numJogadasSobrando, 200, where, ratio * 10));
		repaint();
	}

	void setNumJogadasSobrando(int i) {
		numJogadasSobrando = i;
	}

	void setActionProximo(ActionListener callback) { // para o controller
		prox.addActionListener(callback);
	}

	void setActionPalpite(ActionListener callback) { // para o controller
		prox.addActionListener(callback);
	}

	void setActionMostrarCartas(ActionListener callback) { // para o controller
		prox.addActionListener(callback);
	}

	void setActionNotas(ActionListener callback) { // para o controller
		prox.addActionListener(callback);
	}

	void setActionAcusar(ActionListener callback) { // para o controller
		prox.addActionListener(callback);
	}

	void setActionRolarDados(ActionListener callback) { // para o controller
		prox.addActionListener(callback);
	}

	void setActionUsarDados(ActionListener callback) { // para o controller
		prox.addActionListener(callback);
	}


}
