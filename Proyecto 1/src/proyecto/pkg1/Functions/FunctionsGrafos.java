/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.Functions;

import javax.swing.JOptionPane;
import proyecto.pkg1.Grafo.Grafo;
import proyecto.pkg1.Grafo.ListaVertex;
import proyecto.pkg1.Grafo.NodoVertex;
import proyecto.pkg1.Grafo.User;

/**
 *
 * @author Anabella Jaua
 */
public class FunctionsGrafos {
    
    Grafo grafoAux = new Grafo();
    LeerArchivo f = new LeerArchivo();
    FunctionsTXT use = new FunctionsTXT();
    String infoGrafo = f.leertxt("test\\TxtProyecto.txt");
    String[] users = use.getUsuarios(infoGrafo);
    String[] relaciones = use.getRelaciones(infoGrafo);
    
    public Grafo crearGrafo(String[] users, String[] relaciones){
        for (int i = 1; i < users.length; i++) {
            String[] info = users[i].trim().split(",");
            String username = info[1].trim();
            int id = Integer.parseInt(info[0].trim());
            User user1 = new User(username, id);
            grafoAux.addVertex(user1);}
        for (int j = 1; j < relaciones.length; j++) {
                String[] relationships = relaciones[j].trim().split(",");
                int id1 = Integer.parseInt(relationships[0].trim());
                int id2 = Integer.parseInt(relationships[1].trim());
                int years = Integer.parseInt(relationships[2].trim());
                ListaVertex usersGrafo = grafoAux.getUserList();
//                NodoVertex pointer = usersGrafo.getHead();
//                User userAux = (User) pointer.getElement();
//                int idAux = userAux.getUserID();
                User idName1 = getUsuarioByID(usersGrafo, id1);
                User idName2 = getUsuarioByID(usersGrafo, id2);
                if (idName1 != null && idName2 != null){
                    grafoAux.addEdge(idName1, idName2, years);
                }else{
                    JOptionPane.showMessageDialog(null, "error");
                   }
                
        } return grafoAux;
        
        }
      
     
    public User getUsuarioByID(ListaVertex allUsers, int id){
        User name = null;
        for (NodoVertex i = allUsers.getHead(); i != null; i=i.getNext()) {
            User j = (User) i.getElement();
            int idCompare = j.getUserID();
            if(idCompare == id){
                return j;
            } 
        } return name;
    }
    
    public boolean validarAgregarUser (Grafo grafo,String idUser1, String idUser2, String username1,String username2, String years){
        try{
            if (username1.charAt(0)!='@' || username2.charAt(0)!='@'){
                    JOptionPane.showMessageDialog(null, "Error: Recuerde colocar @ antes de los usernames de los usuarios");
                    return false;
            }
            int year = Integer.parseInt(years);
            int id1 = Integer.parseInt(idUser1);
            int id2 = Integer.parseInt(idUser2);

            if (id1 == id2){
                JOptionPane.showMessageDialog(null, "Error: Recuerde que dos usuarios no pueden tener el mismo id");
                return false;
            } if (username1.equalsIgnoreCase(username2)){
                JOptionPane.showMessageDialog(null, "Error: Recuerde que dos usuarios no pueden tener el mismo username");
                return false;
            }
            User usuario1 = new User(username1, id1);
            User usuario2 = new User(username2, id2);
            ListaVertex listaUsers = grafo.getUserList();
            for (NodoVertex pointer = listaUsers.getHead(); pointer != listaUsers.getTail(); pointer = pointer.getNext()) {
                User usuarioComparar =(User) pointer.getElement();
                String usernameComparar = usuarioComparar.getUsername();
                int idComparar = usuarioComparar.getUserID();
//                if((usuario1.getUserID() == idComparar && !usuario1.getUsername().equalsIgnoreCase(usernameComparar)) || (usuario1.getUserID() != idComparar && usuario1.getUsername().equalsIgnoreCase(usernameComparar))){
//                    JOptionPane.showMessageDialog(null, "Error: Los valores del usuario 1 no coinciden con los guardados en el sistema.\nRecuerde que un usuario tiene un unico id y username");
//                    return false;
//                } if((usuario2.getUserID() == idComparar && !usuario2.getUsername().equalsIgnoreCase(usernameComparar)) || (usuario2.getUserID() != idComparar && usuario2.getUsername().equalsIgnoreCase(usernameComparar))){
//                    JOptionPane.showMessageDialog(null, "Error: Los valores del usuario 2 no coinciden con los guardados en el sistema.\nRecuerde que un usuario tiene un unico id y username");
//                    return false;
//                }; 
                if( idComparar == id1 ){
                    JOptionPane.showMessageDialog(null, "El usuario 1 ya esta registrado en el sistema. Ingrese solo usuarios nuevos.");
                    return false;
                } if (idComparar == id2){
                    JOptionPane.showMessageDialog(null, "El usuario 2 ya esta registrado en el sistema. Ingrese solo usuarios nuevos.");
                    return false;
                }

        }}catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: Recuerde solo ingresar numeros enteros en los ids y en los años de amistad");
            return false;
        } 
        return true;
        
    
        }
           
}
