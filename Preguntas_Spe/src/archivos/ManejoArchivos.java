
package archivos;
import static archivos.Cifrado.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class ManejoArchivos {


    private static File archivo;
    private FileWriter escribir;
    private PrintWriter linea;
    private static int key;
    
    //Para escribir en el archivo
    public void escribirArchivo(String a) {
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
    
    
    //Para leer el archivo de preguntas y devolver []
    public static String[] leerArchivo(String nombreArchivo) throws FileNotFoundException, IOException {
       int i = 0;      
       
       String preguntas[];
       preguntas = new String[50]; //Preguntar cantidad de preguntas 
       
       String cadena, cadenaDescifrada;
       
       FileReader f = new FileReader(nombreArchivo); //Se abre el archivo 
       BufferedReader b = new BufferedReader(f); // Se hace un buffer para leer linea por linea
            
           
       //key = Cifrado.descifrar_key(b.readLine());
    

       try {        
            
           key = Cifrado.descifrar_key(b.readLine()); //Se lee la primera linea con b.readLine() para obtener el key

            while((cadena = b.readLine())!= null) {  //Se comienza a leer hasta que no haya mas lineas 
                 cadenaDescifrada = descifrar(cadena,key); 
                 preguntas[i] = cadena; //Se descifra y se manda al arreglo de preguntas     
                 //System.out.println("Pregunta: "+i+""+cadenaDescifrada);
                 i++;       
            } 
           } catch (IOException | NumberFormatException e){
                e.printStackTrace();
            }

        f.close(); //Se cierra el archivo
        return preguntas;         
   } 
    
    //Para cifrar el arreglo de respuestas y generar el archivo
    public void archivoCifrado(ArrayList<String> r) {  
        int respuestasSize = r.size(), i = 0;
        String cadena, cadenaCifrada;
        
        while (i < respuestasSize) {
            cadena = r.get(i);
            cadenaCifrada = Cifrado.cifrar(cadena, key);
            escribirArchivo(cadenaCifrada); 
            i++;
        }    
       
    }
     
}

