package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Model.Jogo;
import Util.*;
import View.Canvas;

public class Middleware {
	Jogo model = new Jogo();
	
	
	Middleware(){
		//Canvas canvas = new Canvas();
		//JogoFacade model = new JogoFacade();
		initBoard();
		initRolarDados();
	}
	
	
	private void initBoard() {
		
		Canvas.onGameStart(new FunctionClass() {

			@Override
			public void callbackVoid() {
				
				
				
			}
			
		});
	}
	
	
	private void initRolarDados() {
		Canvas.onRolarDados(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.rolarDado();
				Canvas.setDados(model.getDados());
			}
			
		});
	}
	
	public static void main(String[] agrs) {
		new Middleware();
		
	}
	
	
}
