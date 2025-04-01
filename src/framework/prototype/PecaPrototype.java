package prototype;

import model.Jogador;
import model.Terreno;
import model.Posicao;

public interface PecaPrototype extends Cloneable{
    PecaPrototype clonar();  
    String getTipo();      
    int getForca();
    void setPosicao(Posicao posicao);
    void setJogador(Jogador jogador);
    boolean podeCapturar(PecaPrototype outra);
    boolean movimentoValido(Terreno terreno,Posicao posicao);
}

