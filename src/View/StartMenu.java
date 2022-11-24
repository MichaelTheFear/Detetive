package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class StartMenu extends JPanel {

	
	
	StartMenu() {
		JLabel j = new JLabel("Detetive");
		j.setBounds(0, 0, 100, 50);
		this.add(j);
		this.add(new Button("Continuar", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				file.setFileSelectionMode(JFileChooser.FILES_ONLY);
		        int i= file.showOpenDialog(null);
		        if(i == JFileChooser.APPROVE_OPTION) {
		        	//check if file type correct
		        	
		        }
			}
			
		},200, 300));
		this.add(new Button("Novo Jogo", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Canvas.getCanvas().showPanel("SelectChar");
			}

		}, 200, 200));
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, 1200, 700);
	}
}
