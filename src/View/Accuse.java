package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import Controller.Observer;
import Util.Armas;
import Util.Comodos;
import Util.Events;
import Util.Personagem;

public class Accuse extends JFrame {
	
	static private Accuse accuse = null;
	
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
	
	static Accuse newAccuse(List<String> cartas) {
		if(accuse == null)
			accuse = new Accuse(cartas);
		return accuse;
	}
	
	private Accuse(List<String> cartasVistas){
		Personagem personagens[] = Personagem.values();		
		Armas armas[] = Armas.values();		
		Comodos comodos[] = Comodos.values();
		System.out.println(cartasVistas.get(0));
		for(int i = 0 ; i<personagens.length;i++) {
			CheckBox b = new CheckBox(personagens[i],0,i*x);
			if(cartasVistas.indexOf(personagens[i].name())!=-1) 
				b.setEnabled(false);
			else
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
			if(cartasVistas.indexOf(armas[i].name())!=-1) 
				b.setEnabled(false);
			else
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
			if(cartasVistas.indexOf(comodos[i].name())!=-1) 
				b.setEnabled(false);
			else
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
				if(per!=null && comodos!=null && arma!=null) {					
					Observer.getObserver().callEvent(Events.confirmAccuse, new String[] {
							per,arma,comodo
					});
					accuse.dispose();
					accuse = null;
				}
			}
		},1000,600));
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				accuse.dispose();
				accuse = null;
			}
		});
		this.setLayout(new BorderLayout());
		this.pack();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(Canvas.SIZE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
	
	
}
