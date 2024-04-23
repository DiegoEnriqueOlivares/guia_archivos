import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* Agregar header */

public class Ejercicio004 {
    public static void main(String[] args) {
        String ruta = "archivos/user_data2.txt";
        String encabezado = "id,first_name,last_name,email,gender,ip_address\n\n";

        try {
            BufferedReader lector = new BufferedReader(new FileReader(ruta));
            StringBuilder contenidoOriginal = new StringBuilder();
            String linea;
            while ((linea = lector.readLine()) != null) {
                contenidoOriginal.append(linea).append("\n");
            }
            lector.close();

            BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta));
            escritor.write(encabezado + contenidoOriginal.toString());
            escritor.close();

            System.out.println("\nEncabezado agregado exitosamente al archivo.\n");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
