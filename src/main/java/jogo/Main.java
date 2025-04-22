package jogo;

import framework.command.MoverCommand;
import framework.command.InvocadorComandos;
import framework.model.Posicao;
import jogo.model.Animal;
import jogo.strategy.MovimentoRato;
import jogo.strategy.MovimentoElefante;
import jogo.strategy.MovimentoPadrao;

public class Main {
    public static void main(String[] args) {
        // 1. Inicializa o jogo
        JogoSelva jogo = new JogoSelva(); // Supondo que essa classe cria tabuleiro, jogadores e peças

        // 2. Configura as estratégias de movimento para cada peça
        for (Animal animal : jogo.getAnimais()) {
            switch (animal.getTipoAnimal()) {
                case RATO -> animal.setEstrategiaMovimento(new MovimentoRato());
                case ELEFANTE -> animal.setEstrategiaMovimento(new MovimentoElefante());
                default -> animal.setEstrategiaMovimento(new MovimentoPadrao());
            }
        }

        // 3. Suponha que queremos mover o rato do jogador 1 da posição (2,2) para (3,2)
        Animal rato = jogo.getAnimalEm(new Posicao(2, 2));
        Posicao destino = new Posicao(3, 2);

        // 4. Cria o comando de mover
        MoverCommand comando = new MoverCommand(rato.getJogador(), destino, rato);

        // 5. Executa o comando
        InvocadorComandos invocador = new InvocadorComandos();
        invocador.executarComando(comando);

        // 6. (opcional) desfazer
        // invocador.desfazerUltimoComando();
    }
}
