package assignment;

import java.time.LocalDate;
import javax.swing.*;
import javax.swing.text.*;

public class profileGUI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(profileGUI.class.getName());

    private static Customer customerId;  // who we are editing
    private char defaultEchoChar;
    
    public profileGUI() {this(null);}

    public profileGUI(Customer customerId) {
        this.customerId = customerId;

        initComponents();
        setTitle("Personal Profile");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        jPasswordField1.setText("");
        defaultEchoChar = jPasswordField1.getEchoChar(); //Caches password echo char
        prefillPassword(customerId); 

        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));        // day
        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));        // month
        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(2000, 1900, 2100, 1)); // year

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[]{"Choose Nationality", "Malaysia", "Singapore", "Indonesia", "Thailand", "Other"}));

        jComboBox1.setSelectedIndex(0); // show placeholder by default

        forceDigitsOnly(jTextField5); //phone
        forceDigitsOnly(jTextField3); //ic

        if (customerId != null && !customerId.getId().isBlank()) {
            jTextField1.setText(customerId.getId());  // Username = customerID
            jTextField1.setEditable(false);
            prefillCustomer(customerId);
            prefillPassword(customerId); // optional display
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel1.setText("Username");

        jLabel2.setText("Full Name");

        jLabel5.setText("DOB");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("IC/Passport NO.");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Phone Number");

        jButton1.setText("Save Changes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Email Address");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jLabel9.setText("/");

        jLabel10.setText("/");

        jLabel11.setText("Gender");

        jRadioButton1.setText("Male");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Female");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel12.setText("Nationality");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel13.setText("Password");

        jLabel6.setText("Personal Profile");

        jButton3.setText("< Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPasswordField1.setText("jPasswordField1");

        jCheckBox1.setText("show password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField2)
                                            .addComponent(jTextField1))
                                        .addGap(27, 27, 27)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox1))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(250, 250, 250))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(275, 275, 275)))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1)
                    .addComponent(jLabel13)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3)
                    .addComponent(jLabel3)
                    .addComponent(jTextField7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jRadioButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (!validateForm()) return; // block invalid input

            String id     = jTextField1.getText().trim();
            String full   = titleCase(jTextField2.getText().trim());
            String ic     = jTextField3.getText().trim();
            String email  = jTextField7.getText().trim();
            String phone  = jTextField5.getText().trim();
            String nat    = (jComboBox1.getSelectedItem() == null) ? "" : String.valueOf(jComboBox1.getSelectedItem());
            String pwd    = new String(jPasswordField1.getPassword()).trim();
            String gender = jRadioButton1.isSelected() ? "Male" : (jRadioButton2.isSelected() ? "Female" : "");

            int day = (int) jSpinner1.getValue();
            int mon = (int) jSpinner2.getValue();
            int yr  = (int) jSpinner3.getValue();
            String dob = String.format("%04d/%02d/%02d", yr, mon, day); // yyyy/MM/dd
            
            if (!DateValidation.isValidDate(yr, mon, day)) {
            JOptionPane.showMessageDialog(null, "Invalid date selected! Please choose a valid date.");
            return;
        }

        if (DateValidation.isFutureDate(yr, mon, day)) {
            JOptionPane.showMessageDialog(null, "Date of birth cannot be in the future!");
            return;
        }

            try {
                Customer customer;

                if (this.customerId != null && !this.customerId.getId().isBlank()) {
                    customer = Customer.loadCustomer(this.customerId);
                    if (customer == null) {
                        customer = new Customer(id, full, ic, email, dob, gender, phone, nat);
                    } else {
                        if (isUnchanged(customer, full, ic, email, dob, gender, phone, nat, pwd)) {
                            JOptionPane.showMessageDialog(this, "No changes detected. Please edit the details first.");
                            return;
                        }
                    }
                } else {
                    customer = new Customer(id, full, ic, email, dob, gender, phone, nat);
                }

                boolean success = customer.editProfile(full, ic, email, dob, gender, phone, nat, pwd);

                if (success) {
                    JOptionPane.showMessageDialog(this, "Profile saved successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Error saving profile.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Save error: " + ex.getMessage());
            }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed

    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (customerId != null && !customerId.getId().isBlank()) new custMenuGUI(customerId).setVisible(true);
        dispose(); //close this frame
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        String typedId = jTextField1.getText().trim();
        if (typedId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your CustomerID/Username first.");
            return;
        }

        Customer temp = new Customer(typedId, "", "", "", "2000/01/01", "", "", "");
        prefillCustomer(temp);
        prefillPassword(temp);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
      
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
     
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
   
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        jPasswordField1.setEchoChar(jCheckBox1.isSelected() ? (char)0 : defaultEchoChar);
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void forceDigitsOnly(JTextField tf) {
        ((AbstractDocument) tf.getDocument()).setDocumentFilter(new DocumentFilter() {
            private boolean ok(String s) {
                return s.chars().allMatch(ch ->
                    Character.isDigit(ch) || ch == '-'  

                );
            }
            @Override public void insertString(FilterBypass fb, int off, String str, AttributeSet a) throws BadLocationException {
                if (str != null && ok(str)) super.insertString(fb, off, str, a);
            }
            @Override public void replace(FilterBypass fb, int off, int len, String str, AttributeSet a) throws BadLocationException {
                if (str != null && ok(str)) super.replace(fb, off, len, str, a);
                else if (str == null) super.replace(fb, off, len, null, a);
            }
        });
    }

    private void prefillCustomer(Customer id) {
        Customer customer = Customer.loadCustomer(id);
        if (customer == null) {
            System.out.println("Customer not found: " + id);
            return;
        }

        jTextField2.setText(customer.getFullName());
        jTextField3.setText(customer.getIc());
        jTextField7.setText(customer.getEmail());
        jTextField5.setText(customer.getPhoneNumber());

        if ("Male".equalsIgnoreCase(customer.getGender())) {
            jRadioButton1.setSelected(true);
        } else if ("Female".equalsIgnoreCase(customer.getGender())) {
            jRadioButton2.setSelected(true);
        }

        DefaultComboBoxModel<String> m = (DefaultComboBoxModel<String>) jComboBox1.getModel();
        String nat = customer.getNationality();
        if (nat != null && !nat.isBlank()) {
            if (m.getIndexOf(nat) >= 0) {
                jComboBox1.setSelectedItem(nat);
            } else {
                jComboBox1.setSelectedItem("Other");
            }
        }

        try {
            String[] dobParts = customer.getDob().split("/");
            if (dobParts.length == 3) {
                jSpinner1.setValue(Integer.parseInt(dobParts[2]));
                jSpinner2.setValue(Integer.parseInt(dobParts[1]));
                jSpinner3.setValue(Integer.parseInt(dobParts[0]));
            }
        } catch (Exception ignored) {}
    }

    private void prefillPassword(Customer id) {
        jPasswordField1.setText("");

        String password = Customer.loadPassword(id);
        if (password != null && !password.isBlank()) {
            jPasswordField1.setText(password);
        }
    }

    private boolean validateForm() {
        String id = jTextField1.getText().trim();
        if (id.isEmpty()) { warn("Username / CustomerID cannot be empty.", jTextField1); return false; }

        String full = jTextField2.getText().trim();
        if (full.isEmpty()) { warn("Full name is required.", jTextField2); return false; }
        if (full.length() < 2) { warn("Full name looks too short.", jTextField2); return false; }
        if (!full.matches("[\\p{L} .'-]+")) { warn("Full name contains invalid characters.", jTextField2); return false; }

        // IC: required, digits-only (input filter already enforces digits)
        String ic = jTextField3.getText().trim();
        if (ic.isEmpty()) { warn("IC/Passport number is required.", jTextField3); return false; }

        // Email: required, but no regex validation
        String email = jTextField7.getText().trim();
        if (email.isEmpty()) { warn("Email is required.", jTextField7); return false; }

        if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
            warn("Please select a gender.", jRadioButton1); return false;
        }

        // DOB: must be a valid date (keep)
        try {
            int d = (int) jSpinner1.getValue();
            int m = (int) jSpinner2.getValue();
            int y = (int) jSpinner3.getValue();
            LocalDate.of(y, m, d);
        } catch (Exception ex) {
            warn("DOB is invalid.", jSpinner1); return false;
        }

        String phone = jTextField5.getText().trim();
        if (phone.isEmpty()) { warn("Phone number is required.", jTextField5); return false; }

        if (jComboBox1.getSelectedIndex() <= 0) {
            warn("Please choose your nationality.", jComboBox1);
            return false;
        }

        String pwd = new String(jPasswordField1.getPassword()); // keep spaces if user intends them
        if (!pwd.isEmpty()) {
            boolean ok = pwd.matches("^(?=.*[A-Za-z])(?=.*\\d).{8,}$");
            if (!ok) {
                warn("Password must be at least 8 characters, with at least one letter and one number.", jPasswordField1);
                return false;
            }
        }

        return true;
    }

    private void warn(String msg, java.awt.Component focus) {
        JOptionPane.showMessageDialog(this, msg, "Validation", JOptionPane.WARNING_MESSAGE);
        if (focus != null) focus.requestFocus();
    }

    private String titleCase(String s) {
        if (s == null) return "";
        s = s.trim().replaceAll("\\s+", " ").toLowerCase();
        StringBuilder out = new StringBuilder(s.length());
        boolean capNext = true;
        for (char c : s.toCharArray()) {
            if (capNext && Character.isLetter(c)) {
                out.append(Character.toUpperCase(c));
                capNext = false;
            } else {
                out.append(c);
            }
            if (c == ' ' || c == '-' || c == '\'') capNext = true;
        }
        return out.toString();
    }
    
    private boolean isUnchanged(Customer existing,
                            String full, String ic, String email, String dob,
                            String gender, String phone, String nat, String pwd) {

        String exFull   = existing.getFullName()          == null ? "" : existing.getFullName();
        String exIc     = existing.getIc()                == null ? "" : existing.getIc();
        String exEmail  = existing.getEmail()             == null ? "" : existing.getEmail();
        String exDob    = existing.getDob()               == null ? "" : existing.getDob();
        String exGender = existing.getGender()            == null ? "" : existing.getGender();
        String exPhone  = existing.getPhoneNumber()       == null ? "" : existing.getPhoneNumber();
        String exNat    = existing.getNationality()       == null ? "" : existing.getNationality();

        boolean sameProfile =
               exFull.equals(full)
            && exIc.equals(ic)
            && exEmail.equals(email)
            && exDob.equals(dob)
            && exGender.equalsIgnoreCase(gender)
            && exPhone.equals(phone)
            && exNat.equals(nat);

        String storedPwd = Customer.loadPassword(existing);
        String safeStoredPwd = storedPwd == null ? "" : storedPwd;
        boolean pwdChanged = !pwd.isEmpty() && !pwd.equals(safeStoredPwd);

        return sameProfile && !pwdChanged;
    }

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new profileGUI(customerId).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables

}
