package View;

import java.awt.Dimension;
import Controller.Middleware;
import Util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Canvas extends JFrame {
	static Canvas canvas;

	public static final int WIDTH = 1200;
	public static final int HEIGHT = 740;
	public static final Dimension SIZE = new Dimension(WIDTH, HEIGHT);
	private static SelectChar selectChar;
	private static StartMenu startMenu = new StartMenu();
	private static Game board = new Game();

	static {
		canvas = new Canvas();
	}

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

	public static ArrayList<Personagem> onGameStart(FunctionClass functionClass) { // para o controller
		return SelectChar.setGameStart(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Canvas.showPanel("Board");
				functionClass.callbackVoid();
			}
		});
	}

	static void showPanel(String id) {
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

	public static void setNamePlayingNow(String name) {
		board.setName(name);
	}

	public static void onProximoTurno() {
		// board.setActionProximo();
	}

	public static void onPalpite(FunctionClass functionClass) {
		board.setActionPalpite(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});
	}

	public static void setDados(int dados[]) {
		board.sideBar.setDados(dados[0] + dados[1]);
	}

	public static void onPalpiteConfirmed() {

	}

	public static void onMostrarCartas(ActionListener callback) {
		board.setActionMostrarCartas(callback);
	}

	public static void onMostrarNotas(ActionListener callback) {
		board.setActionNotas(callback);
	}

	public static void onAcusar(ActionListener callback) {
		board.setActionAcusar(callback);
	}

	public static void onRolarDados(ActionListener callback) {
		board.setActionRolarDados(callback);
	}

	public static void onUsarDados(ActionListener callback) {
		board.setActionUsarDados(callback);
	}

}
