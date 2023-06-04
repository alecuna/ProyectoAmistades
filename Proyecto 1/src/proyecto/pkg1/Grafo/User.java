/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.Grafo;

/**
 * Clase usuario que conforma los vertices del grafo
 * @author alexandralecuna
 */
public class User {
    
    //Atributos de la clase
    private String username;
    private int userID;
    
    /**
     * Constructor de la clase
     * @param username del usuario
     * @param userID, numero de identificacion del usuario
     */
    public User(String username, int userID) {
        this.username = username;
        this.userID = userID;
    }

    /**
     * Metodo que permite obtener el username de un usuario
     * @return Username del usuario 
     */
    public String getUsername() {
        return username;
    }

    /**
     * Metodo que permite modificar el username de un usuario
     * @param username nuevo del usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Metodo que permite obtener el ID de un usuario
     * @return ID del usuario
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Metodo que permite modificar el ID de un usuario
     * @param userID nuevo del usuario
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }
      
}