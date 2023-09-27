package com.grafos.aresta;

import com.grafos.vertice.Vertice;

public class Aresta {
    private Vertice origem;
    private Vertice destino;
    private int distancia;
    
    public Aresta(Vertice origem, Vertice destino, int distancia) {
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }

    public Vertice getOrigem() {
        return this.origem;
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    public Vertice getDestino() {
        return this.destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public int getDistancia() {
        return this.distancia;
    }

    public void setDistancia(int distancia) {
        if (distancia > 0) {
            this.distancia = distancia;
        } else {
            throw new IllegalArgumentException("A distância - peso - deve ser maior que zero");
        }
    }

    @Override
    public String toString(){
        return destino + " (" + distancia + ")";
    }

}
