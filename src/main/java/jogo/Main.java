package jogo;

import framework.command.MoverCommand;
import framework.command.GerenciadorComandos;
import framework.model.Posicao;
import framework.model.pecas.Peca;
import framework.strategy.EstrategiaMovimento;
import jogo.model.Animal;
import jogo.strategy.MovimentoRato;
import jogo.strategy.MovimentoElefante;
import jogo.strategy.MovimentoPadrao;
import framework.facade.GerenciadorTurnos;
public class Main {
    public static void main(String[] args) {
        
        // Inicializa o jogo
       JogoSelva jogo = new JogoSelva();

        // Configura as estratégias de movimento
        for (Animal animal : jogo.getAnimais()) {
            switch (animal.getTipoAnimal()) {
                case RATO -> animal.setEstrategiaMovimento(new MovimentoRato());
                case ELEFANTE -> animal.setEstrategiaMovimento(new MovimentoElefante());
                default -> animal.setEstrategiaMovimento(new MovimentoPadrao());
            }
        } 

        // Exemplo: mover o rato da posição (2,2) para (3,2)
        Posicao origem = new Posicao(2, 2);
        Animal rato = jogo.getAnimalEm(origem);
        Posicao destino = new Posicao(3, 2);

        // Garante que o rato existe na posição indicada
        if (rato != null) {
            GerenciadorTurnos gerenciadorTurnos = jogo.getGerenciadorTurnos(); // Esse método deve estar na classe JogoSelva

            // Cria comando de mover
            MoverCommand comando = new MoverCommand(rato.getJogador(), destino, rato, gerenciadorTurnos);

            // Executa comando
            GerenciadorComandos invocador = new GerenciadorComandos();
            invocador.executarComando(comando);

        } else {
            System.out.println("Nenhum rato encontrado na posição (2,2).");
        }
    }
}
