package assignment;

import java.util.*;

public class Doctor extends Employee{
    
    public Doctor(String id, String fullName, String gender){
        super(id, fullName, null, null, null, gender, null, null, "Doctor", 0.0);
    }

    public Doctor(String id, String fullName, String ic, String email,
                  String dob, String gender, String phoneNumber, String nationality,
                  double salary) {
        super(id, fullName, ic, email, dob, gender, phoneNumber, nationality,
              "Doctor", salary);  // pass role directly
    }

    
    public List<String[]> getAllAppointments() {
        FileHandler appointmentFile = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\appointment_request.txt");
        FileHandler historyFile = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\appointment_history.txt");
        
        List<String[]> allAppointments = new ArrayList<>();
        
        // Current appointments
        List<String> currentLines = appointmentFile.findLinesByColumn(7, getId()); // userID at column 7
        for (String line : currentLines) {
            allAppointments.add(line.split(";"));
        }
        
        // Historical appointments
        List<String> historyLines = historyFile.findLinesByColumn(7, getId()); // userID at column 7
        for (String line : historyLines) {
            allAppointments.add(line.split(";"));
        }
        
        return allAppointments;
    }
    

    public List<String[]> getAppointmentsByStatus(String status) {
        List<String[]> allAppointments = getAllAppointments();
        List<String[]> filtered = new ArrayList<>();
        
        for (String[] appointment : allAppointments) {
            if (appointment.length > 9 && appointment[9].equals(status)) { // status at index 9
                filtered.add(appointment);
            }
        }
        return filtered;
    }
    
     public boolean addConsultation(String appointmentId, String consultation, 
                                 String medication, String feedback) {
        FileHandler paymentFile = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\payment.txt");
        List<String> lines = paymentFile.readFile();
        
        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(";");
            if (parts.length > 1 && parts[1].equals(appointmentId)) { // appointmentID at index 1
                if (parts.length > 7) parts[7] = consultation;    // consultation
                if (parts.length > 9) parts[9] = medication;      // medication
                if (parts.length > 11) parts[11] = feedback;      // feedback
                if (parts.length > 6) parts[6] = getId();         // userID (doctor ID)
                
                lines.set(i, String.join(";", parts));
                paymentFile.writeFile(lines);
                return true;
            }
        }
        return false;
    }
    
    public boolean updateAppointmentStatus(String appointmentId, String newStatus) {
        FileHandler appointmentFile = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\appointment_request.txt");
        FileHandler historyFile = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\appointment_history.txt");
        
        List<String> lines = appointmentFile.readFile();
        
        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(";");
            if (parts.length > 0 && parts[0].equals(appointmentId)) { // appointmentID at index 0
                if (parts.length > 9) parts[9] = newStatus;
                
                String updatedLine = String.join(";", parts);
                
                if ("Completed".equals(newStatus) || "Cancelled".equals(newStatus)) {
                    historyFile.appendLine(updatedLine);
                    lines.remove(i);
                } else {
                    lines.set(i, updatedLine);
                }
                
                appointmentFile.writeFile(lines);
                return true;
            }
        }
        return false;
    }

    public boolean updateProfile(String fullName, String ic, String email, String dob,
                             String gender, String phone, String nationality) {
        setFullName(fullName);
        setIc(ic);
        setEmail(email);
        setDob(dob);
        setGender(gender);
        setPhoneNumber(phone);
        setNationality(nationality);

        return saveToFile();  // writes back to employee.txt
    }
    
    private boolean saveToFile() {
        FileHandler employeeFile = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\employee.txt");
        String newData = String.join(";", 
            "Doctor", getId(), getFullName(), getIc(), getEmail(),
            getDob(), getGender(), getPhoneNumber(), getNationality(), String.valueOf(getSalary())
        );
        return employeeFile.updateLine(getId(), 1, newData); // find by ID in column 1
    }
}
