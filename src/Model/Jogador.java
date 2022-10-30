package Model;

import java.util.ArrayList;
import java.util.List;

import Util.Personagem;

class Jogador {
	private List<Carta> cartasVistas = new ArrayList<Carta>(); //mudar para ArrayList<Carta> se ele deixar usar as data structure
	private Personagem personagem;
	private boolean podeDarPalpite;
	private boolean errouAcusacao;
	private List<Carta> cartasIniciais = new ArrayList<Carta>();
	private Posicao pos;
	private boolean jogando;
	
	  Jogador(Personagem personagem) {
		this.personagem = personagem;
		switch(this.personagem)
		{
			case Scarlet:
				this.pos = new Posicao(26,9);
				break;
				
			case Mustard:
				this.pos = new Posicao(19,2);
				break;
			
			case White:
				this.pos = new Posicao(2,11);
				break;
				
			case Green:
				this.pos = new Posicao(2,16);
				break;
				
			case Peacock:
				this.pos = new Posicao(8,25);
				break;
				
			case Plum:
				this.pos = new Posicao(21,25);
				break;
				
			
		}
		this.jogando = false;
		this.errouAcusacao = true;
	}
	
	  Jogador(Personagem personagem,Carta cartasIniciais[]) {
		this.personagem = personagem;
		switch(this.personagem)
		{
			case Scarlet:
				this.pos = new Posicao(26,9);
				break;
				
			case Mustard:
				this.pos = new Posicao(19,2);
				break;
			
			case White:
				this.pos = new Posicao(2,11);
				break;
				
			case Green:
				this.pos = new Posicao(2,16);
				break;
				
			case Peacock:
				this.pos = new Posicao(8,25);
				break;
				
			case Plum:
				this.pos = new Posicao(21,25);
				break;
				
		}
		for(int i = 0; i<cartasIniciais.length;i++) {
			this.cartasIniciais.add(cartasIniciais[i]);
			this.cartasVistas.add(cartasIniciais[i]);
		}
		this.podeDarPalpite = true;
		this.errouAcusacao = false;
		this.jogando = false;
	}
	
	  Jogador(Personagem personagem,ArrayList<Carta> cartasIniciais) {
		this.personagem = personagem;
		switch(this.personagem)
		{
			case Scarlet:
				this.pos = new Posicao(26,9);
				break;
				
			case Mustard:
				this.pos = new Posicao(19,2);
				break;
			
			case White:
				this.pos = new Posicao(2,11);
				break;
				
			case Green:
				this.pos = new Posicao(2,16);
				break;
				
			case Peacock:
				this.pos = new Posicao(8,25);
				break;
				
			case Plum:
				this.pos = new Posicao(21,25);
				break;
				
		}
		this.cartasIniciais = cartasIniciais;
		this.cartasVistas.addAll(cartasIniciais);
		this.podeDarPalpite = true;
		this.errouAcusacao = false;
		this.jogando = false;
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

	  List<Carta> getCartasIniciais() {
		return cartasIniciais;
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
	
	Carta temCarta(Carta c[]) {
		for(Carta cOut : c) {
			for(Carta cIn : cartasIniciais) {
				if(cIn.equals(cOut))
					return cIn;
			}
		}
		return null;
	}	
}
