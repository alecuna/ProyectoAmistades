/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.Grafo;

/**
 *
 * @author alexandralecuna
 */
public class NodoFriends {
    
    private NodoFriends next;
    private NodoFriends prev;
    private int weight;
    private User friend;

    public NodoFriends(int weight, User friend) {
        this.next = null;
        this.prev = null;
        this.weight = weight;
        this.friend = friend;
    }

    public NodoFriends getNext() {
        return next;
    }

    public void setNext(NodoFriends next) {
        this.next = next;
    }

    public NodoFriends getPrev() {
        return prev;
    }

    public void setPrev(NodoFriends prev) {
        this.prev = prev;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }
    
    
    
    
}
