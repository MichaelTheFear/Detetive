package Model;

import static org.junit.Assert.assertTrue;

import Util.Personagem;

public class Helpers {
	
	//esta classe foi criada pois havia testes em duas classes de testes que precisavam do mesmo helper
	protected static Carta[] cartasGenericasHelper() {
		Carta cartas[] = new Carta[3];
		cartas[0] = new CartaArma("Corda");
		cartas[1] = new CartaLocal("Cozinha");
		cartas[2] = new CartaSuspeito("Coronel Mustarda");
		return cartas;
	}
	
	protected static Posicao[][] posicoesArrayHelper() {
		Posicao pos[][] = new Posicao[Tabuleiro.numPorLinha][Tabuleiro.numPorLinha];
		for(int i = 0, j;i<Tabuleiro.numPorLinha;i++) {
			for(j = 0;j<Tabuleiro.numPorLinha;j++) {
				pos[i][j] = new Porta(i,j);
			}
			
		}
		//printGrafo(pos);
		return pos;
	}
	
	private static int mod(int a,int b) {
		int res = a%b;
		if(res<0)
			res += b;
		return res;
	}
	
	protected static Coordenadas[][][] posicoesArrayProxHelper(){
		Coordenadas posicoesAdjacentes[][][] = new Coordenadas[Tabuleiro.numPorLinha][Tabuleiro.numPorLinha][4];
		Coordenadas mapa[][] = new Coordenadas[Tabuleiro.numPorLinha][Tabuleiro.numPorLinha];
		for(int i =0;i<Tabuleiro.numPorLinha;i++) {
			for(int j = 0 ;j<Tabuleiro.numPorLinha;j++) {
				mapa[i][j] = new Coordenadas(i,j);	
			}	
		}
				
		for(int i =0;i<Tabuleiro.numPorLinha;i++) {
			for(int j = 0 ;j<Tabuleiro.numPorLinha;j++) {
				posicoesAdjacentes[i][j][0] = mapa[i][(j+1)%Tabuleiro.numPorLinha];
				posicoesAdjacentes[i][j][1] = mapa[i][mod(j-1,Tabuleiro.numPorLinha)];
				posicoesAdjacentes[i][j][2] = mapa[(i+1)%Tabuleiro.numPorLinha][j];
				posicoesAdjacentes[i][j][3] = mapa[mod(i-1,Tabuleiro.numPorLinha)][j];
			}
		}
		return posicoesAdjacentes;
	}
	
	
	protected static Jogador jogadorGenericoHelper() {
		Carta cartas[] = cartasGenericasHelper();
		Posicao p = new Porta(10,10);
		Jogador j = new Jogador(Personagem.Green,cartas);
		return j;
	}
	protected static void posicaoHelper(int x, int y, String msg, Jogador j) {
		Posicao p = j.getPos();
		Posicao esperado = new Porta(x,y);
		assertTrue(msg,esperado.equals(p));
	}
	
	protected static Tabuleiro initCaminhoHelpers() {
		Tabuleiro t = new Tabuleiro(posicoesArrayHelper());
		t.initCaminhos(posicoesArrayProxHelper());
		return t;
	}
	
}
