public class Pila{

    public static void main(String[] args) {
        Integer []arr=new Integer[5];
        Queue<Integer> queue=new Queue<Integer>(arr);
        queue.encolar(5);
        queue.encolar(4);
        queue.encolar(3);
        queue.encolar(2);
        queue.encolar(1);
        System.out.println(queue.descolar());
        queue.encolar(2);


    }





}

class Queue <T> {
    public T[] arr;
    public int back=0;
    public int front=0;
    public int size;
    public int N;
    
    public Queue(T[] ar){
        arr=ar;
        N= arr.length;
    }
    public void encolar(T x){
        if (!isFull()){
            arr[back]=x;
            back=(back+1)%N;
            size++;
        }else{
            throw new RuntimeException("Queue is full item not enqueued");
        }

    }
    public T descolar(){
        if(!isEmpty()){
            T item = arr[front];
            front= (front+1)%N;
            size--;
            return item;
        }
        else{
            throw new RuntimeException("Queue is empty");

        }
    }

    public boolean isEmpty(){
        return size<=0;

    }
    public boolean isFull(){
        return size>=N;
    }
}


