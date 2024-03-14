public class QueuesReferencias {
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

class QueueRef {
    private Node front,rear;

    public QueueRef(){
        front = null;
        rear = null;
    }

    public void enqueue(int item) {
        Node newp = new Node(item);
        if(rear != null){
            rear.next=(newp);
        }
        else{
            front = newp;
            rear = newp;
        }
    }
    public int dequeue() {
        if (front == null) {
            System.out.println("La cola está vacía");
            return -1; // Otra opción sería lanzar una excepción para indicar un error de cola vacía
        }
        int item = front.key;
        front = front.next;
        if (front == null) {
            // Si después de quitar el elemento, la cola está vacía, también actualizamos rear
            rear = null;
        }
        return item;
    }
    
    public boolean empty() {
        return front == null;
    }
    }