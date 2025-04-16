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

    public boolean estaDentroDosLimites(Posicao posicao) {
        int linha = posicao.getLinha();
        int coluna = posicao.getColuna();
        return linha >= 0 && linha < grade.length && coluna >= 0 && coluna < grade[0].length;
    }


    public void definirCasa(Posicao posicao, String peca) {
    if (estaDentroDosLimites(posicao)) { 
        grade[posicao.getLinha()][posicao.getColuna()] = peca;
    } else {
        System.out.println("ERRO: A posição indicada está fora dos limites do tabuleiro.");
    }
    
    // consertar
    // public Peca encontrarPecaPorSimbolo(String simbolo) {
    //     for (Peca peca : pecasAtivas) {
    //         if (peca.getSimbolo().equals(simbolo)) {
    //             return peca;
    //         }
    //     }
    //     return null;
    // }
    
   
    public Peca obterPecaEm(Posicao posicao) {
        if (estaDentroDosLimites(posicao)) {
            String conteudoCasa = grade[posicao.getLinha()] [posicao.getColuna()];
            if (!conteudoCasa.equals(" ") && !conteudoCasa.equals("~") && !conteudoCasa.equals("o") && !conteudoCasa.equals("#")) {
                return encontrarPecaPorSimbolo(conteudoCasa);
            }
        }
        return null; 
    }
    public String[][] getGrade() {
        return grade;
    }
    //consertar
    public Peca getPecaEm(Posicao posicao) {
        if (!estaDentroDosLimites(posicao)) {        
            return null;
        }
        return null;
    }

    public void moverPeca(Animal animal, Posicao posicaoAtual, Posicao proximaPosicao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moverPeca'");
    }
}
