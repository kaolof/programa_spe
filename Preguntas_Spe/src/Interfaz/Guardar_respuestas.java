package Interfaz;

import archivos.ManejoArchivos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import preguntas_spe.Participante;

/**
 *
 * @author ME
 */
public class Guardar_respuestas extends javax.swing.JFrame {

    /**
     * Creates new form Guardar_respuestas
     */
    
    private Participante p;
    private ManejoArchivos respuestas;
    
    public Guardar_respuestas(Participante p) {
        initComponents();
        this.p = p;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Guardar_respuestas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Guardar_respuestas.setText("Guardar respuestas");
        Guardar_respuestas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_respuestasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(Guardar_respuestas, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(205, Short.MAX_VALUE)
                .addComponent(Guardar_respuestas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //REVISAR OPCIONES DEL MÉTODO
    private void Guardar_respuestasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar_respuestasActionPerformed
        //Creamos el objeto JFileChooser
        JFileChooser fc=new JFileChooser();
 
        //Abrimos la ventana, guardamos la opcion seleccionada por el usuario
        int seleccion=fc.showSaveDialog(this);

        //Si el usuario, pincha en aceptar
        if(seleccion==JFileChooser.APPROVE_OPTION){

            //Seleccionamos el fichero
            File fichero=fc.getSelectedFile();

            try(FileWriter fw=new FileWriter(fichero)){

               respuestas.archivoCifrado(p.getRespuestasP());


            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }//GEN-LAST:event_Guardar_respuestasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guardar_respuestas;
    // End of variables declaration//GEN-END:variables
}
