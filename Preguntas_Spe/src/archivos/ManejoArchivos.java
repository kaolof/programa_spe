
package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import preguntas_spe.Respuestas;


public class ManejoArchivos {

    public static String archivos[];
    private static File archivo;
    private FileWriter escribir;
    private PrintWriter linea;
    private static Respuestas r;  
    
    public void escribir(String a) {
        archivo = new File("respuestas.txt");
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();                              
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                linea.print(a);
                linea.close();
                escribir.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {                               
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                linea.print(a);
                linea.close();
                escribir.close();
            } catch (IOException e) {
                e.toString();
            }

        }
    }
    
     public static String[] muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        int i=0;
      
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            for(i=0; i < Respuestas.cont; i++ ){
            archivos[i]= cadena;      
            System.out.println(cadena);
        }
            return archivos;
        }
        b.close();
        return null;
    }    
}

