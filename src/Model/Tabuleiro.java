package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import Util.Comodos;

class Tabuleiro {
	// aquele desgin pattern de unico la
	private Posicao posicoes[][];
	static int numPorLinha = 40;
	ArrayList<Comodo> posCozinha = new ArrayList<Comodo>();
	ArrayList<Comodo> posSalaJantar = new ArrayList<Comodo>();
	ArrayList<Comodo> posSalaEstar = new ArrayList<Comodo>();
	ArrayList<Comodo> posEntrada = new ArrayList<Comodo>();
	ArrayList<Comodo> posEscritorio = new ArrayList<Comodo>(); 
	ArrayList<Comodo> posSalaMusica = new ArrayList<Comodo>();
	ArrayList<Comodo> posJardimInverno = new ArrayList<Comodo>();
	ArrayList<Comodo> posSalaoJogos = new ArrayList<Comodo>();
	ArrayList<Comodo> posBiblioteca = new ArrayList<Comodo>();
	ArrayList<Posicao> posCorredor = new ArrayList<Posicao>();

	Tabuleiro() {}
	
	Posicao[][] getPosicoes() {
		return posicoes;
	}

	void setPosicoes(Posicao p[][]) {
		posicoes = p;
	}

	Posicao getPosicaoAt(int linha, int coluna) {
		return posicoes[linha][coluna];
	}

	void houseKeepingTabuleiro() {
		for (Posicao arrayPos[] : posicoes) {
			for (Posicao pos : arrayPos) {
				if(pos == null) {
					continue;
				}
				pos.setPassouAqui(false);
			}
		}
	}
	
