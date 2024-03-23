package LinkedList;
import java.util.Random;

public class TestsLinkedList {

    public static void main(String[] args) {

        int[] tamañosDatos = { 10000, 100000, 1000000, 10000000, 100000000 };
        Random random = new Random();
        for (int n : tamañosDatos) {
            QueueLinkedList list = new QueueLinkedList();
            long tiempoTotal = 0;

            for (int i = 0; i < n; i++) {
                long inicio = System.nanoTime(); 
                list.enqueue(random.nextInt(10000));
                
                if(n == 100000000 && i > 88000000)
                    System.out.println(i);

                tiempoTotal += (System.nanoTime() - inicio); 
            }
            System.out.println("Tiempo promedio de inserción para " + n + " datos: "
                    + (tiempoTotal)/(double) n + " nanosegundos");

        }
    }
    
}
