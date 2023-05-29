/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.Functions;

/**
 *
 * @author Anabella Jaua
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FunctionsTXT {
    JFileChooser seleccionar = new JFileChooser();
    File archivo; 
    FileInputStream entrada; 
    FileOutputStream salida; 
    /**
     * Creates new form AbrirGuardarTxt
     */

    public String AbrirArchivo(File archivo){
        String documento="";
        try{
            entrada = new FileInputStream(archivo);
            int ascci;
            while((ascci = entrada.read())!=-1){
                char caracter = (char) ascci; 
                documento += caracter; 
            }
        }catch(Exception e){      
        }
        return documento; 
    }
    
    public String GuardarArchivo(File archivo, String documento){
        String mensaje = null; 
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            mensaje="Archivo guardado";  
        }catch(Exception e){
        }
        return mensaje;
    }


    public boolean validarTxt(String contenido){
         if (!contenido.contains("Usuarios") || !contenido.contains("Relaciones")){
             return false;
         } else{
             String[] separar = contenido.split("Relaciones");
             String usuarios = separar [0];
             String relaciones = separar[1];
             String[] users = usuarios.split("\n");
             String[] relations = relaciones.split("\n");
             for (int i = 1; i < users.length; i++){
                 String[] user = users[i].trim().split(",");
                 try{
                     Integer.parseInt(user[0]);
                     String username = user[1];
                     if (user[1].trim().charAt(0) != '@'){
                         return false;     
                     }
                 }catch(Exception e){
                     return false;
                 }
                 
             } for (int i = 1; i < relations.length; i++) {
                 String[] amistad = relations[i].split(",");
                String amistad1 = amistad[0];
                String amistad2 = amistad[1];
                String years = amistad[2];
                 try{
                     Integer.parseInt(amistad[0].trim());
                     Integer.parseInt(amistad[1].trim());
                    Integer.parseInt(amistad[2].trim());
                 } catch(Exception e){
                     return false;
                 }
        
             } return true;
            
         } 
          
       }
    
    public String[] getUsuarios (String content){
        String[] separar = content.split("Relaciones");
        String usuarios = separar [0];
        String[] users = usuarios.split("\n");
        return users;
    }
    
    public String[] getRelaciones (String content){
        String[] separar = content.split("Relaciones");
        String relaciones = separar[1];
        String[] relations = relaciones.split("\n");
        return relations;
    }
        
    
}