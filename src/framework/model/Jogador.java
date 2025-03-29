package model;
public class Jogador {
    private String nome;
    private String cor;
    private int pontos;
    
    public Jogador() {
        this.nome = "";
        this.cor = "";
        this.pontos = 0;
    }
    // public Jogador(String nome, String cor) {
    //     this.nome = nome;
    //     this.cor = cor;
    //     this.pontos = 0;
    // }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    
}
