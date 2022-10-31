package View;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import View.Window.Canvas;

public class Game extends JFrame{
	Board board;
	SideBar sideBar;
	
	Game(){
		this.setLayout(new BorderLayout());
		this.add(board = new Board());
		this.add(sideBar = new SideBar("Green",board));
		this.pack();
		this.setSize(Canvas.SIZE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
	}

	void setActionProximo(ActionListener callback){ //para o controller
		sideBar.setActionProximo(callback);
	}
	
	void setActionPalpite(ActionListener callback){ //para o controller
		sideBar.setActionPalpite(callback);
	}
	
	void setActionMostrarCartas(ActionListener callback){ //para o controller
		sideBar.setActionMostrarCartas(callback);
	}
	
	void setActionNotas(ActionListener callback){ //para o controller
		sideBar.setActionNotas(callback);
	}
	
	void setActionAcusar(ActionListener callback){ //para o controller
		sideBar.setActionAcusar(callback);
	}
	
	void setActionRolarDados(ActionListener callback){ //para o controller
		sideBar.setActionRolarDados(callback);
	}
	
	void setActionUsarDados(ActionListener callback){ //para o controller
		sideBar.setActionUsarDados(callback);
	}
}
