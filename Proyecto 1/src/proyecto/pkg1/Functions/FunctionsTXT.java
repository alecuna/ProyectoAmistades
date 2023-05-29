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
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;
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

    /**
     * Funcion que abre el archivo txt
     * @param archivo, File seleccionado por el usuario
     * @return String documento, contenido del archivo seleccionado
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

    /**
     * Funcion que valida que el contenido del txt cumpla con la estructura requerida
     * @param contenido, contenido del archivo seleccionado por el usuario
     * @return boolean true si el archivo es valido
     */
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
    
    /**
     * Funcion que separa el contenido del archivo para obtener el array de usuarios
     * @param content, contenido del archivo seleccionado por el usuario
     * @return Array users, array de usuarios con sus ids y @usernames
     */
    public String[] getUsuarios (String content){
        String[] separar = content.split("Relaciones");
        String usuarios = separar [0];
        String[] users = usuarios.split("\n");
        return users;
    }
    
    /**
     * Funcion que separa el contenido del archivo para obtener el array de relaciones
     * @param content, contenido del archivo seleccionado por el usuario
     * @return Array users, array de relaciones cada una con los ids de cada usuario y sus años de amistad
     */
    public String[] getRelaciones (String content){
        String[] separar = content.split("Relaciones");
        String relaciones = separar[1];
        String[] relations = relaciones.split("\n");
        return relations;
    }
       
//    public boolean validarUsers (String[] users, String usuario1, String usuario2, int id1, int id2){
//        boolean value = true;
//        for (int i = 0; i < users.length-1; i++) {
//            String[] data = users[i].trim().split(",");
//            String id = data[0];
//            String username = data[1];
//            if(Integer.parseInt(id) == id1){
//                
//                
//            }
//        }
//        
//    }
    
    /**
     * Funcion que permite reemplazar la informacion del TXT del sistema con la informacion subida por el usuario
     * @param contenido, informacion contenida el archivo seleccionado por el usuario
     */
    public void escribir_txt(String contenido){
        
        try{
            PrintWriter pw = new PrintWriter("test\\TxtProyecto.txt");
            pw.append(contenido);
            
            pw.close();
            JOptionPane.showMessageDialog(null, "Guardado exitoso");
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null, err);
        }
    }
    
}