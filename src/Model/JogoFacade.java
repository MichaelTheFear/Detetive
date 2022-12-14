package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import Util.Personagem;

public class JogoFacade {
	private static JogoFacade facade = null;
	private Jogo jogo = new Jogo();

	private JogoFacade() {
	}

	public static JogoFacade getJogoFacade() {
		if (facade == null) {
			facade = new JogoFacade();
		}
		return facade;
	}

	public void setupJogadores(ArrayList<Personagem> players) {
		jogo.setupJogadores(players);

		
		for (Jogador j : jogo.jogadores) {
			if (!j.ehNpc()) {
				
			}
		}
	}

	public void distribuiCartas() {
		jogo.setCartasAssasino();
		jogo.distribuiCartas();
	}

	public void rolarDados() {
		jogo.rolarDado();
	}

	public int[] getDados() {
		return jogo.getDados();
	}

	public void passaVez() {
		jogo.passaVez();
	}

	public Personagem getJogadorVez() {
		return jogo.jogadores.get(jogo.vezDe).getPersonagem();
	}

	public String getNomeJogadorVez() {
		return jogo.jogadores.get(jogo.vezDe).getPersonagem().toString();
	}

	public int getLinhaJogadorVez() {
		return jogo.jogadores.get(jogo.vezDe).getPos().getLinha();
	}

	public int getColunaJogadorVez() {
		return jogo.jogadores.get(jogo.vezDe).getPos().getColuna();
	}
	
	public String getNomeJogador(int i) {
		return jogo.jogadores.get(i).getPersonagem().toString();
	}

	public int getLinhaJogador(int i) {
		return jogo.jogadores.get(i).getPos().getLinha();
	}

	public int getColunaJogador(int i) {
		return jogo.jogadores.get(i).getPos().getColuna();
	}

	public void setDados(Integer[] dices) {
		jogo.setDados(new int[] { dices[0], dices[1] });
	}

	public void salvaJogo(String filePath) throws IOException {
		jogo.guardaPartida(filePath);
	}

	public void carregarJogo(File file) throws FileNotFoundException {
		// jogo.carregaStringsDoArquivo(filePath);
		jogo = new Jogo(file);
	}

	public void novoJogo() {
		jogo = new Jogo();
	}

	public void mover(int[] pos) throws ExceptionLugarNaoPermitido {
		jogo.mover(pos);
	}

	public void darPalpite(String[] palpites) { // dar palpite para o middleware
		jogo.darPalpite(palpites);
	}

	public ArrayList<String> getNotas() { // pega as cartas vistas pelo jogador para o middleware
		return jogo.cartasParaString(jogo.jogadores.get(jogo.vezDe).getCartasVistas());
	}

	public ArrayList<String> getCartasJogador() { // pega as cartas do jogador para mostrar no middleware
		return jogo.cartasParaString(jogo.jogadores.get(jogo.vezDe).getCartasIniciais());
	}

	public boolean acusar(String[] cards) { // acusar para o middleware
		return jogo.acusar(cards);
	}

	public int[] moverPalpite(String player, String place) { // move o player 'acusado' qnd eh feito palpite
		return jogo.moveComPalpite(player, place);
	}

	public boolean getPodeDarPalpite() {
		return jogo.getPodeDarPalpite();
	}

	public boolean getErrouAcusao() {
		return jogo.getErrouAcusao();
	}

	public boolean getErrouAcusaoAll() {
		return jogo.getErrouAcusaoAll();
	}

	public boolean verificaPassagemSecreta() {
		return jogo.verificaPassagemSecreta();
	}

	public void moverPassagemSecreta() {
		jogo.moverPassagemSecreta();
	}

	public boolean estaEmComodo() {
		return jogo.jogadorAtualEmComodo() != null;
	}

	public String qualComodo() {
		return jogo.jogadorAtualEmComodo();
	}

}
