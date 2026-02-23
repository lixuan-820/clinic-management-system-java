
package assignment;

import java.time.LocalDate;

public class generateReport extends javax.swing.JFrame {
    
    Manager manager = new Manager();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(generateReport.class.getName());

    
    public generateReport() {
        initComponents();
        
        LocalDate today = LocalDate.now();
        yearSpinner1.setValue(today.getYear());
        monthSpinner1.setValue(today.getMonthValue());
        daySpinner1.setValue(today.getDayOfMonth());
        
        yearSpinner2.setValue(today.getYear());
        monthSpinner2.setValue(today.getMonthValue());
        daySpinner2.setValue(today.getDayOfMonth());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        yearSpinner = new javax.swing.JSpinner();
        monthSpinner = new javax.swing.JSpinner();
        daySpinner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        yearSpinner1 = new javax.swing.JSpinner();
        monthSpinner1 = new javax.swing.JSpinner();
        daySpinner1 = new javax.swing.JSpinner();
        yearSpinner2 = new javax.swing.JSpinner();
        monthSpinner2 = new javax.swing.JSpinner();
        daySpinner2 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();

        yearSpinner.setModel(new javax.swing.SpinnerNumberModel(2025, 2000, 2025, 1));
        yearSpinner.setEditor(new javax.swing.JSpinner.NumberEditor(yearSpinner, "####"));
        yearSpinner.setMaximumSize(new java.awt.Dimension(2025, 2025));

        monthSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        monthSpinner.setMaximumSize(new java.awt.Dimension(12, 12));
        monthSpinner.setMinimumSize(new java.awt.Dimension(1, 1));

        daySpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        daySpinner.setMaximumSize(new java.awt.Dimension(31, 31));
        daySpinner.setMinimumSize(new java.awt.Dimension(1, 1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setText("Analyzed Report Generator");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Enter the start date for the report :");

        jButton3.setText("< Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Enter the end date for the report :");

        yearSpinner1.setModel(new javax.swing.SpinnerNumberModel(2025, 2000, 2025, 1));
        yearSpinner1.setEditor(new javax.swing.JSpinner.NumberEditor(yearSpinner1, "####"));
        yearSpinner1.setMaximumSize(new java.awt.Dimension(2025, 2025));

        monthSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        monthSpinner1.setMaximumSize(new java.awt.Dimension(12, 12));
        monthSpinner1.setMinimumSize(new java.awt.Dimension(1, 1));

        daySpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        daySpinner1.setMaximumSize(new java.awt.Dimension(31, 31));
        daySpinner1.setMinimumSize(new java.awt.Dimension(1, 1));

        yearSpinner2.setModel(new javax.swing.SpinnerNumberModel(2025, 2000, 2025, 1));
        yearSpinner2.setEditor(new javax.swing.JSpinner.NumberEditor(yearSpinner2, "####"));
        yearSpinner2.setMaximumSize(new java.awt.Dimension(2025, 2025));

        monthSpinner2.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        monthSpinner2.setMaximumSize(new java.awt.Dimension(12, 12));
        monthSpinner2.setMinimumSize(new java.awt.Dimension(1, 1));

        daySpinner2.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        daySpinner2.setMaximumSize(new java.awt.Dimension(31, 31));
        daySpinner2.setMinimumSize(new java.awt.Dimension(1, 1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(yearSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(monthSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(daySpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(yearSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(monthSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(daySpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel3)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(yearSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(daySpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(yearSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(daySpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jButton1)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        mainManager main = new mainManager();
        main.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // start date 
        int Year1 = (Integer) yearSpinner1.getValue();    // use (Integer) or Integer.parseInteger(String.valueOf()) to convert object into int
        int Month1 = (Integer) monthSpinner1.getValue();
        int Day1 = (Integer) daySpinner1.getValue();
        
        // end date
        int Year2 = (Integer) yearSpinner2.getValue();    // use (Integer) or Integer.parseInteger(String.valueOf()) to convert object into int
        int Month2 = (Integer) monthSpinner2.getValue();
        int Day2 = (Integer) daySpinner2.getValue();
        
        String startDate = String.format("%4d-%02d-%02d", Year1, Month1, Day1);
        String endDate = String.format("%4d-%02d-%02d", Year2, Month2, Day2);
            
        if(DateValidation.reportDate(startDate, endDate)) {
            analyzedReport report = new analyzedReport(startDate, endDate);
            report.setVisible(true);
            this.dispose(); 
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new generateReport().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner daySpinner;
    private javax.swing.JSpinner daySpinner1;
    private javax.swing.JSpinner daySpinner2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSpinner monthSpinner;
    private javax.swing.JSpinner monthSpinner1;
    private javax.swing.JSpinner monthSpinner2;
    private javax.swing.JSpinner yearSpinner;
    private javax.swing.JSpinner yearSpinner1;
    private javax.swing.JSpinner yearSpinner2;
    // End of variables declaration//GEN-END:variables
}
