/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.Grafo;

/**
 * Clase que define los nodos pertenecientes a la cola (QUEUE)
 * @author alexandralecuna
 * @param <T>, Objeto de la clase User (usuario)
 */
public class Node<T> {

    //Atributos de la clase
    private T tInfo;
    private Node<T> pNextNode;

    /**
     * Constructor de la clase.
     * @param tInfo, usuario a almacenar en el nodo 
     */
    public Node(T tInfo) {
        this.tInfo = tInfo;
        this.pNextNode = null;
    }

    /**
     * Metodo que permite obtener el usuario almacenado en el nodo actual
     * @return Usuario almacenado en el nodo 
     */
    public T getTInfo() {
        return this.tInfo;
    }

    /**
     * Metodo que permite modificar el usuario almacenado en el nodo actual
     * @param tInfo, nuevo nodo a almacenar en el nodo 
     */
    public void setTInfo(T tInfo) {
        this.tInfo = tInfo;
    }

    /**
     * Metodo que permite obtener el nodo siguiente de la cola
     * @return Nodo siguiente al actual
     */
    public Node<T> getNextNode() {
        return this.pNextNode;
    }

    /**
     * Metodo que permite modificar el nodo siguiente al nodo actual de la cola
     * @param pNextNode, nuevo nodo siguiente al actual 
     */
    public void setNextNode(Node<T> pNextNode) {
        this.pNextNode = pNextNode;
    }

}