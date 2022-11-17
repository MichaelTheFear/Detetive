package View;

import java.awt.Color;

import javax.swing.JLabel;

public class ErrorNotification extends JLabel{
	
	
	ErrorNotification(){
		this.setBounds(700, 560, 200, 75);
	}
	
	void error(String text) {
		this.setText(text);
		this.setOpaque(true);
		this.setBackground(Color.red);
		this.setForeground(Color.white);
	}
	
	void warning(String text) {
		this.setText(text);
		this.setOpaque(true);
		this.setBackground(Color.yellow);
		this.setForeground(Color.white);
	}
 	
}
