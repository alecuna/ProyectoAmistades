/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.pkg1;

import proyecto.pkg1.Functions.FunctionsGrafos;
import proyecto.pkg1.Functions.FunctionsTXT;
import proyecto.pkg1.Functions.LeerArchivo;
import proyecto.pkg1.GUIs.Ventana1;
import proyecto.pkg1.Grafo.Grafo;

/**
 * Clase main que inicia el programa 
 * @author Anabella Jaua
 */
public class Main {
    public static Grafo grafo;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // Se crea el grafo a partir de la informacion guardada 
        LeerArchivo readFile = new LeerArchivo();
        FunctionsTXT editFile = new FunctionsTXT();
        FunctionsGrafos grafoFunctions = new FunctionsGrafos();

        String infoGrafo = readFile.leertxt("test\\TxtProyecto.txt");
        String[] users = editFile.getUsuarios(infoGrafo);
        String[] relaciones = editFile.getRelaciones(infoGrafo);
        grafo = grafoFunctions.crearGrafo(users, relaciones);
       
        // Se abre la pantalla principal 
        Ventana1 window = new Ventana1();
        window.setVisible(true);       
        window.setLocationRelativeTo(null);
        window.setResizable(false);

    }
    
}
