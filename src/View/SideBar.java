package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

import Controller.Observer;

import java.io.File;
import Util.Events;
import Util.ObserverCallback;

public class SideBar extends JPanel {

	private static SideBar sideBar = null;
	private Observer obs = Observer.getObserver();
	int where = 700;
	int ratio = 50;
	String strDice1 = "1";
	String strDice2 = "1";
	ComboBox box1;
	ComboBox box2;
	Button prox; //disable
	Button mostraCartas; 
	Button notas; 
	Button palpite; //disable
	Button acusar;
	Button rolarDados;  //disable
	Button usarDados; //disable
	String jogador;
	int numJogadasSobrando = 10;
	Text txtVezJogador;
	Text jogadas;
	static ErrorNotification error;
	Dices dicesImages;

	public static SideBar newSideBar() {
		if (sideBar == null)
			sideBar = new SideBar();
		return sideBar;
	}
	
	private void changeButtonStates() {
		
		obs.susbcribe(Events.statusNext, new ObserverCallback () {
			@Override
			public void onCall(Object o) {
				Boolean status = (Boolean) o;
				prox.setEnabled(status);
			}
		});
		
		obs.susbcribe(Events.statusGuess, new ObserverCallback () {
			@Override
			public void onCall(Object o) {
				Boolean status = (Boolean) o;
				System.out.println("Status" + status);
				palpite.setEnabled(status);
			}
		});
		
		obs.susbcribe(Events.statusDice, new ObserverCallback () {
			@Override
			public void onCall(Object o) { 
				Boolean status = (Boolean) o;
				usarDados.setEnabled(status);
				rolarDados.setEnabled(status);
			}
		});
		
	}

	private SideBar() {
		this.setLayout(new BorderLayout()); 
		String[] options = { "1", "2", "3", "4", "5", "6" };
		this.add(prox = new Button("Proximo", where, 0));
		this.add(mostraCartas = new Button("Mostra Cartas", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				obs.callEvent(Events.showCards, jogador);
			}

		}, where, ratio));
		this.add(notas = new Button("Notas", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				obs.callEvent(Events.showNotes, jogador);
			}

		}, where, ratio * 2));
		this.add(palpite = new Button("Palpite", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				obs.callEvent(Events.showGuess, null);
			}

		}, where, ratio * 3));
		this.add(acusar = new Button("Acusar", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				obs.callEvent(Events.showAccuse, null);
			}
		}, where, ratio * 4));
		this.add(txtVezJogador = new Text(" - ", where + 80, ratio * 5));
		this.add(rolarDados = new Button("Rolar dados", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				obs.callEvent(Events.dice, null);
			}

		}, where, ratio * 6));
		this.add(usarDados = new Button("Usar esses dados", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer[] dices = new Integer[2];
				dices[0] = Integer.valueOf(strDice1);
				dices[1] = Integer.valueOf(strDice2);
				obs.callEvent(Events.dice, dices);
				setJogadas(dices[0] + dices[1]);
				dicesImages.setDices(dices[0], dices[1]);
			}
		}, where, ratio * 7));
		this.add(new Text("Dado1     Dado2", 900, 60));
		this.add(error = new ErrorNotification());

		this.add(box1 = new ComboBox(options, 900, 100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				strDice1 = (String) box1.getSelectedItem();
			}
		}));
		this.add(box2 = new ComboBox(options, 950, 100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				strDice2 = (String) box2.getSelectedItem();
			}
		}));
		this.add(new Button("Salvar Jogo", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser filePicker = new JFileChooser();
				filePicker.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int i = filePicker.showSaveDialog(null);
				File selectedFile = filePicker.getSelectedFile();
				if (i == JFileChooser.APPROVE_OPTION) {
					obs.callEvent(Events.saveGame, selectedFile.getAbsolutePath());
				}
			}

		}, 900, 200));
		this.add(jogadas = new Text("Jogadas Sobrando: ", 200, 900, 150));
		this.changeButtonStates();
		this.add(dicesImages = new Dices());
		this.setBounds(where, where, 500, 700);
	}

	void setJogador(String jogador) {
		txtVezJogador.setStyle(jogador, Player.getColorOf(jogador));
	}

	void setJogadas(int numJogadas) {
		numJogadasSobrando = numJogadas;
		this.jogadas.setText("Jogadas Sobrando: " + numJogadasSobrando);
	}

	void setDados(int[] dados) {
		System.out.println("Chamou set dados");
		setJogadas(dados[0] + dados[1]);
		this.dicesImages.setDices(dados[0], dados[1]);
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

	void error(String errTxt) {
		error.error(errTxt);
	}

	void warning(String warTxt) {
		error.warning(warTxt);
	}

	static void clearError() {
		error.setOpaque(false);
		error.setText("");
	}

}
