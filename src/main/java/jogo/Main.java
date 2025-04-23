package jogo;

import framework.command.*;
import framework.facade.GerenciadorTurnos;

import java.util.ArrayList;
import java.util.List;

import framework.abstractFactory.*;
import framework.builder.*;
import framework.model.Jogador;
import framework.model.Posicao;
import framework.model.Tabuleiro;
import jogo.abstractFactory.SelvaJogoFactory;
import jogo.builder.ConstrutorJogador;
import jogo.facade.RegrasJogoFacadeImpl;

import jogo.model.Animal;
import jogo.model.SelvaTabuleiro;
import jogo.strategy.MovimentoElefante;
import jogo.strategy.MovimentoPadrao;
import jogo.strategy.MovimentoRato;

public class Main {
    public static void main(String[] args) {
        
        FabricaAbstrataJogo tabuleiroFactory = new SelvaJogoFactory();
        Tabuleiro tabuleiro = tabuleiroFactory.criarTabuleiro();
       
        ConstrutorJogador construtorJogador = new ConstrutorJogador();
        DiretorJogador diretorJogador = new DiretorJogador(construtorJogador);

        Jogador jogador1 = diretorJogador.criarJogador("Pedro", "Preto", 0);
        Jogador jogador2 = diretorJogador.criarJogador("Carlos", "Branco", 0);

        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(jogador1);
        jogadores.add(jogador2);
        tabuleiro.inicializaTerrenoPecas(jogadores);
        //  instanciar regras do jogo facade passando tabuleiro
        //RegrasJogoFacadeImpl regrasDoJogo = new RegrasJogoFacadeImpl(tabuleiro);


        Animal animal = (Animal) tabuleiroFactory.criarPeca(jogador2, new Posicao(1, 1), 0, "LEAO");
        animal.setEstrategiaMovimento(new MovimentoPadrao());
        // 3. Suponha que queremos mover o rato do jogador 1 da posição (2,2) para (3,2)
        Animal rato = (Animal)tabuleiro.obterPecaEm(new Posicao(2, 2));
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
