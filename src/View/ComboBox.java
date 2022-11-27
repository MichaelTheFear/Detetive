package View;

import java.awt.event.ActionListener;

import javax.swing.JComboBox;

class ComboBox extends JComboBox {
	ComboBox(String[] options, int x, int y, ActionListener action) {
		super(options);
		this.addActionListener(action);
		this.setBounds(x, y, 50, 50);
	}
}
