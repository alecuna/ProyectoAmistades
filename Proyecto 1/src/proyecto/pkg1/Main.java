/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.pkg1;

import proyecto.pkg1.Grafo.Grafo;

/**
 *
 * @author Anabella Jaua
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Grafo m = new Grafo(4);
        m.addArista(0, 1);
        m.addArista(1, 2);
        m.addArista(2, 3);
        m.addArista(3, 0);
        
        m.printVerts();
        
    }
    
}
