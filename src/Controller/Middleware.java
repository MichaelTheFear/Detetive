package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Model.JogoFacade;
import Util.*;
import View.Canvas;

public class Middleware {
	static JogoFacade model = JogoFacade.getJogoFacade();

	Middleware() {
		// Canvas canvas = new Canvas();
		// JogoFacade model = new JogoFacade();
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
				model.rolarDados();
				Canvas.setDados(model.getDados());
			}

		});
	}

	public static void main(String[] agrs) {
		new Middleware();

	}

}
