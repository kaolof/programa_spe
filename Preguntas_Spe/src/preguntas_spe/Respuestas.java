
package preguntas_spe;

public class Respuestas {
   private Respuesta respuesta[];
   public static int cont;
       
   Respuestas(){
       respuesta = new Respuesta[2];
       cont=0;      
   }
       
   
   void agregarRespuesta(Respuesta r){
       	if (cont < respuesta.length){
	    	respuesta[cont] = r;
		    cont++;
        }       
   }    

    void listarRespuesas () {
        
    } 
   
}
