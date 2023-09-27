package com.grafos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.grafos.grafo.Grafo;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        String rodoviaria = "codigo\\grafo\\src\\main\\java\\com\\grafos\\rotas.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(rodoviaria))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(":");
                String cidade = partes[0].trim();
                String[] conexoes = partes[1].split(",");
                grafo.adicionarCidade(cidade, conexoes);
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        }

        System.out.println(grafo.toString("Joanesburgo"));

    }

}
