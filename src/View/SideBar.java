package View;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SideBar extends JPanel{

	int where = 700;
	int ratio = 50;
	int dice1 = 3;
	int dice2 = 3;
	JComboBox box1;
	JComboBox box2;
	
	
	SideBar(String jogador, Board b){
		String [] options = {"1","2","3","4","5"};
		box1 = new JComboBox(options);
		box2 = new JComboBox(options);
		box1.addActionListener(e -> System.out.println("Dado 1:  "+(box1.getSelectedIndex()+1)));
		box2.addActionListener(e -> System.out.println("Dado 2:  "+(box2.getSelectedIndex()+1)));
		this.add(new Button("Passagem Secreta",e -> b.movePlayerTo("Mustard", 10, 10),where,0));
		this.add(new Button("Proximo",e -> System.out.println("Passagem Secreta"),where,ratio));
		this.add(new Button("Mostra Cartas",e -> System.out.println("Passagem Secreta"),where,ratio*2));
		this.add(new Button("Notas",e -> System.out.println("Passagem Secreta"),where,ratio*3));
		this.add(new Button("Palpite",e -> System.out.println("Passagem Secreta"),where,ratio*4));
		this.add(new Button("Acusar",e -> System.out.println("Passagem Secreta"),where,ratio*5));
		this.add(new Text(jogador,where+80,ratio*6,Player.getColorOf(jogador)));
		this.add(new Button("Rolar dados", e-> System.out.println("Rolar dados"),where,ratio*7));
		this.add(new Button("Usar esses dados", e-> System.out.println("Usar esses dados"),where,ratio*8));
		box2.setBounds(where,ratio*9,50,50);
		this.add(box2);
		box1.setBounds(where+50,ratio*9,50,50);
		this.add(box1);
		
		this.setLayout(new BorderLayout());
		this.setBounds(where,where,200,700);
	}
	
	
	
}
