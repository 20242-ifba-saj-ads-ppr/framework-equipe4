package jogo.adapter;

import framework.model.Jogador;
import framework.model.Posicao;
import framework.model.Terreno;
import framework.model.pecas.Peca;
import jogo.abstractFactory.SelvaJogoFactory;

import java.util.List;

import framework.abstractFactory.FabricaAbstrataJogo;
import framework.adapter.TabuleiroAdapter;

public class SelvaTabuleiroAdapter implements TabuleiroAdapter {
    private Terreno[][] terrenos; // talvez fazer uso de um set ao inves de matriz

    public SelvaTabuleiroAdapter(int linhas, int colunas) {
        terrenos = new Terreno[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                terrenos[i][j] = new Terreno(i, j);
            }
        }
    }

    @Override
    public String getDescricaoTerreno(Posicao posicao) {
        if (posicao.getLinha() < 0 || posicao.getLinha() >= terrenos.length || posicao.getColuna() < 0
                || posicao.getColuna() >= terrenos[0].length) {
            throw new IllegalArgumentException("Posição inválida no tabuleiro.");
        }
        return terrenos[posicao.getLinha()][posicao.getColuna()].getTipoTerreno().toString();
    }

    @Override
    public boolean estaDentroDosLimites(Posicao posicao) {
        int linha = posicao.getLinha();
        int coluna = posicao.getColuna();
        return linha >= 0 && linha < terrenos.length && coluna >= 0 && coluna < terrenos[0].length;
    }

    @Override
    public void definirCasa(Posicao posicao, Peca peca) {
        // Verifica se a posição está dentro dos limites do tabuleiro
        if (!estaDentroDosLimites(posicao)) {
            throw new IllegalArgumentException("ERRO: A posição indicada está fora dos limites do tabuleiro.");
        }

        // Define a peça na posição especificada
        int linha = posicao.getLinha();
        int coluna = posicao.getColuna();

        terrenos[linha][coluna].setPeca(peca);
    }

    @Override
    public Peca obterPecaEm(Posicao posicao) {
        if (!estaDentroDosLimites(posicao)) {
            throw new IllegalArgumentException("ERRO: A posição indicada está fora dos limites do tabuleiro.");
        }

        Terreno terreno = terrenos[posicao.getLinha()][posicao.getColuna()];

        return terreno.getPeca();
    }

    @Override
    public Terreno obterTerrenoEm(Posicao posicao) {
        if (!estaDentroDosLimites(posicao)) {
            throw new IllegalArgumentException("ERRO: A posição indicada está fora dos limites do tabuleiro.");
        }

        return terrenos[posicao.getLinha()][posicao.getColuna()];
    }

    @Override
    public void inicializaTerrenoPecas(List<Jogador> jogadores) {
        if (jogadores.size() != 2) {
            throw new IllegalArgumentException("ERRO: esse tabuleiro suporta apenas 2 jogadores.");
        }

        int[][][] matrizPosicoesPecas = {
            { // posicao inicial das peças do jogador 1
                { 1, 1 }, { 3, 1 }, { 1, 7 }, { 3, 3 }, { 2, 2 }, { 5, 5 }, { 2, 6 }, { 3, 7 }
            },
            { // posicao inicial das peças do jogador 2
                { 9, 7 }, { 7, 7 }, { 9, 1 }, { 7, 7 }, { 8, 6 }, { 7, 3 }, { 2, 6 }, { 7, 1 }
            }
        };
        String[] animaisNome = { "LEAO", "RATO", "TIGRE", "LEOPARDO", "CAO", "LOBO", "GATO", "ELEFANTE" };

        FabricaAbstrataJogo selvaFactory = new SelvaJogoFactory();
        for (int jogadorContador = 0; jogadorContador < jogadores.size(); jogadorContador++) {
            int animaisNomeContador = 0;
            for (var posicoesPecas : matrizPosicoesPecas[jogadorContador]) {
                int linha = posicoesPecas[0];
                int coluna = posicoesPecas[1];
                terrenos[linha][coluna].setPeca(selvaFactory.criarPeca(jogadores.get(jogadorContador),
                        new Posicao(linha, coluna), 1,  animaisNome[animaisNomeContador]));
                animaisNomeContador += 1;
            }
        }
    }
}
