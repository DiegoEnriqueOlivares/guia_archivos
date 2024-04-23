/*Busque cuantas veces se encuentra la palabra “Dios” en la biblia. */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio001 {
    public static void main(String[] args) throws IOException {
        String ruta = "archivos/BIBLIA_COMPLETA.txt";
        String palabra = "Dios";
        int contador = 0;

        try {
            File archivo = new File(ruta);
            FileReader lector = new FileReader(archivo);
            BufferedReader reader = new BufferedReader(lector);

            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] palabras = linea.split("\\s+"); 

                for (String pal : palabras) {
                    if (pal.toLowerCase().equals(palabra.toLowerCase())) {
                        contador++;
                    }
                }
            }

            reader.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("\nLa palabra "+palabra+" se encontró "+contador+" veces.\n");

    }
}
