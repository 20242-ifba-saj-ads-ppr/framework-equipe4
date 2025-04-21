package framework.command;

import framework.model.Jogador;
import framework.model.Posicao;
import framework.model.pecas.Peca;

public class MoverCommand  implements Command {
    private Jogador jogador;
    private Posicao novaPosicao;
    private Posicao posicaoAnterior;
    private Peca peca;

    public MoverCommand(Jogador jogador, Posicao novaPosicao, Peca peca) {
        this.jogador = jogador;
        this.novaPosicao = novaPosicao;
        this.peca = peca;
    }

    @Override
    public void executar() {
        this.posicaoAnterior = peca.getPosicao(); // Salva a posição atual antes de mover
        jogador.moverPara(novaPosicao, peca);
    }

    @Override
    public void desfazer() {
        jogador.voltarPara(posicaoAnterior, peca); // Retorna à posição anterior
    }
    
}
