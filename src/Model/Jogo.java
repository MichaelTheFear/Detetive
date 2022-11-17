package Model;

import java.util.ArrayList;
import java.util.Random;

import Util.*;

class Jogo {
	static int NUM_MAX_DADO = 6;

	Tabuleiro t;
	Carta[] todasCartas = new Carta[] { new CartaArma(Armas.Cano.toString()), new CartaArma(Armas.Castical.toString()),
			new CartaArma(Armas.ChaveInglesa.toString()), new CartaArma(Armas.Corda.toString()),
			new CartaArma(Armas.Faca.toString()), new CartaArma(Armas.Revolver.toString()),
			new CartaLocal(Comodos.Biblioteca.toString()), new CartaLocal(Comodos.Cozinha.toString()),
			new CartaLocal(Comodos.Entrada.toString()), new CartaLocal(Comodos.Escritorio.toString()),
			new CartaLocal(Comodos.JardimInverno.toString()), new CartaLocal(Comodos.SalaDeEstar.toString()),
			new CartaLocal(Comodos.SalaDeJantar.toString()), new CartaLocal(Comodos.SalaDeMusica.toString()),
			new CartaLocal(Comodos.SalaoDeJogos.toString()), new CartaSuspeito(Personagem.Green.toString()),
			new CartaSuspeito(Personagem.Mustard.toString()), new CartaSuspeito(Personagem.Peacock.toString()),
			new CartaSuspeito(Personagem.Plum.toString()), new CartaSuspeito(Personagem.Scarlet.toString()),
			new CartaSuspeito(Personagem.White.toString()) };
	Carta[] cartasAssassino = new Carta[3];
	ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	ArrayList<Posicao> posCozinha = new ArrayList<Posicao>();
	ArrayList<Posicao> posSalaJantar = new ArrayList<Posicao>();
	ArrayList<Posicao> posSalaEstar = new ArrayList<Posicao>();
	ArrayList<Posicao> posEntrada = new ArrayList<Posicao>();
	ArrayList<Posicao> posEscritorio = new ArrayList<Posicao>();
	ArrayList<Posicao> posSalaMusica = new ArrayList<Posicao>();
	ArrayList<Posicao> posJardimInverno = new ArrayList<Posicao>();
	ArrayList<Posicao> posSalaoJogos = new ArrayList<Posicao>();
	ArrayList<Posicao> posBiblioteca = new ArrayList<Posicao>();
	ArrayList<Posicao> posCorredor = new ArrayList<Posicao>();
	int qtdEmJogo = 0;
	int vezDe = 0;
	int numTurno = 0;
	int dados[] = new int[2];
	Random gerador = new Random();

	Jogo() {
		setupTabuleiro();
	}

