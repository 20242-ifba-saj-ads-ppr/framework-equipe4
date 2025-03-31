package builder;
import java.util.Objects;

import model.Jogador;

public class ConstrutorJogador implements BuilderJogador{
    private Jogador jogador;
   
    public ConstrutorJogador(){
        this.jogador = new Jogador();
    }

    public ConstrutorJogador novo() {
        var construtorJogador = new ConstrutorJogador();
        construtorJogador.comPontos(0);
        return construtorJogador;
    }
    
    @Override
    public ConstrutorJogador comNome(String nome) {
        Objects.requireNonNull(nome, "Nome não pode ser nulo");
        this.jogador.setNome(nome);
        return this;
    }
    @Override
    public ConstrutorJogador comCor(String cor) {
        Objects.requireNonNull(cor, "Cor não pode ser nula");
        this.jogador.setCor(cor);
        return this;
    }
    @Override
    public ConstrutorJogador comPontos(int pontos) {
        if (pontos < 0) {
            throw new IllegalArgumentException("Pontos não podem ser negativos");
        }
        this.jogador.setPontos(pontos);
        return this;
    }

    @Override
    public Jogador construir() {
        if (this.jogador.getNome() == null || this.jogador.getCor() == null) {
            throw new IllegalStateException("Nome e cor são obrigatórios");
        }
        return jogador;
    }
}


