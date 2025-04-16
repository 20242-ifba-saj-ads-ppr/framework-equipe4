package framework.strategy;

import framework.model.Posicao;
import framework.model.Tabuleiro;
import framework.model.pecas.Peca;

public interface EstrategiaMovimento {
    boolean mover(Peca peca, Posicao posicaoDestino, Tabuleiro tabuleiro);
}