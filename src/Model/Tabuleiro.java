package Model;

import java.util.ArrayList;
import java.util.List;

class Tabuleiro {
	// aquele desgin pattern de unico la
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
	
	protected List<Posicao> achaDesitnosFinais(int x,int y,int casas,int turno) {
		ArrayList<Posicao> res = new ArrayList<Posicao>();
		ArrayList<Posicao> aux = new ArrayList<Posicao>();
		aux.addAll(__recAchaDestino(getPosEm(x,y),casas));
		for(Posicao p : aux) {
			if(p.getMudadoNoTurno()!=turno) {
				p.setMudadoNoTurno(turno);
				p.setPassouAqui(0);
			}else {
				p.addUmPassouAqui();
			}
		}
		for(Posicao p: aux) {
			if(p.getPassouAqui()<=3)
				res.add(p);
		}
		return res;
	}
	
	private List<Posicao> __recAchaDestino(Posicao p1,int casas) {
		ArrayList<Posicao> res = null;
		ArrayList<Posicao> prox;
		if(casas>0) {			
			res = new ArrayList<Posicao>();
			for(Posicao p : p1.getPosicoesProximas()) {
				prox = (ArrayList<Posicao>) __recAchaDestino(p,casas--);
				if(prox!=null)
					res.addAll(prox);
			}
		}
		return res;
	}
	
	protected Posicao getPosEm(int x, int y) {
		return posicoes[x+numPorLinha*y];
	}
	

}
