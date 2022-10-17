package Model;

public class Tabuleiro {
	private Posicao posicoes[];
	static int size = 64;
	static int numPorLinha = 8;
	
	protected Tabuleiro(Posicao[] posicoes) {
		this.posicoes = posicoes;
	}
	
	protected void initCaminhos(Posicao[][] posicoesProx) {
		for(int i = 0; i<posicoesProx.length;i++) {
			posicoes[i].setPosicoesProximas(posicoesProx[i]);
		}
	}
	
	protected Posicao[] achaDesitnosFinais() {
		//modificar
		return posicoes;
	}
	
	protected Posicao getPosEm(int x, int y) {
		return posicoes[x+numPorLinha*y];
	}
	

}
