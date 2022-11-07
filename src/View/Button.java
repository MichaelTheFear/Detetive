package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button extends JButton {
	Button(String name, ActionListener actionListner, int x, int y) {
		this.setBounds(x, y, 200, 50);
		this.addActionListener(actionListner);
		this.setText(name);
	}

	Button(String name, ActionListener action, int x, int y, int size) {
		this.setBounds(x, y, size, size);
		this.addActionListener(action);
		this.setText(name);
	}

	public Button(String name, int x, int y) {
		this.setBounds(x, y, 200, 50);
		this.setText(name);
	}

}
