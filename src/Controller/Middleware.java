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
import View.WinPage;

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
				ArrayList<String> notas = model.getNotas(); 
				view.showAccuse(notas);
			}
			
		});
		
		obs.susbcribe(Events.confirmAccuse, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				String[] cards = (String[]) o;
				boolean acusacao = model.acusar(cards);
				if(acusacao)
					view.win(model.getNomeJogadorVez());
				else
					prox();
			}	
		});	
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
					System.out.println("Arquivo não pode ser encontrado");
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
				obs.callEvent(Events.statusSecret, Boolean.valueOf(false));
				obs.callEvent(Events.statusGuess , Boolean.valueOf(false));
			}

		});
	}
	
	
	private void initMovement() {
		
		obs.susbcribe(Events.boardClick, new ObserverCallback() {
			
			@Override
			public void onCall(Object o) {
				Integer[] position = (Integer[]) o;
				int[] posicoes = new int[] { position[1], position[0] }; //position[1] = linha e position[0] = coluna
				int jogadasSobrando;
				jogadasSobrando = view.getJogadasSobrando();
				if (jogadasSobrando != 0) {
					try {
						model.mover(posicoes);
						view.movePlayerTo(model.getNomeJogadorVez(), model.getLinhaJogadorVez(), model.getColunaJogadorVez());
						obs.callEvent(Events.statusGuess, Boolean.valueOf(model.estaEmComodo()));
						view.setJogadasSobrando(jogadasSobrando - 1);
					}
					catch (ExceptionLugarNaoPermitido e) {
						view.showError("NA permitido mover pra ca");
					}
				}
				else {
					view.showError("Não tem mais jogadas");
				}

			}
		});
		
		obs.susbcribe(Events.onSecret, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				model.moverPassagemSecreta();
				view.movePlayerTo(model.getNomeJogadorVez(), model.getLinhaJogadorVez(), model.getColunaJogadorVez());
				obs.callEvent(Events.statusSecret, Boolean.valueOf(false));
				obs.callEvent(Events.statusGuess, Boolean.valueOf(model.getPodeDarPalpite()));
			}
		});
		
	}

	private void initProx() {
		view.onProximoTurno(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				prox();
			}
		});
		
	}
	
	private void prox() {
		model.passaVez();
		if(model.getErrouAcusaoAll())
			view.win("Nenhum");
		Personagem prox = model.getJogadorVez();
		view.setNamePlayingNow(prox.toString());
		obs.callEvent(Events.statusDice, Boolean.valueOf(true));
		obs.callEvent(Events.statusGuess, Boolean.valueOf(model.getPodeDarPalpite()));
		obs.callEvent(Events.statusSecret, Boolean.valueOf(model.verificaPassagemSecreta()));
	}

	private void initNotes() {
		obs.susbcribe(Events.showNotes, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				//List mock =  Arrays.asList(new String[] {Personagem.Green.name(),Armas.Cano.name()});
				//view.showNotes(mock);
				//precisa pegar do model 
				List<String> notas = model.getNotas();  // pega as cartas vistas 
				view.showNotes(notas);   // mostra cartas vistas
			}

		});
	}

	private void initShowPlayersCards() {
		obs.susbcribe(Events.showCards, new ObserverCallback() {
			@Override
			public void onCall(Object o) {
				//List mock =  Arrays.asList(new String[] {Personagem.Green.name(),Armas.Cano.name()});
				//view.showCards(mock);
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
				model.darPalpite(cartasPalpite);    // darPalpite com as cartas q o jogador marcou
				//mover o player 
				int p[] = model.moverPalpite(cartasPalpite[0], cartasPalpite[2]); // mover player 'acusado' para o comodo do palpite
				view.movePlayerTo(cartasPalpite[0], p[0], p[1]);
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

