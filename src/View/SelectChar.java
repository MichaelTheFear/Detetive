package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Util.Personagem;

class SelectChar extends JFrame {

	static ArrayList<Personagem> sus = new ArrayList<Personagem>();
	static Button b = new Button("Começar", 1000, 500);

	static void setGameStart(ActionListener action) {
		b.addActionListener(action);
	}

	private static ArrayList<String> toEnumsStrings() {
		Personagem per[] = Personagem.values();
		ArrayList<String> res = new ArrayList<>();
		for(Personagem p: per) {
			res.add(p.name());
		}
		return res;
	}

	SelectChar() {
		int i = 0;
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, 1200, 700);
		this.add(b);
		for (Personagem p : Personagem.values()) {
			CheckBox check = new CheckBox(p, i);
			check.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (check.isSelected()) {
						sus.add(p);
					} else {
						sus.remove(p);
					}
				}
				
			});
			this.add(check);
			i += 100;
		}
		this.add(new Cards("Suspeitos", toEnumsStrings()));
		this.pack();
		this.setSize(Canvas.SIZE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
	}

	
	
	static ArrayList<Personagem> getSus(){
		return sus;
	}
}
