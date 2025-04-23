package jogo.strategy;

import framework.model.Posicao;
import framework.model.Tabuleiro;
import framework.model.pecas.Peca;
import framework.strategy.EstrategiaMovimento;
import jogo.model.Animal;
import framework.model.pecas.TipoAnimal;

public class MovimentoElefante implements EstrategiaMovimento {

    @Override
    public boolean mover(Peca peca, Posicao destino, Tabuleiro tabuleiro) {
        Animal elefante = (Animal) peca;

        if (!tabuleiro.estaDentroDosLimites(destino)) return false;

        Peca alvo = tabuleiro.obterPecaEm(destino);
        String simbolo = tabuleiro.obterTerrenoEm(destino).getSimbolo();

        // Elefante não pode entrar na água
        if (simbolo.equals("~")) {
            System.out.println("Elefante não pode entrar na água.");
            return false;
        }

        // Pode mover para espaço vazio
        if (simbolo.equals(" ")) {
            tabuleiro.moverPeca(elefante, elefante.getPosicao(), destino);
            return true;
        }

        if (alvo != null && alvo instanceof Animal) {
            Animal alvoAnimal = (Animal) alvo;

            // Elefante não pode capturar rato na água
            String simboloAlvo = tabuleiro.obterTerrenoEm(alvoAnimal.getPosicao()).getSimbolo();
            if (alvoAnimal.getTipoAnimal() == TipoAnimal.RATO && simboloAlvo.equals("~")) {
                System.out.println("Elefante não pode capturar rato na água.");
                return false;
            }

            // Verifica força
            if (elefante.getForca() >= alvoAnimal.getForca()) {
                tabuleiro.moverPeca(elefante, elefante.getPosicao(), destino);
                return true;
            }
        }

        return false;
    }
}
