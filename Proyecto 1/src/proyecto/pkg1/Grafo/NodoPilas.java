
package proyecto.pkg1.Grafo;
/**
 *
 * @author alelecuna
 */

public class NodoPilas {
    private Object element;
    private NodoPilas next;

    public NodoPilas(Object elemento) {
        this.element = elemento;
        this.next = null;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object elemento) {
        this.element = elemento;
    }

    public NodoPilas getNext() {
        return next;
    }

    public void setNext(NodoPilas siguiente) {
        this.next = siguiente;
    }
    
    
    
    
}
