package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	Text jogadas;

	SideBar(Board b) {
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
			}

		}, where, ratio * 2));
		this.add(palpite = new Button("Palpite",new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Guess();
			}
			
		} ,where, ratio * 3));
		this.add(acusar = new Button("Acusar", where, ratio * 4));
		txtVezJogador = new Text(" - ", where + 80, ratio * 5);
		this.add(txtVezJogador);
		this.add(rolarDados = new Button("Rolar dados", where, ratio * 6));
		this.add(usarDados = new Button("Usar esses dados", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Integer[] dices = new Integer[2];
				dices[0] = Integer.valueOf(dice1);
				dices[1] = Integer.valueOf(dice2);
				Observer.getObserver().callEvent(Events.dice, dices);
				
			}
			
		},where, ratio * 7));
		this.add(new Text("Dado1     Dado2", where, ratio * 8));
		jogadas = new Text("Jogadas Sobrando: ", 200, where, ratio * 10);
		this.add(jogadas);
		this.add(box2);
		this.add(box1);
		this.setBackground(Color.GRAY);
		this.setLayout(new BorderLayout());
		this.setBounds(where, where, 200, 700);
	}

	void setJogador(String jogador) {
		txtVezJogador.setStyle(jogador, Player.getColorOf(jogador));
	}
	
	void setJogadas(int numJogadas) {
		numJogadasSobrando = numJogadas;
		this.jogadas.setText("Jogadas Sobrando: "+numJogadasSobrando);
	}

	void setDados(int numJogadasSobrando) {
		this.numJogadasSobrando = numJogadasSobrando;
	}

	void setNumJogadasSobrando(int i) {
		numJogadasSobrando = i;
	}
	
	int getNumJogadasSobrando() {
		return this.numJogadasSobrando; 
	}

	void setActionProximo(ActionListener callback) { // para o controller
		prox.addActionListener(callback);
	}

	void setActionPalpite(ActionListener callback) { // para o controller
		palpite.addActionListener(callback);
	}

	void setActionMostrarCartas(ActionListener callback) { // para o controller
		mostraCartas.addActionListener(callback);
	}

	void setActionNotas(ActionListener callback) { // para o controller
		notas.addActionListener(callback);
	}

	void setActionAcusar(ActionListener callback) { // para o controller
		acusar.addActionListener(callback);
	}

	void setActionRolarDados(ActionListener callback) { // para o controller
		rolarDados.addActionListener(callback);
	}
	
	

}
