package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Controller.Observer;
import Util.Events;
import Util.ObserverCallback;

class Board extends JpgImage implements MouseListener {

	
	int side = 24;
	int sideB = 672;
	static Board board = null;
	boolean canWalk = false;
	
	static Board newBoard(){
		if(board==null)
			board = new Board();
		return board;
	}
	
	
	private Board() {
		images.add(readFile("Tabuleiros/Tabuleiro-Clue-A"));
		addMouseListener(this);
		this.setSize(sideB, sideB);
		Observer.getObserver().susbcribe(Events.statusDice, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				Boolean status = (Boolean) o;
				canWalk = !status;
			}
		});
	}

	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(images.get(0), 0, 0,sideB,696, null); // printa tabuleiro como requerido
		
		drawPlayersAt(g2D, Player.players); // printa quadrado dos players

		for (int i = 0; i < sideB; i += side) { // printa grid
			for (int j = 0; j < sideB; j += side) {
				g2D.setPaint(Color.BLUE);
				g2D.setStroke(new BasicStroke(1));
				g2D.setColor(Color.BLUE);
				g2D.drawRect(i, j, side, side);
			}
		}

	}

	private void drawPlayersAt(Graphics2D g2D, HashMap<String, Player> players) { // printa players no tabuleiro
		for (Player p : players.values()) {
			g2D.setPaint(p.c);
			g2D.fillRect(side * p.getY(), side * p.getX(), side, side);
			g2D.setStroke(new BasicStroke(5)); // marcador para que a White n fique tao branca com o tabuleiro
			g2D.setColor(Color.YELLOW);
			g2D.drawRect(side * p.getY(), side * p.getX(), side, side);
		}
	}

	void movePlayerTo(String player, int x, int y) { // move player e re-printa
		Player.setPlayerTo(player, x, y);
		repaint();
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		Integer [] positions = new Integer[] { e.getX()/side , e.getY()/side};
		SideBar.clearError();
		if(canWalk)
			Observer.getObserver().callEvent(Events.boardClick,positions);
	}




}
