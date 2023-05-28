/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.Functions;

/**
 *
 * @author Anabella Jaua
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Maria Daniela
 */
public class FunctionsTXT extends javax.swing.JFrame {
    JFileChooser seleccionar = new JFileChooser();
    File archivo; 
    FileInputStream entrada; 
    FileOutputStream salida; 
    /**
     * Creates new form AbrirGuardarTxt
     */

    public String AbrirArchivo(File archivo){
        String documento="";
        try{
            entrada = new FileInputStream(archivo);
            int ascci;
            while((ascci = entrada.read())!=-1){
                char caracter = (char) ascci; 
                documento += caracter; 
            }
        }catch(Exception e){      
        }
        return documento; 
    }
    
    public String GuardarArchivo(File archivo, String documento){
        String mensaje = null; 
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            mensaje="Archivo guardado";  
        }catch(Exception e){
        }
        return mensaje;
    }
}

