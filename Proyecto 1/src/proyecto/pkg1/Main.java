/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.pkg1;

import proyecto.pkg1.Grafo.Grafo;
import proyecto.pkg1.Grafo.User;

/**
 *
 * @author Anabella Jaua
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        User user1 = new User("Ale", 123);
        User user2 = new User("Ana", 234);
        User user3 = new User("Mari", 456);
        
        Grafo m = new Grafo();
        
        m.newVertex(user1);
        m.newVertex(user2);
        m.newVertex(user3);
        
        m.printVerts();
//        m.addArista(0, 1);
//        m.addArista(1, 2);
//        m.addArista(2, 3);
//        m.addArista(3, 0);
//        
//        m.printVerts();
        
    }
    
}
