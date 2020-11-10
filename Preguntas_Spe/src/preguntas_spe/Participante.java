// nombre apellido, respuestas[], set and get nombre, set and get apellido, get, respuestas
package preguntas_spe;



public class Participante {
    
    private String nombre, apellido;
    private Respuestas respuestas_participante;
    
    
    public Participante(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        respuestas_participante = new Respuestas();
 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getDatos() {
        return nombre +" "+ apellido;
    }

    //Revisar si necesito tenerlo dos veces
    public Respuestas getRespuestasP () {
        return respuestas_participante;
    }
      
    
}
