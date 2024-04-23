import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Ejercicio008 {
    /* Buscar registros duplicados basados en la dirección IP. Si se encuentra un registro duplicado, eliminar todos
     los registros duplicados y dejar solo el primer registro encontrado. */

    public static void main(String[] args) {
        String ruta = "archivos/user_data.txt";
        String modoficado = "archivos/user_ip_sinm.txt";

        try {
            BufferedReader leer = new BufferedReader(new FileReader(ruta));
            BufferedWriter escribir = new BufferedWriter(new FileWriter(modoficado));

            Set<String> direccionesIPVistas = new HashSet<>();

            String linea;
            while ((linea = leer.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 2) {
                    String direccionIP = partes[5].trim();
                    if (!direccionesIPVistas.contains(direccionIP)) {
                        escribir.write(linea);
                        escribir.newLine();
                        direccionesIPVistas.add(direccionIP);
                    }
                }
            }

            leer.close();
            escribir.close();

            System.out.println("\nRegistros duplicados eliminados exitosamente.\n");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
