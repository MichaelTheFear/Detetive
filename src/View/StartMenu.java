package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class StartMenu extends JPanel{
	
	/*
	StartMenu(){
		JLabel j = new JLabel("Detetive");
		j.setBounds(200,100,100,50);
		this.setBounds(0,0,1200,700);
		this.setVisible(true);
		this.add(new Button("Novo Jogo",e -> System.out.println("Novo Jogo"),200,200));
		this.add(new Button("Continuar",e -> System.out.println("Continuar"),200,300));
		this.add(j);
		
	}
	*/
	
	StartMenu(){
		JLabel j = new JLabel("Detetive");
		j.setBounds(200,200,100,50);
		this.add(j);
		this.add(new Button("Continuar",e -> System.out.println("Continuar"),200,300));
		this.add(new Button("Novo Jogo",e -> System.out.println("Novo Jogo"),200,200));
		this.setLayout(new BorderLayout());
		this.setBackground(Color.red);
		this.setBounds(0,0,1200,700);
	}
}
