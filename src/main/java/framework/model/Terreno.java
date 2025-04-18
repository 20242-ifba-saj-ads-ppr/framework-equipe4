package framework.model;

public class Terreno {
    private int linhas;
    private int colunas;
    private TipoTerrenoEnum tipoTerreno;

    public Terreno(int linhas, int colunas, TipoTerrenoEnum tipoTerreno) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.tipoTerreno = tipoTerreno;
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
    
}

