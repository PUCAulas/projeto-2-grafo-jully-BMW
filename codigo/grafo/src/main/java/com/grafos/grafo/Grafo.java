package com.grafos.grafo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.grafos.aresta.Aresta;
import com.grafos.vertice.Vertice;

public class Grafo {
    private Map<String, ArrayList<Aresta>> listaDeCidades = new HashMap<String, ArrayList<Aresta>>();
    private ArrayList<Vertice> verticesIniciais = new ArrayList<Vertice>();
    static ArrayList<Aresta> arestas = new ArrayList<>();


    public Vertice getVertice(String cidade) {
        for(Vertice vertice : verticesIniciais){
            if(vertice.getNome().equals(cidade))
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

    // public List<String> cidadesInalcancaveis(String cidadeOrigem) {
    //     List<String> cidadesInalcancaveis = new ArrayList<>();
    //     Set<String> visitadas = new HashSet<>();
    //     visitarCidades(cidadeOrigem, visitadas);
    //     for (String cidade : listaDeCidades.keySet()) {
    //         if (!visitadas.contains(cidade)) {
    //             cidadesInalcancaveis.add(cidade);
    //         }
    //     }
    //     return cidadesInalcancaveis;
    // }

    // private void visitarCidades(String cidade, Set<String> visitadas) {
    //     visitadas.add(cidade);
    //     if (listaDeCidades.containsKey(cidade)) {
    //         for (Aresta aresta : listaDeCidades.get(cidade)) {
    //             if (!visitadas.contains(aresta.getDestino())) {
    //                 visitarCidades(aresta.getDestino(), visitadas);
    //             }
    //         }
    //     }
    // }

    public String toString(String cidade) {
        if (!listaDeCidades.containsKey(cidade)) {
            return "Cidade não encontrada.";
        }

        StringBuilder texto = new StringBuilder();
        texto.append("Cidade: ").append(cidade).append("\n");
        texto.append("Conexões: \n");

        ArrayList<Aresta> conexoes = listaDeCidades.get(cidade);
        for (Aresta aresta : conexoes) {
            texto.append(" ---> ").append(aresta.getDestino()).append(" (Peso: ").append(aresta.getDistancia())
                    .append(")\n");
        }
        return texto.toString();
    }

}