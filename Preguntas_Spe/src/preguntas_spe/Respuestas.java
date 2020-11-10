
package preguntas_spe;

import java.util.ArrayList;

public class Respuestas {   
    
    private ArrayList<Respuesta> respuestas;    

    public Respuestas(){
        respuestas = new ArrayList<>(); 
    }

    /*public void agregarRespuesta(Respuesta r) {
        respuestas.add(r);       
    }*/


    private void listarRespuestas() {       
        int n = respuestas.size();
        for (int i = 0; i < n; i++) {
            respuestas.get(i);
        }        
    }

    public ArrayList<Respuesta> getRespuestas() {
        return respuestas;
    }
   
}
