package View;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WinPage extends JFrame{
	
	WinPage(String player){
		this.add(new JLabel(player +" wins"));
		this.pack();
		this.setSize(Canvas.SIZE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
	}
	
}
