package framework.state;

import framework.model.Jogador;

public class TurnoJogador1 implements EstadoTurno {
    @Override
    public boolean podeMover(Jogador jogadorAtual) {
        return jogadorAtual.getId() == 1;
    }

    @Override
    public EstadoTurno proximoEstado() {
        return new TurnoJogador2();
    }
}
