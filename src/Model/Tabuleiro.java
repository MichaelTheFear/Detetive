package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Tabuleiro {
	// aquele desgin pattern de unico la
	private Posicao posicoes[][];
	static int numPorLinha = 8;
	
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
	
	protected ArrayList<Posicao> achaDesitnosFinais(int x,int y,int casas,int turno) {
		ArrayList<Posicao> res = new ArrayList<Posicao>();
		ArrayList<Posicao> aux = new ArrayList<Posicao>();
		//Helpers.printGrafo(posicoes);
		aux.addAll(__recAchaDestino(getPosEm(x,y),casas));
		System.out.println("aux "+ aux.size());
		
		for(Posicao p : aux) {
			if(p!=null) {
				
				if(p.getMudadoNoTurno()!=turno) {
					p.setMudadoNoTurno(turno);
					p.setPassouAqui(0);
				}else {
					p.addUmPassouAqui();
				}
			}
		}
		
		for(Posicao p: aux) {
			if(p.getPassouAqui()<=2 || p instanceof Comodo)
				res.add(p);
		}
		
		return res;
	}
	
	private ArrayList<Posicao> __recAchaDestino(Posicao p1,int casas) {
		ArrayList<Posicao> res = null;
		ArrayList<Posicao> prox = null;
		
		if(casas>0) {
			res = new ArrayList<Posicao>();
			for(Posicao p : p1.getPosicoesProximas()) {
				if(p!=null) {					
					res.add(p);
					prox = __recAchaDestino(p,casas-1);
					if(prox!=null) {
						res.addAll(prox);
						System.out.println()
					}
				}
			}
		}
		return res;
	}
	
	
	

}
