
package preguntas_spe;

public class Respuesta {
    
    private String contenido;
    private float segundos;
    
   public Respuesta(String c, float s){ 
       this.contenido=c;
       this.segundos=s;
   }    

    public String getContenido() {
        return contenido;
    }

    public float getSegundos() {
        return segundos;
    }

    @Override
    public String toString() {
        return contenido+": "+ segundos;
    }
}
