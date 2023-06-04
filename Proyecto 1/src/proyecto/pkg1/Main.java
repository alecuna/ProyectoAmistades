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
        FunctionsGrafos grafoFunctions = new FunctionsGrafos();

        String infoGrafo = f.leertxt("test\\TxtProyecto.txt");
        String[] users = use.getUsuarios(infoGrafo);
        String[] relaciones = use.getRelaciones(infoGrafo);
        grafo = grafoFunctions.crearGrafo(users, relaciones);
       
      
        Ventana1 window = new Ventana1();
        window.setVisible(true);       
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        



    }
    
}
