
package assignment;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class doctorBarChart extends javax.swing.JFrame {
    
    private String startDate, endDate;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(doctorBarChart.class.getName());

    public doctorBarChart() {}
    
    public doctorBarChart(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        initComponents();
        drawChart();
    }

    private void drawChart() {
        try {
            GenerateReportContents tables = new GenerateReportContents();
            ReportDetails report = tables.generateDoctorPerformance(startDate, endDate);

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (String[] row : report.getRows()) {
                String doctorID = row[0];
                int consultations = Integer.parseInt(row[1]);
                dataset.addValue(consultations, "Consultations", doctorID);
            }

            JFreeChart chart = ChartFactory.createBarChart(
                "Doctor Performance Analysis",   // title
                "Doctor ID",   // x-axis label
                "Number of Consultations",    // y-axis label
                dataset,  
                PlotOrientation.VERTICAL,   // chart orientation
                false, true, false    // legend, tooltips, URLs
            );
            
            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
            yAxis.setRange(0.0, yAxis.getUpperBound());

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setMouseWheelEnabled(true);
            panelDoctor.setLayout(new java.awt.BorderLayout());
            panelDoctor.add(chartPanel, java.awt.BorderLayout.CENTER);
            panelDoctor.validate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDoctor = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelDoctor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelDoctorLayout = new javax.swing.GroupLayout(panelDoctor);
        panelDoctor.setLayout(panelDoctorLayout);
        panelDoctorLayout.setHorizontalGroup(
            panelDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 622, Short.MAX_VALUE)
        );
        panelDoctorLayout.setVerticalGroup(
            panelDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        jButton3.setText("< Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDoctor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelDoctor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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
        java.awt.EventQueue.invokeLater(() -> new doctorBarChart().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel panelDoctor;
    // End of variables declaration//GEN-END:variables
}