	 Posicao[][] setupTabuleiro() {
		Posicao[][] posicoesTabuleiro = new Posicao[28][28]; // Tamanho do tabuleiro 28 x 28 quadrados

		
		for (int i = 2; i < 8; i++) {
			for (int j = 2; j < 8; j++) {
				posicoesTabuleiro[i][j] = new Comodo(i, j,Comodos.Cozinha);
				posCozinha.add((Comodo) posicoesTabuleiro[i][j]);
			}
		}
		for (int j = 3; j < 8; j++) {
			posicoesTabuleiro[8][j] = new Comodo(8, j,Comodos.Cozinha);
			posCozinha.add((Comodo) posicoesTabuleiro[8][j]);
		}

		
		for (int i = 12; i < 18; i++) {
			for (int j = 2; j < 10; j++) {
				posicoesTabuleiro[i][j] = new Comodo(i, j,Comodos.SalaDeJantar);
				posSalaJantar.add((Comodo) posicoesTabuleiro[i][j]);
			}
		}
		for (int j = 3; j < 8; j++) {
			posicoesTabuleiro[11][j] = new Comodo(11, j,Comodos.SalaDeJantar);
			posSalaJantar.add((Comodo) posicoesTabuleiro[11][j]);
		}

		
		for (int i = 21; i < 26; i++) {
			for (int j = 2; j < 9; j++) {
				posicoesTabuleiro[i][j] = new Comodo(i, j,Comodos.SalaDeEstar);
				posSalaEstar.add((Comodo) posicoesTabuleiro[i][j]);
			}
		}
		for (int j = 2; j < 8; j++) {
			posicoesTabuleiro[26][j] = new Comodo(26, j,Comodos.SalaDeEstar);
			posSalaEstar.add((Comodo) posicoesTabuleiro[26][j]);
		}

		
		for (int i = 20; i < 26; i++) {
			for (int j = 11; j < 17; j++) {
				posicoesTabuleiro[i][j] = new Comodo(i, j,Comodos.Entrada);
				posEntrada.add((Comodo) posicoesTabuleiro[i][j]);
			}
		}
		for (int j = 12; j < 16; j++) {
			posicoesTabuleiro[26][j] = new Comodo(26, j,Comodos.Entrada);
			posEntrada.add((Comodo) posicoesTabuleiro[26][j]);
		}

		
		for (int i = 23; i < 26; i++) {
			for (int j = 19; j < 26; j++) {
				posicoesTabuleiro[i][j] = new Comodo(i, j,Comodos.Escritorio);
				posEscritorio.add((Comodo) posicoesTabuleiro[i][j]);
			}
		}
		for (int j = 20; j < 26; j++) {
			posicoesTabuleiro[26][j] = new Comodo(26, j,Comodos.Escritorio);
			posEscritorio.add((Comodo) posicoesTabuleiro[26][j]);
		}

		
		for (int i = 4; i < 10; i++) {
			for (int j = 10; j < 18; j++) {
				posicoesTabuleiro[i][j] = new Comodo(i, j,Comodos.SalaDeMusica);
				posSalaMusica.add((Comodo) posicoesTabuleiro[i][j]);
			}
		}
		for (int j = 12; j < 16; j++) {
			posicoesTabuleiro[3][j] = new Comodo(3, j,Comodos.SalaDeMusica);
			posSalaMusica.add((Comodo) posicoesTabuleiro[3][j]);
		}

		
		for (int i = 3; i < 7; i++) {
			for (int j = 20; j < 26; j++) {
				posicoesTabuleiro[i][j] = new Comodo(i, j,Comodos.JardimInverno);
				posJardimInverno.add((Comodo) posicoesTabuleiro[i][j]);
			}
		}
		for (int j = 21; j < 25; j++) {
			posicoesTabuleiro[7][j] = new Comodo(7, j,Comodos.JardimInverno);
			posJardimInverno.add((Comodo) posicoesTabuleiro[7][j]);
		}

		
		for (int i = 10; i < 15; i++) {
			for (int j = 20; j < 26; j++) {
				posicoesTabuleiro[i][j] = new Comodo(i, j,Comodos.SalaoDeJogos);
				posSalaoJogos.add((Comodo) posicoesTabuleiro[i][j]);
			}
		}

		
		for (int i = 16; i < 21; i++) {
			for (int j = 20; j < 25; j++) {
				posicoesTabuleiro[i][j] = new Comodo(i, j,Comodos.Biblioteca);
				posBiblioteca.add((Comodo) posicoesTabuleiro[i][j]);
			}
		}
		for (int i = 17; i < 20; i++) {
			posicoesTabuleiro[i][19] = new Comodo(i, 19,Comodos.Biblioteca);
			posBiblioteca.add((Comodo) posicoesTabuleiro[i][19]);
			posicoesTabuleiro[i][25] = new Comodo(i, 25,Comodos.Biblioteca);
			posBiblioteca.add((Comodo) posicoesTabuleiro[i][25]);
		}

		
		posicoesTabuleiro[3][9] = new Posicao(3, 9);
		posCorredor.add(posicoesTabuleiro[3][9]);
		posicoesTabuleiro[3][10] = new Posicao(3, 10);
		posCorredor.add(posicoesTabuleiro[3][10]);
		posicoesTabuleiro[3][11] = new Posicao(3, 11);
		posCorredor.add(posicoesTabuleiro[3][11]);
		posicoesTabuleiro[3][16] = new Posicao(3, 16);
		posCorredor.add(posicoesTabuleiro[3][16]);
		posicoesTabuleiro[3][17] = new Posicao(3, 17);
		posCorredor.add(posicoesTabuleiro[3][17]);
		posicoesTabuleiro[3][18] = new Posicao(3, 18);
		posCorredor.add(posicoesTabuleiro[3][18]);

		for (int i = 4; i < 11; i++) {
			for (int j = 8; j < 10; j++) {
				posicoesTabuleiro[i][j] = new Posicao(i, j);
				posCorredor.add(posicoesTabuleiro[i][j]);
			}
			for (int k = 18; k < 20; k++) {
				posicoesTabuleiro[i][k] = new Posicao(i, k);
				posCorredor.add(posicoesTabuleiro[i][k]);
			}
		}

		posicoesTabuleiro[9][2] = new Posicao(9, 2);
		posCorredor.add(posicoesTabuleiro[9][2]);
		for (int i = 9; i < 11; i++) {
			for (int j = 3; j < 8; j++) {
				posicoesTabuleiro[i][j] = new Posicao(i, j);
				posCorredor.add(posicoesTabuleiro[i][j]);
			}
		}

		posicoesTabuleiro[7][20] = new Posicao(7, 20);
		posCorredor.add(posicoesTabuleiro[7][20]);
		for (int i = 8; i < 10; i++) {
			for (int j = 20; j < 25; j++) {
				posicoesTabuleiro[i][j] = new Posicao(i, j);
				posCorredor.add(posicoesTabuleiro[i][j]);
			}
		}

		for (int j = 10; j < 18; j++) {
			posicoesTabuleiro[10][j] = new Posicao(10, j);
			posCorredor.add(posicoesTabuleiro[10][j]);
		}
		for (int j = 7; j < 20; j++) {
			posicoesTabuleiro[11][j] = new Posicao(11, j);
			posCorredor.add(posicoesTabuleiro[11][j]);
		}

		for (int i = 12; i < 20; i++) {
			for (int j = 10; j < 12; j++) {
				posicoesTabuleiro[i][j] = new Posicao(i, j);
				posCorredor.add(posicoesTabuleiro[i][j]);
			}
			for (int k = 17; k < 19; k++) {
				posicoesTabuleiro[i][k] = new Posicao(i, k);
				posCorredor.add(posicoesTabuleiro[i][k]);
			}
		}
		for (int i = 12; i < 17; i++) {
			posicoesTabuleiro[i][19] = new Posicao(i, 19);
			posCorredor.add(posicoesTabuleiro[i][19]);
		}

		for (int j = 20; j < 25; j++) {
			posicoesTabuleiro[15][j] = new Posicao(15, j);
			posCorredor.add(posicoesTabuleiro[15][j]);
		}

		for (int j = 12; j < 17; j++) {
			posicoesTabuleiro[19][j] = new Posicao(19, j);
			posCorredor.add(posicoesTabuleiro[19][j]);
		}

		for (int i = 18; i < 21; i++) {
			for (int j = 3; j < 10; j++) {
				posicoesTabuleiro[i][j] = new Posicao(i, j);
				posCorredor.add(posicoesTabuleiro[i][j]);
			}
		}
		posicoesTabuleiro[20][10] = new Posicao(20, 10);
		posCorredor.add(posicoesTabuleiro[20][10]);

		for (int i = 21; i < 26; i++) {
			for (int j = 9; j < 11; j++) {
				posicoesTabuleiro[i][j] = new Posicao(i, j);
				posCorredor.add(posicoesTabuleiro[i][j]);
			}
		}

		for (int i = 20; i < 23; i++) {
			for (int j = 17; j < 20; j++) {
				posicoesTabuleiro[i][j] = new Posicao(i, j);
				posCorredor.add(posicoesTabuleiro[i][j]);
			}
		}
		for (int i = 23; i < 26; i++) {
			for (int j = 17; j < 19; j++) {
				posicoesTabuleiro[i][j] = new Posicao(i, j);
				posCorredor.add(posicoesTabuleiro[i][j]);
			}
		}
		for (int i = 21; i < 23; i++) {
			for (int j = 20; j < 25; j++) {
				posicoesTabuleiro[i][j] = new Posicao(i, j);
				posCorredor.add(posicoesTabuleiro[i][j]);
			}
		}
		posicoesTabuleiro[26][18] = new Posicao(26, 18);
		posCorredor.add(posicoesTabuleiro[26][18]);
		
		// Scarlet
		posicoesTabuleiro[26][9] = new Posicao(26, 9);
		posCorredor.add(posicoesTabuleiro[26][9]);
		// Mustard
		posicoesTabuleiro[19][2] = new Posicao(19, 2);
		posCorredor.add(posicoesTabuleiro[19][2]);
		// White
		posicoesTabuleiro[2][11] = new Posicao(2, 11);
		posCorredor.add(posicoesTabuleiro[2][11]);
		// Green
		posicoesTabuleiro[2][16] = new Posicao(2, 16);
		posCorredor.add(posicoesTabuleiro[2][16]);
		// Peacock
		posicoesTabuleiro[8][25] = new Posicao(8, 25);
		posCorredor.add(posicoesTabuleiro[8][25]);
		// Plum
		posicoesTabuleiro[21][25] = new Posicao(21, 25);
		posCorredor.add(posicoesTabuleiro[21][25]);

		setupPosicoesProximas(posicoesTabuleiro);
		return posicoesTabuleiro;
	}
	
