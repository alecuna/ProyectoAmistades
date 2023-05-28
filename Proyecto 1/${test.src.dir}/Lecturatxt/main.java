
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Maria Daniela
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AbrirGuardarTxt txt = new AbrirGuardarTxt();
        txt.setSize(700, 500);
        txt.setVisible(true);
        txt.setLocationRelativeTo(null);
        txt.setResizable(false);
        
        Funciones2 func2 = new Funciones2();
        func2.leertxt("C:\\Users\\hp\\Documents\\usuarios.txt"); //En esta parte iria lo de absolute path

    }
    
}