	void setupTabuleiro() {
		Posicao[][] posicoesTabuleiro = new Posicao[28][28]; // Tamanho do tabuleiro 28 x 28 quadrados

		System.out.println("Inicializando Posicoes Cozinha");
		for (int i = 2; i < 8; i++) {
			for (int j = 2; j < 8; j++) {
				posicoesTabuleiro[i][j] = new Posicao(i, j);
				posCozinha.add(posicoesTabuleiro[i][j]);
			}
		}
		for (int j = 3; j < 8; j++) {
			posicoesTabuleiro[8][j] = new Posicao(8, j);
			posCozinha.add(posicoesTabuleiro[8][j]);
		}

		System.out.println("Inicializando Posicoes Sala de Jantar");
		for (int i = 12; i < 18; i++) {
			for (int j = 2; j < 10; j++) {
				posicoesTabuleiro[i][j] = new Posicao(i, j);
				posSalaJantar.add(posicoesTabuleiro[i][j]);
			}
		}
		for (int j = 3; j < 8; j++) {
			posicoesTabuleiro[11][j] = new Posicao(11, j);
			posSalaJantar.add(posicoesTabuleiro[11][j]);
		}

		System.out.println("Inicializando Posicoes Sala de Estar");
		for (int i = 21; i < 26; i++) {
			for (int j = 2; j < 9; j++) {
				posicoesTabuleiro[i][j] = new Posicao(i, j);
				posSalaEstar.add(posicoesTabuleiro[i][j]);
			}
		}
		for (int j = 2; j < 8; j++) {
			posicoesTabuleiro[26][j] = new Posicao(26, j);
			posSalaEstar.add(posicoesTabuleiro[26][j]);
		}

		System.out.println("Inicializando Posicoes Entrada");
		for (int i = 20; i < 26; i++) {
			for (int j = 11; j < 17; j++) {
				posicoesTabuleiro[i][j] = new Posicao(i, j);
				posEntrada.add(posicoesTabuleiro[i][j]);
			}
		}
		for (int j = 12; j < 16; j++) {
			posicoesTabuleiro[26][j] = new Posicao(26, j);
			posEntrada.add(posicoesTabuleiro[26][j]);
		}

		System.out.println("Inicializando Posicoes Escritorio");
		for (int i = 23; i < 26; i++) {
			for (int j = 19; j < 26; j++) {
				posicoesTabuleiro[i][j] = new Posicao(i, j);
				posEscritorio.add(posicoesTabuleiro[i][j]);
			}
		}
		for (int j = 20; j < 26; j++) {
			posicoesTabuleiro[26][j] = new Posicao(26, j);
			posEscritorio.add(posicoesTabuleiro[26][j]);
		}

		System.out.println("Inicializando Posicoes Sala de Musica");
		for (int i = 4; i < 10; i++) {
			for (int j = 10; j < 18; j++) {
				posicoesTabuleiro[i][j] = new Posicao(i, j);
				posSalaMusica.add(posicoesTabuleiro[i][j]);
			}
		}
		for (int j = 12; j < 16; j++) {
			posicoesTabuleiro[3][j] = new Posicao(3, j);
			posSalaMusica.add(posicoesTabuleiro[3][j]);
		}

		System.out.println("Inicializando Posicoes Jardim de Inverno");
		for (int i = 3; i < 7; i++) {
			for (int j = 20; j < 26; j++) {
				posicoesTabuleiro[i][j] = new Posicao(i, j);
				posJardimInverno.add(posicoesTabuleiro[i][j]);
			}
		}
		for (int j = 21; j < 25; j++) {
			posicoesTabuleiro[7][j] = new Posicao(7, j);
			posJardimInverno.add(posicoesTabuleiro[7][j]);
		}

		System.out.println("Inicializando Posicoes Salao de Jogos");
		for (int i = 10; i < 15; i++) {
			for (int j = 20; j < 26; j++) {
				posicoesTabuleiro[i][j] = new Posicao(i, j);
				posSalaoJogos.add(posicoesTabuleiro[i][j]);
			}
		}

		System.out.println("Inicializando Posicoes Biblioteca");
		for (int i = 16; i < 21; i++) {
			for (int j = 20; j < 25; j++) {
				posicoesTabuleiro[i][j] = new Posicao(i, j);
				posBiblioteca.add(posicoesTabuleiro[i][j]);
			}
		}
		for (int i = 17; i < 20; i++) {
			posicoesTabuleiro[i][19] = new Posicao(i, 19);
			posBiblioteca.add(posicoesTabuleiro[i][19]);
			posicoesTabuleiro[i][25] = new Posicao(i, 25);
			posBiblioteca.add(posicoesTabuleiro[i][25]);
		}

		System.out.println("Inicializando Posicoes Corredor");
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
		System.out.println("Inicializando Posicoes Jogadores");
		//Scarlet
		posicoesTabuleiro[26][9] = new Posicao(26, 9);
		posCorredor.add(posicoesTabuleiro[26][9]);
		//Mustard
		posicoesTabuleiro[19][2] = new Posicao(19, 2);
		posCorredor.add(posicoesTabuleiro[19][2]);
		//White
		posicoesTabuleiro[2][11] = new Posicao(2, 11);
		posCorredor.add(posicoesTabuleiro[2][11]);
		//Green
		posicoesTabuleiro[2][16] = new Posicao(2, 16);
		posCorredor.add(posicoesTabuleiro[2][16]);
		//Peacock
		posicoesTabuleiro[8][25] = new Posicao(8, 25);
		posCorredor.add(posicoesTabuleiro[8][25]);
		//Plum
		posicoesTabuleiro[21][25] = new Posicao(21, 25);
		posCorredor.add(posicoesTabuleiro[21][25]);

		setupPosicoesProximas(posicoesTabuleiro);
		this.t = new Tabuleiro(posicoesTabuleiro);
	}

