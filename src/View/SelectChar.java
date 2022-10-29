package View;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import Util.Personagem;
import View.Window.Canvas;

public class SelectChar extends JPanel {

	static ArrayList<String> sus = new ArrayList<String>();
	static Button b = new Button("Começar",1000,500);
	
	static ArrayList<String> setGameStart(ActionListener action) {
		b.addActionListener(action);
		return sus;
	}
	
	public static ArrayList<String> getSuspeitos() {
		return sus;
	}
	
	private static String[] toEnumsStrings() {
		Personagem per[] = Personagem.values();
		String res[] = new String[per.length];
		for(int i = 0;i<res.length;i++) {
			res[i] = per[i].toString();
		}
		return res;
	}
	
	SelectChar(){
		int i=0;
		this.setLayout(new BorderLayout());
		this.setBounds(0,0,1200,700);
		this.add(b);
		for(Personagem p: Personagem.values()) {
			this.add(new CheckBox(p,i));
			i+=100;
		}
		this.add(new Cards("Suspeitos",toEnumsStrings()));
	}
	
	private class CheckBox extends JCheckBox{
		CheckBox(Personagem p,int n){
			this.setText(p.name());
			this.setBounds(n, 600, 100, 50);
			this.setFocusable(false);
			this.addActionListener(e ->{
				System.out.println("Added sus "+p.name());
				if(this.isSelected()) {
					sus.add(p.name());
				}else {
					sus.remove(p.name());
				}
			});
		}		
		
	}
}
