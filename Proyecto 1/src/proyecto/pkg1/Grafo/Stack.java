package proyecto.pkg1.Grafo;

public class Stack{
    private NodoPilas peek;

    public Stack() {
        this.peek = null;
    }
    
    public NodoPilas getPeek() {
        return peek;
    }

    public void setPeek(NodoPilas peek) {
        this.peek = peek;
    }
    
    public boolean isEmpty(){
        return peek == null;
    }
    
    public void push(Object object) {
        NodoPilas node = new NodoPilas(object);
        if (isEmpty()) {
            setPeek(node);
        } else {
            node.setNext(peek);
            setPeek(node);
        }
    }

    public Object pop() {
        if (!isEmpty()){
            NodoPilas pointer = getPeek();
            setPeek(pointer.getNext());
            pointer.setNext(null);
            return pointer.getElement();
        }
        return null;
    }

    public void printStack() {
        NodoPilas pointer = getPeek();
        while (pointer != null){
            System.out.println("[" + pointer.getElement() + "]");
            pointer = pointer.getNext();
        }
    }

}
