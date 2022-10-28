package View;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import Util.Personagem;
import View.Window.Canvas;

public class SelectChar extends JPanel {

	private static String[] toEnumsStrings() {
		Personagem per[] = Personagem.values();
		String res[] = new String[per.length];
		for(int i = 0;i<res.length;i++) {
			res[i] = per[i].toString();
		}
		return res;
	}
	
	SelectChar(){
		this.setLayout(new BorderLayout());
		this.setBounds(0,0,1200,700);
		this.add(new Button("Começar", e-> Canvas.showPanel("Board"),1000,500));
		this.add(new Cards("Suspeitos",toEnumsStrings()));
	}
}
