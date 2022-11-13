package View;

import java.awt.Dimension;
import Controller.Middleware;
import Util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Canvas extends JFrame {
	private static Canvas canvas = null;

	public static final int WIDTH = 1200;
	public static final int HEIGHT = 700;
	public static final Dimension SIZE = new Dimension(WIDTH, HEIGHT);
	private static SelectChar selectChar;
	private static StartMenu startMenu = new StartMenu();
	private static Game board = new Game();

	private Canvas() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(startMenu);
		this.pack();
		this.setSize(Canvas.SIZE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
	}

	public static Canvas getCanvas() {
		if (canvas == null) {
			canvas = new Canvas();
		}
		return canvas;
	}
	
	public void movePlayerTo(String player, int x, int y) {
		board.movePlayerTo(player, x, y);
	}
	
	public void moveCurrentPlayerTo(int x, int y) {
		board.moveCurrentPlayerTo(x, y);
	}

	public void onGameStart(ActionListener listener) { // para o controller
		SelectChar.setGameStart(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.actionPerformed(e);
				canvas.showPanel("Board");
			}
		});
	}

	public ArrayList<Personagem> getPlayers() {
		return SelectChar.getSus();
	}

	public void setPlayerName(Personagem playerName) {
		board.setPlayerName(playerName.toString());
	}

	void showPanel(String id) {
		if (id == "SelectChar") {
			canvas.dispose();
			selectChar = new SelectChar();
		}
		else {
			selectChar.dispose();
			board.setVisible(true);
		}
		canvas.repaint();
	}

	public void setNamePlayingNow(String name) {
		board.setPlayerName(name);
		System.out.println("Passando Turno para:");
		System.out.println(name);
	}

	public void onProximoTurno(ActionListener listener) {
		board.setActionProximo(listener);
	}

	public void onPalpite(ActionListener listener) {
		board.setActionPalpite(listener);
	}

	public void onAcusar(ActionListener listener) {
		board.setActionAcusar(listener);
	}

	public void onPalpiteConfirmed(ActionListener listener) {

	}

	public void showCards(ArrayList<String> cards) {
		new CardsInGame(cards);
	}

	public void showNotes(ArrayList<String> cards) {
		new Notes(cards);
	}

	public void setDados(int[] dados) {
		board.setDices(dados[0] + dados[1]);
	}
	
	public void showGuess() {
		new Guess();
	}
	
	public void showAccuse() {
		
	}

}
