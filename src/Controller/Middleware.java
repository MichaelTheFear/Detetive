package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.ExceptionLugarNaoPermitido;
import Model.JogoFacade;
import Util.*;
import View.Canvas;
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
		initMovement();
		initPalpite();
		initShowPlayersCards();
		initNotes();
	}

	private void initBoard() {

		view.onGameStart(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Personagem> viewPlayers = view.getPlayers();
				model.setupJogadores(viewPlayers);
				view.setPlayerName(model.getJogadorVez());
			}

		});
	}

	private void initMovement() {
		Observer.getObserver().susbcribe(Events.boardClick, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				Integer[] position = (Integer[]) o;
				int[] posicoes = new int[] { position[1], position[0] }; //position[1] = linha e position[0] = coluna
				int jogadasSobrando;

				jogadasSobrando = view.getJogadasSobrando();
				System.out.println(jogadasSobrando);
				if (jogadasSobrando != 0) {
					try {
						model.mover(posicoes);
						view.movePlayerTo(model.getNomeJogadorVez(), model.getLinhaJogadorVez(), model.getColunaJogadorVez());
						view.setJogadasSobrando(jogadasSobrando - 1);
					}
					catch (ExceptionLugarNaoPermitido e) {
						view.showError("Não é permitido mover pra ca");
						System.out.println("Lugar nao permitido");
					}
				}
				else {
					view.showError("Não é permitido mover pra ca");
				}

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
				List mock =  Arrays.asList(new String[] {Personagem.Green.name(),Armas.Cano.name()});
				view.showNotes(mock);
				//precisa pegar do model 
			}

		});
	}

	private void initShowPlayersCards() {
		Observer.getObserver().susbcribe(Events.showCards, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				List mock =  Arrays.asList(new String[] {Personagem.Green.name(),Armas.Cano.name()});
				view.showCards(mock);
				//precisa pegar do model 
			}

		});
	}

	private void initRolarDados() {
		Observer.getObserver().susbcribe(Events.dice, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				if (o == null) {
					model.rolarDados();
					view.setDados(model.getDados());
				}
				else {
					Integer dices[] = (Integer[]) o;
					model.setDados(dices);
				}
			}

		});
	}

	private void initPalpite() {
		Observer.getObserver().susbcribe(Events.confirmGuess, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				String[] cartasPalpite = (String[]) o;
				//model.palpite(cartasPalpite);
				//mover o player 
			}
		});
	}

	public static void main(String[] agrs) {
		new Middleware();

	}

}
