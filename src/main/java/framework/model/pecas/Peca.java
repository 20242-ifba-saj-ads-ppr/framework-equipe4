package framework.model.pecas;

import framework.model.Jogador;
import framework.model.Posicao;
import framework.prototype.PecaPrototype;

public abstract class Peca implements PecaPrototype {
    protected final String tipo;
    protected final int forca;
    protected Jogador jogador;
    protected Posicao posicao;

   public Peca(String tipo, int forca, Jogador jogador, Posicao posicao) {
        this.tipo = tipo;
        this.forca = forca;
        this.jogador = jogador;
        this.posicao = posicao;
    }

    public Peca(Peca peca){
        this.tipo = peca.tipo;
        this.forca = peca.forca;
        this.jogador = peca.jogador;
        this.posicao = peca.posicao;
    }
    @Override
    public Peca clonar() {
        try {
            Peca clone = this.getClass().getDeclaredConstructor(this.getClass()).newInstance(this); 
            // Obtém o objeto Class que representa a classe real do objeto atual
            //(se this for um Elefante, retorna Elefante.class) Obtém o construtor que recebe um parâmetro do mesmo tipo da classe Cria uma nova instância usando o construtor de cópia,
            // passando o objeto atual (this) como parâmetro (equivalente a new Elefante(this)
            
            return clone;
        } catch (Exception e) {
            throw new RuntimeException("Falha ao clonar peça", e);
        }
    }

    public String getTipo() {
        return tipo;
    }

    public int getForca() {
        return forca;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    } 
}