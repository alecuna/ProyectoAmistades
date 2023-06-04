/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.Grafo;

/**
 * Clase que define los nodos de la lista de amigos perteneciente a cada nodo vertice del grafo
 * @author alexandralecuna
 */
public class NodoFriends {
    
    //Atributos de la clase
    private NodoFriends next;
    private NodoFriends prev;
    private int weight;
    private User friend;

    /**
     * Constructor de la clase
     * @param weight, años de amistad que tienen los usuarios de relacion entre ellos 
     * @param friend, usuario que esta relacionado al usuario del nodo vertice
     */
    public NodoFriends(int weight, User friend) {
        this.next = null;
        this.prev = null;
        this.weight = weight;
        this.friend = friend;
    }

    /**
     * Metodo que permite obtener el siguiente nodo de la lista de amigos 
     * @return Nodo amigo siguiente al actual
     */
    public NodoFriends getNext() {
        return next;
    }

    /**
     * Metodo que permite modificar el nodo amigo siguiente al actual
     * @param next, nuevo nodo amigo siguiente al actual
     */
    public void setNext(NodoFriends next) {
        this.next = next;
    }

    /**
     * Metodo que permite obtener el nodo anterior de la lista de amigos 
     * @return Nodo amigo anterior al actual
     */
    public NodoFriends getPrev() {
        return prev;
    }

    /**
     * Metodo que permite modificar el nodo amigo previo al actual
     * @param prev, nuevo nodo amigo previo al actual
     */
    public void setPrev(NodoFriends prev) {
        this.prev = prev;
    }

    /**
     * Metodo que permite obtener el peso de la relacion entre el nodo vertice y el nodo amigo
     * @return Años de amistad entre el nodo vertice y el nodo amigo 
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Metodo que permite obtener el usuario almacenado en el nodo amigo actual
     * @return Usuario almacenado en el nodo amigo actual
     */
    public User getFriend() {
        return friend;
    }

    /**
     * Metodo que permite modificar el usuario almacenado en el nodo amigo actual
     * @param friend, nuevo usuario a almacenar en el nodo amigo actual
     */
    public void setFriend(User friend) {
        this.friend = friend;
    }
  
}
