package jogo.factorymethod;

import framework.factoryMethod.FactoryMethodCriadorPeca;
import framework.model.Jogador;
import framework.model.Posicao;
import framework.model.pecas.Peca;
import framework.model.pecas.TipoAnimal;
import jogo.model.Animal;

public class CriadorPecaSelvaConcreto implements FactoryMethodCriadorPeca {

    @Override
    public Peca fabricar(Posicao posicao, Jogador jogador) {
        throw new UnsupportedOperationException("Método 'fabrica' não implementado: Parâmetros incorretos, é necessário definir o tipo do animal.");
    }

    @Override
    public Peca fabricar(Posicao posicao, Jogador jogador, TipoAnimal tipoAnimal) {
        return new Animal(tipoAnimal.toString(), tipoAnimal.getForca(), jogador, posicao);
    }
}