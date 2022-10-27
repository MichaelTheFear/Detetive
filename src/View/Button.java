package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button extends JButton{
	Button(String name,ActionListener action,int x, int y){
		this.setBounds(x,y,200,50);
		this.addActionListener(action);
		this.setText(name);
	}

}
