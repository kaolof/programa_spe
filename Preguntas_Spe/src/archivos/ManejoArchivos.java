
package archivos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import preguntas_spe.Participante;


public class ManejoArchivos {

    private static File archivo;
    private FileWriter escribir;
    private PrintWriter linea;
    private static int key;
    private static String clave;
    
    
    //Para escribir en el archivo    
    public void escribirArchivo(String a, File archivo) {
        
        
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();                              
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);             
                linea.println(a);
                linea.close();
                escribir.close();                
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {                               
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);                
                linea.println(a);                
                linea.close();
                escribir.close();
            } catch (IOException e) {
                e.toString();
            }

        }
    }
    
    
    //Para leer el archivo de preguntas y devolver [] static
    public static ArrayList leerArchivo(String nombreArchivo) throws FileNotFoundException, IOException {        
       ArrayList<String> preguntas = new ArrayList();       
       String cadena, cadenaDescifrada;
       FileReader f = new FileReader(nombreArchivo); //Se abre el archivo 
       BufferedReader b = new BufferedReader(f); // Se hace un buffer para leer linea por linea
       
       try {
            clave = b.readLine();
            key = Cifrado.descifrar_key(clave); //Se lee la primera linea con b.readLine() para obtener el key
            
            while((cadena = b.readLine())!= null) {
                 cadenaDescifrada = Cifrado.descifrar(cadena,key); 
                 preguntas.add(cadenaDescifrada);                      
            } 
           } catch (IOException | NumberFormatException e){
                e.printStackTrace();
            } 

        f.close();
        return preguntas;         
   } 
    
    //Para cifrar el arreglo de respuestas y generar el archivo mandarle el participante     
    public void archivoCifrado(Participante p, File nombreArchivo) { 
        
        int respuestasSize = p.getRespuestasP().getRespuestas().size(), i = 0;      
        
        //SE ESCRIBE EL KEY        
        escribirArchivo(clave, nombreArchivo);        
        
        //SE ESCRIBE EL PARTICIPANTE 
        String datos = Cifrado.cifrar (p.getDatos(), key);
        escribirArchivo(datos, nombreArchivo);      
               
        //SE REGISTRAN LAS PREGUNTAS
        String cadena, cadenaCifrada;      
        
        while (i < respuestasSize) {
            cadena = p.getRespuestasP().getRespuestas().get(i).toString();            
            cadenaCifrada = Cifrado.cifrar(cadena,key);           
            escribirArchivo(cadenaCifrada, nombreArchivo); 
            i++;
        }    
       
    }
        
}

