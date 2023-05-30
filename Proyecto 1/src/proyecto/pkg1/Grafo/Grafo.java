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
public class Grafo {

    private ListaVertex<NodoVertex> userList;
    private int Vmax; // numero maximo de vertices
    private int V; // numero de vertices
    private int A; // numero de aristas

    public Grafo() {
        this.Vmax = 100;
        this.A = 0;
        this.userList = new ListaVertex<NodoVertex>();
    }

    public void addVertex(User currentUser) {
        userList.insertFinal(currentUser);
        V++;
    }

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

        } else {
            JOptionPane.showMessageDialog(null, "Error. El usuario que desea eliminar no existe.");
        }
    }

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

    public void printUsers() {

        userList.printList();
    }

    public void printFriends() {

        for (int i = 0; i < userList.getSize(); i++) {
            System.out.println(userList.getDato(i).getElement().getUsername() + "-->");
            for (int j = 0; j < userList.getDato(i).getFriendList().getSize(); j++) {
                System.out.println(j + ". " + userList.getDato(i).getFriendList().getDato(j).getFriend().getUsername());
            }
        }

    }

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
    
    public ListaVertex<NodoVertex> getUserList() {
        return userList;
    }
    
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
    
    public boolean checkPuente(User user1, User user2) throws Exception {

        boolean isPuente = false;
        int years = -1;

        // obtiene el peso de la arista para volverla agregar al grafo al finalizar la funcion
        if (userList.checkUser(user1) && userList.checkUser(user2) && checkAdj(user1, user2)) {
            
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
            
            System.out.println("UserA: " + user1.getUsername() + " UserB: " + user2.getUsername() + " years: "+ years);
            addEdge(user1, user2, years);
            
            
            System.out.println(cantPuentes + "=" + cantNuevaPuentes);
            
            if (cantPuentes != cantNuevaPuentes) {
                isPuente = true;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error. Alguno de los usuarios ingresados no existe.");
        }
        return isPuente;
    }
    
//    public int getID(User usuario) {
//        int numID = -1;
//        if (userList.checkUser(usuario)) {
//            for (int i = 0; i < userList.getSize(); i++) {
//                if (userList.getDato(i).getElement() == usuario) {
//                    numID = userList.getDato(i).getElement().getUserID();
//                }
//            }
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Error. El usuario ingresado no existe.");
//        }
//        return numID;
//    }
}
