package LinkedList;

public class SortedListLinkedList {
    private LinkedList list;

    public SortedListLinkedList(){
        list = new LinkedList();
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
