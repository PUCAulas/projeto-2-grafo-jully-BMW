package com.grafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class QuestaoD {

    private final int N, start;
    private final double[][] distance;
    private List<Integer> tour = new ArrayList<>();
    private double minTourCost = Double.POSITIVE_INFINITY;
    private boolean ranSolver = false;

    public QuestaoD(double[][] distance) {
        this(0, distance);
    }

    public QuestaoD(int start, double[][] distance) {
        N = distance.length;

        if (N <= 2)
            throw new IllegalStateException("N <= 2 not yet supported.");
        if (N != distance[0].length)
            throw new IllegalStateException("Matrix must be square (n x n)");
        if (start < 0 || start >= N)
            throw new IllegalArgumentException("Invalid start node.");
        if (N > 32)
            throw new IllegalArgumentException(
                    "Matrix too large! A matrix that size for the DP TSP problem with a time complexity of"
                            + "O(n^2*2^n) requires way too much computation for any modern home computer to handle");

        this.start = start;
        this.distance = distance;
    }

    // Retorna o roteiro ideal para o problema do caixeiro viajante.
    public List<Integer> getTour() {
        if (!ranSolver)
            solve();
        return tour;
    }

    // Retorna o custo mínimo do passeio.
    public double getTourCost() {
        if (!ranSolver)
            solve();
        return minTourCost;
    }

    // Resolve o problema do caixeiro viajante e solução de caches.
    public void solve() {

        if (ranSolver)
            return;

        final int END_STATE = (1 << N) - 1;
        Double[][] memo = new Double[N][1 << N];

        // Adiciona todas as arestas de saída do nó inicial à tabela de notas.
        for (int end = 0; end < N; end++) {
            if (end == start)
                continue;
            memo[end][(1 << start) | (1 << end)] = distance[start][end];
        }

        for (int r = 3; r <= N; r++) {
            for (int subset : combinations(r, N)) {
                if (notIn(start, subset))
                    continue;
                for (int next = 0; next < N; next++) {
                    if (next == start || notIn(next, subset))
                        continue;
                    int subsetWithoutNext = subset ^ (1 << next);
                    double minDist = Double.POSITIVE_INFINITY;
                    for (int end = 0; end < N; end++) {
                        if (end == start || end == next || notIn(end, subset))
                            continue;
                        double distanceValue = distance[end][next];
                        // Verifica se o valor da distância é diferente de 0.0
                        if (distanceValue != 0.0) {
                            double newDistance = memo[end][subsetWithoutNext] + distanceValue;
                            if (newDistance < minDist) {
                                minDist = newDistance;
                            }
                        }
                    }
                    memo[next][subset] = minDist;
                }
            }
        }

        // Conecta o tour de volta ao nó inicial e minimize os custos.
        for (int i = 0; i < N; i++) {
            if (i == start)
                continue;
            double tourCost = memo[i][END_STATE] + distance[i][start];
            if (tourCost < minTourCost) {
                minTourCost = tourCost;
            }
        }

        int lastIndex = start;
        int state = END_STATE;
        tour.add(start);

        // Reconstrua o caminho do viajante da tabela de memo.
        for (int i = 1; i < N; i++) {

            int bestIndex = -1;
            double bestDist = Double.POSITIVE_INFINITY;
            for (int j = 0; j < N; j++) {
                if (j == start || notIn(j, state))
                    continue;
                double newDist = memo[j][state] + distance[j][lastIndex];
                if (newDist < bestDist) {
                    bestIndex = j;
                    bestDist = newDist;
                }
            }

            tour.add(bestIndex);
            state = state ^ (1 << bestIndex);
            lastIndex = bestIndex;
        }

        tour.add(start);
        Collections.reverse(tour);

        ranSolver = true;
    }

    private static boolean notIn(int elem, int subset) {
        return ((1 << elem) & subset) == 0;
    }

    // Este método gera todos os conjuntos de bits de tamanho n onde r bits
    // que estão definidos como um. O resultado é retornado como uma lista de máscaras inteiras.
    public static List<Integer> combinations(int r, int n) {
        List<Integer> subsets = new ArrayList<>();
        combinations(0, 0, r, n, subsets);
        return subsets;
    }

    // Para encontrar todas as combinações de tamanho r precisamos recorrer até que tenhamos
    // r elementos selecionados (também conhecidos como r = 0), caso contrário, se r! = 0, ainda precisamos selecionar
    // um elemento que é encontrado após a posição do nosso último elemento selecionado
    private static void combinations(int set, int at, int r, int n, List<Integer> subsets) {

        // Retorne mais cedo se houver mais elementos para selecionar do que o disponivel
        int elementsLeftToPick = n - at;
        if (elementsLeftToPick < r)
            return;

        // Selecionamos elementos 'r' e encontramos um subconjunto válido
        if (r == 0) {
            subsets.add(set);
        } else {
            for (int i = at; i < n; i++) {
                // Tenta incluir este elemento
                set ^= (1 << i);

                combinations(set, i + 1, r - 1, n, subsets);

                // Volte e tente a instância onde não incluímos este elemento
                set ^= (1 << i);
            }
        }
    }

}