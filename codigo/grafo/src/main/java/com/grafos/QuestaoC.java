package com.grafos;

import java.util.LinkedList;
import java.util.List;

public class QuestaoC {

  private final int n;
  private int edgeCount;
  private int[] in, out;
  private LinkedList<Integer> path;
  private List<List<Integer>> graph;

  public QuestaoC(List<List<Integer>> graph) {
    if (graph == null)
      throw new IllegalArgumentException("Grafo não pode ser nulo");
    n = graph.size();
    this.graph = graph;
    path = new LinkedList<>();
  }

  // Retorna uma lista de IDs de nó edgeCount + 1 que fornecem o caminho Euleriano ou
  // nulo se nenhum caminho existir ou o gráfico estiver desconectado
  public int[] getEulerianPath() {
    setUp();

    if (!graphHasEulerianPath()) {
      System.out.println("Não há caminho que percorra todas as cidades e estradas.");
      return null;
    }
    dfs(findStartNode());

    // Certifique-se de que todas as arestas do gráfico foram atravessadas. Poderia ser o
    // caso o grafo esteja desconectado, nesse caso retorne nulo.
    if (path.size() != edgeCount + 1) {
      System.out.println("Não há caminho que percorra todas as cidades e estradas.");
      return null;
    }

    // Em vez de retornar o 'path' como uma lista vinculada, retorne a solução como
    // um array primitivo para conveniência.
    int[] soln = new int[edgeCount + 1];
    for (int i = 0; !path.isEmpty(); i++)
      soln[i] = path.removeFirst();

    return soln;
  }

  private void setUp() {
    // Cria matrizes que rastreiam o grau de entrada e saída de cada nó.
    in = new int[n];
    out = new int[n];

    edgeCount = 0;

    // Calcule os graus dos nós de entrada e saída.
    for (int from = 0; from < n; from++) {
      for (int to : graph.get(from)) {
        in[to]++;
        out[from]++;
        edgeCount++;
      }
    }
    
  }

  private boolean graphHasEulerianPath() {
    if (edgeCount == 0)
      return false;
    int startNodes = 0, endNodes = 0;
    for (int i = 0; i < n; i++) {
      if (out[i] - in[i] > 1 || in[i] - out[i] > 1)
        return false;
      else if (out[i] - in[i] == 1)
        startNodes++;
      else if (in[i] - out[i] == 1)
        endNodes++;
    }
    return (endNodes == 0 && startNodes == 0) || (endNodes == 1 && startNodes == 1);
  }

  private int findStartNode() {
    int start = 0;
    for (int i = 0; i < n; i++) {
      // Nó inicial exclusivo.
      if (out[i] - in[i] == 1)
        return i;
      // Comece em um nó com uma aresta de saída.
      if (out[i] > 0)
        start = i;
    }
    return start;
  }

  // Execute DFS (Busca em profundidade) para encontrar o caminho Euleriano.
  private void dfs(int at) {
    while (out[at] != 0) {
      int next = graph.get(at).get(--out[at]);
      dfs(next);
    }
    path.addFirst(at);
  }

  // Verifica se o grafo é conexo a partir de um vértice inicial.
  public boolean isGraphConnected() {
    boolean[] visited = new boolean[n];
    dfsForConnectivity(0, visited);

    for (boolean v : visited) {
      if (!v) {
        return false;
      }
    }
    return true;
  }

  // Realiza uma DFS (Busca em profundidade) para verificar a conectividade do grafo.
  private void dfsForConnectivity(int at, boolean[] visited) {
    visited[at] = true;
    for (int next : graph.get(at)) {
      if (!visited[next]) {
        dfsForConnectivity(next, visited);
      }
    }
  }

}