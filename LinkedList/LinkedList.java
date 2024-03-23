package LinkedList;
import java.util.NoSuchElementException;

// Crea la clase Nodo que contiene un dato de tipo entero y una referencia al siguiente nodo.
class Node{
    public int data;
    public Node next;
    
    // Crea el constructor de la clase nodo que recibe un dato de tipo entero y lo asigna al nodo.
    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }


public class LinkedList {
    public Node head, tail;

    public LinkedList(Node node){
      head = node;
      tail = node;
    }

    public LinkedList(){
      this(null);
    }

    public void pushFront(int data){
      Node node = new Node(data);
      if(head == null){
        head = node;
        tail = node;
      } else {
        node.next = head;
        head = node;
      }
    }
    
    public void popFront(){
        if(head == null)
          throw new NoSuchElementException("List is empty");
        if(head == tail){
          head = null;
          tail = null;
        } else {
          head = head.next;
        }
    }

    public void pushBack(int data){
        Node node = new Node(data);
        if(tail == null){
          head = node;
          tail = node;
        } else {
          tail.next = node;
          tail = node;
        }
    }

    public void popBack(){
        if(head == null)
          throw new NoSuchElementException("List is empty");
        if(head == tail){
          head = null;
          tail = null;
        } else {
          Node node = head;
          while(node.next != tail){
            node = node.next;
          }
          tail = node;
          tail.next = null;
        }
    }

    public void addAfter(Node prevNode, int data){
        Node node = new Node(data);
        node.next = prevNode.next;
        prevNode.next = node;
        if(node.next == null)
            tail = node;
    }

    public void addBefore(Node nextNode, int data){
        Node node = new Node(data);
        Node prevNode = head;
        while(prevNode.next != nextNode){
            prevNode = prevNode.next;
        }
        prevNode.next = node;
        node.next = nextNode;
    }

    public int size(){
        int size = 0;
        Node node = head;
        while(node != null){
            size++;
            node = node.next;
        }
        return size;
    }

    public int topFront(){
        if(head == null)
          throw new NoSuchElementException("List is empty");
        return head.data;
    }

    public int topBack(){
        if(tail == null)
          throw new NoSuchElementException("List is empty");
        return tail.data;
    }
    
    public boolean find(int data){
        Node node = head;
        while(node != null){
            if(node.data == data)
                return true;
            node = node.next;
        }
        return false;
    }

    public void erase(int data){
        if(head == null)
          throw new NoSuchElementException("List is empty");
        if(head.data == data){
          head = head.next;
          if(head == null)
            tail = null;
          return;
        }
        Node node = head;
        while(node.next != null){
          if(node.next.data == data){
            node.next = node.next.next;
            if(node.next == null)
              tail = node;
            return;
          }
          node = node.next;
        }
    }

}

