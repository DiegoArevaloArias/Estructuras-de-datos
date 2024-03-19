import java.util.Random;

public class PilaDinamico {
    public static void main(String[] args) {
        int[] tamañosDatos = { 10000, 100000, 1000000, 10000000}; 
        for (int n : tamañosDatos) {
            PilaConArregloDinamico<Integer> pila = new PilaConArregloDinamico<>();
            long tiempoTotal = 0;

            Random random = new Random();
            Integer[] datosAleatorios = new Integer[n];
            for (int i = 0; i < n; i++) {
                datosAleatorios[i] = random.nextInt();
            }
            System.out.println('a');

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
