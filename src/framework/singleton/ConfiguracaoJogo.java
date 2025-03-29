package singleton;

public final class ConfiguracaoJogo {
    private static volatile ConfiguracaoJogo instancia;
    private int quantidadeMaximaJogador;
    private int larguraTabuleiro = 7;
    private int alturaTabuleiro = 9;
    
    private ConfiguracaoJogo() {}
    
    public static ConfiguracaoJogo getInstancia() {
        if (instancia == null) {
            synchronized (ConfiguracaoJogo.class) {
                if (instancia == null) {
                    instancia = new ConfiguracaoJogo();
                }
            }
        }
        return instancia;
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

