/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.Grafo;

import javax.swing.JOptionPane;

/**
 *
 * @author alexandralecuna
 */
public class ListaFriends {
    
    private NodoFriends head;
    private NodoFriends tail;
    private int size;

    public ListaFriends() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    
     public boolean isEmpty(){
        return head == null;
    }
    
    public void insertBegin(NodoFriends node) {
        
        if (isEmpty()){
            node.setNext(node);
            node.setPrev(node);
            setHead(node);
            setTail(node);
            
        } else {
            node.setNext(head);
            head.setPrev(node);
            setHead(node);
        }
        size ++;
    }
    
    public void insertLast(NodoFriends node){
   
        if (isEmpty()){
            node.setNext(node);
            node.setPrev(node);
            setHead(node);
            setTail(node);
            
        } else {
            getTail().setNext(node);
            node.setPrev(tail);
            setTail(node);
            
        }
        size ++;
    }
    
    public void deleteFirst() {

        if (!isEmpty()) {
            NodoFriends pointer = getHead();
            setHead(pointer.getNext());
            pointer.setNext(null);
            size--;

        } else {
            JOptionPane.showMessageDialog(null, "Error. Cannot delete node because the list is empty.");

        }
    }
    
    public void deleteLast() {

        if (!isEmpty()) {
            NodoFriends pointer = getHead();

            if (getSize() == 1) {
                setHead(null);

            } else {
                while (pointer.getNext() != null && pointer.getNext().getNext() != null) {
                    pointer = pointer.getNext();
                }
                pointer.setNext(null);
                setTail(pointer);
                size--;
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Error. Cannot delete node because the list is empty.");
        }
    }
    
    public void printList(){
        if (!isEmpty()){
            
            String aux = "[";
            for (int i = 0; i < getSize(); i++) {
                User dato = getDato(i);
                if (i == getSize() - 1){
                    aux += dato + "]";
                } else {
                aux += dato + ",";
                }
            }
            System.out.println(aux);
            
        } else {
            JOptionPane.showMessageDialog(null, "The list is currently empty.");
        }
    }
    
    
    public User getDato(int index) {
        if (isEmpty()) {
            return null;

        } else {
            NodoFriends pointer = getHead();
            int counter = 0;
            while (counter < index && pointer.getNext() != null) {
                pointer = pointer.getNext();
                counter++;
            }
            return pointer.getFriend();
        }
    }
    
    public NodoFriends getHead() {
        return head;
    }

    public void setHead(NodoFriends head) {
        this.head = head;
    }

    public NodoFriends getTail() {
        return tail;
    }

    public void setTail(NodoFriends tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
