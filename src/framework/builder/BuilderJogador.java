package builder;

import model.Jogador;

public interface BuilderJogador {
    BuilderJogador comNome(String nome);
    BuilderJogador comCor(String cor);
    BuilderJogador comPontos(int pontos);
    Jogador construir();
}
