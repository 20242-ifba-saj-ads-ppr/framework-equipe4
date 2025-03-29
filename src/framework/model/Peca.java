package model;


public abstract class Peca {
    protected String nome;
    protected int forca;
    protected Jogador jogador;
    protected Posicao posicao;

    public Peca(Jogador jogador) {
        this.jogador = jogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setDono(Jogador jogador) {
        this.jogador = jogador;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    
}
