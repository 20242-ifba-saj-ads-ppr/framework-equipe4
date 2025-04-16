package framework.model.pecas;

import java.util.HashMap;
import java.util.Map;

import framework.flyweight.PecasJogador;

public class FabricaPecasJogador {
    private static final Map<String, PecasJogador> cachePecas = new HashMap<>();

    public static PecasJogador getPecasJogador(String cor) {
        PecasJogador peca = cachePecas.get(cor);

        if (peca == null) {
            if (cor.equalsIgnoreCase("branco")) { //compara strings ignorando diferenças entre maiúsculas e minúsculas
                peca = new PecasBrancas();
            } else if (cor.equalsIgnoreCase("preto")) {
                peca = new PecasPretas();
            }
            cachePecas.put(cor, peca);
        }

        return peca;
    }
}