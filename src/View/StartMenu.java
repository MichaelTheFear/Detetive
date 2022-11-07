package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StartMenu extends JPanel {

	StartMenu() {
		JLabel j = new JLabel("Detetive");
		j.setBounds(0, 0, 100, 50);
		this.add(j);
		this.add(new Button("Continuar", 200, 300));
		this.add(new Button("Novo Jogo", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Canvas.showPanel("SelectChar");
			}

		}, 200, 200));
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, 1200, 700);
	}
}
