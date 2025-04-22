package framework.adapter;

import framework.model.Posicao;
import framework.model.Terreno;
import framework.model.pecas.Peca;

public interface TabuleiroAdapter {
    String getDescricaoTerreno(Posicao posicao);
    boolean estaDentroDosLimites(Posicao posicao); 
    public void definirCasa(Posicao posicao, String peca);
    public Peca obterPecaEm(Posicao posicao);
    public Peca getPecaEm(Posicao posicao);
    public Terreno obterTerrenoEm(Posicao posicao);
}
