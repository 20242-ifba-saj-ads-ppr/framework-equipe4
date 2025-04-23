package framework.model;

import java.util.List;
import framework.model.pecas.Peca;


public interface Tabuleiro {
    boolean estaDentroDosLimites(Posicao posicao);
    void definirCasa(Posicao posicao, Peca peca);
    Peca obterPecaEm(Posicao posicao);
    // Peca encontraPecaPorSimbolo(String simbolo);
    Terreno obterTerrenoEm(Posicao posicao);
    void inicializaTerrenoPecas(List<Jogador> jogadores);
}
