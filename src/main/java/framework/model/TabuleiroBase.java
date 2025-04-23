package framework.model;

import java.util.List;

import framework.adapter.TabuleiroAdapter;
import framework.model.pecas.Peca;

public class TabuleiroBase implements Tabuleiro {
    private TabuleiroAdapter adapter;

    public TabuleiroBase(TabuleiroAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public boolean estaDentroDosLimites(Posicao posicao) {
        return adapter.estaDentroDosLimites(posicao);
    }

    @Override
    public void definirCasa(Posicao posicao, Peca peca) {
        adapter.definirCasa(posicao, peca);
    }

    // consertar
    // @Override
    // public Peca encontrarPecaPorSimbolo(String simbolo) {
    //     for (Peca peca : pecasAtivas) {
    //         if (peca.getTipoAnimal().getSimbolo().equals(simbolo)) {
    //             return peca;
    //         }
    //     }
    //     return null;
    // }


    @Override
    public Peca obterPecaEm(Posicao posicao) {
        return adapter.obterPecaEm(posicao);
    }

    @Override
    public Terreno obterTerrenoEm(Posicao posicao) {
        return adapter.obterTerrenoEm(posicao);
    }

    @Override
    public void inicializaTerrenoPecas(List<Jogador> jogadores) {
        adapter.inicializaTerrenoPecas(jogadores);
    }
   
}
