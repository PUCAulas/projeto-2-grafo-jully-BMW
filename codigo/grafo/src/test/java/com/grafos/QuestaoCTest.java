package com.grafos;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class QuestaoCTest {

    @Test
    public void testEulerianPath() {
        // Crie um exemplo de grafo com um caminho Euleriano
        List<List<Integer>> exampleGraph = createEulerianPathGraph();

        // Chame a função para encontrar o caminho Euleriano
        QuestaoC solver = new QuestaoC(exampleGraph);
        int[] eulerianPath = solver.getEulerianPath();

        if (eulerianPath != null) {
            System.out.println("Teste passou: Caminho Euleriano encontrado.");
            System.out.print("Caminho Euleriano: ");
            for (int node : eulerianPath) {
                System.out.print(node + " ");
            }
            System.out.println();
        } else {
            System.out.println("Teste falhou: Nenhum caminho Euleriano encontrado.");
        }
    }

    public void testIsGraphConnected() {
        // Crie um exemplo de grafo conexo
        List<List<Integer>> connectedGraph = createConnectedGraph();

        // Chame a função para verificar a conectividade
        QuestaoC checker = new QuestaoC(connectedGraph);
        boolean isConnected = checker.isGraphConnected();

        if (isConnected) {
            System.out.println("Teste passou: O grafo é conexo.");
        } else {
            System.out.println("Teste falhou: O grafo não é conexo.");
        }
    }

    // Função para criar um exemplo de grafo com um caminho Euleriano
    public static List<List<Integer>> createEulerianPathGraph() {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // Adicione conexões ao grafo para criar um caminho Euleriano
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(3).add(2);
        graph.get(3).add(4);
        graph.get(4).add(3);
        return graph;
    }

    // Função para criar um exemplo de grafo conexo
    public static List<List<Integer>> createConnectedGraph() {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // Adicione conexões ao grafo para torná-lo conexo
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(3).add(2);
        return graph;
    }
}
