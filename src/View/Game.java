package View;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Game extends JFrame {
	Board board = new Board();
	String playerName = "-";
	SideBar sideBar = new SideBar(board);

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
		sideBar.setJogador(this.playerName);
	}
	
	void movePlayerTo(String player, int x, int y) {
		board.movePlayerTo(player, x, y);
	}
	
	void moveCurrentPlayerTo(int x, int y) {
		board.movePlayerTo(playerName, x, y);
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

	void setDices(int num) {
		sideBar.setDados(num);
	}
	
	int getJogadasSobrando() {
		return sideBar.getNumJogadasSobrando();
	}
	
	void setJogdadasSobrando(int jogadasSobrando) {
		sideBar.setNumJogadasSobrando(jogadasSobrando);
	}
	
	void error(String e) {
		sideBar.error(e);
	}
	
	void warning(String e) {
		sideBar.warning(e);
	}

}
