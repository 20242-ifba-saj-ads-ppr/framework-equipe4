package framework.facade;

import framework.model.Jogador;
import framework.state.EstadoTurno;
import framework.state.TurnoJogador1;
import java.util.List;


public class GerenciadorTurnos {
    private int turnoAtual;
    private List<Jogador> jogadores;
    private EstadoTurno estadoAtual = new TurnoJogador1();


    public GerenciadorTurnos(List<Jogador> jogadores) {
        if (jogadores == null || jogadores.isEmpty()) {
            throw new IllegalArgumentException("Lista de jogadores não pode ser vazia");
        }
        this.jogadores = jogadores; 
        this.turnoAtual = 0;
    }

    public void proximoTurno() {
        estadoAtual = estadoAtual.proximoEstado();
    }

    public Jogador getJogadorAtual() {  
        return jogadores.get(turnoAtual % jogadores.size()); 
    }
    
    public boolean podeMover(Jogador jogador) {
        return estadoAtual.podeMover(jogador);
    }
 
}   
