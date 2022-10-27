package View;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends JFrame{
	
	Window(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new StartMenu());
		//this.add(new Cards("Suspeitos",new String[] {"Green","Mustard","Peacock","Plum","Scarlet","White"}));
		this.setSize(1200,700);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.pack();
	}
}
