/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.Grafo;

import javax.swing.JOptionPane;

/**
 * Clase grafo implementada con listas de adyacencia 
 * @author alexandralecuna
 */
public class Grafo {

    //Atributos de la clase
    private ListaVertex<NodoVertex> userList;
    private int Vmax; // numero maximo de vertices
    private int V; // numero de vertices
    private int A; // numero de aristas

    /**
     * Constructor de la clase 
     */
    public Grafo() {
        this.Vmax = 100;
        this.A = 0;
        this.userList = new ListaVertex<NodoVertex>();
    }
    
    /**
     * Metodo que agrega un usuario como vertice al grafo 
     * @param currentUser, usuario a añadir
     */
    public void addVertex(User currentUser) {
        userList.insertFinal(currentUser);
        V++;
    }

    /**
     * Metodo que añade una arista entre dos vertices, cuyo peso son los años de amistad
     * @param user1, primer usuario de la relacion
     * @param user2, segundo usuario de la relacion
     * @param years, años de amistas entre el usuario 1 y 2
     */
    public void addEdge(User user1, User user2, int years) {
        NodoFriends friend1 = new NodoFriends(years, user1);
        NodoFriends friend2 = new NodoFriends(years, user2);

        //inserta al user1 en la lista de amigos del user2 y viceversa
        if (userList.checkUser(user1) && userList.checkUser(user2)) {

            for (int i = 0; i < userList.getSize(); i++) {

                if (userList.getDato(i).getElement().equals(user1)) {
                    userList.getDato(i).getFriendList().insertBegin(friend2);
                }

                if (userList.getDato(i).getElement().equals(user2)) {
                    userList.getDato(i).getFriendList().insertBegin(friend1);
                }

            }
            A++;

        } else {
            JOptionPane.showMessageDialog(null, "Error. Alguno de los usuarios ingresados no existe.");
        }

    }

    /**
     * Metodo que elimina una vertice del grafo 
     * @param usuario, usuario a eliminar
     */
    public void deleteVertex(User usuario) {
        if (userList.checkUser(usuario)) {

            for (int i = 0; i < userList.getSize(); i++) {

                for (int j = 0; j < userList.getDato(i).getFriendList().getSize(); j++) {

                    // elimina el usuario de las diferentes listas de amigos
                    if (userList.getDato(i).getFriendList().getDato(j).getFriend() == usuario) {
                        userList.getDato(i).getFriendList().deleteInIndex(j);
                        A--;

                    }

                    // elimina el usuario de la lista de usuarios vertex
                    if (userList.getDato(i).getElement() == usuario) {
                        userList.deleteInIndex(i);
                    }
                }
            } 
            V--;
            userList.setSize(V);

        } else {
            JOptionPane.showMessageDialog(null, "Error. El usuario que desea eliminar no existe.");
        }
    }

    /**
     * Metodo que elimina una arista entre dos vertices del grafo
     * @param user1, usuario 1 de la relacion a eliminar
     * @param user2, usuario 2 de la relacion a eliminar 
     */
    public void deleteEdge(User user1, User user2) {
        if (userList.checkUser(user1) && userList.checkUser(user2)) {

            for (int i = 0; i < userList.getSize(); i++) {

                if (userList.getDato(i).getElement().equals(user1)) {
                    NodoFriends pointer = userList.getDato(i).getFriendList().getHead();

                    for (int j = 0; j < userList.getDato(i).getFriendList().getSize(); j++) {

                        if (pointer.getFriend() == user2) {
                            userList.getDato(i).getFriendList().deleteInIndex(j);

                            break;

                        } else {
                            pointer = pointer.getNext();
                        }
                    }

                } else if (userList.getDato(i).getElement().equals(user2)) {
                    NodoFriends pointer = userList.getDato(i).getFriendList().getHead();

                    for (int j = 0; j < userList.getDato(i).getFriendList().getSize(); j++) {

                        if (pointer.getFriend() == user1) {
                            userList.getDato(i).getFriendList().deleteInIndex(j);
                            break;

                        } else {
                            pointer = pointer.getNext();
                        }

                    }
                }
            }
            A--;
        } else {
            JOptionPane.showMessageDialog(null, "Error. Alguno de los usuarios ingresados no existe.");
        }
    }

    /**
     * Metodo para determinar si existe una arista (relacion) entre dos vertices (usuarios)
     * @param user1, usuario 1 a evaluar
     * @param user2, usuario 2 a evaluar 
     * @return valor logico de si la arista existe o no
     */
    public boolean checkAdj(User user1, User user2) {
        boolean adj = false;
        for (int i = 0; i < userList.getSize(); i++) {
            User currentUser = userList.getDato(i).getElement();
            if (currentUser == user1) {
                for (int j = 0; j < userList.getDato(i).getFriendList().getSize(); j++) {

                    if (userList.getDato(i).getFriendList().getDato(j).getFriend() == user2) {
                        adj = true;
                    }
                }

            }
        }
        return adj;
    }
    
    /**
     * Metodo que imprime todas las vertices del grafo
     */
    public void printVerts() {

        String sVerts = "";
        sVerts += V + " vertices, " + A + " aristas " + "\n";
        for (int i = 0; i < V; i++) {
            NodoVertex pointer = userList.getHead();
            sVerts += (userList.getDato(i).getElement().getUsername() + " -> ");
            for (int j = 0; j < userList.getDato(i).getFriendList().getSize(); j++) {
                sVerts += "(" + userList.getDato(i).getFriendList().getDato(j).getFriend().getUsername() + ", " + userList.getDato(i).getFriendList().getDato(j).getWeight() + ")";

            }
            sVerts += " \n";
        }
        System.out.println(sVerts);
    }

