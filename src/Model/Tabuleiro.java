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
		//__debugPrintPosicoesGrafo();
	}
	
	protected Posicao[][] getPosicoes() {
		return posicoes;
	}
	
	protected void setPosicoes(Posicao p[][]) {
		posicoes = p;
	}
	
	protected void __debugPrintPosicoesGrafo() {
		for(Posicao[] posis: posicoes) {
			for(Posicao pos:posis) {
				System.out.print(pos.getCoordenadas().toString()+": ");
				for(Coordenadas c: pos.getPosicoesProximas()) {
					System.out.print(c.toString()+" ");
				}
				System.out.println();
			}
		}
	}
	
	
	protected void printAsMap(ArrayList<Coordenadas> coords) {
		String mapa[][] = new String[numPorLinha][numPorLinha];
		for(int i = 0;i<numPorLinha;i++) {
			for(int j=0; j<numPorLinha;j++) {
				mapa[i][j] = "_";
			}
		}
		for(Coordenadas c: coords) {
			mapa[c.getX()][c.getY()] = "0";
		}
		
		for(String linha[] : mapa) {
			for(String item : linha) {
				System.out.print(item+" ");
			}
			System.out.println();
		}
	}
	
	/*
	
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
						System.out.println();
					}
				}
			}
		}
		return res;
	}
	
	*/ 
	
	private Posicao getPosicao(int x, int y) {
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
	

}
