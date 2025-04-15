package builder;

import model.Jogador;

public class DiretorJogador {

    private final ConstrutorJogador construtor;

    public DiretorJogador(ConstrutorJogador construtor) {
        this.construtor = construtor;
    }

    public Jogador criarJogador(String nome, String cor, int pontos) {
        construtor.configurarNome(nome);
        construtor.configurarCor(cor);
        construtor.configurarPontos(0);
        return construtor.construir();
    }
}