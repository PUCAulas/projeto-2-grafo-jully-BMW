package com.grafos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.grafos.grafo.Grafo;

public class App {

    static final String rodoviaria = "codigo\\grafo\\src\\main\\java\\com\\grafos\\rotas.txt";
    static final String rotaEureliana = "codigo\\grafo\\src\\main\\java\\com\\grafos\\rotaEureliana.txt";
    static final String rotaDesconexa = "codigo\\grafo\\src\\main\\java\\com\\grafos\\rotaNConectada.txt";
    // Crie a matriz de distâncias a partir do arquivo
    static Map<String, Integer> vertexIndices = new HashMap<>();

    public static void main(String[] args) {

        // Criação Grafo para questão A, B e C
        List<List<Integer>> ListGraph = Grafo.createDistanceAdjacencyList(rodoviaria, vertexIndices);
        System.out.println(vertexIndices);

        // Questão C
        // (c) uma recomendação de visitação em todas
        // as cidades e todas as estradas,

        EulerianPathDirectedEdgesAdjacencyList solver;
        solver = new EulerianPathDirectedEdgesAdjacencyList(ListGraph);

        // Outputs path: [1, 3, 5, 6, 3, 2, 4, 3, 1, 2, 2, 4, 6]
        System.out.println("Caminho para perrcorer todas cidades e estradas possiveis: "
                + Arrays.toString(solver.getEulerianPath()));

        // ### Questão A e B
        // a) se existe estrada de qualquer cidade para
        // qualquer cidade, (b) no caso de não ser possível chegar em alguma cidade via
        // transporte terrestre,
        // identifique quais cidades encontram-se nessas condições,

        GraphConnectivityChecker checker = new GraphConnectivityChecker(ListGraph);
        List<Integer> unreachableVertices = checker.findUnreachableVertices();

        if (unreachableVertices.isEmpty()) {
            System.out.println("O grafo é conexo. Existe estrada de qualquer cidade para qualquer cidade");
        } else {
            System.out.println("O grafo não é conexo. Cidades não alcançáveis:");
            for (int i = 0; i < unreachableVertices.size(); i++) {
                int cityIndex = unreachableVertices.get(i);
                String cityName = Grafo.findCityByIndex(vertexIndices, cityIndex);
                System.out.print("\n -" + cityName);
            }
        }
        // ----------------------------------------------------------------------------------------

        // // (d) recomendação de uma rota para um passageiro que deseja partir
        // // da rodoviária, percorrer todas as cidades conectadas e retornar à
        // rodoviária,
        // // percorrendo a menor distância possível.

        // Crie a matriz de distâncias a partir do arquivo
        int startNode = 0;
        double[][] matrixGraph = Grafo.createDistanceMatrix(rodoviaria, vertexIndices);

        ShortestPath ShortestPathSolver = new ShortestPath(startNode, matrixGraph);
        // Obtém a turnê do caixeiro viajante
        List<Integer> tour = ShortestPathSolver.getTour();

        // Imprime a turnê com os nomes das cidades
        System.out.print("Tour: ");
        for (int i = 0; i < tour.size(); i++) {
            int cityIndex = tour.get(i);
            String cityName = Grafo.findCityByIndex(vertexIndices, cityIndex);
            System.out.print(cityName);
            if (i < tour.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();

        // Imprime o custo minimo da turnê
        System.out.println("Tour cost: " + ShortestPathSolver.getTourCost());

    }
}
