package View;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Window{
	static Canvas canvas = new Canvas();
	
	
	
	static class Canvas extends JFrame{
		public static final int WIDTH = 1200;
		public static final int HEIGHT = 740;
		public static final Dimension SIZE = new Dimension(WIDTH,HEIGHT); 
		private static SelectChar selectChar;
		private static StartMenu startMenu = new StartMenu();
		private static Game board;
		
		Canvas(){
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			this.add(startMenu);
			this.pack();
			this.setSize(Canvas.SIZE);
			this.setVisible(true);
			this.setLocationRelativeTo(null);
			this.setLayout(null);
		}
		
		static void addGameStartListner(ActionListener ac) { //para o controller
			SelectChar.setGameStart(ac);
		}
		
		static void showPanel(String id){
			if(id=="SelectChar") {
				canvas.dispose();
				selectChar = new SelectChar();
			} else {
				selectChar.dispose();
				board = new Game();
			}
			canvas.repaint();
		}
		
		static void setActionProximo(ActionListener callback){ //para o controller
			board.setActionProximo(callback);
		}
		
		static void setActionPalpite(ActionListener callback){
			board.setActionPalpite(callback);//para o controller
		}
		
		static void setActionMostrarCartas(ActionListener callback){ //para o controller
			board.setActionMostrarCartas(callback);
		}
		
		static void setActionNotas(ActionListener callback){ //para o controller
			board.setActionNotas(callback);
		}
		
		static void setActionAcusar(ActionListener callback){ //para o controller
			board.setActionAcusar(callback);
		}
		
		static void setActionRolarDados(ActionListener callback){ //para o controller
			board.setActionRolarDados(callback);
		}
		
		static void setActionUsarDados(ActionListener callback){ //para o controller
			board.setActionUsarDados(callback);
		}
		
	}
	
}
