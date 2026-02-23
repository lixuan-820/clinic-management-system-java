package assignment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class checkAptmt extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(checkAptmt.class.getName());

    private static final Path REQ_FILE = Path.of("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\appointment_request.txt");
    private static final Path EMP_FILE = Path.of("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\employee.txt");

    private final Map<String, String> doctorNameById = new HashMap<>();
    private static Customer customerId = null; // set when opened from menu/login

    public checkAptmt(Customer customerId) {
        initComponents();
        postInit();
        this.customerId = customerId;
        if (customerId != null && !customerId.getId().isBlank()) {
            refreshForCustomer(customerId.getId());
            TableTools.applySort(jTable1, jComboBox1); // after data is loaded
        }
    }

    private void postInit() {
        setTitle("Check Appointment");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // install a sorter once so TableTools can use it
        jTable1.setRowSorter(new javax.swing.table.TableRowSorter<>(jTable1.getModel()));

        // Start with empty search
        jTextField1.setText("");

        DefaultComboBoxModel<String> sortModel = new DefaultComboBoxModel<>();
        sortModel.addElement("By Default");
        sortModel.addElement("AppointmentID");
        sortModel.addElement("Date");
        sortModel.addElement("Time");
        sortModel.addElement("Doctor");
        sortModel.addElement("Special Request");
        sortModel.addElement("Status");
        jComboBox1.setModel(sortModel);
        jComboBox1.setSelectedIndex(0);

        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(new Color(204, 204, 255)),
                        "Check Appointment",
                        javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.TOP
                )
        );

        loadDoctorNames();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AppointmentID", "CustomerID", "Full Name", "Gender", "Phone Number", "Date", "Time", "Doctor", "Special Request", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Check Appointment");

        jButton1.setText("Cancel Appointment");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("< Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.setText("Search");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

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
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 616, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(601, 601, 601))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4)
                                        .addGap(192, 192, 192)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(94, 94, 94))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
        onCancel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (customerId != null && !customerId.getId().isBlank()) {
            new custMenuGUI(customerId).setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

        TableTools.applySearch(jTable1, jTextField1);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        TableTools.applySearch(jTable1, jTextField1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        TableTools.applySort(jTable1, jComboBox1); // sorts ascending by selected column
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

    private void loadDoctorNames() {
        doctorNameById.clear();
        if (!Files.exists(EMP_FILE)) return;
        try (var br = Files.newBufferedReader(EMP_FILE, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] r = line.split(";", -1);
                if (r.length < 3) continue;
                String role = r[0].trim(), id = r[1].trim(), name = r[2].trim();
                if ("doctor".equalsIgnoreCase(role) && !id.isEmpty()) {
                    doctorNameById.put(id, name);
                }
            }
        } catch (Exception ignored) {}
    }

    public void refreshForCustomer(String customerId) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        if (!Files.exists(REQ_FILE)) return;

        try (var br = Files.newBufferedReader(REQ_FILE, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;

                String[] r = line.split(";", -1);
                if (r.length < 9) continue; // at least request format

                String apptId   = r[0].trim();
                String custId   = r[1].trim();
                if (!custId.equalsIgnoreCase(customerId)) continue;

                String fullName = r[2].trim();
                String gender   = r[3].trim();
                String phone    = r[4].trim();
                String date     = r[5].trim();
                String time     = r[6].trim();

                String userId   = (r.length >= 10) ? r[7].trim() : "";
                String special  = (r.length >= 10) ? r[8].trim() : r[7].trim();
                String status   = (r.length >= 10) ? r[9].trim() : r[8].trim();

                // only show non-cancelled
                if ("cancelled".equalsIgnoreCase(status)) continue;

                String doctor = userId.isBlank() ? "" : doctorNameById.getOrDefault(userId, userId);
                model.addRow(new Object[]{apptId, custId, fullName, gender, phone, date, time, doctor, special, status});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Read error: " + ex.getMessage());
        }

        TableTools.applySearch(jTable1, jTextField1);
        TableTools.applySort(jTable1, jComboBox1);
    }

    private void onCancel() {
        int viewRow = jTable1.getSelectedRow();
        if (viewRow == -1) {
            JOptionPane.showMessageDialog(this, "Select an appointment to cancel.");
            return;
        }
        int row = jTable1.convertRowIndexToModel(viewRow);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        String apptId = String.valueOf(model.getValueAt(row, 0));
        String status = String.valueOf(model.getValueAt(row, 9));
        if ("Cancelled".equalsIgnoreCase(status)) {
            JOptionPane.showMessageDialog(this, "This appointment is already cancelled.");
            return;
        }

        int ok = JOptionPane.showConfirmDialog(
                this, "Cancel appointment " + apptId + "?",
                "Confirm", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (ok != JOptionPane.OK_OPTION) return;

        try {
            if (!Files.exists(REQ_FILE)) {
                JOptionPane.showMessageDialog(this, "No request file found.");
                return;
            }
            List<String> lines = Files.readAllLines(REQ_FILE, StandardCharsets.UTF_8);
            boolean moved = false;

            for (int i = 0; i < lines.size(); i++) {
                String ln = lines.get(i);
                if (ln.isBlank()) continue;

                String[] r = ln.split(";", -1);
                if (r.length < 9) continue;

                if (apptId.equals(r[0].trim())) {
                    // write to history (normalized 10 cols), status=Cancelled
                    Appointment.moveRowToHistory(r, "Cancelled");
                    // remove from request
                    lines.remove(i);
                    moved = true;
                    break;
                }
            }

            if (moved) {
                Files.write(REQ_FILE, lines, StandardCharsets.UTF_8,
                        java.nio.file.StandardOpenOption.TRUNCATE_EXISTING,
                        java.nio.file.StandardOpenOption.CREATE);
                JOptionPane.showMessageDialog(this, "Appointment cancelled and moved to history.");
                if (customerId != null) refreshForCustomer(customerId.getId());
            } else {
                JOptionPane.showMessageDialog(this, "Appointment not found.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Write error: " + ex.getMessage());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new checkAptmt(customerId).setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
