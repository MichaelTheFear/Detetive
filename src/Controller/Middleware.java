package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.ExceptionLugarNaoPermitido;
import Model.JogoFacade;
import Util.*;
import View.Canvas;

public class Middleware {
	static JogoFacade model = JogoFacade.getJogoFacade();
	static Canvas view = Canvas.getCanvas();
	static Observer obs = Observer.getObserver();

	Middleware() {
		initBoard();
		initRolarDados();
		initProx();
		initMovement();
		initPalpite();
		initShowPlayersCards();
		initNotes();
		initAcusar();
		initFile();
	}

	private void initAcusar() {
		obs.susbcribe(Events.showAccuse, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				ArrayList<String> notas = model.getNotas(); // pega as cartas vistas para a showAccuse
				System.out.println("Acusar len "+notas.size() );
				for(String str: notas)
					System.out.println("acusar: "+str);
				view.showAccuse(notas);
			}
			
		});
		
		obs.susbcribe(Events.confirmAccuse, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				String[] cards = (String[]) o;
				boolean acusacao = model.acusar(cards); // chama acusar do model com as cartas que o jogador marcou
			}
			
		} );
		
		
	}
	
	private void initFile() {
		obs.susbcribe(Events.saveGame, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				String filePath = (String) o;
				try {					
					model.salvaJogo(filePath);
				}catch(IOException e) {
					view.showError("Não foi possivel achar o diretorio");
				}
			}
		});
		
		obs.susbcribe(Events.loadGame, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				File f = (File) o;
				try {					
					model.carregarJogo(f);
					view.showPanel("Board");
				}catch(FileNotFoundException e) {
					System.out.println(e); //talvez botar um popup no lugar 
				}
			}
		});
	}
	
	private void initBoard() {

		view.onGameStart(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.novoJogo();
				ArrayList<Personagem> viewPlayers = view.getPlayers();
				model.setupJogadores(viewPlayers);
				model.distribuiCartas();
				view.setPlayerName(model.getJogadorVez());
				obs.callEvent(Events.statusGuess , Boolean.valueOf(false));
				obs.callEvent(Events.statusSecret, Boolean.valueOf(false));
			}

		});
	}
	
	
	private void initMovement() {
		
		obs.susbcribe(Events.boardClick, new ObserverCallback() {
			
			@Override
			public void onCall(Object o) {
				Integer[] position = (Integer[]) o;
				int[] posicoes = new int[] { position[1], position[0] };
				int jogadasSobrando;
				jogadasSobrando = view.getJogadasSobrando();
				System.out.println(jogadasSobrando);
				if (jogadasSobrando != 0) {
					try {
						model.mover(posicoes);
						view.movePlayerTo(model.getNomeJogadorVez(), model.getLinhaJogadorVez(), model.getColunaJogadorVez());
						obs.callEvent(Events.statusGuess, Boolean.valueOf(model.estaEmComodo()));
						view.setJogadasSobrando(jogadasSobrando - 1);
					}
					catch (ExceptionLugarNaoPermitido e) {
						view.showError("NÃ£o Ã© permitido mover pra ca");
						System.out.println("Lugar nao permitido");
					}
				}
				else {
					view.showError("NÃ£o Ã© permitido mover pra ca");
				}

			}
		});
		
		obs.susbcribe(Events.onSecret, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				model.moverPassagemSecreta();
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
				obs.callEvent(Events.statusDice, Boolean.valueOf(true));
				obs.callEvent(Events.statusGuess, Boolean.valueOf(false));
				obs.callEvent(Events.statusSecret, Boolean.valueOf(model.verificaPassagemSecreta()));
			}
		});
		
	}

	private void initNotes() {
		obs.susbcribe(Events.showNotes, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				List<String> notas = model.getNotas();
				view.showNotes(notas);  
			}

		});
	}

	private void initShowPlayersCards() {
		obs.susbcribe(Events.showCards, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				ArrayList<String> playersCards = model.getCartasJogador(); // pega cartas do jogador da vez para a showCards
				view.showCards(playersCards);
			}
		});
	}

	private void initRolarDados() {
		obs.susbcribe(Events.dice, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				obs.callEvent(Events.statusDice, Boolean.valueOf(false));
				if (o == null) {

					model.rolarDados();
					view.setDados(model.getDados());
				}
				else {
					Integer dices[] = (Integer[]) o;
					model.setDados(dices);
					view.setDados(model.getDados());
				}
			}
		});
	}

	private void initPalpite() {
		obs.susbcribe(Events.confirmGuess, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				String[] cartasPalpite = (String[]) o;
				model.darPalpite(cartasPalpite);
				model.moverPalpite(cartasPalpite[0], cartasPalpite[2]);
			}
		});
		
		obs.susbcribe(Events.showGuess, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				view.showGuess(model.qualComodo());
			}
		});
	}

	public static void main(String[] agrs) {
		new Middleware();
	}

}

