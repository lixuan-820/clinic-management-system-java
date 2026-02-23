
package assignment;

import java.text.DecimalFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class appointmentPieChart extends javax.swing.JFrame {

    private String startDate, endDate;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(appointmentPieChart.class.getName());

    public appointmentPieChart() {}

    public appointmentPieChart(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        initComponents();
        drawChart(startDate, endDate);
    }

    private void drawChart(String startDate, String endDate) {
        try {
            GenerateReportContents tables = new GenerateReportContents();
            ReportDetails report = tables.generateAppointmentReport(startDate, endDate);

            String[] values = report.getReportValues(); // totalCompleted, totalCancelled, totalAppointments, average, inQueue

            // create dataset
            DefaultPieDataset dataset = new DefaultPieDataset();
            dataset.setValue("Completed", Integer.parseInt(values[0]));
            dataset.setValue("Cancelled", Integer.parseInt(values[1]));
            dataset.setValue("In-Queue", Integer.parseInt(values[4]));

            // create pie chart
            JFreeChart chart = ChartFactory.createPieChart(
                "Appointment Analysis",  // title of the chart
                dataset,
                true,                  // legend
                true,                  // tooltips
                false                  // URLs
            );
            
            PiePlot plot = (PiePlot) chart.getPlot();
            plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
                    "{0}: {1} ({2})",      // {0}=category, {1}=value, {2}=percentage
                    new DecimalFormat("0"), 
                    new DecimalFormat("0.0%") 
            ));

            // insert the chart into ChartPanel
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setSize(panelAppointment.getWidth(), panelAppointment.getHeight());
            chartPanel.setMouseWheelEnabled(true);

            panelAppointment.setLayout(new java.awt.BorderLayout());
            panelAppointment.add(chartPanel, java.awt.BorderLayout.CENTER);
            panelAppointment.validate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        panelAppointment = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setText("< Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panelAppointment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelAppointmentLayout = new javax.swing.GroupLayout(panelAppointment);
        panelAppointment.setLayout(panelAppointmentLayout);
        panelAppointmentLayout.setHorizontalGroup(
            panelAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 668, Short.MAX_VALUE)
        );
        panelAppointmentLayout.setVerticalGroup(
            panelAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );

        getContentPane().add(panelAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 670, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        analyzedReport report = new analyzedReport(startDate, endDate);
        report.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
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
        java.awt.EventQueue.invokeLater(() -> new appointmentPieChart().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel panelAppointment;
    // End of variables declaration//GEN-END:variables
}
