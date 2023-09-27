package com.grafos.grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.grafos.aresta.Aresta;

public class Grafo {
    private Map<String, List<Aresta>> listaDeCidades = new HashMap<>();
    public List<Aresta> arestas = new ArrayList<>();

    public void adicionarCidade(String cidade, List<String> conexoes) {
        List<Aresta> arestas = new ArrayList<>();
        for (String conexao : conexoes) {
            String[] partes = conexao.split("\\s*\\(\\s*|\\s*\\)\\s*,\\s*");
            String cidadeDestino = partes[0];
            int peso = Integer.parseInt(partes[1]);
            arestas.add(new Aresta(cidadeDestino, peso));
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

    public List<String> cidadesInalcancaveis(String cidadeOrigem) {
        List<String> cidadesInalcançaveis = new ArrayList<>();
        Set<String> visitadas = new HashSet<>();
        visitarCidades(cidadeOrigem, visitadas);
        for (String cidade : listaDeCidades.keySet()) {
            if (!visitadas.contains(cidade)) {
                cidadesInalcançaveis.add(cidade);
            }
        }
        return cidadesInalcançaveis;
    }

    private void visitarCidades(String cidade, Set<String> visitadas) {
        visitadas.add(cidade);
        if (listaDeCidades.containsKey(cidade)) {
            for (Aresta aresta : listaDeCidades.get(cidade)) {
                if (!visitadas.contains(aresta.getDestino())) {
                    visitarCidades(aresta.getDestino(), visitadas);
                }
            }
        }
    }

    public String toString(String cidade) {
        if (!listaDeCidades.containsKey(cidade)) {
            return "Cidade não encontrada.";
        }

        StringBuilder texto = new StringBuilder();
        texto.append("Cidade: ").append(cidade).append("\n");
        texto.append("Conexões: \n");

        List<Aresta> conexoes = listaDeCidades.get(cidade);
        for (Aresta aresta : conexoes) {
            texto.append(" ---> ").append(aresta.getDestino()).append(" (Peso: ").append(aresta.getPeso())
                    .append(")\n");
        }

        return texto.toString();
    }

}