package Model;

public class Jogador {
	private Carta cartasVistas[] = new Carta[15]; //mudar para ArrayList<Carta> se ele deixar usar as data structure
	private String personagem;
	private boolean podeDarPalpite;
	private boolean errouAcusacao;
	private Carta cartasIniciais[] = new Carta[3];
	private Posicao pos;
	private boolean jogando;
	
	protected Jogador(String personagem,Carta cartasIniciais[],Posicao posInicial) {
		this.personagem = personagem;
		this.pos = posInicial;
		this.pos.setJogadorAqui(true);
		for(int i = 0; i<3;i++) {
			this.cartasIniciais[i] = cartasIniciais[i];
			this.cartasVistas[i] = cartasIniciais[i];
		}
		this.podeDarPalpite = true;
		this.errouAcusacao = false;
	}
	
	protected Jogador(String personagem,Carta cartasInicais[],Posicao posInicial,boolean jogando) {
		this.personagem = personagem;
		this.pos = posInicial;
		this.pos.setJogadorAqui(true);
		for(int i = 0; i<3;i++) {
			this.cartasIniciais[i] = cartasIniciais[i];
			this.cartasVistas[i] = cartasIniciais[i];
		}
		this.podeDarPalpite = true;
		this.errouAcusacao = false;
		this.jogando = jogando;
	}
	

	protected boolean estaJogando() {
		return jogando;
	}

	protected void setJogando(boolean jogando) {
		this.jogando = jogando;
	}

	protected void addCartasVista(Carta c) {
		for(int i = 0;i<cartasVistas.length;i++) {
			
			if(cartasVistas[i]==null) {
				cartasVistas[i] = c;
				break;
			}
		}
		
	}

	protected Carta[] getCartasVistas() {
		return cartasVistas;
	}

	protected Carta[] getCartasIniciais() {

		return cartasIniciais;
	}

	protected Posicao getPos() {
		return pos;
	}

	protected String getPersonagem() {
		return personagem;
	}
	
	protected boolean getPodeDarPalpite() {
		return podeDarPalpite;
	}
	
	protected void setPodeDarPalpite(boolean p) {
		podeDarPalpite = p;
	}
	
	protected boolean getErrouAcusacao() {
		return errouAcusacao;
	}
	
	protected void setErrouAcusacao(boolean p) {
		errouAcusacao = p;
	}
	
}
