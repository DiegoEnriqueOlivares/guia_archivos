import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* Liste las 10 palabras más repetidas, pero ignore las palabras provistas como parámetro (el parámetro sera un path a un archivo de texto,
 cada palabra ignorada se escribe en una nueva línea. */

public class Ejercicio003 {

    public static void main(String[] args) {
        String rutaArchivo = "archivos/BIBLIA_COMPLETA.txt";
        
        String rutaArchivoIg = "archivos/Palabras_Ignoradas.txt";
        
        try {
            Set<String> palabrasIg = new HashSet<>();
            File archivoIg = new File(rutaArchivoIg);
            BufferedReader reader = new BufferedReader(new FileReader(archivoIg));
            String palabraIgnorada;
            while ((palabraIgnorada = reader.readLine()) != null) {
                palabrasIg.add(palabraIgnorada.toLowerCase());
            }
            reader.close();

            Map<String, Integer> contadorPalabras = new HashMap<>();
            File archivoTexto = new File(rutaArchivo);
            reader = new BufferedReader(new FileReader(archivoTexto));
            String linea;
            while ((linea = reader.readLine()) != null) {
                linea = linea.replaceAll("[\\#$@~!¡&*()\\[\\];.,:?^`\\n\\d\\\\/]+", "");
                String[] palabras = linea.split("\\s+");
                for (String palabra : palabras) {
                    String palabraLowerCase = palabra.toLowerCase();
                    if (!palabrasIg.contains(palabraLowerCase)) {
                        contadorPalabras.put(palabraLowerCase, contadorPalabras.getOrDefault(palabraLowerCase, 0) + 1);
                    }
                }
            }
            reader.close();
            
            List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(contadorPalabras.entrySet());
            listaOrdenada.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            int limite = Math.min(listaOrdenada.size(), 10);
            for (int i = 0; i < limite; i++) {
                Map.Entry<String, Integer> entry = listaOrdenada.get(i);
                System.out.println("Palabra: " + entry.getKey() + ", Frecuencia: " + entry.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

}
