
package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import preguntas_spe.TextToSpeech;
import archivos.ManejoArchivos;
import javax.swing.JLabel;

public class Ronda_pregunta extends javax.swing.JFrame {

    private String[] preguntas={
        "A geologic time period from 290 to 320 million years ago",
        "This is an instrument used to measure viscosity and gel strength of drilling mud. The direct-indicating viscometer is a rotational cylinder and bob instrument.",
        "The irregular movement of a logging tool up a well due to it being stuck at some point and then being released is called how?",
        "What is the density of water in pounds per galon?",
        "This is the name of a tubular placed at the bottom of the subsurface sucker-rod pump and inside the gas anchor to drive the formation fluid with little or no gas into the pump",
        "The treatment of a reservoir formation with a stimulation fluid containing a reactive acid.",
        "This is a type of water-base mud that is saturated with Ca(OH)2 and has excess, undissolved lime solids maintained in reserve",
        "Skin effect with a magnitude that depends on the flow rate of the wellbore fluid.",
        "the percentage of void space within rock that can contain fluids is known as what?",
        "the pumping of acid into the wellbore to remove near-well formation damage and other substances"};
   
    private int minuto=10, segundos=5, segundos15=15, contPreguntas=0;
    TextToSpeech tts ;
    private Timer t5, t15;
    private ManejoArchivos registro;
    long TInicio, TFin;
    float tiempo;
        
    
    public Ronda_pregunta() {
        initComponents();
        bRegistrarPregunta.setEnabled(false);
        taRespuesta.setEnabled(false);
        bResponder.setEnabled(false);
        registro = new ManejoArchivos();
        t5 =new Timer(1000,acciones);
        t15 = new Timer(1000, acciones15);
        
    }
    
    
    public void Partida(){
        tts = new TextToSpeech();
        if (contPreguntas < preguntas.length) {
            if(tts.speak(preguntas[contPreguntas], 1.0f, false, true) == 1) {
                bResponder.setEnabled(true); //Aquí se puede actualizar los segundos
                t5.start();
                TInicio = System.currentTimeMillis();
            } else { 
            JOptionPane.showMessageDialog(null, "¡Hubo un error al cargar las preguntas!");
        }

        } else {
            JOptionPane.showMessageDialog(null, "¡La ronda ha terminado!");
        }
   
    }
   
    
    //TEMPORIZADOR DE LOS 5 SEGUNDOS 
    @SuppressWarnings("Unchecked")

    public ActionListener acciones=new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent ae) {       
            segundos--;
            ActualizarJLabel(segundos, lPrueba5);
            if(segundos==0){
                t5.stop();
                contPreguntas++;
                segundos = 5;
                Partida();
            }
         }
    };
    
    //TEMPORIZADOR 15 SEGUNDOS
    @SuppressWarnings("Unchecked")

    public ActionListener acciones15 =new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent ae) {  //lRespuesta.setText("Tiene " + segundos15 +" segundos para responder");
            segundos15--;
            lPrueba15.setText("Tiene " + segundos15 +" segundos para responder");            
            if (segundos15 == 0) {  
                lPrueba15.setText("Tiene: 0 segundos para responder");
                bResponder.setEnabled(false);
                t15.stop();           
                segundos15 = 15;
                contPreguntas++;
                Partida();
            } 
        }
   };   
               
        
    
    //Ponerle un formato para que sirva para todas
    public void ActualizarJLabel(int s, JLabel jl){
        String mensaje="Tiene " +s+ " segundos para presionar el botón responder";
        jl.setText(mensaje);
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taRespuesta = new javax.swing.JTextArea();
        bResponder = new javax.swing.JButton();
        bRegistrarPregunta = new javax.swing.JButton();
        bStart = new javax.swing.JButton();
        lPrueba5 = new javax.swing.JLabel();
        lPrueba15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        taRespuesta.setColumns(20);
        taRespuesta.setRows(5);
        jScrollPane1.setViewportView(taRespuesta);

        bResponder.setText("RESPONDER");
        bResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bResponderActionPerformed(evt);
            }
        });

        bRegistrarPregunta.setText("REGISTRAR PREGUNTA");
        bRegistrarPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegistrarPreguntaActionPerformed(evt);
            }
        });

        bStart.setText("START");
        bStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStartActionPerformed(evt);
            }
        });

        lPrueba5.setText("Tiene 5 segundos para presionar el botón responder");

        lPrueba15.setText("Tiene 15 segundos para responder");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(bRegistrarPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bStart)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lPrueba15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lPrueba5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(bStart)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lPrueba5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPrueba15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(bRegistrarPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Funciones para habilitar y desahabilitar la caja de texto y registrar respuesta
    public void deshabilitar() { 
        bRegistrarPregunta.setEnabled(false);
        taRespuesta.setEnabled(false);       
    }
    
    public void habilitar() { 
        bRegistrarPregunta.setEnabled(true);
        taRespuesta.setEnabled(true);       
    }

    
    private void bResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResponderActionPerformed
        habilitar();
        bResponder.setEnabled(false);
        //Se reinicia el de 5s y comienza el de 15 hasta que se registre la pregunta 
        t5.stop();
        segundos = 5;
        ActualizarJLabel(0, lPrueba5);
        t15.start();        
    }//GEN-LAST:event_bResponderActionPerformed

    private void bRegistrarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistrarPreguntaActionPerformed
       String respuesta = "";
       respuesta = taRespuesta.getText(); //VALIDAR SI ESTA VACIO 
       registro.escribir(respuesta);
       //taRespuesta.setText(""); Para limpiar la caja despues de guardar la respuesta
       deshabilitar();
       t15.stop();
       segundos15 = 15;
       //ActualizarJLabel(0, lPrueba15);
       contPreguntas++;
       Partida();
       
 
    }//GEN-LAST:event_bRegistrarPreguntaActionPerformed

    private void bStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStartActionPerformed
       Partida();      
       bStart.setEnabled(false);
    }//GEN-LAST:event_bStartActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRegistrarPregunta;
    private javax.swing.JButton bResponder;
    private javax.swing.JButton bStart;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lPrueba15;
    private javax.swing.JLabel lPrueba5;
    private javax.swing.JTextArea taRespuesta;
    // End of variables declaration//GEN-END:variables
}
