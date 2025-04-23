package jogo.strategy;

import framework.model.Posicao;
import framework.model.Tabuleiro;
import framework.model.TipoTerrenoEnum;
import framework.model.pecas.Peca;
import framework.model.pecas.TipoAnimal;
import framework.strategy.EstrategiaMovimento;
import jogo.model.Animal;

public class MovimentoPulo implements EstrategiaMovimento {

    @Override
    public boolean mover(Peca peca, Posicao posicaoDestino, Tabuleiro tabuleiro) {
        Animal animal = (Animal) peca;
        Posicao posicaoAtual = animal.getPosicao();

        int incrementoLinha = calcularIncremento(posicaoAtual.getLinha(), posicaoDestino.getLinha());
        int incrementoColuna = calcularIncremento(posicaoAtual.getColuna(), posicaoDestino.getColuna());

        Posicao proximaPosicao = new Posicao(posicaoAtual.getLinha() + incrementoLinha,
                                             posicaoAtual.getColuna() + incrementoColuna);

        // Avança sobre casas de água
        while (tabuleiro.estaDentroDosLimites(proximaPosicao) &&
               tabuleiro.obterTerrenoEm(proximaPosicao).getTipoTerreno() == TipoTerrenoEnum.AGUA) {
            proximaPosicao = new Posicao(proximaPosicao.getLinha() + incrementoLinha,
                                         proximaPosicao.getColuna() + incrementoColuna);
        }

        // Verifica se o destino final é válido
        if (!tabuleiro.estaDentroDosLimites(proximaPosicao)) {
            System.out.println("Movimento inválido: Fora dos limites do tabuleiro.");
            return false;
        }

        Peca pecaNoDestino = tabuleiro.obterPecaEm(proximaPosicao);

        // Verifica se existe um rato na água no meio do caminho
        Posicao posicaoVerificacao = new Posicao(posicaoAtual.getLinha() + incrementoLinha,
                                                 posicaoAtual.getColuna() + incrementoColuna);

        while (!posicaoVerificacao.equals(proximaPosicao)) {
            Peca pecaNoCaminho = tabuleiro.obterPecaEm(posicaoVerificacao);
            if (pecaNoCaminho instanceof Animal && ((Animal) pecaNoCaminho).getTipoAnimal() == TipoAnimal.RATO) {
                System.out.println("Movimento inválido: Rato bloqueando o salto.");
                return false;
            }
            posicaoVerificacao = new Posicao(posicaoVerificacao.getLinha() + incrementoLinha,
                                             posicaoVerificacao.getColuna() + incrementoColuna);
        }

        // Se o destino está vazio
        if (pecaNoDestino == null) {
            tabuleiro.moverPeca(animal, posicaoAtual, proximaPosicao);
            return true;
        }

        // Se tem inimigo mais fraco
        if (pecaNoDestino instanceof Animal) {
            Animal alvo = (Animal) pecaNoDestino;
            if (animal.getForca() >= alvo.getForca()) {
                tabuleiro.moverPeca(animal, posicaoAtual, proximaPosicao);
                return true;
            } else {
                System.out.println("Movimento inválido: O inimigo é mais forte.");
                return false;
            }
        }

        System.out.println("Movimento inválido: Posição final ocupada.");
        return false;
    }

    private int calcularIncremento(int origem, int destino) {
        if (destino < origem) return -1;
        if (destino > origem) return 1;
        return 0;
    }
}
