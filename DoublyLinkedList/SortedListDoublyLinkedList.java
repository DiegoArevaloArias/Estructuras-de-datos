public class SortedListDoublyLinkedList{
    private DoublyLinkedList list;
  
    public SortedListDoublyLinkedList(){
      list = new DoublyLinkedList();
    }
  
    public void add(int data){
      Node node = list.head;
      while(node != null){
        if(data < node.data){
          list.addBefore(node, data);
          return;
        }
        node = node.next;
      }
      list.pushBack(data);
    }
  
    public void remove(int data){
      list.erase(data);
    }
  
    public int get(int index){
      Node node = list.head;
      for(int i = 0; i < index; i++){
        node = node.next;
      }
      return node.data;
    }
  
    public int size(){
      return list.size();
    }
  
    public boolean isEmpty(){
      return list.head == null;
    }
    
  }