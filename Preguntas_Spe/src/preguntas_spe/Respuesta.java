
package preguntas_spe;

public class Respuesta {
    
   private String contenido, segundos;
    
   public Respuesta(String c, String s){ 
       this.contenido=c;
       this.segundos=s;
   } 
    
   public Respuesta () {
       this.contenido = " ";
   }

    public String getContenido() {
        return contenido;
    }

    public String getSegundos() {
        return segundos;
    }

    @Override
    public String toString() {
        return contenido+" : "+ segundos;
    }
}
