/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.Grafo;

import javax.swing.JOptionPane;

/**
 * Clase que define las listas doblemente enlazadas conformadas por los nodos vertices del grafo
 * @author alexandralecuna
 * @param <T>, Objeto de la clase User (usuario)
 */
public class ListaVertex<T> {

    //Atributos de la clase 
    private NodoVertex<User> head;
    private NodoVertex<User> tail;
    private int size;

    /**
     * Constructor de la clase
     */
    public ListaVertex() {
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
     * Metodo que inserta un nodo al inicio de la lista de vertices
     * @param element, usuario que sera almacenado en el nodo vertice a insertar al inicio de la lista
     */
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

    /**
     * Metodo que inserta un nodo al final de la lista de vertices
     * @param element, usuario que sera almacenado en el nodo vertice a insertar al final de la lista
     */
    public void insertFinal(User element) {
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
            node.setNext(getHead());
            

        }
        size++;
    }
    
    /**
     * Metodo que elimina el primer nodo de la lista de vertices
     * @return Nodo vertice eliminado
     */
    public NodoVertex deleteBegin(){
        if (isEmpty()) {
            System.out.println("List is Empty");
        } else {
            NodoVertex pointer = getHead();
            NodoVertex pointer2 = getHead();
            setHead((NodoVertex) getHead().getNext());
            while (pointer.getNext() != pointer2) {
                pointer = (NodoVertex) pointer.getNext();
            }
            pointer.setNext(getHead());
            pointer2.setNext(null);
            size--;
            return pointer;
        }
        
        return null;
    }
    
     /**
     * Metodo que elimina el ultimo nodo de la lista de vertices
     * @return Nodo vertice eliminado
     */
    public NodoVertex deleteFinal(){
        if (isEmpty()) {
            System.out.println("List is Empty");
        } else {
            NodoVertex pointer = getHead();
            NodoVertex pointer2;
            
            if (size > 1){
                while (((pointer.getNext())).getNext() != getHead()) {
                    pointer = pointer.getNext();
                }
                pointer2 = pointer.getNext();
                pointer2.setNext(null);
                pointer.setNext(getHead());
            } else {
                pointer2 = deleteBegin();
            }
            size--;
            return pointer2;
        }
        
        return null;
    }
    
    /**
     * Metodo que elimina el nodo vertice en una posicion especifica
     * @param index, indice de posicion del nodo a eliminar
     * @return El nodo eliminado, o null si la lista vacia o el indice no es valido
     */
    public NodoVertex deleteInIndex(int index){
        if (isEmpty()) {
            System.out.println("List is Empty");
        } else {
            if (index == 0){
                deleteBegin();
            } else {
                if (index < size) {
                    if(index == size - 1) {
                        deleteFinal();
                    } else {
                        NodoVertex pointer = getHead();
                        NodoVertex pointer2;
                        int cont = 0;
                        while ( cont< index-1 ) {
                            pointer = (NodoVertex) pointer.getNext();
                            cont++;
                        }
                        pointer2 = (NodoVertex) pointer.getNext();
                        pointer.setNext((NodoVertex) pointer2.getNext());
                        pointer2.setNext(null);
                        return pointer2;
                    }
                    
                } else {
                    System.out.println("Error in index");
                }
            }
        }
        size--;
        return null;
    }
    
    /**
     * Metodo que imprime la lista de vertices
     */
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

    /**
     * Metodo que obtiene el nodo vertice que se encuentra en una posicion especifica
     * @param index, indice de posicion del nodo a obtener
     * @return Nodo vertice en la posicion indicada, o null si la lista esta vacia 
     */
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

    /**
     * Metodo que verifica si un usuario se encuentra almacenado algun nodo de la lista de vertices
     * @param currentUser, usuario a buscar en la lista
     * @return valor logico de si el usuario se encuentra en la lista
     */
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

    /**
     * Metodo que obtiene la cabeza de la lista de vertices
     * @return Primer nodo vertice de la lista de vertices
     */
    public NodoVertex<User> getHead() {
        return head;
    }

    /**
     * Metodo que permite modificar la cabeza de la lista
     * @param head, nodo vertice que sera la nueva cabeza de la lista
     */
    public void setHead(NodoVertex<User> head) {
        this.head = head;
    }

    /**
     * Metodo que obtiene la cola de la lista de vertices
     * @return Ultimo nodo vertice de la lista de vertices
     */
    public NodoVertex<User> getTail() {
        return tail;
    }

    /**
     * Metodo que permite modificar la cola de la lista
     * @param tail, nodo vertice que sera la nueva cola de la lista
     */
    public void setTail(NodoVertex<User> tail) {
        this.tail = tail;
    }

    /**
     * Metodo que obtiene el tamaño de la lista de vertices
     * @return Tamaño de la lista de vertices
     */
    public int getSize() {
        return size;
    }

    /**
     * Metodo que permite modificar el tamaño de la lista de vertices
     * @param size, nuevo tamaño de la lista 
     */
    public void setSize(int size) {
        this.size = size;
    }

}
