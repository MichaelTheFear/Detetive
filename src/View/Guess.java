package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import Util.Armas;
import Util.Comodos;
import Util.Events;
import Util.Personagem;

class Guess extends JFrame{
	
	ArrayList<CheckBox> sus = new ArrayList<>();
	ArrayList<CheckBox> weapons = new ArrayList<>();
	ArrayList<CheckBox> places = new ArrayList<>();
	
	String per = null;
	String arma = null;
	String comodo = null;
	
	int x = 50;
	
	private int indexOf(String s,ArrayList<CheckBox> ar) {
		for(int i = 0;i<ar.size();i++) {
			if(ar.get(i).getText()==s) 
				return i;
		}
		return -1;
	}
	
	Guess(){
		
		Personagem personagens[] = Personagem.values();		
		Armas armas[] = Armas.values();		
		Comodos comodos[] = Comodos.values();		
		
		for(int i = 0 ; i<personagens.length;i++) {
			CheckBox b = new CheckBox(personagens[i],0,i*x);
			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(per!=null) {
						sus.get(indexOf(per,sus)).setSelected(false);
					}
					per = b.getText();
				}
			});
			sus.add(b);
			this.add(b);
		}
		
		for(int i = 0 ; i<armas.length;i++) {
			CheckBox b = new CheckBox(armas[i],300,i*x);
			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(arma!=null) {
						weapons.get(indexOf(arma,weapons)).setSelected(false);
					}
					arma = b.getText();
				}
			});
			weapons.add(b);
			this.add(b);
		}
		
		for(int i = 0 ; i<comodos.length;i++) {
			CheckBox b = new CheckBox(comodos[i],600,i*x);
			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(comodo!=null) {
						places.get(indexOf(comodo,places)).setSelected(false);
					}
					comodo = b.getText();
				}
			});
			places.add(b);
			this.add(b);
		}
		this.add(new Button("Confirmar", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(per!=null && comodos!=null && arma!=null) 
					Observer.getObserver().callEvent(Events.confirmGuess, new String[] {
							per,arma,comodo
					});
			}
		},600,1000));
		
		
		this.setLayout(new BorderLayout());
		this.pack();
		this.setSize(Canvas.SIZE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	
	 
}
