package facade;

import model.Jogador;
import model.Posicao;
import model.pecas.Peca;

public interface RegrasJogoFacade {
    
    abstract boolean movimentoValido(Peca peca, Posicao destino);
  
    abstract boolean capturaValida(Peca atacante, Peca defensor);
    
    Jogador verificarVencedor();
    
    void passarTurno();
    
    Jogador getJogadorAtual();
}