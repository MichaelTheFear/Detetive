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
	
	protected Posicao[] getPosicoes() {
		return posicoes;
	}
	
	protected void setPosicoes(Posicao p[]) {
		posicoes = p;
	}
	
	protected ArrayList<Posicao> achaDesitnosFinais(int x,int y,int casas,int turno) {
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
			if(p.getPassouAqui()<=3 || p instanceof Comodo)
				res.add(p);
		}
		return res;
	}
	
	private ArrayList<Posicao> __recAchaDestino(Posicao p1,int casas) {
		ArrayList<Posicao> res = null;
		ArrayList<Posicao> prox;
		System.out.println(p1.getCoordenadas().toString());
		if(casas>0) {			
			res = new ArrayList<Posicao>();
			for(Posicao p : p1.getPosicoesProximas()) {
				prox = __recAchaDestino(p,casas--);
				System.out.println(p.getCoordenadas().toString());
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
