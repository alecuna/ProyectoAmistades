/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.Grafo;

/**
 * Clase que define los nodos vertices del grafo
 * @author alexandralecuna
 * @param <User> 
 */

public class NodoVertex<User> {
    
    //Atributos de la clase
    private User element;
    private NodoVertex next;
    private NodoVertex prev;
    private ListaFriends friendList;
    
    /**
     * Constructor de la clase
     * @param user, usuario que sera almacenado en el nodo vertice
     */
    public NodoVertex(User user){
        this.element = user;
        this.next = null;
        this.prev = null;
        this.friendList = new ListaFriends();
    }

    /**
     * Metodo que permite obtener el usuario almacenado en el nodo
     * @return Usuario almacenado en el nodo
     */
    public User getElement() {
        return element;
    }

    /**
     * Metodo que modifica el usuario almacenado en el nodo
     * @param user, nuevo usuario a almacenar en el nodo
     */
    public void setElement(User user) {
        this.element = user;
    }

    /**
     * Metodo que permite obtener el nodo vertice siguiente al actual
     * @return Nodo vertice siguiente
     */
    public NodoVertex getNext() {
        return next;
    }

    /**
     * Metodo que permite modificar el nodo vertice siguiente al actual
     * @param next, Nodo vertice que sera el nuevo nodo siguiente al actual 
     */
    public void setNext(NodoVertex next) {
        this.next = next;
    }

    /**
     * Metodo que obtiene el nodo vertice anterior al actual
     * @return Nodo vertice anterior
     */
    public NodoVertex getPrev() {
        return prev;
    }

    /**
     * Metodo que permite modificar el nodo vertice anterior al actual
     * @param prev, Nodo vertice que sera el nuevo nodo anterior al actual 
     */
    public void setPrev(NodoVertex prev) {
        this.prev = prev;
    }

    /**
     * Metodo que permite obtener la lista de usuarios relacionados con el nodo vertice actual
     * @return Lista de usuarios relacionados con el nodo vertice actual
     */
    public ListaFriends getFriendList() {
        return friendList;
    }

    /**
     * Metodo que permite modificar la lista de usuarios relacionados con un nodo vertice 
     * @param friendList, Lista nueva de los usuarios relacionados con el nodo vertice 
     */
    public void setFriendList(ListaFriends friendList) {
        this.friendList = friendList;
    }
    
    
}
