package assignment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import javax.swing.table.TableModel;

public class chargeHisGUI extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(chargeHisGUI.class.getName());

    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    private static Customer customerId; // optional filter (show only this customer's payments)
    private DefaultTableModel model;

    public chargeHisGUI() { this(null); }

    public chargeHisGUI(Customer customerId) {
        this.customerId = customerId;
        initComponents();
        setTitle("Charge Details Histories");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new DefaultTableModel(new Object[]{
                "PaymentID", "AppointmentID", "Date", "Total Amount", "Doctor",
                "Consultation", "Consultation Price", "Medication",
                "Medication Price", "Payment Method", "Amount Paid", "Balance"
        }, 0) { @Override public boolean isCellEditable(int r, int c) { return false; } };

        jTable1.setModel(model);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        var sorter = new TableRowSorter<DefaultTableModel>(model);
        sorter.setComparator(2, (a, b) -> { // Date
            try {
                LocalDate d1 = LocalDate.parse(String.valueOf(a), DF);
                LocalDate d2 = LocalDate.parse(String.valueOf(b), DF);
                return d1.compareTo(d2);
            } catch (Exception ex) { return String.valueOf(a).compareTo(String.valueOf(b)); }
        });
        int[] numCols = {3, 6, 8, 10, 11}; // Total, ConsultPrice, MedPrice, Paid, Balance
        for (int c : numCols) {
            sorter.setComparator(c, (a, b) -> {
                try {
                    double x = Double.parseDouble(String.valueOf(a));
                    double y = Double.parseDouble(String.valueOf(b));
                    return Double.compare(x, y);
                } catch (Exception ex) { return String.valueOf(a).compareTo(String.valueOf(b)); }
            });
        }
        jTable1.setRowSorter(sorter);

        DefaultComboBoxModel<String> sortModel = new DefaultComboBoxModel<>();
        sortModel.addElement("By Default");
        for (int i = 0; i < jTable1.getColumnCount(); i++) sortModel.addElement(jTable1.getColumnName(i));
        jComboBox1.setModel(sortModel);
        jComboBox1.setSelectedIndex(0);

        jTextField1.setText(""); // empty search
        loadRows();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Charge Details Histories");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PaymentID", "AppointmentID", "Date", "Total Amount", "DoctorID", "Consultation", "Consultation Prize", "Medication", "Medication Price", "Payment Method", "Amount Paid", "Balance"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

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
                .addComponent(jButton3)
                .addGap(592, 592, 592)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(537, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(326, 326, 326)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    //data loading 
    private void loadRows() {
        model.setRowCount(0);

        Map<String,String> docNames = doctorNameMap();

        for (Payment.ChargeRow r : Payment.loadCharges(customerId.getId())) {
            String doctorDisplay = docNames.getOrDefault(r.doctorId(), r.doctorId());

            String consultation = joinListObject(r.consultation());
            String consultationPrice = joinListObject(r.consultationPrice());
            String medication = joinListObject(r.medication());
            String medicationPrice = joinListObject(r.medicationPrice());

            model.addRow(new Object[]{
                    r.paymentId(),
                    r.appointmentId(),
                    r.date(),
                    r.totalAmount(),
                    doctorDisplay,
                    consultation,
                    consultationPrice,
                    medication,
                    medicationPrice,
                    r.paymentMethod(),
                    r.amountPaid(),
                    r.balance()
            });
        }
    }

    private static Map<String,String> doctorNameMap() {
        Map<String,String> m = new HashMap<>();
        Path EMP_FILE = Path.of("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\employee.txt");
        if (!Files.exists(EMP_FILE)) return m;
        try (var br = Files.newBufferedReader(EMP_FILE, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] r = line.split(";", -1);
                if (r.length < 3) continue;
                if ("doctor".equalsIgnoreCase(r[0].trim())) {
                    m.put(r[1].trim(), r[2].trim()); // id -> full name
                }
            }
        } catch (Exception ignored) {}
        return m;
    }
    
    private static String joinListObject(Object o) {
        if (o == null) return "";
        if (o instanceof java.util.List) {
            return ((java.util.List<?>) o).stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
        }
        if (o.getClass().isArray()) {
            return Arrays.stream((Object[]) o)
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
        }
        // if it's already a String but contains brackets like "[a,b]" -> strip them:
        String s = String.valueOf(o);
        if (s.startsWith("[") && s.endsWith("]")) return s.substring(1, s.length() - 1);
        return s;
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new chargeHisGUI(customerId).setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
