package Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import Util.Personagem;

class Jogador {
	private List<Carta> cartasVistas = new ArrayList<Carta>();
	private Personagem personagem;
	private boolean podeDarPalpite;
	private boolean errouAcusacao;
	private List<Carta> cartasIniciais = new ArrayList<Carta>();
	private Posicao pos;
	private boolean jogando;
	private boolean npc;
	private boolean rolouDado;

	Jogador(Personagem personagem, boolean ehNpc, Tabuleiro t) {
		this.personagem = personagem;
		switch (this.personagem) {
		case Scarlet:
			this.pos = t.getPosicaoAt(26, 9);
			this.pos.setJogadorAqui(true);
			break;

		case Mustard:
			this.pos = t.getPosicaoAt(19, 2);
			this.pos.setJogadorAqui(true);
			break;

		case White:
			this.pos = t.getPosicaoAt(2, 11);
			this.pos.setJogadorAqui(true);
			break;

		case Green:
			this.pos = t.getPosicaoAt(2, 16);
			this.pos.setJogadorAqui(true);
			break;

		case Peacock:
			this.pos = t.getPosicaoAt(8, 25);
			this.pos.setJogadorAqui(true);
			break;

		case Plum:
			this.pos = t.getPosicaoAt(21, 25);
			this.pos.setJogadorAqui(true);
			break;

		}
		this.jogando = false;
		this.npc = ehNpc;
		this.podeDarPalpite = false;
		this.rolouDado = false;
	}

	boolean ehNpc() {
		return npc;
	}
	
	boolean estaJogando() {
		return jogando;
	}

	void setJogando(boolean jogando) {
		this.jogando = jogando;
	}

	void addCartasVista(Carta c) {
		cartasVistas.add(c);
	}

	List<Carta> getCartasVistas() {
		return cartasVistas;
	}

	void setCartasIniciais(List<Carta> cartasIniciais) {
		this.cartasVistas.addAll(cartasIniciais);
		this.cartasIniciais = cartasIniciais;
	}

	List<Carta> getCartasIniciais() {
		return cartasIniciais;
	}
	
	void setPos(Posicao pos) {
		this.pos = pos;
	}
	
	Posicao getPos() {
		return pos;
	}

	Personagem getPersonagem() {
		return personagem;
	}

	boolean getPodeDarPalpite() {
		return podeDarPalpite;
	}

	void setPodeDarPalpite(boolean p) {
		podeDarPalpite = p;
	}

	boolean getErrouAcusacao() {
		return errouAcusacao;
	}

	void setErrouAcusacao(boolean p) {
		errouAcusacao = p;
	}

	Carta temCarta(List<Carta> c) {
		for (Carta cOut : c) {
			for (Carta cIn : cartasIniciais) {
				if (cIn.equals(cOut))
					return cIn;
			}
		}
		return null;
	}
	
	

	Carta temCarta(Carta[] c) {
		for (Carta cOut : c) {
			for (Carta cIn : cartasIniciais) {
				if (cIn.equals(cOut))
					return cIn;
			}
		}
		return null;
	}
	
	Carta temCarta(String[] c) {
		for(String cOut: c) {
			for(Carta cIn : cartasIniciais) {
				if(cIn.getNome().equals(cOut))
					return cIn;
			}
		}
		return null;
	}
	
	void setRolouDado(boolean rolouDado) {
		this.rolouDado = rolouDado;
	}
	
	boolean getRolouDado() {
		return this.rolouDado;
	}
	
	public String toString() { // nome-cartas iniciais-pos-errou acusacao-pode dar palpite-npc-jogando
		String str = this.personagem.name();
		str +=","+pos.toString();
		str += ","+String.valueOf(errouAcusacao);
		str += ","+String.valueOf(podeDarPalpite);
		str += ","+String.valueOf(npc);
		str += ","+String.valueOf(jogando)+",";
		for(int i=0; i<cartasIniciais.size(); i++) {
			str += cartasIniciais.get(i).getNome()+"_";
		}
		str+=",";
		for(Carta c : cartasVistas) {
			str += c.getNome()+"_";
		}
		System.out.println(str);
		return str;
	}
}
