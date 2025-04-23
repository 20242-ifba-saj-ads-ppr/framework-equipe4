package jogo.strategy;

import framework.model.Posicao;
import framework.model.Tabuleiro;
import framework.model.pecas.Peca;
import framework.strategy.EstrategiaMovimento;
import jogo.model.Animal;
import framework.model.pecas.TipoAnimal;

public class MovimentoRato implements EstrategiaMovimento {

    @Override
    public boolean mover(Peca peca, Posicao destino, Tabuleiro tabuleiro) {
        Animal rato = (Animal) peca;

        // Verifica se pode se mover para a posição destino (inclusive água)
        if (!tabuleiro.estaDentroDosLimites(destino)) return false;

        Peca alvo = tabuleiro.obterPecaEm(destino);
        String simbolo = tabuleiro.getSimbolo(destino);

        if (simbolo.equals("~") || simbolo.equals(" ")) {
            // Pode entrar na água ou em espaço vazio
            tabuleiro.moverPeca(rato, rato.getPosicao(), destino);
            return true;
        }

        // Se for atacar
        if (alvo != null && alvo instanceof Animal) {
            Animal alvoAnimal = (Animal) alvo;

            // Rato não pode capturar elefante
            if (alvoAnimal.getTipoAnimal() == TipoAnimal.ELEFANTE) {
                System.out.println("Rato não pode capturar Elefante.");
                return false;
            }

            // Verifica força
            if (rato.getForca() >= alvoAnimal.getForca()) {
                tabuleiro.moverPeca(rato, rato.getPosicao(), destino);
                return true;
            }
        }

        return false;
    }
}
