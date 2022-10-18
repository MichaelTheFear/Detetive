package Model;

import java.util.ArrayList;
import java.util.List;

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
	
	protected List<Posicao> achaDesitnosFinais(int x,int y,int casas) {
		//ArrayList<Integer> posParaResetar = new ArrayList<Integer>();
		ArrayList<Posicao> res = new ArrayList<Posicao>();
		res.addAll(__recAchaDestino(getPosEm(x,y)));
		return res;
	}
	
	private List<Posicao> __recAchaDestino(Posicao p1) {
		ArrayList<Posicao> res = new ArrayList<Posicao>();
		for(Posicao p : p1.getPosicoesProximas()) {
			res.addAll(__recAchaDestino(p));
		}
		return res;
	}
	
	protected Posicao getPosEm(int x, int y) {
		return posicoes[x+numPorLinha*y];
	}
	

}
