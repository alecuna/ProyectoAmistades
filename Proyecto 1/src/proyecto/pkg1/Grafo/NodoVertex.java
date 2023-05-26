/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.Grafo;

/**
 *
 * @author Anabella Jaua
 */
public class NodoVertex<User> {
    
    private User element;
    private NodoVertex next;
    private NodoVertex prev;
    private ListaFriends friendList;
    
    public NodoVertex(User user){
        this.element = user;
        this.next = null;
        this.prev = null;
        this.friendList = new ListaFriends();
    }

    public User getElement() {
        return element;
    }

    public void setElement(User user) {
        this.element = user;
    }

    public NodoVertex getNext() {
        return next;
    }

    public void setNext(NodoVertex next) {
        this.next = next;
    }

    public NodoVertex getPrev() {
        return prev;
    }

    public void setPrev(NodoVertex prev) {
        this.prev = prev;
    }

    public ListaFriends getFriendList() {
        return friendList;
    }

    public void setFriendList(ListaFriends friendList) {
        this.friendList = friendList;
    }
    
    
}