    /**
     * Metodo que imprime la lista de usuarios registrados en el grafo
     */
    public void printUsers() {

        userList.printList();
    }

    /**
     * Metodo que imprime las aristas correspondientes a cada vertice del grafo
     */
    public void printFriends() {

        for (int i = 0; i < userList.getSize(); i++) {
            System.out.println(userList.getDato(i).getElement().getUsername() + "-->");
            for (int j = 0; j < userList.getDato(i).getFriendList().getSize(); j++) {
                System.out.println(j + ". " + userList.getDato(i).getFriendList().getDato(j).getFriend().getUsername());
            }
        }

    }

    /**
     * Metodo que indica la posicion del usuario en la lista de usuarios 
     * @param usuario cuya posicion se desea encontrar
     * @return La posicion del usuario, o -1 si el usuario no se encuentra en la lista
     */
    public int getIndex(User usuario) {
        if (!(userList.isEmpty())) {
            int index = 0;
            NodoVertex aux = userList.getHead();
            while (aux != null) {
                if (aux.getElement() == (usuario)) {
                    break;
                }
                aux = aux.getNext();
                index++;
            }
            return index;
        }
        return -1;
    }

    /**
     * Metodo para realizar el recorrido por anchura del grafo
     * @return La cantidad de islas en el grafo
     * @throws Exception 
     */
    public int BFS() throws Exception {

        Queue<User> cola = new Queue<>();
        ListaVertex<User> usuariosVisitados = new ListaVertex<>();
        boolean visitados[] = new boolean[V];
        User currentUser;
        int contIslas = 0;

        for (int i = 0; i < V; i++) {
            visitados[i] = false;
        }

        for (int i = 0; i < V; i++) {

            if (!visitados[i]) {
                cola.enqueue(userList.getDato(i).getElement());
                visitados[i] = true;

                while (!cola.isEmpty()) {
                    currentUser = cola.dequeue();
                    usuariosVisitados.insertFinal(currentUser);
                    int numAux = getIndex(currentUser);

                    for (int j = 0; j < V; j++) {
                        if ((numAux != j) && (checkAdj(currentUser, userList.getDato(j).getElement())) && (!visitados[j])) {
                            cola.enqueue(userList.getDato(j).getElement());
                            visitados[j] = true;
                        }
                    }
                }
                contIslas += 1;

            }
        }
        return contIslas;

    }
    
    /**
     * Metodo para obtener la lista de usuarios registrados en el grafo
     * @return La lista de usuarios registrados en el grafo
     */
    public ListaVertex<NodoVertex> getUserList() {
        return userList;
    }
    
    /**
     * Metodo recursivo que permite recorrer la lista de usuarios para realizar el recorrido por profundidad del grafo
     * @param numVertice, indice del vertice actual
     * @param visitados, lista de booleanos de los vertices visitados
     * @param usuariosVisitados, listaVertex que contiene los usuarios visitados
     * @return listaVertex de los usuarios visitados 
     */
    private ListaVertex deepTraveling(int numVertice, boolean[] visitados, ListaVertex usuariosVisitados) {
        visitados[numVertice] = true;
        usuariosVisitados.insertFinal(userList.getDato(numVertice).getElement());

        for (int i = 0; i < V; i++) {
            if ((numVertice != i) && (!visitados[i]) && (checkAdj(userList.getDato(numVertice).getElement(), userList.getDato(i).getElement()))) {
                usuariosVisitados = deepTraveling(i, visitados, usuariosVisitados);
            }
        }
        return usuariosVisitados;
    }

    /**
     * Metodo para realizar el recorrido por profundidad del grafo
     * @return Cantidad de islas en el grafo
     * @throws Exception 
     */
    public int DFS() throws Exception {

        int contIslas = 0;

        boolean[] visitados = new boolean[V];
        ListaVertex<User> usuariosVisitados = new ListaVertex<>();
        
       
        for (int i = 0; i < V; i++) {
            visitados[i] = false;
        }
        for (int i = 0; i < V; i++) {
            if (!visitados[i]) {
                usuariosVisitados = deepTraveling(i, visitados, usuariosVisitados);
                contIslas ++;
            } 
        }
        return contIslas;

    }
    
    /**
     * Funcion que indica si la relacion entre dos usuarios crea un puente en el grafo
     * @param user1, usuario 1 a evaluar
     * @param user2, usuario 2 a evaluar
     * @return valor logico de si la relacion crea un puente en el grafo
     * @throws Exception 
     */
    public boolean checkPuente(User user1, User user2) throws Exception {

        boolean isPuente = false;
        int years = -1;

        // obtiene el peso de la arista para volverla agregar al grafo al finalizar la funcion
        if (userList.checkUser(user1) && userList.checkUser(user2)) {
            
            for (int i = 0; i < userList.getSize(); i++) {
                User currentUser = userList.getDato(i).getElement();
                if (currentUser == user1) {
                    for (int j = 0; j < userList.getDato(i).getFriendList().getSize(); j++) {
                        NodoFriends pointer = userList.getDato(i).getFriendList().getDato(j);
                        if (pointer.getFriend() == user2) {
                            years = userList.getDato(i).getFriendList().getDato(j).getWeight();
                            break;
                        }
                    } break;
                }
            }

            int cantPuentes = BFS();
            deleteEdge(user1, user2);
            int cantNuevaPuentes = BFS();
            
            addEdge(user1, user2, years);
            
                      
            if (cantPuentes != cantNuevaPuentes) {
                isPuente = true;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error. Alguno de los usuarios ingresados no existe.");
        }
        return isPuente;
    }
}