package View;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SideBar extends JPanel{

	JLabel jogador;
	
	SideBar(String jogador){
		this.jogador = new JLabel(jogador);
		this.add(new Button("Passagem Secreta",e -> System.out.println("Passagem Secreta"),500,100));
		this.add(new Button("Proximo",e -> System.out.println("Passagem Secreta"),500,200));
		this.add(new Button("Mostra Cartas",e -> System.out.println("Passagem Secreta"),500,300));
		this.add(new Button("Notas",e -> System.out.println("Passagem Secreta"),500,400));
		this.add(new Button("Palpite",e -> System.out.println("Passagem Secreta"),500,500));
		this.add(new Button("Acusar",e -> System.out.println("Passagem Secreta"),500,600));
		this.add(this.jogador);
		this.add(new Button("Usar esses dados", e-> System.out.println("Usar esses dados"),500,800));
		this.add(new Button("Rolar dados", e-> System.out.println("Rolar dados"),500,800));
		
	}
	
}
