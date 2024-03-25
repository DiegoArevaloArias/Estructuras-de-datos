public class UnsortedListDoublyLinkedList{
    private DoublyLinkedList list;
    
    public UnsortedListDoublyLinkedList(){
      list = new DoublyLinkedList();
    }
    
    public void add(int data){
      list.pushBack(data);
    }
    
    public void remove(int index){
      list.erase(index);
    }
    
    public int get(int index){
      return list.get(index);
    }
    
    public int size(){
      return list.size();
    }
    
    public boolean isEmpty(){
      return list.head == null;
    }
  }