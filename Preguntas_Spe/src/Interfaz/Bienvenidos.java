package Interfaz;

public class Bienvenidos extends javax.swing.JFrame {

    public Bienvenidos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbRegistrarme = new javax.swing.JButton();
        jbAcercaDe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbRegistrarme.setText("Registrarme");
        jbRegistrarme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarmeActionPerformed(evt);
            }
        });

        jbAcercaDe.setText("Acerca de");
        jbAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAcercaDeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(157, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbRegistrarme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbAcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(152, 152, 152))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
                .addComponent(jbRegistrarme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbAcercaDe)
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRegistrarmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarmeActionPerformed
       DatosParticipante a = new DatosParticipante();
       a.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jbRegistrarmeActionPerformed

    private void jbAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAcercaDeActionPerformed
       AcercaDe a = new AcercaDe();
       a.setVisible(true);
       this.dispose();                  
    }//GEN-LAST:event_jbAcercaDeActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbAcercaDe;
    private javax.swing.JButton jbRegistrarme;
    // End of variables declaration//GEN-END:variables
}
