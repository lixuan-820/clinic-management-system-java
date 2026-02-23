package assignment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.table.TableModel;

public class aptmtHisGUI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(aptmtHisGUI.class.getName());

    // files 
    private static final Path APPT_HIST_FILE = Path.of("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\appointment_history.txt");
    private static final Path EMP_FILE       = Path.of("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\employee.txt");
    private static final Path PAYMENT_FILE   = Path.of("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\payment.txt");
    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    
    private static Customer customerId;  // which customer's history to show
    private DefaultTableModel model;
    private TableRowSorter<DefaultTableModel> sorter;

    public aptmtHisGUI() {this(null);}


    public aptmtHisGUI(Customer customerId) {
        this.customerId = customerId;
        initComponents();
        setTitle("Appointment Histories");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // model & table
        // create a table model with 8 columns and 0 row
        model = new DefaultTableModel(
                new Object[]{"AppointmentID","Date","Time","Doctor","Special Request","Status","Total Charges","Feedback from Doctor"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; } //make all cells read only
        };
        jTable1.setModel(model); //attatch model to JTable
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //only can select one row a time

        DefaultComboBoxModel<String> sortModel = new DefaultComboBoxModel<>();
        sortModel.addElement("By Default");
        for (int i = 0; i < jTable1.getColumnCount(); i++) sortModel.addElement(jTable1.getColumnName(i));
        jComboBox1.setModel(sortModel);
        jComboBox1.setSelectedIndex(0);

        sorter = new TableRowSorter<>(model);
        sorter.setComparator(1, (a,b) -> { // Date
            try {
                LocalDate d1 = LocalDate.parse(String.valueOf(a), DF);
                LocalDate d2 = LocalDate.parse(String.valueOf(b), DF);
                return d1.compareTo(d2);
            } catch (Exception e) { return String.valueOf(a).compareTo(String.valueOf(b)); }
        });
        sorter.setComparator(6, (a,b) -> { // Total Charges
            try {
                double x = Double.parseDouble(String.valueOf(a));
                double y = Double.parseDouble(String.valueOf(b));
                return Double.compare(x, y);
            } catch (Exception e) { return String.valueOf(a).compareTo(String.valueOf(b)); }
        });
        jTable1.setRowSorter(sorter);

        jTextField1.setText("");

        loadRowsForCustomer(customerId.getId());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AppointmentID", "Date", "Time", "Doctor", "Special Request", "Status", "Total Charges", "Feedback from Doctor"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("< Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setText("Search");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Appointment Histories");

        jButton2.setText("Enter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Sorted by");

        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(464, 464, 464)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (customerId != null && !customerId.getId().isBlank()) { //check if this screen was opened for a specific customerId
            new custMenuGUI(customerId).setVisible(true); 
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
 
        TableTools.applySearch(jTable1, jTextField1);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        TableTools.applySearch(jTable1, jTextField1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        TableTools.applySort(jTable1, jComboBox1);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

    jTextField1.setText("");

        var rs = jTable1.getRowSorter();
        if (rs instanceof TableRowSorter) {
            TableTools.resetTable((TableRowSorter<?>) rs);
        } else {
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable1.getModel());
            jTable1.setRowSorter(sorter);
            TableTools.resetTable(sorter);
        }

        jComboBox1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void loadRowsForCustomer(String custId) {
        model.setRowCount(0);

        Map<String,String> doctorNameById = new HashMap<>();
        if (Files.exists(EMP_FILE)) {
            try (var br = Files.newBufferedReader(EMP_FILE, StandardCharsets.UTF_8)) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.isBlank()) continue;
                    String[] r = line.split(";", -1);
                    if (r.length < 3) continue;
                    String role = r[0].trim();
                    String uid  = r[1].trim();
                    String name = r[2].trim();
                    if ("doctor".equalsIgnoreCase(role) && !uid.isEmpty()) {
                        doctorNameById.put(uid, name);
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Read employee error: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "File not found: " + EMP_FILE);
        }

        record PayFrag(String total, String feedback) {}
        Map<String, PayFrag> payByAppt = new HashMap<>();
        if (Files.exists(PAYMENT_FILE)) {
            try (var br = Files.newBufferedReader(PAYMENT_FILE, StandardCharsets.UTF_8)) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.isBlank()) continue;
                    // indices (no header): see class doc
                    String[] r = line.split(";", -1);
                    if (r.length < 12) continue;
                    String apptId   = r[1].trim(); //appointment id
                    String totalAmt = r[5].trim(); //total charge
                    String fb       = r[11].trim(); //feedback
                    if (!apptId.isEmpty()) payByAppt.put(apptId, new PayFrag(totalAmt, fb));
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Read payment error: " + ex.getMessage());
            }
        }

        // history
        if (!Files.exists(APPT_HIST_FILE)) {
            JOptionPane.showMessageDialog(this, "File not found: " + APPT_HIST_FILE);
            return;
        }

        try (var br = Files.newBufferedReader(APPT_HIST_FILE, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;

                String[] r = line.split(";", -1);
                if (r.length < 10) continue;
                // appointmentID;customerID;full Name;gender;phone_number;date;time;userID;special_requests;status
                String apptId  = r[0].trim();
                String cid     = r[1].trim();
                String date    = normalizeDate(r[5].trim());
                String time    = r[6].trim();
                String docId   = r[7].trim();
                String special = r[8].trim();
                String status  = r[9].trim();

                if (custId != null && !custId.isBlank() && !cid.equalsIgnoreCase(custId)) continue;

                String doctor = docId.isEmpty() ? "" : doctorNameById.getOrDefault(docId, docId);

                PayFrag pf = payByAppt.get(apptId);
                String total = (pf == null || pf.total() == null || pf.total().isBlank()) ? "0" : pf.total();
                String fb    = (pf == null) ? "" : (pf.feedback() == null ? "" : pf.feedback());

                model.addRow(new Object[]{apptId, date, time, doctor, special, status, total, fb});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Read history error: " + ex.getMessage());
        }
    }

    // Date format helper
    private String normalizeDate(String s) {
        if (s == null || s.isBlank()) return "";
        if (s.contains("/")) return s;                    // already yyyy/MM/dd
        try { return LocalDate.parse(s).format(DF); }     // e.g. yyyy-MM-dd -> yyyy/MM/dd
        catch (Exception ignored) { return s; }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new aptmtHisGUI().setVisible(true));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
