package com.grafos;

import java.util.List;

import org.junit.Test;

public class QuestaoDTest {

    @Test
    public void testTSP() {
        // Crie uma matriz de distâncias de exemplo (substitua isso pela sua própria
        // matriz)
        double[][] exampleDistanceMatrix = {
                { 0.0, 2.0, 9.0, 10.0 },
                { 1.0, 0.0, 6.0, 4.0 },
                { 15.0, 7.0, 0.0, 8.0 },
                { 6.0, 3.0, 12.0, 0.0 }
        };

        // Crie uma instância da classe QuestaoD
        QuestaoD solver = new QuestaoD(0, exampleDistanceMatrix);

        // Resolva o problema do caixeiro viajante
        solver.solve();

        // Obtenha o roteiro e o custo mínimo
        List<Integer> tour = solver.getTour();
        double minTourCost = solver.getTourCost();

        // Verifique se o resultado é válido
        if (tour != null && tour.size() == exampleDistanceMatrix.length + 1) {
            System.out.println("Tour válido encontrado!");
            System.out.println("Roteiro: " + tour);
            System.out.println("Custo Mínimo: " + minTourCost);
        } else {
            System.out.println("Nenhum roteiro válido encontrado.");
        }
    }
}
