package jogo.model;

import framework.model.Jogador;
import framework.model.Posicao;
import framework.model.pecas.Peca;
import framework.model.pecas.TipoAnimal;

public class Animal extends Peca{
    public final TipoAnimal tipoAnimal;
    private boolean estaNaAgua;

    public Animal(Peca peca) {
        super(peca);
        this.tipoAnimal = TipoAnimal.valueOf(peca.getTipo());
    }

    public Animal(String tipo, int forca, Jogador jogador, Posicao posicao) {
        super(tipo, forca, jogador, posicao);
        this.tipoAnimal = TipoAnimal.valueOf(tipo);

    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public boolean isEstaNaAgua() {
        return estaNaAgua;
    }

   

}

