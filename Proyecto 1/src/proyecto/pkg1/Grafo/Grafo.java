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

    private Lista<Vertex>[] arrayAdj;
    private int V; // numero de vertices
    private int A; // numero de aristas

    public Grafo(int vertices) {
        this.V = vertices;
        this.A = 0;
        this.arrayAdj = new Lista[vertices];
        for (int i = 0; i < V; i++) {
            arrayAdj[i] = new Lista<Vertex>();
        }
    }

    public void addArista(Vertex a, Vertex b) {
        arrayAdj[a].insertLast(b);
        arrayAdj[b].insertLast(a);
        A++;
    }

    public void printVerts() {

        String sVerts = "";
        sVerts += V + " vertices, " + A + " aristas " + "\n";
        for (int i = 0; i < V; i++) {
            Nodo pointer = arrayAdj[i].getHead();
            sVerts += (i + " -> ");
            for (int j = 0; j < arrayAdj[i].getSize(); j++) {
                sVerts += arrayAdj[i].getDato(j).getUser().getUsername() + " ";
            }
            sVerts += " \n";
        }
        System.out.println(sVerts);
    }
    
    public int findVert(User currentUser) {
        Vertex vert = new Vertex(currentUser);
        boolean found = false;
        int i = 0;
        
        for (i = 0 ; (i < V) && !found ; i++) {
            
            found = arrayAdj[i].equals(vert);
            if (!found) i++;     
        }
        return (i < V) ? i : -1;
    }
    

}
