import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio007 {
    /* Leer el archivo, filtrar los registros por género y escribirlos en un nuevo archivo.
     file_male.txt & file_female.txt */
    public static void main(String[] args) {
        String ruta = "archivos/user_data.txt";
        String rutaMale = "archivos/file_male.txt";
        String rutaFemale = "archivos/file_female.txt";

        try {
            BufferedReader lector = new BufferedReader(new FileReader(ruta));
            BufferedWriter escritorMale = new BufferedWriter(new FileWriter(rutaMale));
            BufferedWriter escritorFemale = new BufferedWriter(new FileWriter(rutaFemale));

            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 3) {

                    String genero = partes[4].trim().toLowerCase(); 
                    if (genero.equals("male")) {
                        escritorMale.write(linea);
                        escritorMale.newLine(); 
                    } else if (genero.equals("female")) {
                        escritorFemale.write(linea);
                        escritorFemale.newLine(); 
                    }
                }
            }

            lector.close();
            escritorMale.close();
            escritorFemale.close();

            System.out.println("\nRegistros filtrados por género y escritos en archivos separados exitosamente.\n");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
