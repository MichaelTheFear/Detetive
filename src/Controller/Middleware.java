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
		initProx();
	}

	private void initBoard() {

		view.onGameStart(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Personagem> viewPlayers = view.getPlayers();
				model.setupJogadores(viewPlayers);
				view.setPlayerName(viewPlayers.get(0));
			}

		});
	}
	
	private void initProx() {
		view.onProximoTurno(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.passaVez();
				Personagem prox = model.getJogadorVez();
				view.setNamePlayingNow(prox.toString());
			}
		});
	}
	
	private void initNotes() {
		Observer.getObserver().susbcribe(Events.showNotes, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				//view.showNotes(model.getCartasVistas);
			}
			
		});
	}
	
	private void initShowPlayersCards() {
		Observer.getObserver().susbcribe(Events.showCards, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				//view.showNotes(model.getCartasIniciais);
			}
			
		});
	}

	private void initRolarDados() {
		Observer.getObserver().susbcribe(Events.dice, new ObserverCallback() {
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
