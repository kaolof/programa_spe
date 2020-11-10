
package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import preguntas_spe.TextToSpeech;
import com.sun.glass.events.KeyEvent;
import java.util.ArrayList;
import preguntas_spe.Participante;
import preguntas_spe.Respuesta;
import javax.swing.SwingWorker;


/*VALIDACIONES
*Que el usuario no pueda entrar a ronda sin cargar las preguntas
*Que las preguntas se carguen solo una vez
*Se puede agregar que la funcion speak devuelva un entero para que si
da error sea con el 0 y mandar un mensaje al usuario de "Error al cargar las preguntas"
*Que pasa si la caja de texto esta vacia al registrar la pregunta 
*/

public class Ronda_pregunta extends javax.swing.JFrame {

    private Participante p;
    private ArrayList<String> preguntas;
    private int minutos_partida=10, segundos5=5, segundos15=15, contPreguntas=0, segundos_partida=0;
    private TextToSpeech tts;
    private Timer t5, t15,t_partida;
    private long tInicio, tFin;
    private String tiempoRespuesta;
    private boolean estado, estado_partida=true;
    
  
        
    
    public Ronda_pregunta(ArrayList<String> a, Participante p) {
        initComponents();
       
        bRegistrarPregunta.setEnabled(false);
        taRespuesta.setEnabled(false); 
        bResponder.setEnabled(false);
        
        tts = new TextToSpeech();
        t5 = new Timer(1000,acciones);
        t15 = new Timer(1000, acciones15); 
        t_partida=new Timer(1000,acciones10min);
        
        preguntas = a;
        this.p = p;
  
    }
    
    
    public void Partida() {
        bResponder.requestFocus();
        if (contPreguntas < preguntas.size()&& estado_partida==true) {
            cont_pregunta.setText(""+(contPreguntas+1));
            tInicio = System.currentTimeMillis();
            final SwingWorker worker = new SwingWorker() {
            @Override  //METODO PARA QUE SE EJECUTE EN SEGUNDO PLANO Y NO BLOQUEE LA INTERFAZ
            protected Object doInBackground() throws Exception {            
                tts.speak(preguntas.get(contPreguntas), 1.0f, false, true); 
                while (tts.getTts().isAlive()) {
                    estado = false;
                     
                } 
                //SI AL FINAL ES FALSO SIGNIFICA QUE NO SE PRESIONO RESPONDER
                if (estado == false) {
                    t5.start();
                }// SI AL FINAL ES VERDADERO SIGNIFICA QUE SÍ SE PRESIONÓ RESPONDER
               
                
                return null;
            }
        };
        worker.execute();
     
        } else {
            JOptionPane.showMessageDialog(null, "¡La ronda ha terminado!");
            guardarRespuestaFrame(p);           
        }
    }
    
    //TEMPORIZADOR DE LOS 5 SEGUNDOS 
    @SuppressWarnings("Unchecked")

