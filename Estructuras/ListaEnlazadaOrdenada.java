public class ListaEnlazadaOrdenada{
    public static void main(String[] args) {
        
    }
}

class Node{
    Node next=null;
    int key;
    public  Node(int d){
        key=d;
    }
}
class OrderLinkedList{

    Node head ;
    Node tail;

    public void insertar(int d){
        
    }

    public int topFront(){
        return head.key;
    }
    public int topBack(){
        return tail.key;
    }
    public void popFront(){
        if(head==null){
            System.out.println("La linked list está vacia");
        }
        else{
            head=head.next;

        }

    }
    public void popBack(){
        if(head==null){
            System.out.println("La linked list está vacia");
        }
        if(head==tail){
            tail=null;
            head=tail;
        }
        else{
            Node p = head.next;
            while(p.next.next!=null){
                p=p.next;
            }
            p.next=null;
            tail=p;
        }
        

    }
    public boolean find(int key){
        Node p = head;
        while(p.key!=key && p.next!=null){
            p=p.next;
        }
        return p.key==key;

    }
    public void delete(int item){
        Node prev=null;
        Node ref=head;
        while (ref!=null && ref.key<item){
            prev=ref;
            ref=ref.next;
        }
        if (ref!= null && ref.key==item){
            if(prev!=null){
                prev.next=ref.next;
            }
            else{
                head=ref;
            }
        }

    }
    public boolean empty(){
        return head==null;

    }

    public void imprimir(){
        Node ref;
        ref=head;
        while (ref!=null){
            System.out.println(ref.key);
            ref=ref.next;
        }
    }





}