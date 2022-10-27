package View;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends JFrame{
	
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 700;
	public static final Dimension SIZE = new Dimension(WIDTH,HEIGHT);
	
	
	Window(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.add(new SelectChar());
		//this.add(new StartMenu());
		//this.add(new Cards("Suspeitos",new String[] {"Green","Mustard","Peacock","Plum","Scarlet","White"}));
		this.add(new Board());
		this.add(new SideBar("Scarlet"));
		this.setSize(Window.SIZE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.pack();
	}
}
