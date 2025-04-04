# Padrão Abstract Factory (Fábrica Abstrata)
## Intenção
Fornecer uma interface para criar famílias de objetos relacionados ou dependentes sem especificar suas classes concretas.

## Motivação
No desenvolvimento do Jogo da Selva, precisamos criar famílias de objetos, como animais e terrenos, que sejam consistentes em diferentes temas, como Realista, Cartoon e Pixel Art.
Sem um padrão, o código ficaria confuso e difícil de manter, tornando a troca de temas e a adição de novos estilos complicadas. Para resolver isso, usamos o padrão Abstract Factory.
Esse padrão define uma interface chamada FabricaPecasSelva, que inclui métodos como criarPeca() e criarTerreno(). Cada tema terá sua própria implementação dessa interface, garantindo que os objetos criados sejam sempre compatíveis com o estilo escolhido.

### Cenário sem o Padrão
```mermaid
classDiagram
	class Leao
	class Tigre
	class Agua
	class Armadilha
    
	class Jogo {
    	-List~Animal~ animais
    	-List~Terreno~ terrenos
    	+criarPecas()
	}
    
	Jogo --> Leao
	Jogo --> Tigre
	Jogo --> Agua
	Jogo --> Armadilha
```
### Estrutura do Padrão (GOF)
![image](https://github.com/user-attachments/assets/09722940-c24c-4950-b8f1-7f57392a31f7)

### Diagrama UML (Padrão)
```mermaid
classDiagram
	class FabricaPecasSelva {
    	<<interface>>
    	+criarPeca(String, Jogador) Peca
    	+criarTerreno(String) Terreno
	}
    
	class Peca {
    	<<interface>>
	}
    
	class Terreno {
    	<<interface>>
	}
    
	FabricaPecasSelva --> Peca
	FabricaPecasSelva --> Terreno
```

## Participantes
- AbstractFactory (FabricaPecasSelva): Interface com métodos para criar produtos abstratos
- ConcreteFactory: Implementa a criação de produtos concretos
- AbstractProduct (Peca, Terreno): Interfaces dos produtos
- ConcreteProduct (Leao, Agua):  define um objeto-produto a ser criado pela correspondente fábrica concreta.



# Padrão Builder

## Intenção
O padrão Builder tem como objetivo principal simplificar a construção de objetos complexos que exigem múltiplos parâmetros, alguns obrigatórios e outros opcionais. 
Em vez de depender de construtores sobrecarregados ou métodos setters que podem deixar o objeto em estado inconsistente, o Builder oferece uma abordagem mais organizada e segura. 
Ele permite configurar o objeto passo a passo, garantindo que todas as validações necessárias sejam aplicadas antes que a instância final seja criada.

## Motivação
Na construção de sistemas de jogos, frequentemente nos deparamos com a necessidade de criar objetos complexos como personagens jogáveis. 
Esses objetos geralmente possuem uma variedade de atributos, alguns essenciais e outros opcionais, cada um com suas próprias regras de validação.
O principal desafio surge quando tentamos criar esses objetos usando abordagens convencionais. Construtores com múltiplos parâmetros rapidamente se tornam difíceis de gerenciar e entender. 
Imagine um construtor que precise aceitar nome, cor, pontos iniciais, nível, habilidades especiais e equipamentos - rapidamente teríamos um método confuso e propenso a erros. 
Alternativas como usar setters após a criação também apresentam problemas, pois permitem que o objeto exista em estados inconsistentes durante sua construção.

### Cenário sem o Padrão
```mermaid
classDiagram
	class Jogador {
    	-String nome
    	-String cor
    	-int pontos
    	+Jogador(nome: String, cor: String, pontos: int)
    	+getNome() String
    	+setNome(nome: String)
    	+getCor() String
    	+setCor(cor: String)
    	+getPontos() int
    	+setPontos(pontos: int)
	}

	class Cliente {
    	+criarJogador()
	}

	Cliente --> Jogador
```
### Diagrama UML (Padrão)
```mermaid
classDiagram
	class BuilderJogador {
    	<<interface>>
    	+comNome(String) BuilderJogador
    	+comCor(String) BuilderJogador
    	+comPontos(int) BuilderJogador
    	+construir() Jogador
	}

	class ConstrutorJogador {
    	-jogador: Jogador
    	+novo() ConstrutorJogador
    	+comNome(String) ConstrutorJogador
    	+comCor(String) ConstrutorJogador
    	+comPontos(int) ConstrutorJogador
    	+construir() Jogador
	}

	class Jogador {
    	-nome: String
    	-cor: String
    	-pontos: int
    	+getNome()
    	+setNome(String)
    	+getCor()
    	+setCor(String)
    	+getPontos()
    	+setPontos(int)
	}

	class DiretorJogador {
    	+criarNovo(String, String) Jogador
	}

	BuilderJogador <|.. ConstrutorJogador : implements
	ConstrutorJogador --> Jogador 
	DiretorJogador --> ConstrutorJogador 
```
## Participantes

- Builder (BuilderJogador): Define a interface para construir diferentes partes do objeto Jogador. Fornece os métodos abstratos para personalização (comNome(), comCor(), etc.).

- ConcreteBuilder (ConstrutorJogador):Aqui temos a implementação concreta do Builder. O ConstrutorJogador é encarregado de construir o objeto Jogador de fato. Ele mantém a representação do jogador em um atributo interno e oferece métodos específicos para configurar suas propriedades, como comNome(), comCor() e comPontos(). Após definir todas as características desejadas, o método construir() é chamado para retornar o objeto Jogador completamente configurado e pronto para uso.

- Director (DiretorJogador): Garante que os passos de construção sejam seguidos corretamente. Utiliza um Builder para criar um Jogador com configurações específicas.

- Product (Jogador): O objeto complexo que está sendo construído.


# Singleton

## Intenção
Garantir que apenas uma instância das configurações do jogo exista em toda a aplicação, fornecendo um acesso global e consistente a esses dados.

## Motivação
Em um jogo, é fundamental que configurações como o tamanho do tabuleiro e o número máximo de jogadores sejam definidas de forma centralizada. Se cada parte do jogo puder ter suas próprias configurações, surgirão inconsistências: um jogador pode estar em um tabuleiro de 7x9 enquanto outro está em um de 10x10, o que tornaria a experiência confusa e cheia de erros.

O padrão Singleton resolve esse problema ao garantir que haja apenas uma instância da configuração do jogo, acessível a todas as partes do sistema. Isso significa que todos compartilham os mesmos valores, e qualquer alteração é refletida em todo o jogo, mantendo a coerência.

Por exemplo, se o tabuleiro é 7x9, mas o sistema de colisões usa um grid de 10x12, isso pode resultar em bugs sérios, como jogadores aparecendo fora do mapa ou habilidades que funcionam em alguns módulos, mas falham em outros.

## Cenário sem o Padrão
```mermaid
classDiagram
    class ConfiguracaoJogo {
        -int larguraTabuleiro
        -int alturaTabuleiro
        -int quantidadeMaximaJogador
        +getLarguraTabuleiro()
        +setLarguraTabuleiro()
    }

    class Tabuleiro {
        -ConfiguracaoJogo config
    }

    class Jogador {
        -ConfiguracaoJogo config
    }

    class MenuOpcoes {
        -ConfiguracaoJogo config
    }

    Tabuleiro --> ConfiguracaoJogo
    Jogador --> ConfiguracaoJogo
    MenuOpcoes --> ConfiguracaoJogo
```
## Diagrama UML (Padrão)
``` mermaid

 ```
## Padrão aplicado no cenário

No código fornecido, o padrão Singleton é aplicado para gerenciar as configurações globais do jogo:

- Garante que todas as partes do jogo acessem as mesmas configurações.
- Centraliza a gestão das configurações.
- Permite modificações globais quando necessário.

## Participantes

- **Singleton (ConfiguracaoJogo)** - mantém a única instância da classe e fornece acesso global.
  - Armazena os dados de configuração (quantidadeMaximaJogador, larguraTabuleiro, alturaTabuleiro).
  - Implementa o método getInstancia() para controle de acesso.

# Padrão Prototype
## Intenção
Permitir a criação de novos objetos através da clonagem de instâncias existentes, evitando a necessidade de subclasses para criação de objetos e fornecendo um mecanismo flexível para criação de objetos complexos.

## Motivação
Em um jogo de tabuleiro na selva, exploradores, animais e armadilhas precisam ser criados dinamicamente. O desafio é permitir a criação de novos tipos de peças sem repetir código ou dificultar a manutenção do jogo.
A solução está no uso de protótipos: em vez de criar cada peça do zero, o jogo pode clonar um modelo pré-existente. Assim, cada ferramenta do jogo gera novas peças a partir de um protótipo, tornando o código mais flexível.

### Cenário sem o Padrão
``` mermaid
classDiagram
    class Jogador
    class Posicao
    class Peca {
        +String tipo
        +int forca
        +Jogador jogador
        +Posicao posicao
        +novoElefante() Peca
        +novoLeao() Peca
    }
    
    Peca --> Jogador
    Peca --> Posicao
```
### Estrutura GOF

![image](https://github.com/user-attachments/assets/3b7b2bf7-b978-47a1-b60a-979807fc581c)

## Diagrama UML (Padrão)
``` mermaid
classDiagram
    class PecaPrototype {
        <<interface>>
        +clonar() PecaPrototype
        +getTipo() String
        +getForca() int
        +setPosicao(Posicao)
        +setJogador(Jogador)
        +podeCapturar(PecaPrototype) boolean
        +movimentoValido(Terreno,Posicao) boolean
    }
    
    class Peca {
        <<abstract>>
        -String tipo
        -int forca
        -Jogador jogador
        -Posicao posicao
        +clonar() PecaPrototype
        +getTipo() String
        +getForca() int
        +setPosicao(Posicao)
        +setJogador(Jogador)
    }
    
    class Elefante {
        +Elefante(Elefante)
    }
    
    class Leao {
        +Leao(Leao)
    }
    
    PecaPrototype <|.. Peca
    Peca <|-- Elefante
    Peca <|-- Leao
    Peca --> Jogador
    Peca --> Posicao
 ```
- Padrão aplicado no cenário:
Com a aplicação do padrão Prototype, cada tipo de peça pode ser criado a partir de um protótipo existente. Isso simplifica a criação de novas peças e reduz a duplicação de código. Por exemplo, ao clonar uma peça existente, todas as suas propriedades são copiadas automaticamente.

## Participante
- Prototype (PecaPrototype) Interface que define o método clonar() para permitir a clonagem de objetos.
- ConcretePrototype (Peca): Classe abstrata que implementa PecaPrototype e fornece a lógica para clonagem e atributos das peças.


# Padrão Facade  
## Intenção  

Fornecer uma interface unificada para um conjunto de interfaces em um subsistema. O Facade define uma interface de nível mais alto que torna o subsistema mais fácil de ser usado, reduzindo o acoplamento e organizando melhor as interações entre os componentes internos.

## Motivação  
Durante o desenvolvimento do jogo, notamos que várias partes do código interagiam diretamente com regras complexas, como validação de movimentos e verificação de vencedores. Isso tornava o código difícil de ler e manter. Para resolver isso, criamos a RegrasJogoFacade, que centraliza todas as regras do jogo em um único ponto, permitindo chamadas simples e diretas sem expor a lógica interna.  

### Antes do Facade  
O código precisava interagir diretamente com várias classes diferentes, o que aumentava a complexidade e dificultava futuras modificações.  


### Depois do Facade  
Agora, a RegrasJogoFacade encapsula toda a lógica e expõe apenas os métodos essenciais, como movimentoValido(), capturaValida() e verificarVencedor(). Isso torna o código mais limpo e fácil de manter.  

### Estrutura GOF

![alt text](image.png)

## Estrutura  
O Facade no projeto é composto por:  
- *RegrasJogoFacade (Interface)* → Define os métodos principais.  
- *RegrasJogoFacadeImpl (Implementação)* → Coordena as chamadas para componentes internos.  
- *GerenciadorTurnos, Tabuleiro, Peca, Jogador, etc.* → Componentes que lidam com regras específicas acessadas pela Facade.  

  

