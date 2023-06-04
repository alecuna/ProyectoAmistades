/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.Grafo;

import javax.swing.JOptionPane;

/**
 * Clase que define las listas doblemente enlazadas conformadas por los nodos amigos
 * @author alexandralecuna
 */
public class ListaFriends {

    //Atributos de la clase
    private NodoFriends head;
    private NodoFriends tail;
    private int size;

    /**
     * Constructor de la clase
     */
    public ListaFriends() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Metodo que evalua si la lista esta vacia
     * @return valor logico de si la lista esta vacia
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Metodo que inserta un nodo al inicio de la lista
     * @param node, nodo amigo a insertar 
     */
    public void insertBegin(NodoFriends node) {

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

    /**
     * Metodo que inserta un nodo al final de la lista
     * @param node, nodo amigo a insertar 
     */
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
    
    /**
     * Metodo que elimina el primer nodo de la lista
     */
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
    
    /**
     * Metodo que elimina el ultimo nodo de la lista
     * @return Nodo eliminado de la lista, o null si la lista esta vacia
     */
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

    /**
     * Metodo que elimina el nodo en una posicion especifica
     * @param index, indice de posicion del nodo a eliminar
     * @return El nodo eliminado, o null si la lista vacia o el indice no es valido
     */
    public NodoFriends deleteInIndex(int index) {
        if (!isEmpty()) {
            NodoFriends pointer = getHead();
            if (index > getSize()) {
                System.out.println("The index is bigger than the size");
                return deleteFinal();
                
            } else if (index == 0){
                deleteFirst();
                
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
                    return temp;

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
                    return temp;
                }
            }
        }
        return null;
    }

    /**
     * Metodo que imprime la lista
     */
    public void printList() {
        if (!isEmpty()) {

            String aux = "[";
            for (int i = 0; i < getSize(); i++) {
                String dato = getDato(i).getFriend().getUsername();
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

    
    /**
     * Metodo que obtiene el nodo amigo que se encuentra en una posicion especifica
     * @param index, indice de posicion del nodo a obtener
     * @return Nodo amigo en la posicion indicada, o null si la lista esta vacia 
     */
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

    /**
     * Metodo que verifica si un usuario se encuentra almacenado algun nodo de la lista 
     * @param currentUser, usuario a buscar en la lista
     * @return valor logico de si el usuario se encuentra en la lista
     */
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

    /**
     * Metodo que obtiene el primer nodo amigo de la lista
     * @return Primer nodo de la lista
     */
    public NodoFriends getHead() {
        return head;
    }

    /**
     * Metodo que permite modificar la cabeza de la lista
     * @param head, nodo amigo que sera la nueva cabeza de la lista
     */
    public void setHead(NodoFriends head) {
        this.head = head;
    }

    /**
     * Metodo que obtiene el ultimo nodo amigo de la lista
     * @return Ultimo nodo de la lista
     */
    public NodoFriends getTail() {
        return tail;
    }

    /**
     * Metodo que permite modificar la cola de la lista
     * @param tail, nodo amigo que sera la nueva cola de la lista
     */
    public void setTail(NodoFriends tail) {
        this.tail = tail;
    }

    /**
     * Metodo que permite obtener el tamaño de la lista
     * @return Tamaño de la lista de amigos
     */
    public int getSize() {
        return size;
    }

}