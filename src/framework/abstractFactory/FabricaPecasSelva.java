package abstractFactory;

import model.Jogador;
import model.Terreno;
import model.pecas.Peca;

public interface FabricaPecasSelva {
    Peca criarPeca(String tipo, Jogador jogador);
    Terreno criarTerreno(String tipo);
    
} 
