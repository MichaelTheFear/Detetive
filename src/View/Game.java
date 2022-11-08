package View;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame {
	Board board = new Board();
	String playerName = "Scarlet";
	SideBar sideBar = new SideBar(playerName, board);

	Game() {
		this.setLayout(new BorderLayout());
		this.add(board);
		this.add(sideBar);
		this.pack();
		this.setSize(Canvas.SIZE);
		this.setVisible(false);
		this.setLocationRelativeTo(null);

	}

	void setPlayerName(String name) {
		this.playerName = name;
	}

	void setActionProximo(ActionListener callback) { // para o controller
		sideBar.setActionProximo(callback);
	}

	void setActionPalpite(ActionListener callback) { // para o controller
		sideBar.setActionPalpite(callback);
	}

	void setActionMostrarCartas(ActionListener callback) { // para o controller
		sideBar.setActionMostrarCartas(callback);
	}

	void setActionNotas(ActionListener callback) { // para o controller
		sideBar.setActionNotas(callback);
	}

	void setActionAcusar(ActionListener callback) { // para o controller
		sideBar.setActionAcusar(callback);
	}

	void setActionRolarDados(ActionListener callback) { // para o controller
		sideBar.setActionRolarDados(callback);
	}

	void setActionUsarDados(ActionListener callback) { // para o controller
		sideBar.setActionUsarDados(callback);
	}
	
	void setDices(int num) {
		sideBar.setDados(num);
	}

}
