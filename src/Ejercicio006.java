
/* Reemplazar el ID numérico por la primera letra del nombre, la primera letra del apellido 
y tres dígitos basados en la longitud del apellido */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio006 {
    public static void main(String[] args) {
        String ruta = "archivos/user_data3.txt";

        try {
            File archivo = new File(ruta);
            FileReader lector = new FileReader(archivo);
            BufferedReader reader = new BufferedReader(lector);

            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] campos = linea.split(",");

                campos[0] = generarID(campos[1], campos[2]);
                contenido.append(String.join(",", campos)).append("\n");
            }

            reader.close();
            FileWriter escritor = new FileWriter(archivo);
            escritor.write(contenido.toString());
            escritor.close();

            System.out.println("\nID reemplazado correctamente en el archivo.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generarID(String nombre, String apellido) {
        StringBuilder id = new StringBuilder();
        id.append(nombre.charAt(0));
        id.append(apellido.charAt(0)); 
        id.append(String.format("%03d", apellido.length())); 
        return id.toString();
    }
}
