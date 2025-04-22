package framework.command;

import framework.facade.GerenciadorTurnos;
import framework.model.Jogador;
import framework.model.Posicao;
import framework.model.pecas.Peca;

public class MoverCommand implements Command {
    private final Jogador jogador;
    private final Posicao novaPosicao;
    private Posicao posicaoAnterior;
    private final Peca peca;
    private final GerenciadorTurnos gerenciadorTurnos;

    public MoverCommand(Jogador jogador, Posicao novaPosicao, Peca peca, GerenciadorTurnos gerenciadorTurnos) {
        this.jogador = jogador;
        this.novaPosicao = novaPosicao;
        this.peca = peca;
        this.gerenciadorTurnos = gerenciadorTurnos;
    }

    @Override
    public void executar() {
        if (!gerenciadorTurnos.podeMover(jogador)) {
            System.out.println("Não é o turno desse jogador!");
            return;
        }

        this.posicaoAnterior = peca.getPosicao(); // Salva a posição atual antes de mover
        jogador.moverPara(novaPosicao, peca);     // Move a peça
        gerenciadorTurnos.proximoTurno();         // Avança para o próximo turno
    }

    @Override
    public void desfazer() {
        jogador.voltarPara(posicaoAnterior, peca); // Retorna à posição anterior
    }
}
