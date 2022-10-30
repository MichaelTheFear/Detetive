package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Tabuleiro {
	// aquele desgin pattern de unico la
	private Posicao posicoes[][];
	static int numPorLinha = 40;
	
	protected Tabuleiro(Posicao[][] posicoes) {
		this.posicoes = posicoes;
	}
	
	protected void initCaminhos(Coordenadas[][][] posicoesProx) {
		for(int i = 0; i<numPorLinha;i++) {
			for(int j = 0;j<numPorLinha;j++) {
				posicoes[i][j].setPosicoesProximas(posicoesProx[i][j]);
			}
		}
	}
	
	protected Posicao[][] getPosicoes() {
		return posicoes;
	}
	
	protected void setPosicoes(Posicao p[][]) {
		posicoes = p;
	}
	
	
	
	private Posicao getPosicaoAt(int x, int y) {
		return posicoes[x][y];
	}
	

}
