package com.grafos;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class QuestaoAeBTest {

    @Test
    public void testFindUnreachableVertices() {
        // Crie um exemplo de grafo com alguns vértices não alcançáveis
        List<List<Integer>> exampleGraph = createExampleGraph();

        // Chame a função para encontrar vértices não alcançáveis
        QuestaoAeB checker = new QuestaoAeB(exampleGraph);
        List<Integer> unreachableVertices = checker.findUnreachableVertices();

        if (unreachableVertices.isEmpty()) {
            System.out.println("Teste passou: O grafo é conexo.");
        } else {
            System.out.println("Teste falhou: O grafo não é conexo. Cidades não alcançáveis:");
            for (int i = 0; i < unreachableVertices.size(); i++) {
                int cityIndex = unreachableVertices.get(i);
                System.out.println("- Vértice não alcançável: " + cityIndex);
            }
        }
    }

    @Test
    public List<List<Integer>> createExampleGraph() {
        // Crie um exemplo de grafo com alguns vértices não alcançáveis
        List<List<Integer>> exampleGraph = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            exampleGraph.add(new ArrayList<Integer>());
        }
        // Adicione conexões ao grafo
        exampleGraph.get(0).add(1);
        exampleGraph.get(1).add(0);
        exampleGraph.get(1).add(2);
        exampleGraph.get(2).add(1);
        exampleGraph.get(3).add(4);
        exampleGraph.get(4).add(3);

        return exampleGraph;
    }
}
