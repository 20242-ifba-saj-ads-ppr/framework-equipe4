package jogo.abstractFactory;

import framework.abstractFactory.FabricaAbstrataJogo;
import framework.adapter.TabuleiroAdapter;
import framework.model.pecas.Peca;
import framework.model.Jogador;
import framework.model.Posicao;
import framework.model.Tabuleiro;
import jogo.model.Animal;
import jogo.model.SelvaTabuleiro;
import jogo.adapter.SelvaTabuleiroAdapter;

public class SelvaTabuleiroFactory implements FabricaAbstrataJogo {
    @Override
    public Peca criarPeca(Jogador jogador, Posicao posicao, int forca, String tipo) {
        Peca peca = new Animal(tipo, forca, jogador, posicao);
        return peca;
    };

    @Override
    public Tabuleiro criarTabuleiro() {
        TabuleiroAdapter selvaTabuleiroAdapter = new SelvaTabuleiroAdapter(9, 7);
        Tabuleiro selvaTabuleiro = new SelvaTabuleiro(selvaTabuleiroAdapter);
        return selvaTabuleiro;
    }
}
