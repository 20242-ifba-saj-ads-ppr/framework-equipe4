package builder;

import model.Jogador;

public class DiretorJogador {

    public Jogador criarNovo(String nome, String cor) {
        return new ConstrutorJogador()
            .comNome(nome)
            .comCor(cor)
            .comPontos(0)
            .construir();
    }
}