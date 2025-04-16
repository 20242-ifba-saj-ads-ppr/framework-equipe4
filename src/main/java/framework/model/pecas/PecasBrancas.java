package framework.model.pecas;

import framework.flyweight.PecasJogador;

public class PecasBrancas implements PecasJogador {

    @Override
    public String getCor() {
        return "branco";
    }
}
