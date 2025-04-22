package framework.state;

import framework.model.Jogador;

public interface EstadoTurno {
    boolean podeMover(Jogador jogadorAtual);
    EstadoTurno proximoEstado();
}
