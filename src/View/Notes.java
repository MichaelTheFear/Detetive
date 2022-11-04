package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import Util.Armas;
import Util.Comodos;
import Util.Personagem;


public class Notes extends JFrame {
	Notes(){
		Armas arm[] = Armas.values();
		
		int i = 0;
		
		for(i = 0;i<arm.length;i++) {
			add(new Text(arm[i].name(), 0, i*25)); 
		}
		
		
		
		this.pack();
		this.setSize(Canvas.SIZE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
	}
}
