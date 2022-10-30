package View;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Game extends JPanel{
	Board board;
	SideBar sideBar;
	
	Game(){
		this.setLayout(new BorderLayout());
		this.add(board = new Board());
		this.add(sideBar = new SideBar("Green",board));
	}

	void setActionProximo(ActionListener callback){
		sideBar.setActionProximo(callback);
	}
	
	void setActionPalpite(ActionListener callback){
		sideBar.setActionPalpite(callback);
	}
	
	void setActionMostrarCartas(ActionListener callback){
		sideBar.setActionMostrarCartas(callback);
	}
	
	void setActionNotas(ActionListener callback){
		sideBar.setActionNotas(callback);
	}
	
	void setActionAcusar(ActionListener callback){
		sideBar.setActionAcusar(callback);
	}
	
	void setActionRolarDados(ActionListener callback){
		sideBar.setActionRolarDados(callback);
	}
	
	void setActionUsarDados(ActionListener callback){
		sideBar.setActionUsarDados(callback);
	}
}