	private void setupPosicoesProximas(Posicao[][] posicoesTabuleiro) {
		System.out.println("Inicializando Posicoes Proximas...");
		posicoesTabuleiro[9][6].setPosicoesProximas(posCozinha);
		System.out.println("Porta Cozinha: OK");

		posicoesTabuleiro[7][9].setPosicoesProximas(posSalaMusica);
		posicoesTabuleiro[7][18].setPosicoesProximas(posSalaMusica);
		posicoesTabuleiro[10][11].setPosicoesProximas(posSalaMusica);
		posicoesTabuleiro[10][16].setPosicoesProximas(posSalaMusica);

		posicoesTabuleiro[7][20].setPosicoesProximas(posJardimInverno);

		posicoesTabuleiro[14][10].setPosicoesProximas(posSalaJantar);
		posicoesTabuleiro[18][8].setPosicoesProximas(posSalaJantar);

		posicoesTabuleiro[11][19].setPosicoesProximas(posSalaoJogos);
		posicoesTabuleiro[15][24].setPosicoesProximas(posSalaoJogos);

		posicoesTabuleiro[18][18].setPosicoesProximas(posBiblioteca);
		posicoesTabuleiro[15][22].setPosicoesProximas(posBiblioteca);

		posicoesTabuleiro[20][8].setPosicoesProximas(posSalaEstar);

		posicoesTabuleiro[19][13].setPosicoesProximas(posEntrada);
		posicoesTabuleiro[19][14].setPosicoesProximas(posEntrada);
		posicoesTabuleiro[22][17].setPosicoesProximas(posEntrada);

		posicoesTabuleiro[22][19].setPosicoesProximas(posEscritorio);

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
	}

	void setupJogadores(ArrayList<Personagem> players) {
		for (Personagem susPersonagem : Personagem.values()) {
			for (Personagem p : players) {
				if (susPersonagem == p) {
					jogadores.add(new Jogador(p, false, t));
					qtdEmJogo++;
					break;
				}
			}
			if (jogadores.isEmpty()) {
				jogadores.add(new Jogador(susPersonagem, true, t));
			}
			else if (jogadores.get(jogadores.size() - 1).getPersonagem() != susPersonagem) {
				jogadores.add(new Jogador(susPersonagem, true, t));
			}
		}

		for (int i = 0; i < jogadores.size(); i++) {
			if (!jogadores.get(i).ehNpc()) {
				vezDe = i;
				break;
			}
		}
	}

	void setCartasAssasino(Carta[] cartas) {
		cartasAssassino[0] = todasCartas[gerador.nextInt(6)]; // De 0 a 5 estão as Cartas de Arma
		cartasAssassino[1] = todasCartas[gerador.nextInt(9) + 6]; // Gera-se nums de 0 a 8 e incrementa 6 para ser de 6 a 14 onde estão as Cartas de Local
		cartasAssassino[2] = todasCartas[gerador.nextInt(6) + 15]; // Gera-se nums de 0 a 5 e incrementa 15 para ser de 15 a 20 onde estão as Cartas de Suspeito
	}

	private ArrayList<Carta> getCartasEmJogo() {
		ArrayList<Carta> cartasEmJogo = new ArrayList<Carta>();
		for (int i = 0; i < todasCartas.length; i++) {
			if (i < 6) {
				if (todasCartas[i].getNome().compareTo(cartasAssassino[0].getNome()) == 0) {
					continue;
				}
			}
			else if (i < 15) {
				if (todasCartas[i].getNome().compareTo(cartasAssassino[1].getNome()) == 0) {
					continue;
				}
			}
			else {
				if (todasCartas[i].getNome().compareTo(cartasAssassino[3].getNome()) == 0) {
					continue;
				}
			}
			cartasEmJogo.add(todasCartas[i]);
		}
		return cartasEmJogo;
	}

