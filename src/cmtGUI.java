package assignment;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class cmtGUI extends javax.swing.JFrame {

    private static final Path EMP_FILE = Path.of("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\employee.txt");   // Role;UserID;Full Name;...
    private static final Path CUS_FILE = Path.of("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\customer.txt");   // customerID;full name;IC;email;DOB;gender;phone;nationality

    private static Customer customerId; // may be null if opened standalone

    private ButtonGroup roleGroup;
    
    public cmtGUI() { this(null); }

    public cmtGUI(Customer customerId) {
        this.customerId = customerId;
        initComponents();
        setTitle("Comments");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        ((JComponent) getContentPane()).setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(204,204,255)),
                "Comments",
                javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.TOP
            )
        );

        roleGroup = new ButtonGroup();
        roleGroup.add(jRadioButton1);
        roleGroup.add(jRadioButton2);

        if (customerId != null && !customerId.getId().isBlank()) {
            jTextField3.setText(customerId.getId()); // CustomerID
            jTextField3.setEditable(false);
        }

        getRootPane().setDefaultButton(jButton1);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Please provide your value comment.");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Comment");

        jLabel3.setText("Comment for");

        jLabel4.setText("Comments");

        jLabel5.setText("CustomerID");

        jLabel6.setText("EmployeeID");

        jRadioButton1.setText("Doctor");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Staff");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Submit");
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

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jButton2)
                        .addGap(35, 35, 35)
                        .addComponent(jButton1)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addGap(1, 1, 1)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton1)
                        .addComponent(jRadioButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
   
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
     
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Submit button handling
        String customerId = jTextField3.getText().trim();
        String employeeId = jTextField1.getText().trim();
        String comment    = jTextField2.getText().trim();
        String roleChosen = jRadioButton1.isSelected() ? "Doctor"
                          : (jRadioButton2.isSelected() ? "Staff" : "");

        if (customerId.isEmpty()) { warn("Please enter a CustomerID.", jTextField3); return; }
        if (!customerExists(customerId)) { warn("CustomerID not found.", jTextField3); return; }

        if (roleChosen.isEmpty()) { warn("Please select Doctor/Staff.", jRadioButton1); return; }

        if (employeeId.isEmpty()) { warn("Please enter an EmployeeID.", jTextField1); return; }
        if (!employeeExistsWithRole(employeeId, roleChosen)) {
            warn("EmployeeID not found with role: " + roleChosen, jTextField1); return;
        }

        if (comment.isEmpty()) { warn("Please enter a comment.", jTextField2); return; }
        if (comment.length() < 3) { warn("Comment is too short.", jTextField2); return; }
        if (comment.length() > 500) { warn("Comment is too long (max 500).", jTextField2); return; }

        comment = comment.replace(';', ',')
                         .replace("\r", " ")
                         .replace("\n", " ")
                         .replaceAll("\\s+", " ")
                         .trim();

        try {
            Comment c = Comment.ofToday(customerId, employeeId, comment);
            c.save();
            JOptionPane.showMessageDialog(this, "Comment submitted. Thank you!");
            jTextField1.setText("");          // employee ID
            roleGroup.clearSelection();       // role (Doctor/Staff)
            jTextField2.setText("");          // comment
            jTextField1.requestFocus();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Save error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (customerId != null && !customerId.getId().isBlank()) {
            new custMenuGUI(customerId).setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (customerId == null) jTextField3.setText(""); // only clear CustomerID if it wasn't prefilled
        jTextField1.setText("");
        jTextField2.setText("");
        roleGroup.clearSelection();
        jTextField1.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void warn(String msg, java.awt.Component focus) {
        JOptionPane.showMessageDialog(this, msg, "Validation", JOptionPane.WARNING_MESSAGE);
        if (focus != null) focus.requestFocus();
    }

    private boolean employeeExistsWithRole(String userId, String role) {
        if (!Files.exists(EMP_FILE)) return true; // if file missing, don't block submit
        try (BufferedReader br = Files.newBufferedReader(EMP_FILE, StandardCharsets.UTF_8)) {
            String line; boolean first = true;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                if (first) {
                    first = false;
                    String low = line.trim().toLowerCase();
                    if (low.startsWith("role;")) continue; // skip header
                }
                String[] r = line.split(";", -1);
                if (r.length < 2) continue;
                String rRole = r[0].trim();
                String rId   = r[1].trim();
                if (rRole.equalsIgnoreCase(role) && rId.equalsIgnoreCase(userId)) return true;
            }
        } catch (IOException ignored) {}
        return false;
    }

    private boolean customerExists(String customerId) {
        if (!Files.exists(CUS_FILE)) return true; // if file missing, don't block submit
        try (BufferedReader br = Files.newBufferedReader(CUS_FILE, StandardCharsets.UTF_8)) {
            String line; boolean first = true;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                if (first) {
                    first = false;
                    String low = line.trim().toLowerCase();
                    if (low.startsWith("customerid;")) continue; // skip header if present
                }
                String[] r = line.split(";", -1);
                if (r.length == 0) continue;
                if (customerId.equalsIgnoreCase(r[0].trim())) return true;
            }
        } catch (IOException ignored) {}
        return false;
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new cmtGUI(customerId).setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
