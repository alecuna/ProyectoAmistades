
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import proyecto.pkg1.Grafo.NodoVertex;
import static proyecto.pkg1.Main.grafo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maria Daniela
 */
public class Libreria {
    
    //Esto va en ventana1
    private void viewGraph(Graph graph) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout()){
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(640, 480);
            }
        };
        frame.setSize(panel.getWidth(), panel.getHeight());
     
        Viewer viewer = new SwingViewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout();
        ViewPanel viewPanel = (ViewPanel) viewer.addDefaultView(true);
        panel.add(viewPanel);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);      
    }
    
    
    // Esto va en el boton de Mostrar Grafo en ventana1
       // TODO add your handling code here:
        Graph graph = new MultiGraph("Relacion");
        System.setProperty("org.graphstream.ui", "swing");
        graph.setAttribute("ui.stylesheet", "node{\n"+ "size:40px,30px;\n"+"fill-color:#9EBCEF; \n"+"text-mode: normal; \n"+"}");
        
        for (int i=0;i<grafo.getUserList().getSize();i++){
            String user= grafo.getUserList().getDato(i).getElement().getUsername();
            int userid = grafo.getUserList().getDato(i).getElement().getUserID();
            graph.addNode(user).setAttribute("ui.label",userid);
        }
        // Se recorre la matriz de adyacencia de nuestro grafo para añadir los arcos y pesos al grafo de GraphStream
        for (int i=0; i < grafo.getUserList().getSize(); i++){
            String friend1 = grafo.getUserList().getDato(i).getElement().getUsername();
            NodoVertex node1 = grafo.getUserList().getDato(i);
            for (int j=0; j<node1.getFriendList().getSize(); j++){
                String friend2 = node1.getFriendList().getDato(j).getFriend().getUsername();
                String weight = String.valueOf(node1.getFriendList().getDato(j).getWeight());
                String weightName = friend1 + friend2;
                graph.addEdge(weightName, friend1, friend2, false).setAttribute("ui.label", weight);
            }
        }
        this.viewGraph(graph);
}
