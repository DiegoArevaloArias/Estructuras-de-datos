public class StackDoublyLinkedList{
    private DoublyLinkedList list;
    
    public StackDoublyLinkedList(){
      list = new DoublyLinkedList();
    }
    
    public void push(int data){
      list.pushFront(data);
    }
    
    public int pop(){
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