import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class PilaDinamico100 {
    public static void main(String[] args) {
        int[] tamañosDatos = { 10000, 100000, 1000000, 10000000, 100000000 }; 
        for (int n : tamañosDatos) {
            PilaConArregloDinamico<Integer> pila = new PilaConArregloDinamico<>();
            long tiempoTotal = 0;

            Integer[] datosAleatorios = leerDatosDesdeArchivo("numeros_aleatorios.txt", n);

            for (int i = 0; i < n; i++) {
                long inicio = System.nanoTime(); 
                pila.push(datosAleatorios[i]); 
                long fin = System.nanoTime(); 
                tiempoTotal += (fin - inicio); 
            }

            System.out.println("Tiempo promedio de inserción para " + n + " datos: "
                    + (tiempoTotal / (double) n) + " nanosegundos");
        }
    }

    private static Integer[] leerDatosDesdeArchivo(String nombreArchivo, int cantidad) {
        Integer[] datos = new Integer[cantidad];
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int indice = 0;
            while ((linea = reader.readLine()) != null && indice < cantidad) {
                datos[indice++] = Integer.parseInt(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datos;
    }
}
class DynamicArray<T>{
    T[] arr;
    int capacity;
    int size=0;

    public DynamicArray(T[] ar){
        arr=ar;
        capacity=arr.length;

    }

    public void set(int i,T item){
        if (i<0 || i>=size){
            System.out.println("indice fuera del rango");
        }else{
            arr[i]=item;
        }
    }
    
    public T get(int i){
        if (i<0 || i>=size){
            System.out.println("Indice fuera del rango");
            throw new RuntimeException("Indice fuera del arreglo");
        }else{
            return arr[i];
        }
    }

    public void remove(int i){
        if (i<0 || i>=size){
            System.out.println("Indice fuera del rango");
            throw new RuntimeException("Indice fuera del arreglo");
        }else{
            for (int j=i;j<size-1;j++){
                arr[j]=arr[j+1];
            } 
            size--; 
        }
    }

    public void pushBack(T item){
        if (size==capacity){
            @SuppressWarnings("unchecked")
            T[] newArr= (T[]) Array.newInstance(arr.getClass().getComponentType(), capacity*2);
            for (int i=0; i<size-1;i++){
                newArr[i]=arr[i];
            }
            arr=newArr;
            capacity=capacity*2;
        }
        arr[size]=item;
        size++;
    }

    public int size(){
        return size;
    }

}

class PilaConArregloDinamico<T> {
    private DynamicArray<T> dynamicArray;

    public PilaConArregloDinamico() {
        dynamicArray = new DynamicArray<>(createArray(10));
    }

    public void push(T item) {
        dynamicArray.pushBack(item);
    }

    public T pop() {
        if (dynamicArray.size() == 0) {
            throw new IllegalStateException("La pila está vacía");
        }
        T item = dynamicArray.get(dynamicArray.size() - 1);
        dynamicArray.remove(dynamicArray.size() - 1);
        return item;
    }

    public boolean empty() {
        return dynamicArray.size() == 0;
    }

    @SuppressWarnings("unchecked")
    private T[] createArray(int initialCapacity) {
        return (T[]) new Object[initialCapacity];
    }

    public void imprimir() {
        System.out.println("Elementos en la pila (de arriba hacia abajo):");
        for (int i = dynamicArray.size() - 1; i >= 0; i--) {
            System.out.println(dynamicArray.get(i));
        }
    }
}