	private void setupPosicoesProximas(Posicao[][] posicoesTabuleiro) {
		
		for (int i = 0; i < posCorredor.size(); i++) {
			Posicao p = posCorredor.get(i);

			int linha = p.getLinha();
			int coluna = p.getColuna();
			ArrayList<Posicao> posProx = new ArrayList<Posicao>();

			if (p.getPosicoesProximas().isEmpty()) {
				if (posCorredor.contains(posicoesTabuleiro[linha - 1][coluna])) {
					posProx.add(posicoesTabuleiro[linha - 1][coluna]);
				}
				if (posCorredor.contains(posicoesTabuleiro[linha + 1][coluna])) {
					posProx.add(posicoesTabuleiro[linha + 1][coluna]);
				}
				if (posCorredor.contains(posicoesTabuleiro[linha][coluna - 1])) {
					posProx.add(posicoesTabuleiro[linha][coluna - 1]);
				}
				if (posCorredor.contains(posicoesTabuleiro[linha][coluna + 1])) {
					posProx.add(posicoesTabuleiro[linha][coluna + 1]);
				}
				p.setPosicoesProximas(posProx);
			}
		}
		

		posicoesTabuleiro[9][6].addComodosProximos(posCozinha);

		posicoesTabuleiro[7][9].addComodosProximos(posSalaMusica);
		posicoesTabuleiro[7][18].addComodosProximos(posSalaMusica);
		posicoesTabuleiro[10][11].addComodosProximos(posSalaMusica);
		posicoesTabuleiro[10][16].addComodosProximos(posSalaMusica);

		posicoesTabuleiro[7][20].addComodosProximos(posJardimInverno);

		posicoesTabuleiro[14][10].addComodosProximos(posSalaJantar);
		posicoesTabuleiro[18][8].addComodosProximos(posSalaJantar);

		posicoesTabuleiro[11][19].addComodosProximos(posSalaoJogos);
		posicoesTabuleiro[15][24].addComodosProximos(posSalaoJogos);

		posicoesTabuleiro[18][18].addComodosProximos(posBiblioteca);
		posicoesTabuleiro[15][22].addComodosProximos(posBiblioteca);

		posicoesTabuleiro[20][8].addComodosProximos(posSalaEstar);

		posicoesTabuleiro[19][13].addComodosProximos(posEntrada);
		posicoesTabuleiro[19][14].addComodosProximos(posEntrada);
		posicoesTabuleiro[22][17].addComodosProximos(posEntrada);

		posicoesTabuleiro[22][19].addComodosProximos(posEscritorio);
		

		for (int i = 0; i < posCozinha.size(); i++) {
			Posicao p = posCozinha.get(i);
			ArrayList<Posicao> posProx = new ArrayList<Posicao>();
			posProx.add(posicoesTabuleiro[9][6]);

			p.setPosicoesProximas(posProx);
		}
		

		for (int i = 0; i < posSalaMusica.size(); i++) {
			Posicao p = posSalaMusica.get(i);
			ArrayList<Posicao> posProx = new ArrayList<Posicao>();
			posProx.add(posicoesTabuleiro[7][9]);
			posProx.add(posicoesTabuleiro[7][18]);
			posProx.add(posicoesTabuleiro[10][11]);
			posProx.add(posicoesTabuleiro[10][16]);

			p.setPosicoesProximas(posProx);
		}
		

		for (int i = 0; i < posJardimInverno.size(); i++) {
			Posicao p = posJardimInverno.get(i);
			ArrayList<Posicao> posProx = new ArrayList<Posicao>();
			posProx.add(posicoesTabuleiro[7][20]);

			p.setPosicoesProximas(posProx);
		}
		

		for (int i = 0; i < posSalaJantar.size(); i++) {
			Posicao p = posSalaJantar.get(i);
			ArrayList<Posicao> posProx = new ArrayList<Posicao>();
			posProx.add(posicoesTabuleiro[14][10]);
			posProx.add(posicoesTabuleiro[18][8]);

			p.setPosicoesProximas(posProx);
		}
		

		for (int i = 0; i < posSalaoJogos.size(); i++) {
			Posicao p = posSalaoJogos.get(i);
			ArrayList<Posicao> posProx = new ArrayList<Posicao>();
			posProx.add(posicoesTabuleiro[11][19]);
			posProx.add(posicoesTabuleiro[15][24]);

			p.setPosicoesProximas(posProx);
		}
		

		for (int i = 0; i < posBiblioteca.size(); i++) {
			Posicao p = posBiblioteca.get(i);
			ArrayList<Posicao> posProx = new ArrayList<Posicao>();
			posProx.add(posicoesTabuleiro[18][18]);
			posProx.add(posicoesTabuleiro[15][22]);

			p.setPosicoesProximas(posProx);
		}
		

		for (int i = 0; i < posSalaEstar.size(); i++) {
			Posicao p = posSalaEstar.get(i);
			ArrayList<Posicao> posProx = new ArrayList<Posicao>();
			posProx.add(posicoesTabuleiro[20][8]);

			p.setPosicoesProximas(posProx);
		}
		

		for (int i = 0; i < posEntrada.size(); i++) {
			Posicao p = posEntrada.get(i);
			ArrayList<Posicao> posProx = new ArrayList<Posicao>();
			posProx.add(posicoesTabuleiro[19][13]);
			posProx.add(posicoesTabuleiro[19][14]);
			posProx.add(posicoesTabuleiro[22][17]);

			p.setPosicoesProximas(posProx);
		}
		

		for (int i = 0; i < posEscritorio.size(); i++) {
			Posicao p = posEscritorio.get(i);
			ArrayList<Posicao> posProx = new ArrayList<Posicao>();
			posProx.add(posicoesTabuleiro[22][19]);

			p.setPosicoesProximas(posProx);
		}
		
	}
}
