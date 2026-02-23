package assignment;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Customer extends User{
    
    public Customer(String customerID, String fullName, String ic, String email, 
                   String dob, String gender, String phoneNumber, String nationality) {
        super(customerID, fullName, ic, email, dob, gender, phoneNumber, nationality);
    }

    // converts customer data into ; sperated line for saving to file
    @Override
    public String toString() {
        return this.getCustomerID() + ";" +
               this.getFullName() + ";" +
               this.getIc() + ";" +
               this.getEmail() + ";" +
               this.getDob() + ";" +
               this.getGender() + ";" +
               this.getPhoneNumber() + ";" +
               this.getNationality();
    }

    // connect to GUI edit profile action
    public boolean editProfile(String newFullName, String newIc, String newEmail, 
                             String newDob, String newGender, String newPhoneNumber, 
                             String newNationality, String newPassword) {
        try {
            this.setFullName(newFullName);
            this.setIc(newIc);
            this.setEmail(newEmail);
            this.setDob(newDob);
            this.setGender(newGender);
            this.setPhoneNumber(newPhoneNumber);
            this.setNationality(newNationality);

            boolean customerUpdated = updateCustomerInFile();
            boolean passwordUpdated = true;
            
            if (newPassword != null && !newPassword.trim().isEmpty()) {
                passwordUpdated = updatePasswordInFile(newPassword);
            }

            return customerUpdated && passwordUpdated;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error updating profile: " + e.getMessage());
            return false;
        }
    }

    // keep customer profile data up to date
    private boolean updateCustomerInFile() {
        try {
            FileHandler fh = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\customer.txt"); //open customer.txt
            List<String> lines = fh.readFile(); 

            boolean found = false; 

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i); //get the current line
                if (line == null || line.isBlank()) continue; //skip empty or null lines

                String[] parts = line.split(";", -1); //split line by ;

                if (parts.length >= 1 && parts[0].trim().equalsIgnoreCase(this.getCustomerID())) {
                    lines.set(i, this.toString()); //Replace the old line with the updated profile string (toFileString()
                    found = true; //Mark that we found the customer in the file.
                    break;
                }
            }
            if (!found) lines.add(this.toString());

            fh.writeFile(lines);
            return true;
        } catch (Exception e) {
            System.out.println("Error updating customer file: " + e.getMessage());
            return false;
        }
    }

    private boolean updatePasswordInFile(String newPassword) {
        try {
            FileHandler fh = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\password.txt");
            List<String> lines = fh.readFile(); //Load all existing password lines into a list.
            boolean found = false; //Flag to track if customer ID is already present.
            
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line == null || line.isBlank()) continue;

                String[] p = line.split(";", -1);

                if (p.length >= 2 && p[0].trim().equalsIgnoreCase(this.getCustomerID())) {
                    lines.set(i, this.getCustomerID() + ";" + newPassword); //Replace line with the new ID + new password
                    found = true;
                    break;
                }
            }
            if (!found) lines.add(this.getCustomerID() + ";" + newPassword);

            fh.writeFile(lines);
            return true;
        } catch (Exception e) {
            System.out.println("Error updating password file: " + e.getMessage());
            return false;
        }
    }

    public static Customer loadCustomer(Customer customerID) {
        try {
            FileHandler fh = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\customer.txt");
            List<String> lines = fh.readFile();
            //loop through each line of the file
            for (String line : lines) {
                if (line == null || line.isBlank()) continue; //skip empty/null lines

                String[] p = line.split(";", -1);
                if (p.length >= 8 && p[0].trim().equalsIgnoreCase(customerID.getId())) {
                    return new Customer(
                        p[0].trim(), p[1].trim(), p[2].trim(), p[3].trim(),
                        p[4].trim(), p[5].trim(), p[6].trim(), p[7].trim()
                    );
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading customer: " + e.getMessage());
        }
        return null; 
    }
    
    public static String loadPassword(Customer customerID) {
        try {
            FileHandler fh = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\password.txt");
            List<String> lines = fh.readFile();

            for (String line : lines) {
                if (line == null || line.isBlank()) continue;

                String[] p = line.split(";", -1);

                if (p.length >= 2 && p[0].trim().equalsIgnoreCase(customerID.getId())) {
                    return p[1].trim();
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading password: " + e.getMessage());
        }
        return null;
    }

    public String getCustomerID() {
        return this.getId();
    }

    public static List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>(); //Create an empty list to store Customer objects
        try {
            FileHandler fh = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\customer.txt");
            List<String> lines = fh.readFile();
            for (String line : lines) {
                if (line == null || line.isBlank()) continue;
                String[] parts = line.split(";", -1);
                if (parts.length >= 8) {

                    customers.add(new Customer(
                        parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim(),
                        parts[4].trim(), parts[5].trim(), parts[6].trim(), parts[7].trim()
                    ));
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading all customers: " + e.getMessage());
        }
        return customers;
    }
}
