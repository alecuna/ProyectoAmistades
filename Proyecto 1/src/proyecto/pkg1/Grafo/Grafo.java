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

    
    public void newVertex(User currentUser) {
        userList.insertLast(currentUser);
        V++;
    }
    

    public void newEdge(User user1, User user2, int years) {
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
                
            } A++;

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
                sVerts += "(" + userList.getDato(i).getFriendList().getDato(j).getUsername() + ")";
                
            }
            sVerts += " \n";
            System.out.println(sVerts);
        }
    }

}