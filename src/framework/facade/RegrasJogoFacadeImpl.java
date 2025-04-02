package facade;

import model.Jogador;
import model.Posicao;
import model.Tabuleiro;
import model.pecas.Peca;

public  abstract class RegrasJogoFacadeImpl implements RegrasJogoFacade {
    private final Tabuleiro tabuleiro;
    private final GerenciadorTurnos gerenciadorTurnos;
    

     public RegrasJogoFacadeImpl(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        this.gerenciadorTurnos = new GerenciadorTurnos(null);
    }

    @Override
    public abstract boolean movimentoValido(Peca peca, Posicao destino);

    @Override
    public abstract boolean capturaValida(Peca atacante, Peca defensor);

    @Override
    public Jogador verificarVencedor() {
        throw new UnsupportedOperationException("Unimplemented method 'verificarVencedor'");
    }

    @Override
    public void passarTurno() {
        gerenciadorTurnos.proximoTurno();    }

    @Override
    public Jogador getJogadorAtual() {
        return gerenciadorTurnos.getJogadorAtual();    }
    
}
