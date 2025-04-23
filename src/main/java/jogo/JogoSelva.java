package jogo;

import framework.facade.GerenciadorTurnos;
import framework.model.Jogador;
import framework.model.Posicao;
import framework.model.Tabuleiro;
import jogo.model.Animal;
import framework.model.pecas.TipoAnimal;

import java.util.ArrayList;
import java.util.List;

public class JogoSelva {
    private final Tabuleiro tabuleiro;
    private final List<Animal> animais;
    private final Jogador jogador1;
    private final Jogador jogador2;
    private final GerenciadorTurnos gerenciadorTurnos;

    public JogoSelva() {
        this.tabuleiro = new Tabuleiro(7, 9);
        this.animais = new ArrayList<>();

        this.jogador1 = new Jogador("Jogador 1", "Azul");
        this.jogador2 = new Jogador("Jogador 2", "Vermelho");

        List<Jogador> jogadores = List.of(jogador1, jogador2);
        this.gerenciadorTurnos = new GerenciadorTurnos(jogadores);

        inicializarAnimais();
    }

    private void inicializarAnimais() {
        // Exemplo: adicionar um rato para cada jogador
        Animal rato1 = new Animal("RATO", 1, jogador1, new Posicao(2, 2));
        Animal rato2 = new Animal("RATO", 1, jogador2, new Posicao(6, 6));

        animais.add(rato1);
        animais.add(rato2);
    }

    public Animal getAnimalEm(Posicao posicao) {
        for (Animal animal : animais) {
            if (animal.getPosicao().equals(posicao)) {
                return animal;
            }
        }
        return null;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public GerenciadorTurnos getGerenciadorTurnos() {
        return gerenciadorTurnos;
    }
}
