package jogo.strategy;

import framework.model.Tabuleiro;
import framework.model.Posicao;
import framework.model.pecas.Peca;
import framework.model.pecas.TipoAnimal;
import framework.strategy.EstrategiaMovimento;
import jogo.model.Animal;

public class MovimentoPulo implements EstrategiaMovimento {

    @Override
    public boolean mover(Peca peca,Posicao posicaoDestino, Tabuleiro tabuleiro) {
        // Converte a peça genérica para uma peça específica da selva
        Animal animal = (Animal) peca;

        Posicao posicaoAtual = animal.getPosicao();

    
        // calcula os incrementos de linha e coluna para determinar a direcao do movimento
        int incrementoLinha = calcularIncremento(posicaoAtual.getLinha(), posicaoDestino.getLinha());
        int incrementoColuna = calcularIncremento(posicaoAtual.getColuna(), posicaoDestino.getColuna());

        // definira a proxima posição inicialmente como um passo na direcao do destino
        Posicao proximaPosicao = new Posicao(posicaoAtual.getLinha() + incrementoLinha, posicaoAtual.getColuna() + incrementoColuna);

        // avanca enquanto encontrar agua ("~") no caminho
        while (tabuleiro.estaDentroDosLimites(proximaPosicao) &&
               tabuleiro.getGrade()[proximaPosicao.getLinha()][proximaPosicao.getColuna()].equals("~")) {
            proximaPosicao = new Posicao(proximaPosicao.getLinha() + incrementoLinha, proximaPosicao.getColuna() + incrementoColuna);
        }

        // verifica se a próxima posicao e valida
        if (tabuleiro.estaDentroDosLimites(proximaPosicao)) {
            String quadradoAlvo = tabuleiro.getGrade()[proximaPosicao.getLinha()][proximaPosicao.getColuna()];

            // verifica se o quadrado esta vazio
            if (quadradoAlvo.equals(" ")) {
                boolean ratoNaAgua = false;
                Posicao posicaoVerificacao = new Posicao(posicaoAtual.getLinha() + incrementoLinha, posicaoAtual.getColuna() + incrementoColuna);

                // verifica tem rato na agua bloqueando o salto
                while (tabuleiro.estaDentroDosLimites(posicaoVerificacao) &&
                       !posicaoVerificacao.equals(proximaPosicao)) {
                    Peca pecaNoCaminho = tabuleiro.getPecaEm(posicaoVerificacao);
                    if (pecaNoCaminho != null && ((Animal) pecaNoCaminho).getTipoAnimal() == TipoAnimal.RATO) {
                        ratoNaAgua = true;
                        break;
                    }
                    posicaoVerificacao = new Posicao(posicaoVerificacao.getLinha() + incrementoLinha, posicaoVerificacao.getColuna() + incrementoColuna);
                }

                if (!ratoNaAgua) {
                    // realiza o movimento
                    tabuleiro.moverPeca(animal, posicaoAtual, proximaPosicao);
                    return true;
                } else {
                    System.out.println("Movimento inválido: O rato está bloqueando o salto.");
                    return false;
                }
            } else {
                System.out.println("Movimento inválido: A posição de destino não está vazia.");
                return false;
            }
        } else {
            System.out.println("Movimento inválido: Fora dos limites do tabuleiro.");
            return false;
        }
    }

    private int calcularIncremento(int origem, int destino) {
        if (destino < origem) {
            return -1; // movimento para cima ou para a esquerda
        } else if (destino > origem) {
            return 1; // movimento para baixo ou para a direita
        }
        return 0; // mesma posição
    }
}