package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SideBar extends JPanel{

	int where = 700;
	int ratio = 50;
	String dice1 = "3";
	String dice2 = "3";
	ComboBox box1;
	ComboBox box2;
	Button prox;
	Button mostraCartas;
	Button notas;
	Button palpite;
	Button acusar;
	Button rolarDados;
	Button usarDados;
	String jogador;
	
	
	SideBar(String jogador, Board b){
		String [] options = {"1","2","3","4","5"};
		box1 = new ComboBox(options,where,ratio*9, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dice1 = (String) box1.getSelectedItem();
			}
		});
		box2 = new ComboBox(options,where+50,ratio*9, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dice2 = (String) box2.getSelectedItem();
			}
		});
		this.add(prox = new Button("Proximo",where,0));
		this.add(mostraCartas = new Button("Mostra Cartas",where,ratio));
		this.add(notas = new Button("Notas",where,ratio*2));
		this.add(palpite = new Button("Palpite",where,ratio*3));
		this.add(acusar = new Button("Acusar",where,ratio*4));
		this.add(new Text(jogador,where+80,ratio*5,Player.getColorOf(jogador)));
		this.add(rolarDados = new Button("Rolar dados",where,ratio*6));
		this.add(usarDados = new Button("Usar esses dados",where,ratio*7));
		this.add(new Text("Dado1     Dado2",where,ratio*8));
		this.add(box2);
		this.add(box1);
		this.setLayout(new BorderLayout());
		this.setBounds(where,where,200,700);
	}
	
	void setJogador(String jogador) {
		this.jogador = jogador;
	}
	
	
	void setActionProximo(ActionListener callback){
		prox.addActionListener(callback);
	}
	
	void setActionPalpite(ActionListener callback){
		prox.addActionListener(callback);
	}
	
	void setActionMostrarCartas(ActionListener callback){
		prox.addActionListener(callback);
	}
	
	void setActionNotas(ActionListener callback){
		prox.addActionListener(callback);
	}
	
	void setActionAcusar(ActionListener callback){
		prox.addActionListener(callback);
	}
	
	void setActionRolarDados(ActionListener callback){
		prox.addActionListener(callback);
	}
	
	void setActionUsarDados(ActionListener callback){
		prox.addActionListener(callback);
	}
	
	
	
}
