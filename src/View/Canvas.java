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
	public static final int HEIGHT = 740;
	public static final Dimension SIZE = new Dimension(WIDTH, HEIGHT);
	private static SelectChar selectChar;
	private static StartMenu startMenu = new StartMenu();
	private static Game board = new Game();

	private Canvas() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.board.setVisible(false);
		this.add(startMenu);
		this.pack();
		this.setSize(Canvas.SIZE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
	}
	
	public static Canvas getCanvas() {
		if(canvas == null) {
			canvas = new Canvas();
		}
		return canvas;
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

	public ArrayList<Personagem> getPlayers(){
		return SelectChar.getSus();
	}
	
	void showPanel(String id) {
		if (id == "SelectChar") {
			canvas.dispose();
			selectChar = new SelectChar();
		} else {
			selectChar.dispose();
			board.setVisible(true);
			// board.sideBar.setVisible(true);
		}
		canvas.repaint();
	}

	public void setNamePlayingNow(String name) {
		board.setName(name);
	}

	public void onProximoTurno() {
		// board.setActionProximo();
	}

	public void onPalpite(ActionListener listener) {
		board.setActionPalpite(listener);
	}

	public void setDados(int dados[]) {
		board.sideBar.setDados(dados[0] + dados[1]);
	}

	public void onPalpiteConfirmed() {

	}

	public void onMostrarCartas(ActionListener callback) {
		board.setActionMostrarCartas(callback);
	}

	public void onMostrarNotas(ActionListener callback) {
		board.setActionNotas(callback);
	}

	public void onAcusar(ActionListener callback) {
		board.setActionAcusar(callback);
	}

	public void onRolarDados(ActionListener callback) {
		board.setActionRolarDados(callback);
	}

	public void onUsarDados(ActionListener callback) {
		board.setActionUsarDados(callback);
	}

}
