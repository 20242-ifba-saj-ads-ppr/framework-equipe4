package framework.state;

import framework.model.Jogador;

public class TurnoJogador2 implements EstadoTurno {
    @Override
    public boolean podeMover(Jogador jogadorAtual) {
        return jogadorAtual.getId() == 2;
    }

    @Override
    public EstadoTurno proximoEstado() {
        return new TurnoJogador1();
    }
}
