package jogo.model;

import framework.model.Jogador;
import framework.model.Posicao;
import framework.model.Tabuleiro;
import framework.model.pecas.Peca;
import framework.model.pecas.TipoAnimal;
import framework.strategy.EstrategiaMovimento;
import java.util.Arrays;

public class Animal extends Peca{
    private EstrategiaMovimento estrategiaMovimento;
    public final TipoAnimal tipoAnimal;
    private boolean estaNaAgua;

    public Animal(Peca peca) {
        super(peca);
        this.tipoAnimal = TipoAnimal.valueOf(peca.getTipo());
    }

    public Animal(String tipo, int forca, Jogador jogador, Posicao posicao) {
    super(tipo, forca, jogador, posicao);
    try {
        this.tipoAnimal = TipoAnimal.valueOf(tipo);
    } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException("Tipo de animal inválido: " + tipo + 
               ". Valores válidos: " + Arrays.toString(TipoAnimal.values()));
    }
}

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public boolean isEstaNaAgua() {
        return estaNaAgua;
    }

    public void setEstrategiaMovimento(EstrategiaMovimento estrategia) {
        this.estrategiaMovimento = estrategia;
    }

    public boolean mover(Posicao destino, Tabuleiro tabuleiro) {
    if (estrategiaMovimento == null) {
        System.out.println("Erro: estratégia de movimento não definida para " + this.getTipoAnimal());
        return false;
    }
    return estrategiaMovimento.mover(this, destino, tabuleiro);
}


   

}

