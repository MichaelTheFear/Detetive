package View;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class Game extends JPanel{
	Board board = new Board();
	
	Game(){
		this.setLayout(new BorderLayout());
		this.add(board);
		this.add(new SideBar("Scarlet",board));
	}
}
