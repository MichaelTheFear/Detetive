package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Model.JogoFacade;
import Util.*;
import View.Canvas;

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

	private void initRolarDados() {
		view.onRolarDados(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.rolarDados();
				view.setDados(model.getDados());
			}

		});
	}

	public static void main(String[] agrs) {
		new Middleware();

	}

}
