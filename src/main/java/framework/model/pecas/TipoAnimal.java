package framework.model.pecas;

public enum TipoAnimal {
    GATO(2, "G"),
    CACHORRO(4, "C"),
    ELEFANTE(8, "E"),
    LEOPARDO(5, "L"),
    LEAO(7, "LE"),
    RATO(1, "R"),
    TIGRE(6, "T"),
    LOBO(3, "LB");

    private final int forca;
    private String simbolo;

    // Construtor
    TipoAnimal(int forca, String simbolo) {
        this.forca = forca;
        this.simbolo = simbolo;
    }
    
    public int getForca() {
        return forca;
    }

    public String getSimbolo() {
        return simbolo;
    }

}