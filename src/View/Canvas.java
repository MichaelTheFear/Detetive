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
	private static Game board;

	private Canvas() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add(startMenu);
		this.pack();
		this.setSize(Canvas.SIZE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
	}
	
	public static void init() {
		canvas = new Canvas();
	}

	public static ArrayList<Personagem> addGameStartListner(FunctionClass functionClass) { // para o controller
		return SelectChar.setGameStart(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				functionClass.callback();
			}
		});
	}

	static void showPanel(String id) {
		if (id == "SelectChar") {
			canvas.dispose();
			selectChar = new SelectChar();
		} else {
			selectChar.dispose();
			board = new Game();
		}
		canvas.repaint();
	}
	
	
	

	public static void setActionProximo(ActionListener callback) { // para o controller
		board.setActionProximo(callback);
	}

	public static void setActionPalpite(ActionListener callback) {
		board.setActionPalpite(callback);// para o controller
	}

	public static void setActionMostrarCartas(ActionListener callback) { // para o controller
		board.setActionMostrarCartas(callback);
	}

	public static void setActionNotas(ActionListener callback) { // para o controller
		board.setActionNotas(callback);
	}

	public static void setActionAcusar(ActionListener callback) { // para o controller
		board.setActionAcusar(callback);
	}

	public static void setActionRolarDados(ActionListener callback) { // para o controller
		board.setActionRolarDados(callback);
	}

	public static void setActionUsarDados(ActionListener callback) { // para o controller
		board.setActionUsarDados(callback);
	}

}
