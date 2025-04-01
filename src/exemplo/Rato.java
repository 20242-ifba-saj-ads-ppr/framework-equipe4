package model.pecas;

import model.Jogador;
import model.Posicao;
import model.Terreno;
import prototype.PecaPrototype;

public class Rato extends Peca {
    public Rato(Jogador jogador, Posicao posicao) {
        super("rato", 1, jogador, posicao);
    }
    @Override
    public boolean podeCapturar(PecaPrototype outra) {
       
    }

    @Override
    public boolean movimentoValido(Terreno terreno, Posicao posicao) {
    
    }
    
}
