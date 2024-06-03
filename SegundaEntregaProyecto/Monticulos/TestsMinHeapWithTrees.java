package SegundaEntregaProyecto.Monticulos;

import java.util.Random;

public class TestsMinHeapWithTrees {

    public static void main(String[] args) throws Exception{
        
        MinHeapWithTrees heap = new MinHeapWithTrees();
        heap.insert(0);
        heap.insert(2);
        heap.insert(0);
        heap.insert(1);
        heap.insert(-1);
        heap.extractMax();
        heap.printHeapByLevel();
        
        //pruebaConPromedios();

    }

    public static void pruebaConPromedios() throws Exception{

        int[] tamañosDatos = { 10000, 100000, 1000000, 10000000, 100000000 }; 

        Random rn = new Random();

        for (int n : tamañosDatos) {
            MaxHeapWithTrees heap = new MaxHeapWithTrees();
            long tiempoTotalInsert = 0, tiempoTotalRemove = 0, tiempoTotalExtractMax = 0, tiempoTotalGetMax = 0, inicio = 0, fin = 0;

            for (int i = 0; i < n; i++) {
                inicio = System.nanoTime(); 
                MaxHeapWithTrees.Node node = heap.insert(rn.nextInt(n)); 
                fin = System.nanoTime(); 
                tiempoTotalInsert += (fin - inicio);
                inicio = System.nanoTime();
                heap.remove(node);
                fin = System.nanoTime();
                tiempoTotalRemove += (fin - inicio);
                heap.insert(rn.nextInt(n));
                inicio = System.nanoTime();
                heap.extractMax();
                fin = System.nanoTime();
                tiempoTotalExtractMax += (fin - inicio);
                heap.insert(rn.nextInt(n));
                inicio = System.nanoTime();
                heap.getMax();
                fin = System.nanoTime();
                tiempoTotalGetMax += (fin - inicio);
                
            }

            System.out.println("Tiempo promedio de insert para " + n + " datos: "
                    + (tiempoTotalInsert / (double) n) + " nanosegundos");
            System.out.println("Tiempo promedio de remove para " + n + " datos: "
                    + (tiempoTotalRemove / (double) n) + " nanosegundos");
            System.out.println("Tiempo promedio de ExtractMax para " + n + " datos: "
                    + (tiempoTotalExtractMax / (double) n) + " nanosegundos");
            System.out.println("Tiempo promedio de GetMax para " + n + " datos: "
                    + (tiempoTotalGetMax / (double) n) + " nanosegundos");
            System.out.println();
        }

    }

    public static void pruebaUnitaria() throws Exception{

        int[] tamañosDatos = { 10000, 100000, 1000000, 10000000, 100000000 }; 

        Random rn = new Random();

        for (int n : tamañosDatos) {
            MaxHeapWithTrees heap = new MaxHeapWithTrees();
            long inicio = 0, fin = 0;

            for (int i = 0; i < n; i++) {
                heap.insert(rn.nextInt(n));
            }

            inicio = System.nanoTime();
            MaxHeapWithTrees.Node node = heap.insert(rn.nextInt(n));
            fin = System.nanoTime();

            System.out.println("Tiempo de insert para " + n + " datos: "
                    + (fin - inicio) + " nanosegundos");
            
            inicio = System.nanoTime();
            heap.remove(node);
            fin = System.nanoTime();

            System.out.println("Tiempo de remove para " + n + " datos: "
                    + (fin - inicio) + " nanosegundos");

            heap.insert(rn.nextInt(n));
            inicio = System.nanoTime();
            heap.extractMax();
            fin = System.nanoTime();

            System.out.println("Tiempo de ExtractMax para " + n + " datos: "
                    + (fin - inicio) + " nanosegundos");

            inicio = System.nanoTime();
            heap.getMax();
            fin = System.nanoTime();
            
            System.out.println("Tiempo de GetMax para " + n + " datos: "
                    + (fin - inicio) + " nanosegundos");
            System.out.println();
        }

    }
    
}

