package framework.model;

import framework.model.pecas.Peca;

public class Terreno {
    private int linhas;
    private int colunas;
    private TipoTerrenoEnum tipoTerreno;
    private Peca peca;

    public Peca getPeca() {
        return peca;
    }
    public Terreno(int linha, int coluna, TipoTerrenoEnum comum) {
    }
    
    public Terreno(int linha, int coluna) {
        this(linha, coluna, TipoTerrenoEnum.COMUM); // Valor padrão
    }



    public int getLinhas() {
        return linhas;
    }

    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public void setColunas(int colunas) {
        this.colunas = colunas;
    }

    public TipoTerrenoEnum getTipoTerreno() {
        return tipoTerreno;
    }

    public void setTipoTerreno(TipoTerrenoEnum tipoTerreno) {
        this.tipoTerreno = tipoTerreno;
    }

    public String getSimbolo() {
    if (peca != null) {
        return peca.getSimbolo(); 
    }
    return tipoTerreno.getSimbolo(); 
}

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    
}

