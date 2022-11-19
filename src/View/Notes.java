package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Util.Armas;
import Util.Comodos;
import Util.Personagem;

class Notes extends JFrame {

	public Notes(List<String> cards) {
		this.setLayout(new BorderLayout());
		
		this.add(new NotesPanel(cards));
		this.pack();
		this.setSize(Canvas.SIZE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}


	private class NotesPanel extends JPanel {
		NotesPanel(List<String> cartas){
			ArrayList<String> unmarked = new ArrayList<>();
			int i = 0;
			
			for(Armas carta : Armas.values()) {
				unmarked.add(carta.name());
			}
			for(Personagem carta : Personagem.values()) {
				unmarked.add(carta.name());
			}
			for(Comodos carta: Comodos.values()) {
				unmarked.add(carta.name());
			}
			for(String carta: cartas) {
				unmarked.remove(carta);
			}
			
			for(i = 0;i<cartas.size();i++) {
				this.add(new CheckBox(cartas.get(i),(i)*25,true));
			}
			
			for(int j = 0 ;j<unmarked.size();j++) {
				this.add(new CheckBox(unmarked.get(j),(i+j)*25,false));
			}
			
			
			this.setLayout(new BorderLayout());
			this.setSize(Canvas.SIZE);
		}
		
		
	}
	
}
