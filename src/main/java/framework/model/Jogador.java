package framework.model;

import framework.model.pecas.Peca;

public class Jogador {
    private int id;
    private String nome;
    private String cor;
    private int pontos;
    private Peca ultimaPeca = null;
    
    public Jogador() {
        this.nome = "";
        this.cor = "";
        this.pontos = 0;
    }
    
     public Jogador(String nome, String cor) {
         this.nome = nome;
         this.cor = cor;
         this.pontos = 0;
     }

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
    

    public void adicionarPontos(int pontos) {
        this.pontos += pontos;
    }
    
    public void moverPara(Posicao novaPosicao, Peca peca) {
        System.out.println(nome + " moveu para " + novaPosicao);
        this.ultimaPeca = peca;
        peca.setPosicao(novaPosicao);
    }

    public void voltarPara(Posicao posicaoAnterior, Peca peca) {
        System.out.println(nome + " voltou para " + posicaoAnterior);
        this.ultimaPeca = peca;
        peca.setPosicao(posicaoAnterior);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
