package com.grafos;

import java.util.ArrayList;
import java.util.List;

public class QuestaoAeB {

  private final int n; // Número de vértices no grafo.
  private final List<List<Integer>> graph; // Lista de adjacência representando o grafo.
  private boolean[] visited;

  public QuestaoAeB(List<List<Integer>> graph) {
    this.n = graph.size();
    this.graph = graph;
  }

  public List<Integer> findUnreachableVertices() {
    if (n <= 1) {
      return new ArrayList<>(); // Um grafo com 0 ou 1 vértice não tem vértices não alcançáveis.
    }

    visited = new boolean[n];
    dfs(0); // Comece a busca a partir de um vértice arbitrário.

    List<Integer> unreachableVertices = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        unreachableVertices.add(i); // Adicione vértices não alcançáveis à lista.
      }
    }

    return unreachableVertices;
  }

  private void dfs(int vertex) {
    visited[vertex] = true;
    for (int neighbor : graph.get(vertex)) {
      if (!visited[neighbor]) {
        dfs(neighbor);
      }
    }
  }
}
