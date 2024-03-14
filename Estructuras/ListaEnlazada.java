public class ListaEnlazada{

    public static void main(String[] args) {
        LinkedList linkedList= new LinkedList();
        linkedList.pushFront(0);
        linkedList.pushFront(1);
        linkedList.pushBack(-1);
        linkedList.imprimir();
        System.out.println(linkedList.topBack());
        System.out.println(linkedList.topFront());
        linkedList.popBack();
        linkedList.popFront();
        System.out.println("aaaa");
        linkedList.imprimir();
        System.out.println(linkedList.find(0));

    }
}

class Node {
    int key;
    Node next;
    public Node(int k){
        next=null;
        key=k;
    }

}
class LinkedList{
    Node head;
    Node tail;

    public void pushFront(int key){
        Node node = new Node(key);
        node.next=head;
        head=node;
        if (tail==null){
            tail=head;
        }


    }
    public void pushBack(int key){
        Node node = new Node(key);
        node.next=null;
        if (tail==null){
            head=node;
            tail=node;


        }
        else{
            tail.next=node;
            tail=node;
        }


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
    public void erase(int key) {
        if (head == null) {
            System.out.println("La lista enlazada está vacía");
            return;
        }
        
        if (head.key == key) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        
        Node prev = head;
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        
        if (prev.next == null) {
            System.out.println("No se encontró el elemento " + key + " en la lista");
            return;
        }
        
        prev.next = prev.next.next;
        if (prev.next == null) {
            tail = prev;
        }
    }
    public boolean empty(){
        return head==null;

    }
    public void addBefore(Node beforNode, int key){
        Node node2= new Node(key);
        Node p=head;
        if(beforNode==tail){
            pushBack(key);
        }
        else{

        
        while (p.next.next!=beforNode){
            p=p.next;
        
            }
            node2.next=p.next.next;
            p.next=node2;
        }
    }

    public void addAfter(Node afterNode, int key){
        Node node2= new Node(key);
        node2.next=afterNode.next;
        afterNode.next=node2;
        if (tail==afterNode){
            tail=node2;
        }

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
