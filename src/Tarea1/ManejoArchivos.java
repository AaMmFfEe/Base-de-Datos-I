package Tarea1;

import java.io.*;

public class ManejoArchivos {
    public static void main(String[] args) {

        // primero declaramos una variable String en donde se encuentra nuestro archivo a leer, el cual se encuentra dentro de nuestro proyecto
        String archivo = "codigos_postales_hmo.csv";

        // ahora declaramos 2 variables de tipo int las cuales actuan de esta manera:
            // int n sirve para guardar cada código postal que no haya aparecido nuevamente
            // int contador servirá para guardar cuantas veces se repitió un código postal
        int n = 83000, contador = 0;

        // el BufferedReader "leer" será nuestro lector de archivos
        // abrimos un try-catch por si ocurre algún error
        try (BufferedReader leer = new BufferedReader(new FileReader(archivo))) {

            // declaramos una variable String que utilizaremos para guardar las líneas del archivo una por una al ser leídas
            // mientras hayan líneas para leer, se llevará a cabo el siguiente paso
            String linea;
            do {
                linea = leer.readLine();
                if (linea != null) {

                    // para poder imprimir solo el texto con los códigos postales, crearemos un substring de solo los
                    // 5 primeros dígitos, oséa el código postal que se encuentra al principio de cada línea
                    int codigoPostal = Integer.valueOf(linea.substring(0, 5));

                    // creamos un loop con 2 casos:
                    // si el código postal aparece por primera vez, se agrega a n y su contador cambia de 0 a 1
                    // si el código postal ya ha aparecido una vez, su contador incrementa 1 por cada vez que siga apareciendo
                    if (codigoPostal == n) {
                        contador = contador + 1;
                    } else {
                        System.out.println(" El Código postal " + n + " tiene " + contador + " asentamientos.");
                        n = codigoPostal;
                        contador = 1;
                    }
                }

                // esto ocurre mientras todavía hayan líneas para leer
            } while (linea != null);

            // creamos un loop en el que cada vez que exista un código postal nuevo, lo imprimirá, y cuantas veces se repite
            if (n != 83000) {
                System.out.println(" El Código postal " + n + " tiene " + contador + " asentamientos.");
            }

            // agregamos un catch por si ocurre un error encontrando el archivo y se imprime el mensaje de error
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());

            // agregamos un catch para cualquier error de input/output y se imprime el mensaje de error
        } catch (IOException g) {
            System.out.println("Error: " + g.getMessage());
        }
    }
}




