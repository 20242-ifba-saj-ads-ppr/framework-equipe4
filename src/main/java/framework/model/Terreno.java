package framework.model;

import framework.model.pecas.Peca;

public class Terreno {
    private int linha;
    private int coluna;
    private TipoTerrenoEnum tipoTerreno;
    private Peca peca;

    public Terreno(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        this.tipoTerreno = TipoTerrenoEnum.COMUM;
        this.peca = null;
    }

    public Terreno(int linha, int coluna, TipoTerrenoEnum tipoTerreno) {
        this.linha = linha;
        this.coluna = coluna;
        this.tipoTerreno = tipoTerreno;
        this.peca = null;
    }

    public int getlinha() {
        return linha;
    }

    public void setlinha(int linha) {
        this.linha = linha;
    }

    public int getcoluna() {
        return coluna;
    }

    public void setcoluna(int coluna) {
        this.coluna = coluna;
    }

    public TipoTerrenoEnum getTipoTerreno() {
        return tipoTerreno;
    }

    public void setTipoTerreno(TipoTerrenoEnum tipoTerreno) {
        this.tipoTerreno = tipoTerreno;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }
}
