import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio009 {
    /* Contar y mostrar la cantidad de registros cuya dirección IP pertenece a un rango específico
     (por ejemplo, contar cuántos registros tienen una dirección IP que comienza con "170."). */

    public static void main(String[] args) {
        String ruta = "archivos/user_data.txt";
        String prefijo = "170.";

        try {
            BufferedReader lector = new BufferedReader(new FileReader(ruta));

            int contador = 0;

            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 2) {
                    String direccionIP = partes[5].trim();
                    if (direccionIP.startsWith(prefijo)) {
                        contador++;
                    }
                }
            }
            lector.close();

            System.out.println("\nCantidad de registros en el rango " + prefijo + " son: " + contador+"\n");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
