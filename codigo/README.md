## Documentação para Execução de Projeto Java no Visual Studio Code

Este guia fornece instruções sobre como executar um projeto Java no Visual Studio Code (VS Code). O projeto em questão possui um arquivo `App.java` com um menu que permite resolver várias questões relacionadas a um grafo, e também permite testar diferentes percursos substituindo o conteúdo do arquivo `rotas.txt`.

**Requisitos:**
- Visual Studio Code (VS Code) instalado.
- Extensão "Java Extension Pack" instalada no VS Code.
- JDK (Java Development Kit) instalado.

Aqui está um passo a passo para rodar o projeto:

**Passo 1: Clonar o Repositório (Opcional)**

Se o projeto estiver em um repositório Git, você pode cloná-lo para o seu computador. Caso contrário, você pode simplesmente baixar o projeto em um arquivo ZIP e descompactá-lo.

**Passo 2: Abrir o Projeto no VS Code**

Abra o Visual Studio Code e vá para "File" (Arquivo) > "Open Folder" (Abrir Pasta) e selecione a pasta do projeto.

**Passo 3: Configurar o Projeto**

Certifique-se de que a pasta do projeto no VS Code contenha um arquivo `App.java`, bem como o arquivo `rotas.txt`. O `rotas.txt` é o arquivo que define as rotas entre cidades.

**Passo 4: Executar o Projeto**

No VS Code, abra o arquivo `App.java`. Localize o método `main` e clique no ícone "Run" (Executar) ao lado dele ou use o atalho `Ctrl+Shift+F5` (Windows/Linux) ou `Cmd+Shift+F5` (macOS) para executar o aplicativo Java.

Isso compilará e executará o projeto Java. O console do VS Code exibirá a saída do programa.

**Passo 5: Usar o Menu do Aplicativo**

O aplicativo Java possui um menu que permite resolver várias questões relacionadas a um grafo. Você pode usar as opções do menu para explorar diferentes funcionalidades.

- Questão A: Verificar se existe uma estrada de qualquer cidade para qualquer cidade.
- Questão B: Identificar cidades não alcançáveis.
- Questão C: Recomendação de visitação em todas as cidades e estradas.
- Questão D: Recomendação de uma rota para um passageiro que deseja percorrer todas as cidades conectadas e retornar à rodoviária.

Para realizar as questões A, B e C, o aplicativo usa um grafo representado como uma lista de adjacência. Você também pode testar diferentes percursos substituindo o conteúdo do arquivo `rotas.txt`, respeitando a estrutura especificada no início deste documento.

**Passo 6: Visualizar Resultados**

O resultado de cada questão será exibido no console do VS Code após a execução do aplicativo.

**Observação Importante:**

Certifique-se de ter o arquivo `rotas.txt` devidamente formatado antes de executar o programa para garantir que as questões funcionem corretamente.

Formatação:

nome_cidade_vertice: cidade_saida_1(distancia),cidade_saida_2(distancia),...

Com este guia, você deve ser capaz de executar o projeto Java no Visual Studio Code e explorar as diferentes funcionalidades disponíveis. Se necessário, você pode adaptar o projeto de acordo com suas necessidades ou criar sua própria entrada no arquivo `rotas.txt` para testar diferentes cenários.