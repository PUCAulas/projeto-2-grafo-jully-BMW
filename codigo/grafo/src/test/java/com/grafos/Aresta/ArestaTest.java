// package com.grafos.Aresta;

// import static org.junit.Assert.*;
// import org.junit.Test;

// public class ArestaTest {

//     @Test
//     public void testGetOrigem() {
//         Aresta aresta = new Aresta("Belo Horizonte", "São Paulo", 10);
//         assertEquals("Belo Horizonte", aresta.getOrigem());
//     }

//     @Test
//     public void testSetOrigem() {
//         Aresta aresta = new Aresta("Belo Horizonte", "São Paulo", 10);
//         aresta.setOrigem("Belo Horizonte");
//         assertEquals("Belo Horizonte", aresta.getOrigem());
//     }

//     @Test
//     public void testGetDestino() {
//         Aresta aresta = new Aresta("Belo Horizonte", "São Paulo", 10);
//         assertEquals("São Paulo", aresta.getDestino());
//     }

//     @Test
//     public void testSetDestino() {
//         Aresta aresta = new Aresta("Belo Horizonte", "São Paulo", 10);
//         aresta.setDestino("São Paulo");
//         assertEquals("São Paulp", aresta.getDestino());
//     }

//     @Test
//     public void testGetDistancia() {
//         Aresta aresta = new Aresta("Belo Horizonte", "São Paulo", 10);
//         assertEquals(10, aresta.getDistancia());
//     }

//     @Test
//     public void testSetDistancia() {
//         Aresta aresta = new Aresta("Belo Horizonte", "São Paulo", 10);
//         aresta.setDistancia(20);
//         assertEquals(20, aresta.getDistancia());
//     }

//     @Test(expected = IllegalArgumentException.class)
//     public void testSetDistanciaInvalid() {
//         Aresta aresta = new Aresta("Belo Horizonte", "São Paulo", 10);
//         aresta.setDistancia(-5);
//     }

//     @Test
//     public void testToString() {
//         Aresta aresta = new Aresta("Belo Horizonte", "São Paulo", 10);
//         assertEquals("São Paulo (10)", aresta.toString());
//     }
// }
