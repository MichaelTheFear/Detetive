package View;

import java.awt.Dimension;
import Controller.Middleware;
import Util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Canvas extends JFrame {
	private static Canvas canvas = null;

	public static final int WIDTH = 1200;
	public static final int HEIGHT = 700;
	public static final Dimension SIZE = new Dimension(WIDTH, HEIGHT);
	private static SelectChar selectChar = null;
	private static StartMenu startMenu = new StartMenu();
	private static Game board = new Game();
	private String[] looksAndFeels = new String[] { "javax.swing.plaf.nimbus.NimbusLookAndFeel\r\n",
			"com.sun.java.swing.plaf.motif.MotifLookAndFeel\r\n",
			"com.sun.java.swing.plaf.windows.WindowsLookAndFeel\r\n",
			"com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel" };
	
	private int lookIndex = 0;

	private void loadLook() {
		try {
			if(lookIndex != -1)
				UIManager.setLookAndFeel(looksAndFeels[lookIndex]);
			else
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			lookIndex++;
			loadLook();
		} catch (ClassNotFoundException e) {
			lookIndex++;
			loadLook(); 
		} catch (IndexOutOfBoundsException e) {
			lookIndex = -1;
			loadLook();
		}catch (Exception e) {
			lookIndex++;
			loadLook();
		}
	}

	private Canvas() {
		loadLook();
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
		} else {
			if (selectChar != null)
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

	public void showCards(List<String> cards) {
		new CardsInGame(cards);
	}

	public void showNotes(List<String> cards) {
		new Notes(cards);
		System.out.println("Hmmm");
	}

	public void setDados(int[] dados) {
		System.out.println("Chamou canvas");
		board.setDices(dados);
	}

	public void showGuess(String comodo) {
		Guess.newGuess(comodo);
	}

	public void showAccuse(List<String> cartas) {
		Accuse.newAccuse(cartas);
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
