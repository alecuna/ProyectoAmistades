/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.Functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import proyecto.pkg1.Grafo.Grafo;
import proyecto.pkg1.Grafo.ListaVertex;
import proyecto.pkg1.Grafo.NodoVertex;
import proyecto.pkg1.Grafo.User;
import static proyecto.pkg1.Main.grafo;

/**
 * Clase que define los distintos metodos utilizados para la modificacion del TXT guardado en el sistema 
 * @author Anabella Jaua
 */

public class FunctionsTXT {
    
    //Variables declaradas como atributos de la clase para facilitar el manejo de los metodos creados 
    File archivo; 
    FileInputStream entrada; 
    FileOutputStream salida; 

    /**
     * Funcion que abre el archivo txt y obtiene su contendio 
     * @param archivo seleccionado por el usuario
     * @return Contenido del archivo seleccionado 
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

    /**
     * Funcion que valida que el contenido del archivo ingresado cumpla con la estructura requerida
     * @param contenido del archivo seleccionado por el usuario
     * @return Valor logico de si el archivo cumple con la estructura requerida
     */
    public boolean validarTxt(String contenido){
        try{
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
                    }}
                }
        }catch(Exception e){
                 return false;
        }return true; 
       }
    
    /**
     * Funcion que separa el contenido del archivo para obtener el array de usuarios
     * @param content, contenido del archivo seleccionado por el usuario
     * @return Array de los usuarios guardados, cada uno con su ID y username 
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
     * @return Array de las relaciones guardadas, cada una con los ids de cada usuario y sus años de amistad
     */
    public String[] getRelaciones (String content){
        String[] separar = content.split("Relaciones");
        String relaciones = separar[1];
        String[] relations = relaciones.split("\n");
        return relations;
    }
    
    /**
     * Funcion que permite reemplazar la informacion del TXT del sistema con la informacion subida por el usuario
     * @param contenido del archivo seleccionado por el usuario
     */
    public void escribir_txt(String contenido){
        
        try{
            PrintWriter pw = new PrintWriter("test\\TxtProyecto.txt");
            pw.write(contenido);
            
            pw.close();
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null, err);
        }
    }
    
    /**
     * Metodo que agrega una relacion entre dos usuarios al archivo TXT guardado en el sistema 
     * @param id1, id del primer usuario de la relacion
     * @param id2, id del segundo usuario de la relacion
     * @param years, peso de la relacion (años de amistad)
     */
    public void agregarRelacion(int id1, int id2, int years){
        LeerArchivo read = new LeerArchivo();
        String document = read.leertxt("test\\TxtProyecto.txt");
        String[] info = document.split("Relaciones");
        String users = info[0];
        
        String relaciones = info[1];
        String[] relations = relaciones.split("\n");
        String relacionesFinal ="";
        String agregar = users +"\n\nRelaciones\n";
        
        for (int i = 1; i < relations.length; i++) {
            String[] ids = relations[i].trim().split(",");
                relacionesFinal += relations[i]+"\n";
            }
        agregar += relacionesFinal + String.valueOf(id1) +"," + String.valueOf(id2)+","+String.valueOf(years);
        escribir_txt(agregar);
    }
    
    /**
     * Metodo que permite eliminar un usuario y todas sus relaciones del archivo TXT guardado en el sistema 
     * @param usuario a eliminar 
     */
    public void eliminarUsuariosTxt (User usuario){
        LeerArchivo read = new LeerArchivo();
        String document = read.leertxt("test\\TxtProyecto.txt");
        String[] separar = document.split("Relaciones");
        String usuarios = separar [0];
        String[] users = usuarios.split("\n");
        String[] separando = document.split("Relaciones");
        String relaciones = separando[1];
        String[] relations = relaciones.split("\n");
        String usuariosFinal = "Usuarios\n";
        String relacionesFinal = "Relaciones\n";
        for (int i = 1; i < users.length; i++) {
            String[] usernames = users[i].split(",");
            if (!usernames[1].trim().equals(usuario.getUsername())){
                usuariosFinal += users[i]+"\n";
            }
        }for (int i = 1; i < relations.length; i++) {
            String[] ids = relations[i].trim().split(",");
            if (Integer.parseInt(ids[0].trim()) != usuario.getUserID() && Integer.parseInt(ids[1].trim())!= usuario.getUserID()){
                relacionesFinal += relations[i]+"\n";
        }}
        String agregar = usuariosFinal + relacionesFinal;
        escribir_txt(agregar);
        
    }
    
    /**
     * Metodo que permite añadir un usuario al archivo TXT guardado en el sistema
     * @param username del usuario a agregar
     * @param id del usuario a agregar
     */
    public void agregarUser (String username, int id){
        LeerArchivo read = new LeerArchivo();
        String document = read.leertxt("test\\TxtProyecto.txt");
        String[] info = document.split("Relaciones");
        String users = info[0];
        String relations = info[1];
        users += +id+","+username+"\n";

        String agregar = users +"\n\nRelaciones"+relations;

        escribir_txt(agregar);
    }
    
}