    public ActionListener acciones=new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent ae) {       
            segundos5--;
            lPrueba5.setText("Tiene " + segundos5 +" segundos para presionar el botón responder");
            if(segundos5==0){
                if (estado == false) {
                    Respuesta respuesta;
                    String s = " "; //VALIDAR SI ESTA VACIO
                    respuesta = new Respuesta(s, s);
                    p.getRespuestasP().getRespuestas().add(respuesta);
                }                
                lPrueba5.setText("Tiene 0 segundos para presionar el botón responder");
                t5.stop();
                contPreguntas++;
                segundos5 = 5;
                Partida();
            }
         }
    };
    
    //TEMPORIZADOR 15 SEGUNDOS
    @SuppressWarnings("Unchecked")

    public ActionListener acciones15 =new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent ae) { 
            segundos15--;
            lPrueba15.setText("Tiene " + segundos15 +" segundos para responder");            
            if (segundos15 == 0) {  
                lPrueba15.setText("Tiene 0 segundos para responder");
                bResponder.setEnabled(false);
                t15.stop();           
                segundos15 = 15;
                contPreguntas++;
                Partida();
            } 
        }
   };  
   
       //TEMPORIZADOR 10 minutos
    @SuppressWarnings("Unchecked")

    public ActionListener acciones10min =new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent ae) { 
            
               if(segundos_partida==0){
                  minutos_partida--;
                  segundos_partida=60;
               }
               
               segundos_partida--;
               ActualizarJLabel();
               if(segundos_partida==0 & minutos_partida==0){
                   estado_partida=false;//para que mary no siga hablando cuando acabe la partida
                   t_partida.stop();
                   tts.stopSpeaking();
                   JOptionPane.showMessageDialog(null, "¡El tiempo ha terminado!");
                   guardarRespuestaFrame(p);
               }
            }

   };
    //actualiza el label del temporizador de toda la partida
    public void ActualizarJLabel(){
        String tiempo= "0"+minutos_partida+":"+(segundos_partida<=9?"0":"")+segundos_partida;
        Tiempo_partida.setText(tiempo);
            
     }     
               
    
   public void guardarRespuestaFrame(Participante p) {        
        Guardar_respuestas a = new Guardar_respuestas(p);
        a.setVisible(true);
        this.dispose();       
   }    

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taRespuesta = new javax.swing.JTextArea();
        Tiempo_partida = new javax.swing.JLabel();
        cont_pregunta = new javax.swing.JLabel();
        bResponder = new javax.swing.JButton();
        bRegistrarPregunta = new javax.swing.JButton();
        bStart = new javax.swing.JButton();
        lPrueba5 = new javax.swing.JLabel();
        lPrueba15 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        taRespuesta.setColumns(20);
        taRespuesta.setRows(5);
        taRespuesta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                taRespuestaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(taRespuesta);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 486, 149));

        Tiempo_partida.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Tiempo_partida.setForeground(new java.awt.Color(255, 255, 255));
        Tiempo_partida.setText("10:00");
        getContentPane().add(Tiempo_partida, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 70, 30));

        cont_pregunta.setFont(new java.awt.Font("Tahoma", 1, 41)); // NOI18N
        cont_pregunta.setForeground(new java.awt.Color(255, 255, 255));
        cont_pregunta.setText("0");
        getContentPane().add(cont_pregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 50, 40));

        bResponder.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bResponder.setText("RESPONDER");
        bResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bResponderActionPerformed(evt);
            }
        });
        bResponder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bResponderKeyPressed(evt);
            }
        });
        getContentPane().add(bResponder, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 150, 40));

        bRegistrarPregunta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bRegistrarPregunta.setText("REGISTRAR PREGUNTA");
        bRegistrarPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegistrarPreguntaActionPerformed(evt);
            }
        });
        bRegistrarPregunta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bRegistrarPreguntaKeyPressed(evt);
            }
        });
        getContentPane().add(bRegistrarPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 270, 40));

        bStart.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bStart.setText("START");
        bStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStartActionPerformed(evt);
            }
        });
        getContentPane().add(bStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

        lPrueba5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lPrueba5.setForeground(new java.awt.Color(255, 255, 255));
        lPrueba5.setText("Tiene   segundos para presionar el botón responder");
        getContentPane().add(lPrueba5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 510, 18));

        lPrueba15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lPrueba15.setForeground(new java.awt.Color(255, 255, 255));
        lPrueba15.setText("Tiene   segundos para responder");
        getContentPane().add(lPrueba15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 500, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ronda_pregunta.PNG"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Funciones para habilitar y desahabilitar la caja de texto y registrar respuesta
    public void deshabilitar() { 
        bRegistrarPregunta.setEnabled(false);
        taRespuesta.setEnabled(false); 
        bResponder.setEnabled(true);
    }
    
    public void habilitar() { 
        bRegistrarPregunta.setEnabled(true);
        taRespuesta.setEnabled(true);
    }

    /*----------------METODOS DE LOS EVENTOS Y AP---------------------**/
    
    //Metodo que se ejecuta cuando se presiona el boton responder o la tecla arriba 
    private void responder() { 
        habilitar();
        taRespuesta.requestFocus();
        bResponder.setEnabled(false);
        tFin = System.currentTimeMillis();
        long resta = tFin - tInicio;
        float calcularTiempo = (float) resta / 1000;
        tiempoRespuesta = String.format("%.3f",calcularTiempo);        
        t5.stop();
        tts.stopSpeaking();
        lPrueba5.setText("Tiene   segundos para presionar el botón responder");
        segundos5 = 5;
        t15.start();
        estado = true;     //PRESIONO RESPONDER POR LO TANTO NO SE ACTIVA EL CONTADOR DE LOS 5s  
    }
    
    //Metodo que se ejecuta cuando se presiona el botÃ³n registrar respuesta o la tecla abajo
    private void registrar() {
        Respuesta respuesta;
        String s = taRespuesta.getText(); //VALIDAR SI ESTA VACÃ�O
        respuesta = new Respuesta(s, tiempoRespuesta);
        p.getRespuestasP().getRespuestas().add(respuesta);//Revisar
        taRespuesta.setText(" ");
        deshabilitar();
        t15.stop();
        lPrueba15.setText("Tiene   segundos para responder");
        segundos15 = 15;
        contPreguntas++;
        Partida();
        estado = false; //VUELVE A SU ESTADO ORIGINAL PARA EVALUAR LA SIGUIENTE PREGUNTA
    }
    
   /*----------------EVENTOS Y ACTION PERFORMED---------------------**/
    private void bRegistrarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistrarPreguntaActionPerformed
        registrar();
    }//GEN-LAST:event_bRegistrarPreguntaActionPerformed

    private void bStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStartActionPerformed
       Partida();      
       bStart.setEnabled(false);
       t_partida.start();
       bResponder.setEnabled(true);

    }//GEN-LAST:event_bStartActionPerformed

    private void bRegistrarPreguntaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bRegistrarPreguntaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) { //CON VK_... CAMBIAS LA TECLA QUE HACE EL LLAMADO
            registrar();
        }
    }//GEN-LAST:event_bRegistrarPreguntaKeyPressed

    private void bResponderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bResponderKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) { //CON VK_... CAMBIAS LA TECLA QUE HACE EL LLAMADO
            responder();
        }
    }//GEN-LAST:event_bResponderKeyPressed

    private void bResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResponderActionPerformed
        responder();
    }//GEN-LAST:event_bResponderActionPerformed

    private void taRespuestaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taRespuestaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) { //CON VK_... CAMBIAS LA TECLA QUE HACE EL LLAMADO
            registrar();
        }
    }//GEN-LAST:event_taRespuestaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Tiempo_partida;
    private javax.swing.JButton bRegistrarPregunta;
    private javax.swing.JButton bResponder;
    private javax.swing.JButton bStart;
    private javax.swing.JLabel cont_pregunta;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lPrueba15;
    private javax.swing.JLabel lPrueba5;
    private javax.swing.JTextArea taRespuesta;
    // End of variables declaration//GEN-END:variables
}
