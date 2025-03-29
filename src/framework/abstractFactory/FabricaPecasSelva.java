package abstractFactory;

import model.Jogador;
import model.Peca;
import model.Terreno;

public interface FabricaPecasSelva {
    Peca criarPeca(String tipo, Jogador jogador);
    Terreno criarTerreno(String tipo);
    
} 
