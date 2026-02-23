package assignment;

import java.io.*;
import java.util.*;

public class FileHandler {

    static List<String[]> readFile(String passwordtxt) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    private String filePath;
    
    public FileHandler(String filePath){
        this.filePath = filePath;
    }
    
    public List<String> readFile(){
        List<String> lines = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while((line = br.readLine()) != null){
                lines.add(line);
            }
            br.close();
        } 
        catch(IOException e){
            e.printStackTrace();
        }
        return lines;
    }
    
    public void writeFile(List<String> lines){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            for(String line:lines){
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } 
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void appendLine(String line){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
            bw.write(line);
            bw.newLine();
            bw.close();
        } 
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    // new
    public List<String> findLinesByColumn(int columnIndex, String searchValue) {
        List<String> lines = readFile();
        List<String> results = new ArrayList<>();
        
        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length > columnIndex && parts[columnIndex].equals(searchValue)) {
                results.add(line);
            }
        }
        return results;
    }
    
    public boolean updateLine(String searchValue, int searchColumn, String newLine) {
        List<String> lines = readFile();
        boolean found = false;
        
        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(";");
            if (parts.length > searchColumn && parts[searchColumn].equals(searchValue)) {
                lines.set(i, newLine);
                found = true;
                break;
            }
        }
        
        if (found) {
            writeFile(lines);
            return true;
        }
        return false;
    }

    public static Doctor loadDoctorByID(String userID) {
    FileHandler employeeFile = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\employee.txt");
    List<String> rows = employeeFile.readFile();

    for (String line : rows) {
        String[] parts = line.split(";");
        // Role, UserID, FullName, IC, Email, DOB, Gender, Phone, Nationality, Salary
        if (parts.length >= 10 && parts[1].equals(userID) && "Doctor".equals(parts[0])) {
            return new Doctor(
                parts[1], // UserID
                parts[2], // Full Name
                parts[3], // IC/Passport
                parts[4], // Email
                parts[5], // DOB
                parts[6], // Gender
                parts[7], // Phone
                parts[8], // Nationality
                Double.parseDouble(parts[9]) // Salary
            );
        }
    }
    return null;
}
    
    public static Customer loadCustomerByID(String userID) {
    FileHandler customerFile = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\customer.txt");
    List<String> rows = customerFile.readFile();

    for (String line : rows) {
        String[] parts = line.split(";");
        // Role, UserID, FullName, IC, Email, DOB, Gender, Phone, Nationality, Salary
        if (parts.length >= 7 && parts[0].equals(userID)) {
            return new Customer(
                parts[0],
                parts[1], // UserID
                parts[2], // Full Name
                parts[3], // IC/Passport
                parts[4], // Email
                parts[5], // DOB
                parts[6], // Gender
                parts[7] // Phone
            );
        }
    }
    return null;
}
    
    public static Staff loadStaffByID(String userID) {
    FileHandler staffFile = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\employee.txt");
    List<String> rows = staffFile.readFile();

    for (String line : rows) {
        String[] parts = line.split(";");

        if (parts.length >= 10 
            && parts[1].trim().equalsIgnoreCase(userID) 
            && parts[0].trim().equalsIgnoreCase("Staff")) {

            return new Staff(
                parts[1].trim(),  // UserID
                parts[2].trim(),  // Full Name
                parts[3].trim(),  // IC/Passport
                parts[4].trim(),  // Email
                parts[5].trim(),  // DOB
                parts[6].trim(),  // Gender
                parts[7].trim(),  // Phone
                parts[8].trim(),  // Nationality
                Double.parseDouble(parts[9].trim()) // Salary
            );
        }
    }
    return null; 
}

    public static boolean updatePassword(String filePath, String userID, String newPassword) {
    FileHandler fh = new FileHandler(filePath);
    List<String> lines = fh.readFile();
    boolean updated = false;

    for (int i = 0; i < lines.size(); i++) {
        String[] parts = lines.get(i).split(";");
        if (parts.length == 2 && parts[0].equals(userID)) {
            lines.set(i, userID + ";" + newPassword);
            updated = true;
            break;
        }
    }

    if (updated) {
        fh.writeFile(lines);
        return true;
    }
    return false;
}
    
    public static boolean updateAppointmentStatus(String appointmentID, String newStatus) {
        FileHandler appointmentFile = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\appointment_history.txt");
        List<String> lines = appointmentFile.readFile();
        boolean updated = false;

        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(";");

            if (parts.length > 9 && parts[0].equals(appointmentID)) {
                if (parts[9].equalsIgnoreCase("In-Queue")) { 
                    parts[9] = newStatus;  // update only if still In-Queue
                    lines.set(i, String.join(";", parts));
                    updated = true;
                }
                break;
            }
        }

        if (updated) {
            appointmentFile.writeFile(lines);  // overwrite file with new content
            return true;
        }
        return false;
    }

}
