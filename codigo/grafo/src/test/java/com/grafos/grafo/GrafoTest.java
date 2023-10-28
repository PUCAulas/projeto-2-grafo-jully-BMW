package com.grafos.grafo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class GrafoTest {

    @Test
    public void findCityByIndexTest() {
        Map<String, Integer> vertexIndices = createVertexIndices();

        int indexToFind = 0;
        String cityName = Grafo.findCityByIndex(vertexIndices, indexToFind);

        // Verifique se a cidade encontrada é igual a "Cidade do Cabo"
        if ("Cidade do Cabo".equals(cityName)) {
            System.out.println("Teste passou: cityName é igual a 'Cidade do Cabo'");
        } else {
            System.out.println("Teste falhou: cityName não é igual a 'Cidade do Cabo'");
        }
    }

    @Test
    public void createDistanceMatrix() {
        Map<String, Integer> vertexIndices = new HashMap<>();
        int startNode = 0;
        double[][] distanceMatrix = Grafo.createDistanceMatrix("codigo\\grafo\\src\\test\\java\\com\\grafos\\rotas.txt",
                vertexIndices);

        if (distanceMatrix != null) {
            // Teste 1: Verifique o tamanho da matriz
            int n = distanceMatrix.length;
            System.out.println("Tamanho da matriz: " + n);

            // Teste 2: Verifique o valor da matriz em algumas posições
            int index1 = vertexIndices.get("Cidade do Cabo");
            int index2 = vertexIndices.get("Joanesburgo");
            double distance1to2 = distanceMatrix[index1][index2];
            System.out.println("Distância de Cidade do Cabo para Joanesburgo: " + distance1to2);

            // Continue com mais verificações de valores da matriz conforme necessário

        } else {
            System.out.println("Falha ao criar a matriz de distâncias.");
        }
    }

    @Test
    public void createDistanceAdjacencyList() {
        Map<String, Integer> vertexIndices = new HashMap<>();
        // Chame a função de criação da lista de adjacência
        List<List<Integer>> adjacencyList = Grafo.createDistanceAdjacencyList("codigo\\grafo\\src\\test\\java\\com\\grafos\\rotas.txt", vertexIndices);

        if (adjacencyList != null) {
            // Teste 1: Verifique o tamanho da lista
            int n = adjacencyList.size();
            System.out.println("Tamanho da lista de adjacência: " + n);

            // Teste 2: Verifique a existência de conexões
            int index1 = vertexIndices.get("Cidade do Cabo");
            int index2 = vertexIndices.get("Joanesburgo");
            List<Integer> connections1to2 = adjacencyList.get(index1);
            boolean isConnected = connections1to2.contains(index2);
            System.out.println("Cidade do Cabo está conectada a Joanesburgo: " + isConnected);

            // Continue com mais verificações de acordo com suas expectativas

        } else {
            System.out.println("Falha ao criar a lista de adjacência.");
        }

    }

    private Map<String, Integer> createVertexIndices() {
        Map<String, Integer> vertexIndices = new HashMap<>();
        vertexIndices.put("Bangcoc", 10);
        vertexIndices.put("Cidade do Cabo", 0);
        vertexIndices.put("Nairobi", 2);
        vertexIndices.put("Berlim", 6);
        vertexIndices.put("Tóquio", 7);
        vertexIndices.put("Pequim", 8);
        vertexIndices.put("Joanesburgo", 1);
        vertexIndices.put("Londres", 4);
        vertexIndices.put("Amsterdã", 5);
        vertexIndices.put("Mumbai", 9);
        vertexIndices.put("Paris", 3);
        return vertexIndices;
    }
}
