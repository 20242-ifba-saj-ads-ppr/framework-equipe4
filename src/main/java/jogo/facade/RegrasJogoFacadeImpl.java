package jogo.facade;

import framework.facade.GerenciadorTurnos;
import framework.facade.RegrasJogoFacade;
import framework.model.Jogador;
import framework.model.Posicao;
import framework.model.Tabuleiro;
import framework.model.pecas.Peca;
import framework.model.pecas.TipoAnimal;
import jogo.model.Animal;

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
    public boolean capturaValida(Peca atacante, Peca defensor){
        Animal atacanteConvertido = (Animal) atacante;
        Animal defensorConvertido = (Animal) defensor;
        TipoAnimal tipoAtacante = atacanteConvertido.getTipoAnimal();
        TipoAnimal tipoDefensor = defensorConvertido.getTipoAnimal();


        // Regra: O rato pode capturar o elefante
        if (tipoAtacante == TipoAnimal.RATO && tipoDefensor == TipoAnimal.ELEFANTE) {
            return true;
        }

        // Regra: O elefante não pode capturar o rato
        if (tipoAtacante == TipoAnimal.ELEFANTE && tipoDefensor == TipoAnimal.RATO) {
            return false;
        }

        // Regra: Comparação de força
        return tipoAtacante.getForca() > tipoDefensor.getForca();
    }
    

    @Override
    public Jogador verificarVencedor() {
        throw new UnsupportedOperationException("Unimplemented method 'verificarVencedor'");
    }

    @Override
    public void passarTurno() {
        gerenciadorTurnos.proximoTurno();    
    }

    @Override
    public Jogador getJogadorAtual() {
        return gerenciadorTurnos.getJogadorAtual();    
    }
    
}
