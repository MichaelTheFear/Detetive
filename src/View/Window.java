package View;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends JFrame {
	
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 700;
	public static final Dimension SIZE = new Dimension(WIDTH,HEIGHT);
	public static String print = "A";
	
	
	Window(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Board b =new Board();
		JLabel printL = new JLabel(print);
		printL.setBounds(900, 50, 100, 100);
		//this.add(new SelectChar());
		//this.add(new StartMenu());
		//this.add(new Cards("Suspeitos",new String[] {"Green","Mustard","Peacock","Plum","Scarlet","White"}));
		this.add(printL);
		this.add(b);
		this.add(new SideBar("Scarlet",b));
		this.pack();
		this.setSize(Window.SIZE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
	}
}
