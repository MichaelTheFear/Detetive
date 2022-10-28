package View;

import java.awt.Color;

import javax.swing.JLabel;

public class Text extends JLabel {
	Text(String text,int x,int y){
		this.setText(text);
		this.setBounds(x, y, 100, 50);
	}
	
	Text(String text,int x,int y, Color c){
		this.setText(text);
		this.setBounds(x, y, 100, 50);
		this.setForeground(c);
	}

	public Text(String jogador, int i, int j, int k, int l, Color colorOf) {
		// TODO Auto-generated constructor stub
	}

}
