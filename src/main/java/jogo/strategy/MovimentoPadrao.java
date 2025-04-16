package jogo.strategy;

import framework.model.Posicao;
import framework.model.Tabuleiro;
import framework.model.pecas.Peca;
import framework.strategy.EstrategiaMovimento;
import jogo.model.Animal;

public class MovimentoPadrao implements EstrategiaMovimento {
    @Override
    public boolean mover(Peca peca, Posicao posicaoDestino, Tabuleiro tabuleiro) {
        // obtém o animal (que é a peça no jogo)
        Animal animal = (Animal) peca;

        // posição atual do animal
        Posicao posicaoAtual = animal.getPosicao();

        // verifica se a nova posição está dentro dos limites do tabuleiro
        if (!tabuleiro.estaDentroDosLimites(posicaoDestino)) {
            System.out.println("ERRO: Nova posição fora dos limites do tabuleiro.");
            return false;
        }

        String simboloAlvo = tabuleiro.getGrade()[posicaoDestino.getLinha()][posicaoDestino.getColuna()];

        // verifica se o alvo é água ("~"), onde peças não podem entrar
        if (simboloAlvo.equals("~")) {
            System.out.println("Movimento inválido: " + animal.getTipoAnimal() + " não pode entrar na água.");
            return false;
        }

        // verifica se o alvo é uma casa de vitória ("o" ou "O")
        if (simboloAlvo.equals("o") || simboloAlvo.equals("O")) {
            if ((simboloAlvo.equals("O") && animal.getJogador().getCor().equals("branco")) ||
                    (simboloAlvo.equals("o") && animal.getJogador().getCor().equals("preto"))) {
                System.out.println("Jogador " + animal.getJogador().getCor() + " ganhou o jogo!");
                return true; // Encerra o movimento indicando que o jogo terminou
            } else {
                System.out.println("Movimento inválido: Apenas peças da cor correta podem entrar nessa casa.");
                return false;
            }
        }

        // falta verifica se o alvo é um espaço vazio (" ")

        // corrigir retorno
        return false;
    }
}