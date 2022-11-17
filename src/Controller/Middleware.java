package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Model.ExceptionLugarNaoPermitido;
import Model.JogoFacade;
import Util.*;
import View.Canvas;
import View.Observer; 

public class Middleware {
	static JogoFacade model = JogoFacade.getJogoFacade();
	static Canvas view = Canvas.getCanvas();
	static Observer obs = Observer.getObserver();
	
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
	
	private void initMovement() {
		obs.susbcribe(Events.boardClick, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				Integer[] position = (Integer[]) o;
				int[] posicoes = new int[] {position[0],position[1]};
				int jogadasSobrando;
				/*
					jogadasSobrando = view.getJogadasSobrando();
					if(jogadasSobrando!= 0){
				try {
						model.mover(posicoes);
						view.setJogadasSobrando(jogadasSobrando-1);
							}catch(ExceptionLugarNaoPermitido e) {
								view.showError("Não é permitido mover pra ca");
							}
					}else{
						view.showError("Não é permitido mover pra ca");
					}
				*/
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
		obs.susbcribe(Events.showNotes, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				//view.showNotes(model.getCartasVistas);
			}
			
		});
	}
	
	private void initShowPlayersCards() {
		obs.susbcribe(Events.showCards, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				//view.showNotes(model.getCartasIniciais);
			}
			
		});
	}

	private void initRolarDados() {
		obs.susbcribe(Events.dice, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				if(o==null) {
					model.rolarDados();
					view.setDados(model.getDados());
				}else {
					Integer dices[] = (Integer[]) o;
					model.setDados(dices);
				}
			}
			
		});	
	}
	
	private void initPalpite() {
		obs.susbcribe(Events.confirmGuess, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				String[] cartasPalpite = (String[]) o;
				//model.palpite(cartasPalpite);
				//mover o player 
			}
		});
	}
	
	private void initAccuse() {
		obs.susbcribe(Events.confirmAccuse, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				//model.acusar(view.getLastAccuse());
			}
		});
		
		obs.susbcribe(Events.showAccuse, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				//view.showAccuse(model.getCartasVistas());
			}
			
		});
	}
	
	

	public static void main(String[] agrs) {
		new Middleware();

	}

}
