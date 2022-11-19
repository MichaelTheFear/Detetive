package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import Util.Personagem;

class CheckBox extends JCheckBox {

	CheckBox(String name, int where, boolean marked) {
		this.setBounds(0, where, 150, 25);
		this.setText(name);
		this.setSelected(marked);
		this.setEnabled(false);
		this.setVisible(true);
	}

	<T extends Enum<T>> CheckBox(T p,int n) {
		this.setText(p.name());
		this.setBounds(n, 600, 100, 50);
		this.setFocusable(false);

	}
	
	<T extends Enum<T>> CheckBox(T p,int x,int y) {
		this.setText(p.name());
		this.setBounds(x, y, 200, 50);
		this.setFocusable(false);
	}
	
	

}
