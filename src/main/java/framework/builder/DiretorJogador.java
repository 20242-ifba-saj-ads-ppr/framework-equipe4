package framework.builder;

import framework.model.Jogador;

public class DiretorJogador {

    private final BuilderJogador construtor;

    public DiretorJogador(BuilderJogador construtor) {
        this.construtor = construtor;
    }

    public Jogador criarJogador(String nome, String cor, int pontos) {
        construtor.configurarNome(nome);
        construtor.configurarCor(cor);
        construtor.configurarPontos(pontos);
        return construtor.construir();
    }
}