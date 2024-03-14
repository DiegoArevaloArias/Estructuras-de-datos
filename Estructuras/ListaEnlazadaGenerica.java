public class ListaEnlazadaGenerica {
    
}
class LinkedListInnerNodeGeneric<T extends Comparable<T>> {

    private class Node<T> {
        private T data;
        private Node<T> next;
        public Node(){
            data=null;
            next=null;
        }

        public Node (T data) {
            this.data = data;
            next = null;
        }
    }

    private Node<T> head;
    public LinkedListInnerNodeGeneric(){
        head = null;
    }

    public boolean insert(T item) {
        boolean inserted;
        Node<T> ptr,prev;
        inserted = false;
        ptr = head;
        prev = null;

        while(ptr != null && ((Comparable<T>) ptr.data).compareTo(item) < 0){
            prev = ptr;
            ptr = ptr.next;
        }

        if (ptr == null || ptr.data == item) {
            inserted = true;
            Node<T> newp = new Node<T>();
            newp.data = item;
            newp.next = ptr;
            if (prev == null){
                head = newp;
            }
            else{
                prev.next = newp;
            }
        }
        return inserted;
    
    }

    public boolean delete(int item) {
    boolean deleted = false;
    Node<T> ptr, prev;
    //Body of method
    return deleted;
    }
    public void printRecursive() {
        System.out.print("List Recursive:" );
        printR(head);
        System.out.println();
    }
    private void printR(Node<T> p){
        if(p != null) {
        System.out.print(p.data + "");
        printR(p.next);
    }
    }
    }
