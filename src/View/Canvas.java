package View;

import java.awt.Dimension;
import Controller.Middleware;
import Util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Canvas extends JFrame {
	private static Canvas canvas = null;

	public static final int WIDTH = 1200;
	public static final int HEIGHT = 700;
	public static final Dimension SIZE = new Dimension(WIDTH, HEIGHT);
	private static SelectChar selectChar = null;
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

	public void showPanel(String id) {
		if (id == "SelectChar") {
			canvas.dispose();
			selectChar = new SelectChar();
		}
		else {
			if(selectChar!=null) 
				selectChar.dispose();
			else 
				canvas.dispose();
			
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

	public void showCards(List<String> cards) {
		new CardsInGame(cards);
	}

	public void showNotes(List<String> cards) {
		new Notes(cards);
		System.out.println("Hmmm");
	}

	public void setDados(int[] dados) {
		board.setDices(dados[0] + dados[1]);
	}
	
	public void showGuess() {
		new Guess();
	}
	
	public void showAccuse(List<String> cartas) {
		new Accuse(cartas);
	}
	
	public void setJogadasSobrando(int i) {
		board.setJogdadasSobrando(i);
	}
	
	public int getJogadasSobrando() {
		return board.getJogadasSobrando();
	}
	
	public void showError(String err) {
		board.error(err);
	}
	
	public void showWarning(String err) {
		board.warning(err);
	}

}
