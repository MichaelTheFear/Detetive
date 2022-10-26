package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button extends JButton implements ActionListener{
	Button(String name,int x, int y){
		this.setBounds(x,y,100,50);
		this.addActionListener(this);
		this.setText(name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this) {
			System.out.println("Teste");
		}
		
	}
}
