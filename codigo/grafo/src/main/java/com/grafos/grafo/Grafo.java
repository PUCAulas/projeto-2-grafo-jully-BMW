package com.grafos.grafo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.grafos.aresta.Aresta;
import com.grafos.vertice.Vertice;

public class Grafo {
    private Map<String, ArrayList<Aresta>> listaDeCidades = new HashMap<String, ArrayList<Aresta>>();
    private ArrayList<Vertice> verticesIniciais = new ArrayList<Vertice>();
    static ArrayList<Aresta> arestas = new ArrayList<>();

    public Vertice getVertice(String cidade) {
        for (Vertice vertice : verticesIniciais) {
            if (vertice.getNome().equals(cidade))
                return vertice;
        }
        return null;
    }

    public void setVerticesIniciais(ArrayList<Vertice> verticesIniciais) {
        this.verticesIniciais = verticesIniciais;
    }

    public void adicionarArestas(String cidade, String[] conexoes) {
        for (String conexao : conexoes) {
            String[] dadosConexao = conexao.trim().split("\\(");
            int distancia = Integer.parseInt(dadosConexao[1].replaceAll("[^0-9]", ""));
            arestas.add(new Aresta(cidade, dadosConexao[0], distancia));
        }
        listaDeCidades.put(cidade, arestas);
    }

    public boolean existeEstrada(String cidadeOrigem, String cidadeDestino) {
        if (!listaDeCidades.containsKey(cidadeOrigem) || !listaDeCidades.containsKey(cidadeDestino)) {
            return false;
        }
        for (Aresta aresta : listaDeCidades.get(cidadeOrigem)) {
            if (aresta.getDestino().equals(cidadeDestino)) {
                return true;
            }
        }
        return false;
    }

    public static String findCityByIndex(Map<String, Integer> vertexIndices, int index) {
        for (Map.Entry<String, Integer> entry : vertexIndices.entrySet()) {
            if (entry.getValue() == index) {
                return entry.getKey();
            }
        }
        return null; // Retorna null se o índice não for encontrado
    }

    public static void addDirectedEdge(List<List<Integer>> g, int from, int to) {
        g.get(from).add(to);
    }

    public static List<List<Integer>> initializeEmptyGraph(int n) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>()); // Especificar o tipo genérico como Integer
        }
        return graph;
    }

    // Função para criar a lista de distâncias a partir do arquivo
    public static List<List<Integer>> createDistanceAdjacencyList(String filePath, Map<String, Integer> vertexIndices) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            int index = 0;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String vertexName = parts[0].trim();
                vertexIndices.put(vertexName, index);
                index++;
            }

            int n = vertexIndices.size();
            List<List<Integer>> graph = initializeEmptyGraph(n);

            // Redefinir o leitor para o início do arquivo
            reader.close();

            // Cria um novo leitor para o mesmo arquivo
            BufferedReader newReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(filePath), "UTF-8"));

            while ((line = newReader.readLine()) != null) {
                String[] parts = line.split(":");
                String fromVertex = parts[0].trim();
                String[] connections = parts[1].split(",");

                int fromIndex = vertexIndices.get(fromVertex);

                for (String connection : connections) {
                    String[] connParts = connection.trim().split("\\(");
                    String toCity = connParts[0].trim();

                    int toIndex = vertexIndices.get(toCity);

                    Grafo.addDirectedEdge(graph, fromIndex, toIndex);
                }
            }

            newReader.close();
            
            return graph;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Função para criar a matriz de distâncias a partir do arquivo
    public static double[][] createDistanceMatrix(String filePath, Map<String, Integer> vertexIndices) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            int index = 0;
            System.out.println(vertexIndices);


            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String vertexName = parts[0].trim();
                vertexIndices.put(vertexName, index);
                index++;
            }


            int n = vertexIndices.size();

            double[][] distanceMatrix = new double[n][n];

            // Redefinir o leitor para o início do arquivo
            reader.close();

            for (double[] row : distanceMatrix)
                java.util.Arrays.fill(row, 100000.00);

            // Cria um novo leitor para o mesmo arquivo
            BufferedReader newReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(filePath), "UTF-8"));

            while ((line = newReader.readLine()) != null) {
                String[] parts = line.split(":");
                String fromVertex = parts[0].trim();
                String[] connections = parts[1].split(",");

                int fromIndex = vertexIndices.get(fromVertex);

                for (String connection : connections) {
                    String[] connParts = connection.trim().split("\\(");
                    String toCity = connParts[0].trim();
                    double distance = Double.parseDouble(connParts[1].replaceAll("\\)",
                            "").trim());

                    int toIndex = vertexIndices.get(toCity);

                    distanceMatrix[fromIndex][toIndex] = distance;
                }
            }

            // // Função para imprimir a matriz de distâncias
            // Grafo.printDistanceMatrix(distanceMatrix, vertexIndices);

            newReader.close();

            return distanceMatrix;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Função para imprimir a matriz de distâncias
    public static void printDistanceMatrix(double[][] graph, Map<String, Integer> vertexIndices) {
        if (graph == null || graph.length == 0 || vertexIndices == null || vertexIndices.isEmpty()) {
            System.out.println("Matriz vazia.");
            return;
        }

        int n = graph.length;

        // Crie um mapa ordenado por índices
        Map<Integer, String> indexToCityMap = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : vertexIndices.entrySet()) {
            indexToCityMap.put(entry.getValue(), entry.getKey());
        }

        int maxLabelLength = 0;
        for (String cityName : indexToCityMap.values()) {
            maxLabelLength = Math.max(maxLabelLength, cityName.length());
        }

        int cellWidth = maxLabelLength + 2;

        System.out.print(String.format("%-" + cellWidth + "s", ""));
        for (String cityName : indexToCityMap.values()) {
            System.out.print(String.format("%-" + cellWidth + "s", cityName));
        }
        System.out.println();

        for (int i : indexToCityMap.keySet()) {
            System.out.print(String.format("%-" + cellWidth + "s", indexToCityMap.get(i)));
            for (int j : indexToCityMap.keySet()) {
                double distance = graph[i][j];
                if (distance == Double.POSITIVE_INFINITY) {
                    System.out.print(String.format("%-" + cellWidth + "s", "null"));
                } else {
                    System.out.print(String.format("%-" + cellWidth + ".1f", distance == 100000.00 ? 0 : distance));
                }
            }
            System.out.println("\t");
        }
    }
}