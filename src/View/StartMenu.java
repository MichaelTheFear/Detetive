package View;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class StartMenu extends JFrame{

	StartMenu(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new Painel());
		this.setSize(1200,700);
		this.setVisible(true);
		/*
		this.setLayout(null);
		JLabel j = new JLabel("Detetive");
		j.setBounds(200,100,100,50);
		*/
		/*
		this.add(new Button("Novo Jogo",200,200));
		this.add(new Button("Continuar",200,300));
		this.add(j);
		*/
	}

}
