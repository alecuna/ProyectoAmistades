/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.pkg1;


import java.io.File;
import proyecto.pkg1.Functions.FunctionsGrafos;
import proyecto.pkg1.Functions.FunctionsTXT;
import proyecto.pkg1.Functions.LeerArchivo;
import proyecto.pkg1.GUIs.Ventana1;
import proyecto.pkg1.Grafo.Grafo;
import proyecto.pkg1.Grafo.User;

/**
 *
 * @author Anabella Jaua
 */
public class Main {
    public static Grafo grafo;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        LeerArchivo f = new LeerArchivo();
        FunctionsTXT use = new FunctionsTXT();
        String infoGrafo = f.leertxt("test\\TxtProyecto.txt");
        String[] users = use.getUsuarios(infoGrafo);
        String[] relaciones = use.getRelaciones(infoGrafo);
        FunctionsGrafos grafoFunctions = new FunctionsGrafos();
        grafo = grafoFunctions.crearGrafo(users, relaciones);
//        grafo.printFriends();
       
      
        Ventana1 window = new Ventana1();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        
//        LeerArchivo go = new LeerArchivo();
//        go.leertxt("C:\\Anabella\\Universidad\\Trimestre 6\\Estructuras de Datos\\Proyectos\\Proyecto 1\\Proyecto 1\\test\\TxtProyecto.txt");
        
 
//        User user1 = new User("Ale", 123);
//        User user2 = new User("Ana", 234);
//        User user3 = new User("Mari", 456);
//        
//        Grafo m = new Grafo();
//        
//        m.newVertex(user1);
//        m.newVertex(user2);
//        m.newVertex(user3);
//        
//        m.printVerts();
//        m.addArista(0, 1);
//        m.addArista(1, 2);
//        m.addArista(2, 3);
//        m.addArista(3, 0);
//        
//        m.printVerts();
//        


//        User user1 = new User("Ale", 123);
//        User user2 = new User("Ana", 234);
//        User user3 = new User("Mari", 456);
//        User user4 = new User("cristo", 234234);
//        
//        Grafo m = new Grafo();
//       
//        m.addVertex(user1);
//        m.addVertex(user2);
//        m.addVertex(user3);
//        m.addVertex(user4);
//        
//        m.addEdge(user1, user2, 2);
//        m.addEdge(user1, user3, 4);
//        m.addEdge(user2, user3, 6);
//        
//        m.printVerts();
//        
//        System.out.println("Lista sin coneccion ale y ana");
//        m.deleteEdge(user1, user2);
//        m.printVerts();
//       
//        System.out.println("lista sin usuario ana");
//        m.deleteVertex(user2);
//        m.printVerts();

    }
    
}
