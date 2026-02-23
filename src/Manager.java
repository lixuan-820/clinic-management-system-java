package assignment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.JOptionPane;

public class Manager extends Employee {
    private FileHandler fileEmployee = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\employee.txt");
    private FileHandler filePassword = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\password.txt");
    private FileHandler appointment = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\appointment_history.txt");
    private FileHandler payment_feedback = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\payment.txt");
    private FileHandler comment = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\cust_cmt.txt");
    
    private GenerateReportContents reportGenerator = new GenerateReportContents();

    public Manager() {
        super();
    }
    
    public Manager(String userID, String fullName, String ic, String emailAddress, String dob, String gender, String phoneNumber, String nationality, String role, double salary) {
        super(userID, fullName, ic, emailAddress, dob, gender, phoneNumber, nationality, role, salary);
    }
    
    public List<String> getAllUsers() {
        return fileEmployee.readFile();        
    }
    
    public boolean createUser(String role, String userID, String fullName, String ic, String email, int Year, int Month, int Day, String dob, String gender, String phoneNumber, String nationality, String salary) {
        if (role.equals("Select Role") || userID.isEmpty() || fullName.isEmpty() || ic.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || nationality.equals("Select Nationality") || salary.isEmpty() || gender.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled!");
            return false;
        }

        if (role.equals("Manager") && !userID.startsWith("M")) {
            JOptionPane.showMessageDialog(null, "Manager ID must start with 'M'");
            return false;
        } else if (role.equals("Staff") && !userID.startsWith("S")) {
            JOptionPane.showMessageDialog(null, "Staff ID must start with 'S'");
            return false;
        } else if (role.equals("Doctor") && !userID.startsWith("D")) {
            JOptionPane.showMessageDialog(null, "Doctor ID must start with 'D'");
            return false;
        }
        
        List<String> allLines = fileEmployee.readFile();
        for (String line : allLines) {
            String[] values = line.split(";");
            if (values.length > 1 && userID.equals(values[1])) {
                JOptionPane.showMessageDialog(null, "User ID already exists! Please enter another user ID.");
                return false;
            }
        }
        
        if (!DateValidation.isValidDate(Year, Month, Day)) {
            JOptionPane.showMessageDialog(null, "Invalid date selected! Please choose a valid date.");
            return false;
        }

        if (DateValidation.isFutureDate(Year, Month, Day)) {
            JOptionPane.showMessageDialog(null, "Date of birth cannot be in the future!");
            return false;
        }
            
        if (!phoneNumber.matches("\\d{7,15}")) {
            JOptionPane.showMessageDialog(null, "Phone number must be 7–15 digits!");
            return false;
        }
        
        try {
            double salaryValue = Double.parseDouble(salary);
            if (salaryValue < 0) {
                JOptionPane.showMessageDialog(null, "Salary cannot be negative value!");
                return false;
            }
            else if(salaryValue < 1000) {
                JOptionPane.showMessageDialog(null, "Salary cannot be less than RM 1,000.00");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Salary must be a number!");
            return false;
        }
        
        String newLine = role + ";" + userID + ";" + fullName + ";" + ic + ";" + email + ";" + dob + ";" + gender + ";" + phoneNumber + ";" + nationality + ";" + salary;
        fileEmployee.appendLine(newLine);
        return true;
    }

    public boolean editUser(String oldRole, String newRole, String oldUserID, String newUserID, String fullName, String ic, String email, int Year, int Month, int Day, String dob, String gender, String phoneNumber, String nationality, String salary) {       
        if (newRole.equals("Select Role") || newUserID.isEmpty() || fullName.isEmpty() || ic.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || nationality.equals("Select Nationality") || salary.isEmpty() || gender.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled!");
            return false;
        }

        if (!newUserID.equals(oldUserID)) {
            if (!newRole.equals(oldRole)) { 
                if (newRole.equals("Manager") && !newUserID.startsWith("M")) {
                    JOptionPane.showMessageDialog(null, "Manager ID must start with 'M'");
                    return false;
                } else if (newRole.equals("Staff") && !newUserID.startsWith("S")) {
                    JOptionPane.showMessageDialog(null, "Staff ID must start with 'S'");
                    return false;
                } else if (newRole.equals("Doctor") && !newUserID.startsWith("D")) {
                    JOptionPane.showMessageDialog(null, "Doctor ID must start with 'D'");
                    return false;
                }

                List<String> allLines = fileEmployee.readFile();
                for (String line : allLines) {
                    String[] values = line.split(";");
                    if (values.length > 1 && newUserID.equals(values[1])) {
                        JOptionPane.showMessageDialog(null, "User ID already exists! Please enter another user ID.");
                        return false;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "UserID cannot be changed unless Role is modified.");
                return false;
            }
        }

        if (!DateValidation.isValidDate(Year, Month, Day)) {
            JOptionPane.showMessageDialog(null, "Invalid date selected! Please choose a valid date.");
            return false;
        }

        if (DateValidation.isFutureDate(Year, Month, Day)) {
            JOptionPane.showMessageDialog(null, "Date of birth cannot be in the future!");
            return false;
        }     
        
        if (!phoneNumber.matches("\\d{7,15}")) {
            JOptionPane.showMessageDialog(null, "Phone number must be 7–15 digits!");
            return false;
        }

        try {
            double salaryValue = Double.parseDouble(salary);
            if (salaryValue < 0) {
                JOptionPane.showMessageDialog(null, "Salary cannot be negative value!");
                return false;
            }
            else if(salaryValue < 1000) {
                JOptionPane.showMessageDialog(null, "Salary cannot be less than RM 1,000.00");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Salary must be a number!");
            return false;
        }

        List<String> allLines = fileEmployee.readFile();
        List<String> updatedLines = new ArrayList<>();
        boolean found = false;

        for (String line : allLines) {
            String[] values = line.split(";");
            if (values.length > 1 && values[1].equals(oldUserID)) {
                String updatedLine = newRole + ";" + newUserID + ";" + fullName + ";" + ic + ";" + email + ";" + dob + ";" + gender + ";" + phoneNumber + ";" + nationality + ";" + salary;
                updatedLines.add(updatedLine);
                found = true;

                if (!oldUserID.equals(newUserID)) {
                    updatePasswordFile(oldUserID, newUserID);
                }
            } else {
                updatedLines.add(line);
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "User not found!");
            return false;
        }

        fileEmployee.writeFile(updatedLines);
        return true;
    }
    
    public boolean deleteUser(String userID) {
        List<String> allLines = fileEmployee.readFile();
        List<String> updatedLines = new ArrayList<>();
        boolean found = false;
        
        for (String line : allLines) {
            String[] values = line.split(";");
            if (values.length > 1 && !values[1].equals(userID)) {
                updatedLines.add(line);
            } else {
                found = true;
            }
        }
        
        if (found) {
            deleteFromPasswordFile(userID);
            fileEmployee.writeFile(updatedLines);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "User not found!");
            return false;
        }
    }
    
    private void updatePasswordFile(String oldUserID, String newUserID) {
        List<String> passwordLines = filePassword.readFile();
        List<String> updatedPasswordLines = new ArrayList<>();
        
        for (String line : passwordLines) {
            String[] parts = line.split(";");
            if (parts.length > 0 && parts[0].equals(oldUserID)) {
                String newLine = newUserID + ";" + (parts.length > 1 ? parts[1] : "");
                updatedPasswordLines.add(newLine);
            } else {
                updatedPasswordLines.add(line);
            }
        }
        
        filePassword.writeFile(updatedPasswordLines);
    }
    
    private void deleteFromPasswordFile(String userID) {
        List<String> passwordLines = filePassword.readFile();
        List<String> updatedPasswordLines = new ArrayList<>();
        
        for (String line : passwordLines) {
            String[] parts = line.split(";");
            if (parts.length > 0 && !parts[0].equals(userID)) {
                updatedPasswordLines.add(line);
            }
        }
        
        filePassword.writeFile(updatedPasswordLines);
    }
    
    public List<Payment> viewFeedback() {
        List<Payment> payments = new ArrayList<>();
        List<String> allLines = payment_feedback.readFile();

        for (String line : allLines) {
            if (line == null || line.isBlank()) continue;
            String[] v = line.split(";");

            if (v.length < 12) {
                System.out.println("Invalid payment line (skipped): " + line);
                continue;
            }
            String[] consulation = v[7]
                    .replace("[", "")
                    .replace("]", "")
                    .split(",");

            double[] consulationPrice = Arrays.stream(
                    v[8].replace("[", "").replace("]", "").split(","))
                    .filter(s -> !s.isBlank())
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            String[] medication = v[9]
                    .replace("[", "")
                    .replace("]", "")
                    .split(",");
            for (int i = 0; i < medication.length; i++) {
                medication[i] = medication[i].trim();
            }

            double[] medicationPrice = Arrays.stream(
                    v[10].replace("[", "").replace("]", "").split(","))
                    .filter(s -> !s.isBlank())
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            // If old record (12 fields), fill in defaults
            String paymentMethod = v.length > 12 ? v[12] : "N/A";
            double amountPaid = v.length > 13 ? Double.parseDouble(v[13]) : 0.0;
            double balance = v.length > 14 ? Double.parseDouble(v[14]) : 0.0;

            Payment p = new Payment(
                v[0], v[1], v[2], v[3],
                v[4], Double.parseDouble(v[5]),
                v[6], consulation,
                consulationPrice,
                medication, medicationPrice,
                v[11], paymentMethod,
                amountPaid, balance
            );
            payments.add(p);
        }
        return payments;
    }
    
    public List<Comment> viewComments() {
        List<Comment> comments = new ArrayList<>();
        List<String> lines = comment.readFile(); 
        
        for (String line : lines) {
            String[] eachLineValues = line.split(";", -1); 
            Comment newRow = new Comment(
                    eachLineValues[0], // custID
                    eachLineValues[1], // employeeID
                    eachLineValues[2], // comment
                    eachLineValues[3] // date
            );
            comments.add(newRow);
        }
        return comments;
    }
    
    public Report generateAnalyzedReport(String startDate, String endDate) {
        ReportDetails appointmentReport = reportGenerator.generateAppointmentReport(startDate, endDate);
        ReportDetails doctorReport = reportGenerator.generateDoctorPerformance(startDate, endDate);
        ReportDetails revenueReport = reportGenerator.generateRevenueReport(startDate, endDate);
        ReportDetails feedbackReport = reportGenerator.generateFeedbackAndCommentsReport(startDate, endDate);

        LocalDateTime now = LocalDateTime.now();
        String nowDateAndTime = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        
        Random rn = new Random();
        int reportID = rn.nextInt(10000000, 100000000);
        
        return new Report(
            "APU Medical Centre",
            "Jalan Teknologi 5, Taman Teknologi Malaysia, 57000 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur",
            nowDateAndTime,
            reportID,
            startDate.replace("-", "/"),
            endDate.replace("-", "/"),
            appointmentReport,
            doctorReport,
            revenueReport,
            feedbackReport
        );
    }
}
