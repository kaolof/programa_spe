
package preguntas_spe;

public class Respuesta {
    
    private String contenido;
    private int segundos;
    
   public Respuesta(String c, int s){ 
       this.contenido=c;
       this.segundos=s;
   }    

    public String getContenido() {
        return contenido;
    }

    public int getSegundos() {
        return segundos;
    }

    @Override
    public String toString() {
        return contenido +" "+ segundos;
    }
}
