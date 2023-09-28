package com.grafos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.grafos.BFS.BFS;
import com.grafos.grafo.Grafo;
import com.grafos.vertice.Vertice;

public class App {
    static Grafo grafo = new Grafo();
    static ArrayList<Vertice> vertices = new ArrayList<Vertice>();

    public static void main(String[] args) {
        int op = -1;
        BFS busca;
        Vertice vertice;
        Scanner input = new Scanner(System.in);

        String rodoviaria = "codigo\\grafo\\src\\main\\java\\com\\grafos\\rotas.txt";

        adicionarVertices();

        try (BufferedReader br = new BufferedReader(new FileReader(rodoviaria))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(":");
                String cidade = partes[0].trim();
                String[] conexoes = partes[1].split(",");

                grafo.adicionarArestas(cidade, conexoes);
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        }

        System.out.println(grafo.toString("Joanesburgo"));

        // while(op != 0){
        //     System.out.print("\t--- CAMINHO EM GRAFOS ---\n");
        //     System.out.print("1 - \n2 - \n3 - Recomendacao de rota\n\tEscolha: ");
        //     op = input.nextInt();

        //     switch(op){
        //         case 1:

        //         break;
        //         case 2:
        //         break;
        //         case 3:
        //             // ArrayList<Vertice> resultadoBFS = busca.buscaEmLargura("Joanesburgo");

        //             // System.out.println("Resultado da Busca em Largura a partir de " + origem.getNome() + ":");
        //             // for (Vertice v : resultadoBFS) {
        //             //     System.out.println(v.getNome());
        //             // }
        //         break;
        //     }
        // }
    }


    public static void adicionarVertices(){
        String rodoviaria = "codigo\\grafo\\src\\main\\java\\com\\grafos\\rotas.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(rodoviaria))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(":");
                String cidade = partes[0].trim();
                vertices.add(new Vertice(cidade));
            }
            grafo.setVerticesIniciais(vertices);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        }
    }
}
