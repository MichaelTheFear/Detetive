package View;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SideBar extends JPanel{

	JLabel jogador;
	int where = 700;
	int ratio = 50;
	
	SideBar(String jogador, Board b){
		this.jogador = new JLabel(jogador);
		this.add(new Button("Passagem Secreta",e -> b.movePlayerTo("Mustard", 10, 10),where,0));
		this.add(new Button("Proximo",e -> System.out.println("Passagem Secreta"),where,ratio));
		this.add(new Button("Mostra Cartas",e -> System.out.println("Passagem Secreta"),where,ratio*2));
		this.add(new Button("Notas",e -> System.out.println("Passagem Secreta"),where,ratio*3));
		this.add(new Button("Palpite",e -> System.out.println("Passagem Secreta"),where,ratio*4));
		this.add(new Button("Acusar",e -> System.out.println("Passagem Secreta"),where,ratio*5));
		this.jogador.setBounds(100, 100, where, ratio*6);
		this.add(this.jogador);
		this.add(new Button("Usar esses dados", e-> System.out.println("Usar esses dados"),where,ratio*7));
		this.add(new Button("Rolar dados", e-> System.out.println("Rolar dados"),where,ratio*8));
		this.setLayout(new BorderLayout());
		this.setBounds(where,where,200,700);
	}
	
}
