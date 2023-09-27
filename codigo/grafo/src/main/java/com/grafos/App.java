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

        String rodoviaria = "rotas.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(rodoviaria))) {
            String linha;

            String cidadeOrigem = br.readLine();
            cidadeOrigem = cidadeOrigem.split(":")[0].trim();

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(":");
                String cidade = partes[0].trim();
                String[] conexoes = partes[1].split(",");
                List<String> conexoesCidade = new ArrayList<>();
                for (String conexao : conexoes) {
                    conexoesCidade.add(conexao.trim());
                }
                grafo.adicionarCidade(cidade, conexoesCidade);
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        }

        grafo.toString("Joanesburgo");

    }

}
