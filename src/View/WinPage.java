package View;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WinPage extends JFrame{
	
	public WinPage(String player){
		this.setLayout(new FlowLayout());
		this.add(new JLabel(player +" wins"));
		this.pack();
		this.setSize(500,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
	}
	
}
