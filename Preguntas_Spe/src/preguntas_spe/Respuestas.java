
package preguntas_spe;

import java.util.ArrayList;

public class Respuestas {
   //private Respuesta respuesta[];
   private ArrayList<String> respuestas;    
   public static int cont;
       
   Respuestas(){
       respuestas = new ArrayList<String>(); 
       cont=0; 
       //respuesta = new Respuesta[n];   
   }

    
   /*
   void agregarRespuesta(Respuesta r){
       	if (cont < respuesta.length){
	    	respuesta[cont] = r;
		    cont++;
        }       
   }

    public Respuesta[] getRespuesta() {
        return respuesta;
    }*/
   
   void agregarRespuestas(String r) {
       respuestas.add(r);       
   }
   
   
   void listarRespuestas() {       
       int n = respuestas.size();
       for (int i = 0; i < n; i++) {
           respuestas.get(i);
       }        
   }

    public ArrayList<String> getRespuestas() {
        return respuestas;
    }

   

  
   
}
