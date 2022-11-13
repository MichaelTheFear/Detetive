package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import Util.Armas;
import Util.Comodos;
import Util.Personagem;

class Guess extends JFrame{
	
	ArrayList<CheckBox> sus;
	ArrayList<CheckBox> weapons;
	ArrayList<CheckBox> places;
	
	String per = null;
	String arma = null;
	String comodo = null;
	
	int x = 50;
	
	Guess(){
		this.setLayout(new BorderLayout());
		
		Personagem personagens[] = Personagem.values();		
		Armas armas[] = Armas.values();		
		Comodos comodos[] = Comodos.values();		
		
		for(int i = 0 ; i<personagens.length;i++) {
			CheckBox b = new CheckBox(personagens[i],0,i*x);
			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String current = b.getName();
					if(per!=null) {
						sus.get(sus.indexOf(per)).setSelected(false);
					}
					per = b.getText();
				}
			});
			sus.add(b);
			this.add(b);
		}
		
		for(int i = 0 ; i<armas.length;i++) {
			CheckBox b = new CheckBox(armas[i],0,i*x);
			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String current = b.getName();
					if(arma!=null) {
						weapons.get(weapons.indexOf(arma)).setSelected(false);
					}
					arma = b.getText();
				}
			});
			weapons.add(b);
			this.add(b);
		}
		
		for(int i = 0 ; i<comodos.length;i++) {
			CheckBox b = new CheckBox(comodos[i],0,i*x);
			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String current = b.getName();
					if(comodo!=null) {
						weapons.get(weapons.indexOf(comodo)).setSelected(false);
					}
					comodo = b.getText();
				}
			});
			places.add(b);
			this.add(b);
		}
		
		this.pack();
		this.setSize(Canvas.SIZE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	
	 
}
