/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.Grafo;

/**
 * Clase que define una cola para implementar el recorrido por anchura del grafo
 * @author alexandralecuna
 * @param <T>, objeto de la clase User (usuario)
 */
public class Queue<T> {

    //Atributos de la clase
    private int length;
    private Node<T> front;
    private Node<T> back;

    /**
     * Constructor de la clase.
     */
    public Queue() {
        this.length = 0;
        this.front = this.back = null;
    }

    /**
     * Metodo que permite obtener el tamaño de la cola
     * @return Tamaño de la cola
     */
    public int getLength() {
        return length;
    }

    /**
     * Metodo que permite modificar el tamaño de la cola
     * @param newLength, nuevo tamaño de la cola
     */
    public void setLegth(int newLength) {
        this.length = newLength;
    }

    /**
     * Metodo para obtener el primer nodo de la cola
     * @return Primer nodo de la cola
     */
    public Node<T> getFront() {
        return front;
    }

    /**
     * Metodo para modificar el primer nodo de la cola 
     * @param newFront, nodo que sera el primer nodo de la cola
     */
    public void setFrond(Node<T> newFront) {
        this.front = newFront;
    }

    /**
     * Metodo para obtener el ultimo nodo de la cola
     * @return Ultimo nodo de la cola
     */
    public Node<T> getback() {
        return back;
    }

    /**
     * Metodo para modificar el ultimo nodo de la cola 
     * @param newBack, nodo que sera el ultimo nodo de la cola
     */
    public void setback(Node<T> newback) {
        this.back = newback;
    }

    /**
     * Metodo que retorna el nodo siguiente al actual
     * @param nodo al cual se quiere buscar su siguiente
     * @return nodo siguiente al nodo ingresado
     */
    public Node<T> next(Node<T> nodo) {
        return nodo.getNextNode();
    }

    /**
     * Metodo que verifica si la cola esta vacia
     * @return valor logico de si la cola esta vacia
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Metodo que inserta un nodo al final de la cola
     * @param tInfo, Usuario almacenado en el nodo a insertar al final de la cola
     */
    public void enqueue(T tInfo) {
        Node<T> newNodo = new Node(tInfo);
        if (isEmpty()) {
            front = newNodo;
        } else {
            back.setNextNode(newNodo);
        }
        back = newNodo;
        length++;
    }

    /**
     * Metodo que elimina el primer elemento de la cola
     * @return Usuario eliminado 
     */
    public T dequeue() {
        T aux = null;
        if (!isEmpty()) {
            aux = front.getTInfo();
            this.front = next(front);
            length--;
        }
        return aux;
    }

}
