package framework.adapter;

import framework.model.Posicao;
import framework.model.Terreno;
import framework.model.TipoTerrenoEnum;
import framework.model.pecas.Peca;

public class TerrenoAdapter implements TabuleiroAdapter {
    private Terreno[][] terrenos;

    public TerrenoAdapter(int linhas, int colunas) {
        terrenos = new Terreno[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                terrenos[i][j] = new Terreno(i, j, TipoTerrenoEnum.INICIAL);
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
    public void definirCasa(Posicao posicao, String peca) {
        // Verifica se a posição está dentro dos limites do tabuleiro
        if (!estaDentroDosLimites(posicao)) {
            throw new IllegalArgumentException("ERRO: A posição indicada está fora dos limites do tabuleiro.");
        }

        // Define a peça na posição especificada
        int linha = posicao.getLinha();
        int coluna = posicao.getColuna();

        terrenos[linha][coluna] = new Terreno(posicao.getLinha(), posicao.getColuna(),
                TipoTerrenoEnum.valueOf(peca.toUpperCase()));
    }

    public Peca obterPecaEm(Posicao posicao) {
        if (!estaDentroDosLimites(posicao)) {
            throw new IllegalArgumentException("ERRO: A posição indicada está fora dos limites do tabuleiro.");
        }

        Terreno terreno = terrenos[posicao.getLinha()][posicao.getColuna()];

        return terreno.getPeca();
    }

    public Peca getPecaEm(Posicao posicao) {
        if (!estaDentroDosLimites(posicao)) {
            return null;
        }
        return null;
    }

    public Terreno obterTerrenoEm(Posicao posicao) {
    if (!estaDentroDosLimites(posicao)) {
        throw new IllegalArgumentException("ERRO: A posição indicada está fora dos limites do tabuleiro.");
    }

    return terrenos[posicao.getLinha()][posicao.getColuna()];
    }
}
