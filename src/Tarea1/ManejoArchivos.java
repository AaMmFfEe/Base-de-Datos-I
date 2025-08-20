package Tarea1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class ManejoArchivos {
    public static void main(String[] args) throws FileNotFoundException {

        try {

            File archivo = new File("codigos_postales_hmo.csv");
            Scanner k = new Scanner(archivo);
            String texto = k.nextLine();

           while ((texto = k.nextLine()) != null) {

                System.out.println(texto.substring(0,5));

           }

           //CÓDIGO VIEJO // do {
               // System.out.println(texto.substring(0,5));
           // }

           // while (k.hasNextLine()); {

            //    System.out.println(texto);
           //
        System.out.println ("El código postal ");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        } catch (IOException e){
            throw new RuntimeException(e);


        }
    }
}
