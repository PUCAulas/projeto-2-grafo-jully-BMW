package com.grafos;

import java.util.ArrayList;
import java.util.List;

public class UnreachableVerticesFinder  {

    private final List<List<Integer>> graph; // Representação do grafo como lista de adjacência
    private final int numVertices;

    public UnreachableVerticesFinder(List<List<Integer>> graph) {
        this.graph = graph;
        this.numVertices = graph.size();
    }

    public List<Integer> findUnreachableVertices() {
        List<Integer> unreachableVertices = new ArrayList<>();
        boolean[] visited = new boolean[numVertices];

        // Execute a busca em profundidade a partir de todos os vértices
        for (int vertex = 0; vertex < numVertices; vertex++) {
            if (!visited[vertex]) {
                depthFirstSearch(vertex, visited);
            }
        }

        // Verifique quais vértices não foram visitados durante a busca
        for (int vertex = 0; vertex < numVertices; vertex++) {
            if (!visited[vertex]) {
                unreachableVertices.add(vertex);
            }
        }

        return unreachableVertices;
    }

    private void depthFirstSearch(int vertex, boolean[] visited) {
        visited[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                depthFirstSearch(neighbor, visited);
            }
        }
    }
}
