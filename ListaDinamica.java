import java.lang.reflect.Array;

public class ListaDinamica{

}
class ListaDinamicaDesordenada<T> {
    private DynamicArray<T> dynamicArray;

    public ListaDinamicaDesordenada() {
        dynamicArray = new DynamicArray<>(createArray(10));
    }

    public void insert(T item) {
        dynamicArray.pushBack(item);
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
        return (T[]) new Object[initialCapacity];
    }
}
