package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Tabuleiro {
	// aquele desgin pattern de unico la
	private Posicao posicoes[][];
	static int numPorLinha = 40;

	Tabuleiro(Posicao[][] posicoes) {
		this.posicoes = posicoes;
	}

	Posicao[][] getPosicoes() {
		return posicoes;
	}

	void setPosicoes(Posicao p[][]) {
		posicoes = p;
	}

	Posicao getPosicaoAt(int linha, int coluna) {
		return posicoes[linha][coluna];
	}

	void houseKeepingTabuleiro() {
		for (Posicao arrayPos[] : posicoes) {
			for (Posicao pos : arrayPos) {
				pos.setPassouAqui(false);
			}
		}
	}
}
