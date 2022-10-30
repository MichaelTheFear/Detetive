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
	

	protected ArrayList<Coordenadas> achaPosFinais(int x, int y, int casas, int turno){
		
		ArrayList<Coordenadas> aux = new ArrayList<Coordenadas>();

		aux.addAll(__recAchaPosFinais(x,y,casas+1,turno));
		//printAsMap(aux);
		
		return aux;
	}
	
	private ArrayList<Coordenadas> __recAchaPosFinais(int x, int y, int casas, int turno){
		ArrayList<Coordenadas> res = new ArrayList<Coordenadas>();
		ArrayList<Coordenadas> prox = new ArrayList<Coordenadas>();
		Posicao posAtual;
		Coordenadas coordAtual;
		posAtual = getPosicao(x,y);
		coordAtual = posAtual.getCoordenadas();
		if(casas>0) {
			res = new ArrayList<Coordenadas>();
			res.add(coordAtual);
			coordAtual.setPassouAqui(true);
			for(Coordenadas c: posAtual.getPosicoesProximas()) {
				if(c!=null) {
					if(!c.getPassouAqui()) {
						prox = __recAchaPosFinais(c.getX(),c.getY(),casas-1,turno);
						if(prox!=null) {
							res.addAll(prox);
						}
					}
				}
			}
			coordAtual.setPassouAqui(false);
		}
		return res;
	}
	
	void houseKeepingTabuleiro() {
		for(Posicao arrayPos[] : posicoes) {
			for(Posicao pos : arrayPos) {
				pos.getCoordenadas().setPassouAqui(false);
			}
		}
	}
}
