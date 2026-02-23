
package assignment;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class revenueBarChart extends javax.swing.JFrame {
    
    private String startDate, endDate;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(revenueBarChart.class.getName());

    public revenueBarChart() {}
    
    public revenueBarChart(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        initComponents();
        drawChart();
    }

    private void drawChart() {
        try {
            GenerateReportContents tables = new GenerateReportContents();   
            ReportDetails report = tables.generateRevenueReport(startDate, endDate);   // contains tables contents and summary data

            String[] methods = {"Cash", "Debit/Credit Card", "Touch N Go", "Online Banking"};
            String[] values = report.getReportValues();   // only get the summary data

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (int i = 0; i < 4; i++) {
                double revenue = Double.parseDouble(values[i]);
                dataset.addValue(revenue, "Revenue", methods[i]);
            }

            JFreeChart chart = ChartFactory.createBarChart(
                "Revenue Analysis",    // title
                "Payment Method",    // x-axis label
                "Total Revenue (RM)",    // y-axis label
                dataset,
                PlotOrientation.VERTICAL,   // chart orientation
                false, true, false   // legend, tooltips, URLs
            );

            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
            yAxis.setRange(0.0, yAxis.getUpperBound());
            
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setMouseWheelEnabled(true);
            panelRevenue.setLayout(new java.awt.BorderLayout());
            panelRevenue.add(chartPanel, java.awt.BorderLayout.CENTER);
            panelRevenue.validate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        panelRevenue = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton3.setText("< Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        panelRevenue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelRevenueLayout = new javax.swing.GroupLayout(panelRevenue);
        panelRevenue.setLayout(panelRevenueLayout);
        panelRevenueLayout.setHorizontalGroup(
            panelRevenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );
        panelRevenueLayout.setVerticalGroup(
            panelRevenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRevenue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(panelRevenue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        java.awt.EventQueue.invokeLater(() -> new revenueBarChart().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel panelRevenue;
    // End of variables declaration//GEN-END:variables
}
