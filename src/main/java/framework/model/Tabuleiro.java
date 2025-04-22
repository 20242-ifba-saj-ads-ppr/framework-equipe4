package framework.model;

import framework.adapter.TabuleiroAdapter;
import framework.model.pecas.Peca;
import jogo.model.Animal;

public class Tabuleiro {
    private TabuleiroAdapter adapter;

    public Tabuleiro(TabuleiroAdapter adapter) {
        this.adapter = adapter;
    }   


    public boolean estaDentroDosLimites(Posicao posicao) {
        return adapter.estaDentroDosLimites(posicao);
    }


    public void definirCasa(Posicao posicao, String peca) {
        adapter.definirCasa(posicao, peca);
    }
    
    // consertar
    // public Peca encontrarPecaPorSimbolo(String simbolo) {
    //     for (Peca peca : pecasAtivas) {
    //         if (peca.getSimbolo().equals(simbolo)) {
    //             return peca;
    //         }
    //     }
    //     return null;
    // }
    
   
    public Peca obterPecaEm(Posicao posicao) {
        return adapter.obterPecaEm(posicao);
    }
   
  
    public Terreno obterTerrenoEm(Posicao posicao) {
        return adapter.obterTerrenoEm(posicao);

    }


    public void moverPeca(Animal animal, Posicao posicaoAtual, Posicao proximaPosicao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moverPeca'");
    }
}
