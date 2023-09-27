package com.grafos.aresta;

public class Aresta {
    private String destino;
    private int peso;

    public Aresta(String destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    public String getDestino() {
        return this.destino;
    }

    public int getPeso() {
        return this.peso;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setPeso(int peso) {
        if (peso > 0) {
            this.peso = peso;
        } else {
            throw new IllegalArgumentException("A distância - peso - deve ser maior que zero");
        }
    }
}
