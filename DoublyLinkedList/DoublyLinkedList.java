import java.util.NoSuchElementException;

class Node{
    public int data;
    public Node next, prev;
  
    public Node(int data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }
  }

public class DoublyLinkedList{
  public Node head, tail;

  public DoublyLinkedList(Node node){
    head = node;
    tail = node;
  }

  public DoublyLinkedList(){
    this(null);
  }

  public void pushBack(int data){
    Node node = new Node(data);
    if(tail == null){
      head = node;
      tail = node;
    } else {
      tail.next = node;
      node.prev = tail;
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
      tail = tail.prev;
      tail.next = null;
    }
  }

  public void addAfter(Node node, int data){
    Node newNode = new Node(data);
    newNode.next = node.next;
    newNode.prev = node;
    node.next = newNode;
    if(newNode.next != null)
      newNode.next.prev = newNode;
    if(tail == node)
      tail = newNode;
  }

  public void addBefore(Node node, int data){
    Node newNode = new Node(data);
    newNode.prev = node.prev;
    newNode.next = node;
    node.prev = newNode;
    if(newNode.prev != null)
      newNode.prev.next = newNode;
    if(head == node)
      head = newNode;
  }

  public void popFront(){
    if(head == null)
      throw new NoSuchElementException("List is empty");
    head = head.next;
    if(head != null)
      head.prev = null;
    else
      tail = null;
  }

  public void pushFront(int data){
    Node node = new Node(data);
    if(head == null){
      head = node;
      tail = node;
    } else {
      head.prev = node;
      node.next = head;
      head = node;
    }
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

  public void erase(int index){
    Node node = head;
    for(int i = 0; i < index; i++){
      node = node.next;
    }
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  public int get(int index){
    Node node = head;
      for(int i = 0; i < index; i++){
        node = node.next;
      }
      return node.data;
  }
  
}