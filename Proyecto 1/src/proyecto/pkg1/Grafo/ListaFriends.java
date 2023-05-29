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
    
     public void insertLast(NodoFriends node) {

        if (isEmpty()) {
            node.setNext(node);
            node.setPrev(node);
            setHead(node);
            setTail(node);

        } else {
            getTail().setNext(node);
            node.setPrev(tail);
            setTail(node);
            node.setNext(getHead());

        }
        size++;
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
    
    

    public NodoFriends deleteFinal() {

        if (!isEmpty()) {
            NodoFriends pointer = getHead();
            if (getSize() == 1) {
                NodoFriends nodeReturn = getHead();
                setHead(null);
                size--;
                return nodeReturn;
            } else {
                while (pointer.getNext() != getHead() && pointer.getNext().getNext() != getHead()) {
                    pointer = pointer.getNext();
                }
                pointer.getNext().setPrev(null);
                NodoFriends nodeReturn = pointer.getNext();
                pointer.setNext(null);
                setTail(pointer);
                getHead().setPrev(getTail());
                getTail().setNext(getHead());
                size--;
                return nodeReturn;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error. Cannot delete node because the list is empty.");
        }
        return null;
    }

    public NodoFriends deleteInIndex(int index) {
        if (!isEmpty()) {
            NodoFriends pointer = getHead();
            if (index > getSize()) {
                System.out.println("The index is bigger than the size");
                return deleteFinal();
            } else {
                if (index > getSize() / 2) {
                    pointer = getTail();
                    int cont = 0;
                    while (cont <= (getSize() - index - 1) && pointer.getPrev() != getTail()) {
                        pointer = pointer.getPrev();
                        cont++;
                    }
                    NodoFriends temp = pointer.getNext();
                    pointer.setNext(temp.getNext());
                    temp.getNext().setPrev(pointer);
                    temp.setNext(null);
                    temp.setPrev(null);
                    size--;

                } else {
                    pointer = getHead();
                    int cont = 0;
                    while (cont < (index - 1) && pointer.getNext() != getHead()) {
                        pointer = pointer.getNext();
                        cont++;
                    }
                    NodoFriends temp = pointer.getNext();
                    pointer.setNext(temp.getNext());
                    temp.getNext().setPrev(pointer);
                    temp.setNext(null);
                    temp.setPrev(null);
                    size--;
                }
            }
        }
        return null;
    }

    
    public void printList(){
        if (!isEmpty()){
            
            String aux = "[";
            for (int i = 0; i < getSize(); i++) {
                User dato = getDato(i).getFriend();
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
    
    
    public NodoFriends getDato(int index) {
        if (isEmpty()) {
            return null;

        } else {
            NodoFriends pointer = getHead();
            int counter = 0;
            while (counter < index && pointer.getNext() != null) {
                pointer = pointer.getNext();
                counter++;
            }
            return pointer;
        }
    }
    
    public boolean checkUser(User currentUser) {
        boolean found = false;
        for (int i = 0; i < getSize(); i++) {
            if (getDato(i).getFriend().equals(currentUser)) {
                found = true;
                break;
            }
        }
        return found;
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
