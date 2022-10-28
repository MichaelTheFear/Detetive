package View;

import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window extends JFrame {
	
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 700;
	public static final Dimension SIZE = new Dimension(WIDTH,HEIGHT); 
	private static JPanel panelControl = new JPanel();
	private static CardLayout Layout = new CardLayout();
	private static Window window;
	
	Window(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelControl.setLayout(Layout);
		panelControl.add(new StartMenu(),"Meu");
		panelControl.add(new SelectChar(),"SelectChar");
		panelControl.add(new Board(),"Board");
		Layout.show(panelControl, "Menu");
		this.add(new Button("Prox pagina", e-> showPanel("Board"),1000,100));
		this.add(panelControl);
		//this.add(new StartMenu());
		//this.add(new Cards("Suspeitos",new String[] {"Green","Mustard","Peacock","Plum","Scarlet","White"}));
		//this.add(b);
		//this.add(new SideBar("Scarlet",b));
		this.pack();
		this.setSize(Window.SIZE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
	}
	
	void showPanel(String id){
		Layout.show(panelControl, id);
		repaint();
	}
	
	
	
	
}
