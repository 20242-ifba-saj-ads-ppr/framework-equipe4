package jogo.builder;

import framework.model.Jogador;
import framework.builder.BuilderJogador;

public class ConstrutorJogador implements BuilderJogador {
    private Jogador jogador;

    public ConstrutorJogador() {
        this.jogador = new Jogador();
    }

    @Override
    public void configurarNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome do jogador não pode ser nulo ou vazio.");
        }
        jogador.setNome(nome);
    }

    @Override
    public void configurarCor(String cor) {
        if (cor == null || cor.isEmpty()) {
            throw new IllegalArgumentException("A cor do jogador não pode ser nula ou vazia.");
        }
        jogador.setCor(cor);
    }

    @Override
    public void configurarPontos(int pontos) {
        if (pontos < 0) {
            throw new IllegalArgumentException("Os pontos do jogador não podem ser negativos.");
        }
        jogador.setPontos(pontos);
    }

    @Override
    public Jogador construir() {
        if (this.jogador.getNome() == null || this.jogador.getCor() == null) {
            throw new IllegalStateException("Nome e cor são obrigatórios");
        }
        return jogador;
    }

}
