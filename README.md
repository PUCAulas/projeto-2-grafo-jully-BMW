[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=11963022&assignment_repo_type=AssignmentRepo)
# Caminho em Grafos
Sabemos que um grafo G é uma estrutura composta por um conjunto de vértices V e um conjunto de arestas
A, e é representado como G = (V, A). No cenário proposto, um vértice é representado por um número inteiro denominado ID, um rótulo textual. Uma aresta, por sua vez, é representada por um par de IDs de vértices denominados origem e destino, além de um valor numérico denominado peso. Dadas as definições de vértices e arestas, um grafo é um objeto composto por dois atributos: uma lista de vértices e uma lista de arestas. A partir dessas definições, deseja-se solucionar problemas da Rodoviária Internacional:

1. A solução para transporte de passageiros não precisa deter informações sobre veículos ou pessoas, mas
deve ser capaz de informar a pessoas interessadas: (a) se existe estrada de qualquer cidade para
qualquer cidade, (b) no caso de não ser possível chegar em alguma cidade via transporte terrestre,
identifique quais cidades encontram-se nessas condições, (c) uma recomendação de visitação em todas
as cidades e todas as estradas, e (d) recomendação de uma rota para um passageiro que deseja partir
da rodoviária, percorrer todas as cidades conectadas e retornar à rodoviária, percorrendo a menor
distância possível.

2. Para solucionar a presente demanda do setor de transporte de passageiros, vocês receberam os
seguintes registros do sistema de informações geográficas internacionais, em formato .txt:
```
Cidade do Cabo: Joanesburgo (1270), Nairobi (3900), Paris (8900)
Joanesburgo: Cidade do Cabo (1270), Nairobi (4700), Mumbai (6500)
Nairobi: Cidade do Cabo (3900), Joanesburgo (4700), Mumbai (4300)
Paris: Londres (340), Berlim (1050), Cidade do Cabo (8900)
Londres: Paris (340), Amsterdã (320), Cidade do Cabo (8900)
Amsterdã: Londres (320), Paris (430), Berlim (620)
Berlim: Amsterdã (620), Paris (1050)
Tóquio: Pequim (2400), Mumbai (6800)
Pequim: Tóquio (2400), Mumbai (3700), Bangcoc (2700)
Mumbai: Pequim (3700), Tóquio (6800), Nairobi (4300)
Bangcoc: Pequim (2700), Mumbai (4300), Joanesburgo (8800)
```
Cada registro contém um nome de cidade atendida pela rodoviária e as cidades vizinhas com
suas distâncias, para as quais há estrada. A cidade sede da rodoviária é a primeira do arquivo.

3. Vocês terão quatro semanas para solucionar o problema do setor.

i. Para a primeira entrega, dia 20/09, o grupo deverá atualizar o readme.md do GitHub,
desenhar o diagrama de classes conforme o enunciado e implementar a representação
de grafos, conforme o enunciado;

ii. Para a segunda entrega, dia 27/09, deverão apresentar a solução para os requisitos (a) e (b) funcionando, com o respectivo teste unitário;

iii. Para a terceira entrega, 04/10, deverão apresentar a solução para o requisito (c) funcionando;

iv. Para a quarta e última entrega, 11/10, deverão apresentar a solução para o requisito (d) funcionando;

As soluções deverão ser implementadas como uma aplicação de console, em Java, com um menu simples com
pelo menos os itens dos requisitos como opções.

## Alunos integrantes da equipe

* Belle Nerissa Aguiar Elizeu
* Jully Ketely Alves da Silva
* Maria Aryene Costa dos Santos
* Warley Leandro dos Anjos

## Professor responsável 

* Johnatan Alves de Oliveira

