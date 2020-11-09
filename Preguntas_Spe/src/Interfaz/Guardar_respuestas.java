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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Guardar_respuestas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Guardar_respuestas.setText("Guardar respuestas");
        Guardar_respuestas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_respuestasActionPerformed(evt);
            }
        });
        getContentPane().add(Guardar_respuestas, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 220, 38));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Guardar_respuestas.PNG"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
                fichero.getAbsolutePath();
               respuestas.archivoCifrado(p.getRespuestasP(),fichero.getAbsolutePath());


            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }//GEN-LAST:event_Guardar_respuestasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guardar_respuestas;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
