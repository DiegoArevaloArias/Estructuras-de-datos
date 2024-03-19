public class ColaDinamico{

}

class ColaConArregloDinamico<T> {
    private DynamicArray<T> dynamicArray;

    public ColaConArregloDinamico() {
        dynamicArray = new DynamicArray<>(createArray(10));
    }

    public void enqueue(T item) {
        dynamicArray.pushBack(item);
    }

    public T dequeue() {
        if (dynamicArray.size() == 0) {
            throw new IllegalStateException("La cola está vacía");
        }
        T item = dynamicArray.get(0);
        dynamicArray.remove(0);
        return item;
    }

    public boolean empty() {
        return dynamicArray.size() == 0;
    }
    
        
    
        
        
    

    private T[] createArray(int initialCapacity) {
        return (T[]) new Object[initialCapacity];
    }
}