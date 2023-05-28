/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.Functions;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Maria Daniela
 */
public class LeerArchivo {

    public String leertxt(String url){

        String line;  
        String grafo_txt="";
        File file = new File(url);
        try{
            if (!file.exists()){
                file.createNewFile();
            } else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine())!= null){
                    if (!line.isEmpty()){
                        grafo_txt += line+ "\n";
                    } 
                }
                br.close();
                JOptionPane.showMessageDialog(null, "Lectura Exitosa");
            }
        }catch(Exception err){
             JOptionPane.showMessageDialog(null, "Error");
        }

        Scanner scanner = new Scanner(grafo_txt);
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
        return grafo_txt;
    }
}



