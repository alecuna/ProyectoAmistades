/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.Grafo;

import javax.swing.JOptionPane;

/**
 *
 * @author Anabella Jaua
 */
public class Lista<T> {
    
    private Nodo<T> head;
    private Nodo<T> tail;
    private int size;

    /**
     * Constructor para una lista vacia
     */
    public Lista() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    /**
     * Constructor con un primer el primer nodo
     */
    public Lista(Nodo node){
        this.head = this.tail = node;
        size = 1;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void insertBegin(T element) {
        Nodo<T> node = new Nodo(element);
        
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
    
    public void insertLast(T element){
        Nodo<T> node = new Nodo(element);
        
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
            Nodo<T> pointer = getHead();
            setHead(pointer.getNext());
            pointer.setNext(null);
            size--;

        } else {
            JOptionPane.showMessageDialog(null, "Error. Cannot delete node because the list is empty.");

        }
    }
    
    public void deleteLast() {

        if (!isEmpty()) {
            Nodo<T> pointer = getHead();

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
                T dato = getDato(i);
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
    
    
    public T getDato(int index) {
        if (isEmpty()) {
            return null;

        } else {
            Nodo<T> pointer = getHead();
            int counter = 0;
            while (counter < index && pointer.getNext() != null) {
                pointer = pointer.getNext();
                counter++;
            }
            return pointer.getElement();
        }
    }
    
    public Lista merge(Lista list1, Lista list2) {
        Nodo pointer1 = list1.getHead();
        Nodo pointer2 = list2.getHead();

        Lista merged = new Lista();

        while (pointer1 != null && pointer2 != null) {
            if ((int) pointer1.getElement() < (int) pointer2.getElement()) {
                merged.insertLast(pointer1.getElement());
                pointer1 = pointer1.getNext();

            } else {
                merged.insertLast(pointer2.getElement());
                pointer2 = pointer2.getNext();

            }
        }
        while (pointer1 != null) {
            merged.insertLast(pointer1.getElement());
            pointer1 = pointer1.getNext();
        }
        while (pointer2 != null) {
            merged.insertLast(pointer2.getElement());
            pointer2 = pointer2.getNext();
        }

        return merged;
    }
    
//    public boolean contains(String name){
//        int start = 0;
//        Nodo<String> current = getHead();
//        while(start < getSize()  && current.getNext() != null){ 
//          if(name.equals(current.getData())){
//              return true;
//          }
//          current = current.getNext();
//        }
//        return false;
//    }


    public Nodo<T> getHead() {
        return head;
    }

    public void setHead(Nodo<T> head) {
        this.head = head;
    }

    public Nodo<T> getTail() {
        return tail;
    }

    public void setTail(Nodo<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
        
    
    
}
