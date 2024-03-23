package LinkedList;

public class QueueLinkedList {
    private LinkedList list;

    public QueueLinkedList(){
      list = new LinkedList();
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
