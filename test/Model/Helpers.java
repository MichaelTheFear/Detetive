package Model;

import static org.junit.Assert.assertTrue;

public class Helpers {
	
	//esta classe foi criada pois havia testes em duas classes de testes que precisavam do mesmo helper
	protected static Carta[] cartasGenericasHelper() {
		Carta cartas[] = new Carta[3];
		cartas[0] = new CartaArma("Corda");
		cartas[1] = new CartaLocal("Cozinha");
		cartas[2] = new CartaSuspeito("Coronel Mustarda");
		return cartas;
	}
	
	protected static Posicao[] posicoesArrayHelper() {
		Posicao pos[] = new Posicao[Tabuleiro.size];
		for(int i = 0, j;i<Tabuleiro.numPorLinha;i++) {
			for(j = 0;j<Tabuleiro.numPorLinha;j++) {
				pos[j+i*Tabuleiro.numPorLinha] = new Quadrado(i,j);
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
	
	protected static Posicao[][] posicoesArrayProxHelper(){
		Posicao posicoesAdjacentes[][] = new Posicao[Tabuleiro.size][4];
		Posicao aux[] = posicoesArrayHelper();
		for(int i =0;i<Tabuleiro.size;i++) {
			posicoesAdjacentes[i][0] = aux[mod(i-2,Tabuleiro.size)];
			posicoesAdjacentes[i][1] = aux[mod(i-1,Tabuleiro.size)];
			posicoesAdjacentes[i][2] = aux[(i+1)%Tabuleiro.size];
			posicoesAdjacentes[i][3] = aux[(i+2)%Tabuleiro.size];
		}
		return posicoesAdjacentes;
	}
	
	protected static Jogador jogadorGenericoHelper() {
		Carta cartas[] = cartasGenericasHelper();
		Posicao p = new Quadrado(10,10);
		Jogador j = new Jogador("Reverendo Green",cartas,p);
		return j;
	}
	
	protected static void posicaoHelper(int x, int y, String msg, Jogador j) {
		Posicao p = j.getPos();
		Posicao esperado = new Quadrado(x,y);
		assertTrue(msg,esperado.equals(p));
	}
	
	protected static Tabuleiro initCaminhoHelpers() {
		Tabuleiro t = new Tabuleiro(posicoesArrayHelper());
		t.initCaminhos(posicoesArrayProxHelper());
		return t;
	}
	
	
	protected static void printGrafo(Posicao posicoes[]) {
		System.out.println("Grafo: ");
		for(Posicao pos: posicoes) {
			Posicao posProx[] = pos.getPosicoesProximas();
			System.out.print("("+pos.getCoordenadas()[0]+ ","+pos.getCoordenadas()[1] + ") = [");
			if(posProx!=null && posProx[0]!=null) {
				for(Posicao pOut:posProx) {
					System.out.print(pOut.toString());
				}
			}
			System.out.println("]");
		}
	}
}
