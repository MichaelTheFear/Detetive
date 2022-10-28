package View;

import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window{
	static Canvas canvas = new Canvas();
	
	public static class Canvas extends JFrame{
		public static final int WIDTH = 1200;
		public static final int HEIGHT = 740;
		public static final Dimension SIZE = new Dimension(WIDTH,HEIGHT); 
		private static JPanel panelControl = new JPanel();
		private static CardLayout Layout = new CardLayout();
		
		Canvas(){
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			panelControl.setLayout(Layout);
			panelControl.add(new StartMenu(),"Meu");
			panelControl.add(new SelectChar(),"SelectChar");
			panelControl.add(new Game(),"Board");
			Layout.show(panelControl, "Menu");
			this.add(panelControl);
			//this.add(new StartMenu());
			//this.add(new Cards("Suspeitos",new String[] {"Green","Mustard","Peacock","Plum","Scarlet","White"}));
			//this.add(b);
			//this.add(new SideBar("Scarlet",b));
			this.pack();
			this.setSize(Canvas.SIZE);
			this.setVisible(true);
			this.setLocationRelativeTo(null);
			this.setLayout(null);
		}
		
		static void showPanel(String id){
			Layout.show(panelControl, id);
			canvas.repaint();
		}
	}
	
}
