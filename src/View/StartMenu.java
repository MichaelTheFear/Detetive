package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.*;

import View.Window.Canvas;

public class StartMenu extends JPanel{
	
	
	StartMenu(){
		JLabel j = new JLabel("Detetive");
		j.setBounds(0,0,100,50);
		this.add(j);
		this.add(new Button("Continuar",e -> System.out.println("Continuar"),200,300));
		this.add(new Button("Novo Jogo",e -> Canvas.showPanel("SelectChar"),200,200));
		this.setLayout(new BorderLayout());
		this.setBounds(0,0,1200,700);
	}
}
