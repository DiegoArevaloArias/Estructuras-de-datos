import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeneradorNumerosAleatorio {
    public static void main(String[] args) {
        final int cantidadNumeros = 100_000_000; // Cantidad de números aleatorios a generar
        final String nombreArchivo = "numeros_aleatorios.txt"; // Nombre del archivo de texto
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            Random random = new Random();
            for (int i = 0; i < cantidadNumeros; i++) {
                int numeroAleatorio = random.nextInt();
                writer.write(Integer.toString(numeroAleatorio));
                writer.newLine();
            }
            System.out.println("Se generaron y guardaron " + cantidadNumeros + " números aleatorios en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
