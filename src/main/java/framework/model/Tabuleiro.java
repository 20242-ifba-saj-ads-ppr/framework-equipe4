package framework.model;

import framework.model.pecas.Peca;
import java.util.List;


public interface Tabuleiro {
    boolean estaDentroDosLimites(Posicao posicao);
    void definirCasa(Posicao posicao, Peca peca);
    Peca obterPecaEm(Posicao posicao);
    // Peca encontraPecaPorSimbolo(String simbolo);
    Terreno obterTerrenoEm(Posicao posicao);
    void inicializaTerrenoPecas(List<Jogador> jogadores);

    void moverPeca(Peca peca, Posicao origem, Posicao destino);
}
