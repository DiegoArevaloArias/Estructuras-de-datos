public class QueueDoublyLinkedList{
    private DoublyLinkedList list;
    
    public QueueDoublyLinkedList(){
      list = new DoublyLinkedList();
    }
    
    public void enqueue(int data){
      list.pushBack(data);
    }
    
    public int dequeue(){
      int data = list.head.data;
      list.popFront();
      return data;
    }
    
    public int peek(){
      return list.head.data;
    }
    
    public boolean isEmpty(){
      return list.head == null;
    }
  }
