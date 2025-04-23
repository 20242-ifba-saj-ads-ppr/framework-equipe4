package framework.singleton;

public final class ConfiguracaoJogo {
    private int quantidadeMaximaJogador;
    private int larguraTabuleiro = 7;
    private int alturaTabuleiro = 9;
    
    private ConfiguracaoJogo() {}
    
    private static volatile ConfiguracaoJogo instancia;

    public static ConfiguracaoJogo getInstancia() {
        ConfiguracaoJogo result = instancia;
        if (result == null) {
            synchronized (ConfiguracaoJogo.class) {
                result = instancia;
                if (result == null) {
                    instancia = result = new ConfiguracaoJogo();
                }
            }
        }
        return result;
    }
    public int getLarguraTabuleiro() {
        return larguraTabuleiro;
    }
    
    public int getAlturaTabuleiro() {
        return alturaTabuleiro;
    }

    public int getQuantidadeMaximaJogador() {
        return quantidadeMaximaJogador;
    }

    public void setLarguraTabuleiro(int larguraTabuleiro) {
        this.larguraTabuleiro = larguraTabuleiro;
    }

    public void setAlturaTabuleiro(int alturaTabuleiro) {
        this.alturaTabuleiro = alturaTabuleiro;
    }

    public void setQuantidadeMaximaJogador(int quantidadeMaximaJogador) {
        this.quantidadeMaximaJogador = quantidadeMaximaJogador;
    }
}

