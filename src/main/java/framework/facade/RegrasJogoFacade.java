package framework.facade;

import framework.model.Jogador;
import framework.model.Posicao;
import framework.model.pecas.Peca;

public interface RegrasJogoFacade {
    
    abstract boolean movimentoValido(Peca peca, Posicao destino);
  
    abstract boolean capturaValida(Peca atacante, Peca defensor);
    
    Jogador verificarVencedor();
    
    void passarTurno();
    
    Jogador getJogadorAtual();
}