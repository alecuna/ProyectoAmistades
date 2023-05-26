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
public class ListaVertex<T> {

    private NodoVertex<User> head;
    private NodoVertex<User> tail;
    private int size;

    /**
     * Constructor para una lista vacia
     */
    public ListaVertex() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Constructor con un primer el primer nodo
     */
    public ListaVertex(NodoVertex node) {
        this.head = this.tail = node;
        size = 1;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertBegin(T element) {
        NodoVertex<User> node = new NodoVertex(element);

        if (isEmpty()) {
            node.setNext(node);
            node.setPrev(node);
            setHead(node);
            setTail(node);

        } else {
            node.setNext(head);
            head.setPrev(node);
            setHead(node);
        }
        size++;
    }

    public void insertLast(User element) {
        NodoVertex<User> node = new NodoVertex(element);

        if (isEmpty()) {
            node.setNext(node);
            node.setPrev(node);
            setHead(node);
            setTail(node);

        } else {
            getTail().setNext(node);
            node.setPrev(tail);
            setTail(node);

        }
        size++;
    }

    public void deleteFirst() {

        if (!isEmpty()) {
            NodoVertex<User> pointer = getHead();
            setHead(pointer.getNext());
            pointer.setNext(null);
            size--;

        } else {
            JOptionPane.showMessageDialog(null, "Error. Cannot delete node because the list is empty.");

        }
    }

    public void deleteLast() {

        if (!isEmpty()) {
            NodoVertex<User> pointer = getHead();

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

    public void printList() {
        if (!isEmpty()) {

            String aux = "[";
            for (int i = 0; i < getSize(); i++) {
                String dato = getDato(i).getElement().getUsername();
                if (i == getSize() - 1) {
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

    public NodoVertex<User> getDato(int index) {
        if (isEmpty()) {
            return null;

        } else {
            NodoVertex<User> pointer = getHead();
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
            if (getDato(i).getElement().equals(currentUser)) {
                found = true;
                break;
            }
        }
        return found;
    }

//    public ListaVertex merge(ListaVertex list1, ListaVertex list2) {
//        NodoVertex pointer1 = list1.getHead();
//        NodoVertex pointer2 = list2.getHead();
//
//        ListaVertex merged = new ListaVertex();
//
//        while (pointer1 != null && pointer2 != null) {
//            if ((int) pointer1.getElement() < (int) pointer2.getElement()) {
//                merged.insertLast(pointer1.getElement());
//                pointer1 = pointer1.getNext();
//
//            } else {
//                merged.insertLast(pointer2.getElement());
//                pointer2 = pointer2.getNext();
//
//            }
//        }
//        while (pointer1 != null) {
//            merged.insertLast(pointer1.getElement());
//            pointer1 = pointer1.getNext();
//        }
//        while (pointer2 != null) {
//            merged.insertLast(pointer2.getElement());
//            pointer2 = pointer2.getNext();
//        }
//
//        return merged;
//    }
//    public boolean contains(String name){
//        int start = 0;
//        NodoVertex<String> current = getHead();
//        while(start < getSize()  && current.getNext() != null){ 
//          if(name.equals(current.getData())){
//              return true;
//          }
//          current = current.getNext();
//        }
//        return false;
//    }
    public NodoVertex<User> getHead() {
        return head;
    }

    public void setHead(NodoVertex<User> head) {
        this.head = head;
    }

    public NodoVertex<User> getTail() {
        return tail;
    }

    public void setTail(NodoVertex<User> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
