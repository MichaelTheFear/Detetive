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

	public static ArrayList<Personagem> onGameStart(FunctionClass functionClass) { // para o controller
		return SelectChar.setGameStart(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
			board = new Game();
		}
		canvas.repaint();
	}
	

	public static void onProximoTurno(FunctionClass functionClass) { 
		board.setActionProximo(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				board.setName(functionClass.callbackString());
			}
			
		});
	}

	public static void onPalpite(FunctionClass functionClass) {
		board.setActionPalpite(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
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
