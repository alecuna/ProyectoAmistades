/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.Grafo;

import javax.swing.JOptionPane;

/**
 *
 * @author alexandralecuna
 */
public class Grafo {

    private Lista<Integer>[] adj;
    private int V; // numero de vertices
    private int E; // numero de aristas

    public Grafo(int vertices) {
        this.V = vertices;
        this.E = 0;
        this.adj = new Lista[vertices];
        for (int i = 0; i < V; i++) {
            adj[i] = new Lista<>();
        }
    }

    public void addArista(int a, int b) {
        adj[a].insertLast(b);
        adj[b].insertLast(a);
        E++;
    }

    public void printVerts() {

        String sVerts = "";
        sVerts += V + " vertices, " + E + " edges " + "\n";
        for (int v = 0; v < V; v++) {
            Nodo pointer = adj[v].getHead();
            sVerts += (v + ": ");
            for (int i = 0; i < adj[v].getSize(); i++) {
                sVerts += adj[v].getDato(i) + " ";
            }
            sVerts += " \n";
        }
        System.out.println(sVerts);
    }

}
