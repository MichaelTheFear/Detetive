package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Util.Armas;
import Util.Comodos;
import Util.Personagem;

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
	int qtdEmJogo = 0;
	int vezDe = 0;
	int numTurno = 0;
	int dados[] = new int[2];
	Random gerador = new Random();
	ArrayList<String> blocoDeNotas = new ArrayList<String>();

	Jogo() {
		this.t = new Tabuleiro();
		t.setPosicoes(t.setupTabuleiro());
		this.setCartasAssasino();
		// this.distribuiCartas();
	}

	Jogo(File file) throws FileNotFoundException {
		List<String> infoStrings = carregaStringsDoArquivo(file);
		vezDe = Integer.parseInt(infoStrings.get(0));// le linha do vezDe
		cartasAssassino[0] = new CartaArma(infoStrings.get(1));
		cartasAssassino[1] = new CartaLocal(infoStrings.get(2));
		cartasAssassino[2] = new CartaSuspeito(infoStrings.get(3));
		for (int i = 4; i < infoStrings.size(); i++) {
			String[] s = infoStrings.get(i).split(",()");
			Jogador j = new Jogador(Personagem.valueOf(s[0]), Boolean.valueOf(s[1]), t);
			int coluna = Integer.parseInt(s[2]);
			int linha = Integer.parseInt(s[3]);
			j.setPos(new Posicao(linha, coluna));
			j.setErrouAcusacao(Boolean.valueOf(s[4]));
			j.setPodeDarPalpite(Boolean.valueOf(s[5]));
			j.setJogando(Boolean.valueOf(s[6]));

		}
	}

	List<String> carregaStringsDoArquivo(File file) throws FileNotFoundException {
		List<String> lines = new ArrayList<String>();
		Scanner scan = new Scanner(file);
		while (scan.hasNext()) {
			lines.add(scan.nextLine());
		}
		scan.close();
		return lines;
	}

	void guardaPartida(String filePath) throws IOException {
		PrintWriter writer = new PrintWriter(new FileWriter(filePath));
		writer.println(vezDe);
		for (Carta assassino : this.cartasAssassino) {
			writer.println(assassino.getNome());
		}
		for (Jogador jogador : jogadores) {
			writer.println(jogador.toString());
		}
		writer.close();
	}

	void setupJogadores(ArrayList<Personagem> players) {
		System.out.println("Aqui");
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
			} else if (jogadores.get(jogadores.size() - 1).getPersonagem() != susPersonagem) {
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

	void setCartasAssasino() {
		cartasAssassino[0] = todasCartas[gerador.nextInt(6)]; // De 0 a 5 estão as Cartas de Arma
		cartasAssassino[1] = todasCartas[gerador.nextInt(9) + 6]; // Gera-se nums de 0 a 8 e incrementa 6 para ser de 6
																	// a 14 onde estão as Cartas de Local
		cartasAssassino[2] = todasCartas[gerador.nextInt(6) + 15]; // Gera-se nums de 0 a 5 e incrementa 15 para ser de
																	// 15 a 20 onde estão as Cartas de Suspeito
		for(Carta c : cartasAssassino)
			System.out.println("Ass "+c.getNome());
	}

	private ArrayList<Carta> getCartasEmJogo() {
		ArrayList<Carta> cartasEmJogo = new ArrayList<Carta>();
		for (int i = 0; i < todasCartas.length; i++) {
			if (i < 6) {
				if (todasCartas[i].getNome().compareTo(cartasAssassino[0].getNome()) == 0) {
					continue;
				}
			} else if (i < 15) {
				if (todasCartas[i].getNome().compareTo(cartasAssassino[1].getNome()) == 0) {
					continue;
				}
			} else {
				if (todasCartas[i].getNome().compareTo(cartasAssassino[2].getNome()) == 0) {
					continue;
				}
			}
			cartasEmJogo.add(todasCartas[i]);
		}
		return cartasEmJogo;
	}

	void distribuiCartas() {
		ArrayList<Carta> cartasDistribuir = getCartasEmJogo();
		int numCartasPessoa = cartasDistribuir.size() / qtdEmJogo; // Qtd de cartas que cada um tem = todas as cartas
																	// menos do assassino / qtd de jogadores em jogo
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
				jogadores.get(cont).getCartasIniciais().add(cartasDistribuir.get(0)); // Adiciona uma carta que sobrou
																						// as Cartas Iniciais
				cartasDistribuir.remove(0);
			}
			cont++;
		}
	}

	void rolarDado() {
		dados[0] = gerador.nextInt(6) + 1; // Gera-se nums de 0 a 5 e incrementa 1 para ser de 1 a 6
		dados[1] = gerador.nextInt(6) + 1;
		jogadores.get(vezDe).setRolouDado(true);
	}

	int[] getDados() {
		return dados;
	}

	void setDados(int[] dados) {
		this.dados = dados;
		jogadores.get(vezDe).setRolouDado(true);
	}

	private int proxTurno(int turno) {
		do {
			turno++;
			if (turno == jogadores.size())
				turno = 0;
		} while (jogadores.get(turno).ehNpc());
		return turno;
	}

	void passaVez() {
		jogadores.get(vezDe).setRolouDado(false);
		vezDe = proxTurno(vezDe);
		t.houseKeepingTabuleiro();
	}

	void mover(int[] posicao) throws ExceptionLugarNaoPermitido {
		if (jogadorAtualEmComodo() != null) {
			ocupaComodo((Comodo) jogadores.get(vezDe).getPos());
		}

		Posicao escolhida = t.getPosicaoAt(posicao[0], posicao[1]);
		for (Posicao pos : jogadores.get(vezDe).getPos().getPosicoesProximas()) {
			if (pos.equals(escolhida)) {
				if (pos.getPassouAqui()) {
					throw new ExceptionLugarNaoPermitido("Já passou aqui");
				}
				if (pos.getJogadorAqui()) { // verificando se ja tem um jogador na posicao escolhida
					throw new ExceptionLugarNaoPermitido("Posi��o ocupada");
				}
				jogadores.get(vezDe).getPos().setPassouAqui(true);
				jogadores.get(vezDe).getPos().setJogadorAqui(false);
				pos.setJogadorAqui(true);
				jogadores.get(vezDe).setPos(pos);
				jogadores.get(vezDe).setPodeDarPalpite((jogadorAtualEmComodo() != null));
				return;
			}
		}
		throw new ExceptionLugarNaoPermitido("Não é adjacente");
	}

	boolean verificaPassagemSecreta() {
		if (!jogadores.get(vezDe).getRolouDado() && jogadorAtualEmComodo() != null) {
			Comodo posJogador = (Comodo) jogadores.get(vezDe).getPos();
			if (posJogador.getComodo() == Comodos.Cozinha.toString()
					|| posJogador.getComodo() == Comodos.Escritorio.toString()
					|| posJogador.getComodo() == Comodos.SalaDeEstar.toString()
					|| posJogador.getComodo() == Comodos.JardimInverno.toString())
				return true;
		}
		return false;
	}

	void moverPassagemSecreta() {
		Comodo posJogador = (Comodo) jogadores.get(vezDe).getPos();
		posJogador.setJogadorAqui(false);
		jogadores.get(vezDe).setPodeDarPalpite(true);
		
		switch(Comodos.valueOf(posJogador.getComodo())) {
			case Cozinha:
				for (Comodo posOutroComodo : t.posEscritorio) {
					if (posOutroComodo.getJogadorAqui()) {
						continue;
					} 
					posOutroComodo.setJogadorAqui(true);
					jogadores.get(vezDe).setPos(posOutroComodo);
					return;
				}
				break;
			
			case Escritorio:
				for (Comodo posOutroComodo : t.posCozinha) {
					if (posOutroComodo.getJogadorAqui()) {
						continue;
					}
					posOutroComodo.setJogadorAqui(true);
					jogadores.get(vezDe).setPos(posOutroComodo);
					return;
				}
				break;
				
			case SalaDeEstar:
				for (Comodo posOutroComodo : t.posJardimInverno) {
					if (posOutroComodo.getJogadorAqui()) {
						continue;
					}
					posOutroComodo.setJogadorAqui(true);
					jogadores.get(vezDe).setPos(posOutroComodo);
					return;
				}
				break;
					
			case JardimInverno:
				for (Comodo posOutroComodo : t.posSalaEstar) {
					if (posOutroComodo.getJogadorAqui()) {
						continue;
					}
					posOutroComodo.setJogadorAqui(true);
					jogadores.get(vezDe).setPos(posOutroComodo);
					return;
				}
				break;
				
			default:
				System.out.println("Erro ao usar Passagem Secreta");
				break;
		}
	}

	public String jogadorAtualEmComodo() {
		Posicao pos = jogadores.get(vezDe).getPos();
		if (pos instanceof Comodo) {
			Comodo comodo = (Comodo) pos;
			return comodo.getComodo();
		}
		return null;
	}

	private void ocupaComodo(Comodo pos) {
		switch(Comodos.valueOf(pos.getComodo())) {
			case Cozinha:
				for (Comodo posComodo : t.posCozinha) {
					posComodo.setPassouAqui(true);
				}
				break;
			
			case SalaDeJantar:
				for (Comodo posComodo : t.posSalaJantar) {
					posComodo.setPassouAqui(true);
				}
				break;
				
			case SalaDeEstar:
				for (Comodo posComodo : t.posSalaEstar) {
					posComodo.setPassouAqui(true);
				}
				break;
				
			case Entrada:
				for (Comodo posComodo : t.posEntrada) {
					posComodo.setPassouAqui(true);
				}
				break;
				
			case Escritorio:
				for (Comodo posComodo : t.posEscritorio) {
					posComodo.setPassouAqui(true);
				}
				break;
				
			case SalaDeMusica:
				for (Comodo posComodo : t.posSalaMusica) {
					posComodo.setPassouAqui(true);
				}
				break;
				
			case JardimInverno:
				for (Comodo posComodo : t.posJardimInverno) {
					posComodo.setPassouAqui(true);
				}
				break;
				
			case SalaoDeJogos:
				for (Comodo posComodo : t.posSalaoJogos) {
					posComodo.setPassouAqui(true);
				}
				break;
				
			case Biblioteca:
				for (Comodo posComodo : t.posBiblioteca) {
					posComodo.setPassouAqui(true);
				}
				break;
		}
	}

	boolean acusar(String cartasAcusacao[]) { // agora recebe string
		// talvez mudar td para treeSet
		for (int i = 0; i < 3; i++) { // compara o nome das cartas do assassino
			if (!cartasAcusacao[0].equals(cartasAssassino[i].getNome())
					&& !cartasAcusacao[1].equals(cartasAssassino[i].getNome())
					&& !cartasAcusacao[2].equals(cartasAssassino[i].getNome())) {
				jogadores.get(vezDe).setErrouAcusacao(true); // o acusador errou
				return false;
			}

		}
		return true;

	}

	String darPalpite(String palpites[]) { // aqui so mudou o parametro, alterei a temCarta (em jogador) para funcionar
		int proxJogador = proxTurno(vezDe);
		jogadores.get(vezDe).setPodeDarPalpite(false);
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

	int[] moveComPalpite(String per, String comodo) { // move jogador do palpite para comodo do palpite
		Comodos c = Comodos.valueOf(comodo);
		ArrayList<Comodo> posComodo;
		switch (c) {
		case Biblioteca:
			posComodo = t.posBiblioteca;
			break;
		case Cozinha:
			posComodo = t.posCozinha;
			break;
		case Entrada:
			posComodo = t.posEntrada;
			break;
		case Escritorio:
			posComodo = t.posEscritorio;
			break;
		case JardimInverno:
			posComodo = t.posJardimInverno;
			break;
		case SalaDeEstar:
			posComodo = t.posSalaEstar;
			break;
		case SalaDeJantar:
			posComodo = t.posSalaJantar;
			break;
		case SalaDeMusica:
			posComodo = t.posSalaMusica;
			break;
		case SalaoDeJogos:
			posComodo = t.posSalaoJogos;
			break;
		default: // gambiarra ; posComodo tinha q ser inicializada se nao da ruim (faco direito
					// depois)
			posComodo = null;
			break;
		}
		for (Posicao p : posComodo) { // coloca o jogador do palpite em uma posicao qualquer livre do comodo do
										// palpite
			if (!p.getJogadorAqui()) {
				for (Jogador j : jogadores) {
					if (j.getPersonagem().equals(Personagem.valueOf(per))) {
						j.getPos().setJogadorAqui(false);
						p.setJogadorAqui(true);
						j.setPos(p);
						j.setPodeDarPalpite(true);
						int[] pos = new int[2];
						pos[0] = p.getLinha();
						pos[1] = p.getColuna();
						return pos;
					}
				}
			}
		}
		return null;
	}

	boolean getPodeDarPalpite() {
		return jogadores.get(vezDe).getPodeDarPalpite();
	}

	boolean getErrouAcusao() {
		return jogadores.get(vezDe).getErrouAcusacao();
	}

	boolean getErrouAcusaoAll() {
		for (Jogador jog : jogadores) {
			if (!jog.ehNpc() && !jog.getErrouAcusacao()) {
				return false;
			}
		}
		return true;
	}

	ArrayList<String> cartasParaString(List<Carta> cartas) { // transforma array de cartas para array de strings
		ArrayList<String> str = new ArrayList<String>();
		for (Carta c : cartas) {
			str.add(c.getNome());
		}
		return str;
	}

}
