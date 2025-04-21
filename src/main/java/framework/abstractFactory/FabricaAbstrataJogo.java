package framework.abstractFactory;

import java.util.List;
import framework.model.Tabuleiro;
import framework.model.pecas.Peca;

public interface FabricaAbstrataJogo {
    List<Peca> criarPecas();
    Tabuleiro criarTabuleiro();
} 
