package Model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import Util.Personagem;

import org.junit.Before;

public class TesteJogo {

	Jogo j = null;

    @Before
    public void newJogo() {
        j = new Jogo();
        j.setupJogadores(Arrays.asList(Personagem.values()));
    }

    @Test
    public void testeConstrutor() {
        assertNotNull("Testando construtor jogo", j);
    }

    @Test
    public void testeDados(){
        j.setDados(new int[] {1, 2});
        assertTrue("Testando dados", j.getDados()[0] == 1 && j.getDados()[1] == 2);
    }

    




}
