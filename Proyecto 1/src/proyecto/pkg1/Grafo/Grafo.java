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
                    userList.getDato(i).getFriendList().insertLast(friend2);
                }

                if (userList.getDato(i).getElement().equals(user2)) {
                    userList.getDato(i).getFriendList().insertLast(friend1);
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
                    if (userList.getDato(i).getElement() == usuario){
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
            } A--;
        } else {
            JOptionPane.showMessageDialog(null, "Error. Alguno de los usuarios ingresados no existe.");
        }
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

//    public void printFriendsAle(){
//        System.out.println(userList.getDato(1).getElement().getUsername() + "-->");
//        for (int j = 0; j < userList.getDato(1).getFriendList().getSize(); j++) {
//                System.out.println(j + ". " + userList.getDato(1).getFriendList().getDato(j).getFriend().getUsername());
//            }
//    }
//
//    public void pruebaDelete() {
//        userList.getDato(1).getFriendList().deleteInIndex(0);
//        }
//    
}
