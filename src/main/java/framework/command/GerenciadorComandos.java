package framework.command;

import java.util.Stack;

public class GerenciadorComandos {
    private Stack<Command> historicoExecucao = new Stack<>();
    private Stack<Command> historicoDesfazer = new Stack<>();

    public void executarComando(Command comando) {
        comando.executar();
        historicoExecucao.push(comando); // Adiciona ao histórico de execução
        historicoDesfazer.clear();       // Limpa o histórico de refazer
    }

    public void desfazer() {
        if (!historicoExecucao.isEmpty()) {
            Command comando = historicoExecucao.pop();
            comando.desfazer();
            historicoDesfazer.push(comando); // Adiciona ao histórico de refazer
        } else {
            System.out.println("Nada para desfazer.");
        }
    }

    public void refazer() {
        if (!historicoDesfazer.isEmpty()) {
            Command comando = historicoDesfazer.pop();
            comando.executar();
            historicoExecucao.push(comando); // Adiciona novamente ao histórico de execução
        } else {
            System.out.println("Nada para refazer.");
        }
    }
}
