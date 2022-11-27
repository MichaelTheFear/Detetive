package View;

import java.awt.Color;

import javax.swing.JLabel;

class Text extends JLabel {
	Text(String text, int x, int y) {
		this.setText(text);
		this.setBounds(x, y, 100, 50);
	}

	Text(String text, int x, int y, Color c) {
		this.setText(text);
		this.setBounds(x, y, 100, 50);
		this.setForeground(c);
	}

	Text(String text, int width, int x, int y) {
		this.setText(text);
		this.setBounds(x, y, width, 50);
		
	}
	
	void setStyle(String text, Color c) {
		this.setText(text);
		this.setForeground(c);
	}

}
