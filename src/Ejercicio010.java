import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio010 {
    /* Agregar una nueva columna al registro original
    con la información encontrada en el siguiente archivo. */
    public static void main(String[] args) {
        String ruta = "archivos/user_data.txt";
        String infoExtra = "archivos/user_names.txt";
        String nuevo = "archivos/new_user_data.txt";

        try {
            
            BufferedReader lectorInformacionExtra = new BufferedReader(new FileReader(infoExtra));
            String informacionExtra = lectorInformacionExtra.readLine();
            lectorInformacionExtra.close();

            BufferedReader lectorOriginal = new BufferedReader(new FileReader(ruta));
            BufferedWriter escritorModificado = new BufferedWriter(new FileWriter(nuevo));

            String linea;
            while ((linea = lectorOriginal.readLine()) != null) {
                String[] partes = linea.split(",");
                String[] nuevasPartes = new String[partes.length + 1];
                
                System.arraycopy(partes, 0, nuevasPartes, 0, 3);

                nuevasPartes[3] = informacionExtra;

                System.arraycopy(partes, 3, nuevasPartes, 4, partes.length - 3);
                nuevasPartes[nuevasPartes.length - 1] = partes[partes.length - 1];

                StringBuilder nuevaLinea = new StringBuilder();
                for (String parte : nuevasPartes) {
                    nuevaLinea.append(parte).append(",");
                }
                escritorModificado.write(nuevaLinea.substring(0, nuevaLinea.length() - 1));
                escritorModificado.newLine();
            }

            lectorOriginal.close();
            escritorModificado.close();

            System.out.println("\nLa información extra ha sido agregada exitosamente al archivo.\n");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
