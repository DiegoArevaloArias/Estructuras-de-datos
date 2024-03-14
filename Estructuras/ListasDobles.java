public class ListasDobles{
    public static void main(String[] args) {
        
    }
}
    class Node {
        int key;
        Node next;
        Node prev;
        public Node(int k){
            next=null;
            prev=null;
            key=k;
        }
    }

class DoubleLinkedList{
        Node head;
        Node tail;
    
        public void pushFront(int key){
            Node node = new Node(key);
            head.next=node;
            node.prev=head;
            if (tail==null){
                tail.next=head;
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
                node.prev=tail;
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
                System.out.println("La double linked list está vacia");
            }
            else{
                head.next.prev=head;
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
                tail=tail.prev;
                tail.next=null;
            }
            
    
        }
        public boolean find(int key){
            Node p = head;
            while(p.key!=key && p.next!=null){
                p=p.next;
            }
            return p.key==key;
    
        }
        public void erase(int key){ 
    
        }
        public boolean empty(){
            return head==null;
    
        }
        public void addBefore(Node beforNode, int key){
            Node node2= new Node(key);
            if(beforNode==tail){
                pushBack(key);
            }
            else{
                beforNode.prev.next=node2;
                node2.prev=beforNode.prev;
                node2.next=beforNode;
                beforNode.prev= node2;
            }
            if (beforNode==head){
                head=node2;

            }
    
    
            
    
            
    
        }
        public void addAfter(Node afterNode, int key){
            Node node2= new Node(key);
            node2.next=afterNode.next;
            node2.prev=afterNode;
            afterNode.next=node2;
            if(node2.next!=null){
                node2.next.prev=node2;
            }
            if (tail==afterNode){
                tail=node2;
            }
    
        }
    
    
    }
    
