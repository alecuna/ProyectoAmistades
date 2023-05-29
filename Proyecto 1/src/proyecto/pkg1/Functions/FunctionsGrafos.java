/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.Functions;

import proyecto.pkg1.Grafo.Grafo;

/**
 *
 * @author Anabella Jaua
 */
public class FunctionsGrafos {
    
    LeerArchivo f = new LeerArchivo();
    FunctionsTXT use = new FunctionsTXT();
    String infoGrafo = f.leertxt("test\\TxtProyecto.txt");
    String[] users = use.getUsuarios(infoGrafo);
    String[] relaciones = use.getRelaciones(infoGrafo);
    
//    public Grafo crearGrafo(String[] users, String[] relaciones){
//       return Grafo; 
//    }
    
    
    
}
