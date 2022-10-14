package Model;

public class Jogador {
	private Carta cartasVistas[]; //mudar para ArrayList<Carta> se ele deixar usar as data structure
	private String personagem;
	private boolean podeDarPalpite;
	private Carta cartasIniciais[];
	private Posicao pos;
	
	private Jogador(String personagem,Posicao posInicial,Carta cartasInicais[]) {
		this.personagem = personagem;
		this.pos = posInicial;
		for(int i = 0; i<3;i++) {
			this.cartasIniciais[i].clone(cartasIniciais[i]);
		}
	}
	
}
