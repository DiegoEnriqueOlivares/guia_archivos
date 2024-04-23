
/* Buscar un registro pro id  Mostrar el registro encontrado o un mensaje
 indicando que el registro no fue encontrado. */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio005 {
    public static void main(String[] args) {
        String ruta = "archivos/user_data.txt";
        int idBuscado = 1; 

            try {
            File archivo = new File(ruta);
            FileReader lector = new FileReader(archivo);
            BufferedReader bufferedReader = new BufferedReader(lector);

            String linea;
            boolean encontrado = false;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] campos = linea.split(",");

                int id = Integer.parseInt(campos[0]);
                if (id == idBuscado) {
                    System.out.println("Registro encontrado:");
                    System.out.println("ID: " + campos[0]);
                    System.out.println("Nombre: " + campos[1]);
                    System.out.println("Apellido: " + campos[2]);
                    System.out.println("Email: " + campos[3]);
                    System.out.println("Gender: " + campos[4]);
                    System.out.println("IP: " + campos[5]);
                    encontrado = true;
                    break; 
                }
            }
            bufferedReader.close();

            if (!encontrado) {
                System.out.println("Registro con ID " + idBuscado + " no encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
