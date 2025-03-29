package builder;
import java.util.Objects;

import model.Jogador;

public class ConstrutorJogador {
    Jogador jogador;
   
    public ConstrutorJogador novo() {
        var construtorJogador = new ConstrutorJogador();
        construtorJogador.comPontos(0);
        return construtorJogador;
    }

    public ConstrutorJogador comNome(String nome) {
        Objects.requireNonNull(nome, "Nome não pode ser nulo");
        this.jogador.setNome(nome);
        return this;
    }

    public ConstrutorJogador comCor(String cor) {
        Objects.requireNonNull(cor, "Cor não pode ser nula");
        this.jogador.setCor(cor);
        return this;
    }
    // melhorar
    public ConstrutorJogador comPontos(int pontos) {
        if (pontos < 0) {
            throw new IllegalArgumentException("Pontos não podem ser negativos");
        }
        this.jogador.setPontos(pontos);
        return this;
    }
    public Jogador construir() {
        if (this.jogador.getNome() == null || this.jogador.getCor() == null) {
            throw new IllegalStateException("Nome e cor são obrigatórios");
        }
        return jogador;
    }
}

