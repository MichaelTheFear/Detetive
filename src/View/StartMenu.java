package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.Observer;
import Util.Events;

class StartMenu extends JPanel {
	 
	StartMenu() {
		JLabel j = new JLabel("Detetive");
		j.setBounds(0, 0, 100, 50);
		this.add(j);
		this.add(new Button("Continuar", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser filePicker = new JFileChooser();
				filePicker.setFileSelectionMode(JFileChooser.FILES_ONLY);
		        int i= filePicker.showOpenDialog(null);
		        
		        if(i == JFileChooser.APPROVE_OPTION) {
		        	Observer.getObserver().callEvent(Events.loadGame, filePicker.getSelectedFile());
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
