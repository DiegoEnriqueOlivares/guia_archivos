/*Liste las 10 palabras más repetidas en la biblia */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio002 {
    public static void main(String[] args) {
        String ruta = "archivos/BIBLIA_COMPLETA.txt";
        Map<String, Integer> mapaPal = new HashMap<>();
        
        try {

            File archivo = new File(ruta);
            FileReader lector = new FileReader(archivo);
            BufferedReader reader = new BufferedReader(lector);

            
            String linea;
            while ((linea = reader.readLine()) != null) {
                linea = linea.replaceAll("[\\#$@~!¡&*()\\[\\];.,:?^`\\n\\d\\\\/]+", "");
                String[] palabras = linea.split("\\s+");
            
                for (String pal : palabras) {
                    pal = pal.toLowerCase(); 
                    mapaPal.put(pal, mapaPal.getOrDefault(pal, 0) + 1);
                }
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Map.Entry<String, Integer>> listaPal = new ArrayList<>(mapaPal.entrySet());
        listaPal.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        System.out.println("Las 10 palabras más repetidas son:");
        for (int i = 0; i < 10 && i < listaPal.size(); i++) {
            Map.Entry<String, Integer> entrada = listaPal.get(i);
            System.out.println(entrada.getKey() + ": " + entrada.getValue() + " veces");
        }
    }
}
