# Jogo da Forca

## Participante(s):
* [Lucca Hiratsuca Costa](https://github.com/LuccaHiratsuca)

## Descrição do Projeto

Esse projeto tem como finalidade o desenvolvimento e implementação de um jogador de jogo da forca, além da avaliação de seu desempenho em diferentes cenários.

## Pré-requisitos e dependências

Clonar o repositorio do projeto:

```bash
https://github.com/LuccaHiratsuca/jogo-da-forca.git
```

Instalar as dependencias:

```bash
pip install -r requirements.txt
```

## Como rodar a aplicação

Para rodar a aplicação, basta executar o arquivo `main.py`:

```bash
python main.py
```

## Implementação

O código implementado está divido em algumas partes, dentre essas:

**Inicialização**: O jogo é iniciado chamando o método novo_jogo() do objeto jogo (provindo da classe ``JogoDeForca``). A palavra a ser adivinhada é armazenada em palavra, e uma lista palavras é criada contendo todas as palavras possíveis com o mesmo comprimento da palavra a ser adivinhada.

**Definição das variáveis**: 
- Um conjunto vazio (``set()``) chamado letras_tentadas é criado para armazenar as letras já tentadas pelo jogador. 
- A variável letras é inicializada como um objeto Counter, que conta a frequência de cada letra nas palavras possíveis. Para isso foi utilizado a biblioteca ``collections``.

**Loop principal**: O jogo acontece em um loop while que continua até que o jogador ainda tenha vidas restantes.

**Verificação de condições de finalização**: Uma condição é verificada para determinar se o jogo está em um estado em que é possível adivinhar a palavra ou se é necessário continuar adivinhando letras. Se houver apenas uma possibilidade restando (len(palavras) == 1) ou se houver mais de um e o jogador tiver apenas uma vida restante (len(palavras) > 1 and jogo.vidas == 1), o código retorna a tentativa da palavra atual utilizando o método ``tentar_palavra()`` do objeto jogo.

**Seleção da próxima letra**: Caso contrário, o algoritmo seleciona a próxima letra a ser tentada com base na frequência das letras nas palavras possíveis. A letra escolhida é aquela com a maior frequência entre as letras que ainda não foram tentadas. Isso é feito utilizando a função``max()`` juntamente com uma expressão geradora que itera sobre as letras que não estão em letras_tentadas e seleciona a letra com a maior frequência de ocorrência de acordo com o objeto letras.


**Atualização da lista de palavras**: Dependendo do resultado da tentativa, o algoritmo atualiza a lista palavras. Se o retorno da função for verdadeiro (ou seja, a letra está presente na palavra), a lista novas_palavras é atualizada com palavras que possuem a letra nas posições corretas. Caso contrário, essa é atualizada com palavras que não contêm a letra.

**Atualização de variáveis**: A lista palavras é atualizada com a lista novas_palavras. A letra atual é adicionada ao conjunto letras_tentadas, evitando tentativas repetidas. A variável letras é atualizada novamente utilizando um objeto Counter, contando as letras nas palavras possíveis, excluindo aquelas já tentadas.

**Conclusão do loop**: O loop continua até que o jogador não tenha mais vidas restantes. Se o loop terminar sem retornar uma
palavra, o algoritmo retorna a palavra atual utilizando o método tentar_palavra() do objeto jogo.

## Exemplos de falha:

### Exemplo 1: Letra mais frequente
Por conta do algotimo se basear na frequência das letras nas palavras possíveis, ele pode falhar em alguns casos. Por exemplo, se a palavra a ser adivinhada for "abacaxi", o algoritmo irá tentar a letra "a" primeiro, pois ela é a mais frequente. Porém, se o correto a ser adivinhado for "abacate", o algoritmo irá tentar a letra "a" primeiro, mas ela não está presente na palavra, fazendo com que o algoritmo erre a palavra.

### Exemplo 2: Vidas restantes
O algoritmo também pode falhar caso o jogador tenha apenas uma vida restante e ainda há diversas possibilidade possíveis, isso faz com que o programa acerte ou erro apenas com base na sorte.

### Exemplo 3: Palavras com combinações de letras pouco frequentes
Como dito anteriormente, por conta do algoritmo se basear na frequência das letras nas palavras possíveis, ele pode falhar em alguns casos, principalmente quando essas possuíres letras pouco comuns, como: ``X``, ``Z``, ``W``, ``Y``.

## Resultado dos testes

![Resultado dos testes](assets/output.png)

O algoritmo, após realizar 1000 jogos, obteve a taxa de acerto de 92,7% e a taxa de erro de 7,3%.



