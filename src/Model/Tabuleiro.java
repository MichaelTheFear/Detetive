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

	void initCaminhos(Coordenadas[][][] posicoesProx) {
		for (int i = 0; i < numPorLinha; i++) {
			for (int j = 0; j < numPorLinha; j++) {
				posicoes[i][j].setPosicoesProximas(posicoesProx[i][j]);
			}
		}
	}

	Posicao[][] getPosicoes() {
		return posicoes;
	}

	void setPosicoes(Posicao p[][]) {
		posicoes = p;
	}

	private Posicao getPosicaoAt(int x, int y) {
		return posicoes[x][y];
	}

	void houseKeepingTabuleiro() {
		for (Posicao arrayPos[] : posicoes) {
			for (Posicao pos : arrayPos) {
				pos.getCoordenadas().setPassouAqui(false);
			}
		}
	}
}
