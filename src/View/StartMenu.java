package View;

import javax.swing.*;

public class StartMenu extends JFrame{

	StartMenu(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,500);
		this.setVisible(true);
		JLabel j = new JLabel("Detetive");
		j.setBounds(200,100,100,50);
		this.add(new Button("Novo Jogo",200,200));
		this.add(new Button("Continuar",200,300));
		this.add(j);
	}
}
