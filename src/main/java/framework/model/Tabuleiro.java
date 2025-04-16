package framework.model;
import framework.model.pecas.Peca;
import jogo.model.Animal;

public class Tabuleiro {
    private String[][] grade;

    public Tabuleiro(int linhas, int colunas) {
        grade = new String[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                grade[i][j] = " ";
            }
        }
    }

    public boolean estaDentroDosLimites(int linha, int coluna) {
        return linha >= 0 && linha < grade.length && coluna >= 0 && coluna < grade[0].length;
    }

    public String[][] getGrade() {
        return grade;
    }
    //consertar
    public Peca getPecaEm(Posicao posicao) {
        if (!estaDentroDosLimites(posicao.getLinha(), posicao.getColuna())) {        
            return null;
        }
        return null;
    }

    public void moverPeca(Animal animal, Posicao posicaoAtual, Posicao proximaPosicao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moverPeca'");
    }
}
