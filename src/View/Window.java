package View;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window{
	static Canvas canvas = new Canvas();
	
	
	
	static class Canvas extends JFrame{
		public static final int WIDTH = 1200;
		public static final int HEIGHT = 740;
		public static final Dimension SIZE = new Dimension(WIDTH,HEIGHT); 
		private static JPanel panelControl = new JPanel();
		private static CardLayout Layout = new CardLayout();
		private static SelectChar selectChar = new SelectChar();
		private static StartMenu startMenu = new StartMenu();
		private static Game board = new Game();
		
		Canvas(){
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			panelControl.setLayout(Layout);
			panelControl.add(startMenu,"Menu");
			panelControl.add(selectChar,"SelectChar");
			panelControl.add(board,"Board");
			Layout.show(panelControl, "Menu");
			this.add(panelControl);
			this.pack();
			this.setSize(Canvas.SIZE);
			this.setVisible(true);
			this.setLocationRelativeTo(null);
			this.setLayout(null);
		}
		
		static void addGameStartListner(ActionListener ac) {
			SelectChar.setGameStart(ac);
		}
		
		static void showPanel(String id){
			Layout.show(panelControl, id);
			canvas.repaint();
		}
		
		static void setActionProximo(ActionListener callback){
			board.setActionProximo(callback);
		}
		
		static void setActionPalpite(ActionListener callback){
			board.setActionPalpite(callback);
		}
		
		static void setActionMostrarCartas(ActionListener callback){
			board.setActionMostrarCartas(callback);
		}
		
		static void setActionNotas(ActionListener callback){
			board.setActionNotas(callback);
		}
		
		static void setActionAcusar(ActionListener callback){
			board.setActionAcusar(callback);
		}
		
		static void setActionRolarDados(ActionListener callback){
			board.setActionRolarDados(callback);
		}
		
		static void setActionUsarDados(ActionListener callback){
			board.setActionUsarDados(callback);
		}
		
	}
	
}
