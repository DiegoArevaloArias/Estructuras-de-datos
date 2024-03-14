public class PilaReferencias {
    public static void main(String[] args) {
        
    }
}
class Node{
    Node next=null;
    int key;
    public Node(int k){
        key=k;
    }
}
class StackRef {
    private Node top;

    public StackRef() {
        top = null;
    }
    public void push(int item) {
    Node newp = new Node(item);
    newp.next=top;
    top = newp;
    }
    public int pop() {
        if (top == null) {
            System.out.println("La pila está vacía");
        }
        int item = top.key;
        top = top.next;
        return item;
    }
    
    public boolean empty() {
        return top == null;
    }
}
