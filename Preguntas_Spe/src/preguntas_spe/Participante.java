// nombre apellido, respuestas[], set and get nombre, set and get apellido, get, respuestas
package preguntas_spe;

public class Participante {
    
    private String nombre, apellido;
    private Respuestas respuestas_participante;

    Participante(){}

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

    public Respuestas getRespuestas_participante() {
        return respuestas_participante;
    }
      
    
}
