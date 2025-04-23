package framework.adapter;

import java.util.List;

import framework.model.Jogador;
import framework.model.Posicao;
import framework.model.Terreno;
import framework.model.pecas.Peca;

public interface TabuleiroAdapter {
    String getDescricaoTerreno(Posicao posicao);
    boolean estaDentroDosLimites(Posicao posicao);
    void definirCasa(Posicao posicao, Peca peca);
    Peca obterPecaEm(Posicao posicao);
    Terreno obterTerrenoEm(Posicao posicao);
    void inicializaTerrenoPecas(List<Jogador> jogadores);
}