	void distribuiCartas() {
		ArrayList<Carta> cartasDistribuir = getCartasEmJogo();
		int numCartasPessoa = cartasDistribuir.size() / qtdEmJogo; // Qtd de cartas que cada um tem = todas as cartas menos do assassino / qtd de jogadores em jogo
		int cont = 0;

		for (int i = 1; i < jogadores.size(); i++) {
			if (jogadores.get(i).ehNpc()) {
				continue;
			}

			ArrayList<Carta> cartasIniciais = new ArrayList<Carta>();
			for (int j = 0; j < numCartasPessoa; j++) {
				Carta carta = cartasDistribuir.get(gerador.nextInt(cartasDistribuir.size()));
				cartasIniciais.add(carta);
				cartasDistribuir.remove(carta);
			}
			jogadores.get(i).setCartasIniciais(cartasIniciais);
		}

		while (!cartasDistribuir.isEmpty()) { // Caso sobrem cartas
			if (cont == jogadores.size()) {
				cont = 0;
			}

			if (!jogadores.get(cont).ehNpc()) { // Se não for NPC
				jogadores.get(cont).getCartasIniciais().add(cartasDistribuir.get(0)); // Adiciona uma carta que sobrou as Cartas Iniciais
				cartasDistribuir.remove(0);
			}
			cont++;
		}
	}

	void rolarDado() {
		dados[0] = gerador.nextInt(6) + 1; // Gera-se nums de 0 a 5 e incrementa 1 para ser de 1 a 6
		dados[1] = gerador.nextInt(6) + 1;
	}

	int[] getDados() {
		return dados;
	}

	void setDados(int[] dados) {
		this.dados = dados;
	}

	private int proxTurno(int turno) {
		do {
			turno++;
			if (turno == jogadores.size())
				turno = 0;
		}
		while (jogadores.get(turno).ehNpc());
		return turno;
	}

	void passaVez() {
		vezDe = proxTurno(vezDe);
		//t.houseKeepingTabuleiro();
	}

	void mover(int[] posicao) throws ExceptionLugarNaoPermitido {
		Posicao escolhida = t.getPosicaoAt(posicao[0], posicao[1]);
		System.out.print("Posicao Clicada: ");
		System.out.println(escolhida.toString());
		for (Posicao pos : jogadores.get(vezDe).getPos().getPosicoesProximas()) {
			System.out.print("Posicao proxima: ");
			System.out.println(pos.toString());
			if (pos.equals(escolhida)) {
				if (pos.getPassouAqui()) {
					throw new ExceptionLugarNaoPermitido("Já passou aqui");
				}
				jogadores.get(vezDe).getPos().setPassouAqui(true);
				jogadores.get(vezDe).getPos().setJogadorAqui(false);
				pos.setJogadorAqui(true);
				jogadores.get(vezDe).setPos(pos);
				return;
			}
		}
		throw new ExceptionLugarNaoPermitido("Não é adjacente");
	}

	boolean acusar(Carta acusacao[]) {
		// talvez mudar td para treeSet
		for (int i = 0; i < 3; i++) {
			if (!acusacao[0].equals(cartasAssassino[i]) && !acusacao[1].equals(cartasAssassino[i])
					&& !acusacao[2].equals(cartasAssassino[i])) {
				return false;
			}

		}
		return true;

	}

	String darPalpite(Carta palpites[]) {
		int proxJogador = proxTurno(vezDe);
		while (proxJogador != vezDe) {
			Carta c = jogadores.get(proxJogador).temCarta(palpites);
			if (c != null) {
				jogadores.get(vezDe).addCartasVista(c);
				return c.getNome();
			}
			proxJogador = proxTurno(proxJogador);
		}
		return "nenhum";
	}
}
