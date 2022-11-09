package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Model.JogoFacade;
import Util.*;
import View.Canvas;
import View.Dices;
import View.Observer;

public class Middleware {
	static JogoFacade model = JogoFacade.getJogoFacade();
	static Canvas view = Canvas.getCanvas();

	Middleware() {
		// Canvas canvas = new Canvas();
		// JogoFacade model = new JogoFacade();
		initBoard();
		initRolarDados();
	}

	private void initBoard() {

		view.onGameStart(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Personagem> viewPlayers = view.getPlayers();
				model.setupJogadores(viewPlayers);
			}

		});
	}
	
	private void initNotes() {
		Observer.susbcribe(Events.showNotes, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				//view.showNotes(model.getCartasVistas);
			}
			
		});
	}
	
	private void initShowPlayersCards() {
		Observer.susbcribe(Events.showCards, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				//view.showNotes(model.getCartasIniciais);
			}
			
		});
	}

	private void initRolarDados() {
		Observer.susbcribe(Events.dice, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				if(o==null) {
					model.rolarDados();
					view.setDados(model.getDados());
				}else {
					Dices dices = (Dices) o;
					//model.setDados(dices);
				}
			}
			
		});
		
		
		
		/*
		view.onRolarDados(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.rolarDados();
				view.setDados(model.getDados());
			}

		});
		*/
	}

	public static void main(String[] agrs) {
		new Middleware();

	}

}
