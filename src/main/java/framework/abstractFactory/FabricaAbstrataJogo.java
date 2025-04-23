package framework.abstractFactory;

import framework.model.Jogador;
import framework.model.Posicao;
import framework.model.Tabuleiro;
import framework.model.pecas.Peca;

public interface FabricaAbstrataJogo {
    Peca criarPeca(Jogador jogador, Posicao posicao, int forca, String tipo);
    Tabuleiro criarTabuleiro();
}
