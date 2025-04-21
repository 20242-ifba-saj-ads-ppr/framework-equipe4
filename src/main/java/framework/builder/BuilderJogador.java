package framework.builder;

import framework.model.Jogador;


public interface BuilderJogador {
    void configurarNome(String nome);
    void configurarCor(String cor);
    void configurarPontos(int pontos); 
    Jogador construir();

}
