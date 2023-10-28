package com.grafos.aresta;

public class Aresta {
    private String origem;
    private String destino;
    private int distancia;
    
    public Aresta(String origem, String destino, int distancia) {
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }

    public String getOrigem() {
        return this.origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) {
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
