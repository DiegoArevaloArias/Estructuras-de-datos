public class ListaOrdenada {
    
}
class ListaDinamicaOrdenada<T extends Comparable<T>> {
    private DynamicArray<T> dynamicArray;

    public ListaDinamicaOrdenada() {
        dynamicArray = new DynamicArray<>(createArray(10));
    }

    public void insert(T item) {
        int i = 0;
        while (i < dynamicArray.size() && item.compareTo(dynamicArray.get(i)) > 0) {
            i++;
        }
        dynamicArray.set(i, item);
    }

    public void remove(int index) {
        dynamicArray.remove(index);
    }

    public T get(int index) {
        return dynamicArray.get(index);
    }

    public int size() {
        return dynamicArray.size();
    }

    @SuppressWarnings("unchecked")
    private T[] createArray(int initialCapacity) {
        return (T[]) new Comparable[initialCapacity];
    }
}
