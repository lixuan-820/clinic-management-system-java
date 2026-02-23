
package assignment;

import java.util.ArrayList;
import java.util.List;

public class Employee extends User{
    private String role;
    private double salary;
    
    public Employee(){
        super();
    }

    public Employee(String id, String fullName, String ic, String email, String dob,
                    String gender, String phoneNumber, String nationality,
                    String role, double salary) {
        super(id, fullName, ic, email, dob, gender, phoneNumber, nationality);
        this.role = role;
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public List<Appointment> viewAppointment() {
        FileHandler appointment = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\appointment_history.txt");
        List<Appointment> appointments = new ArrayList<>();
        List<String> lines = appointment.readFile(); 
        
        for (String line : lines) {
            String[] eachLineValues = line.split(";"); 
            Appointment newRow = new Appointment(
                    eachLineValues[0], // appointmentID
                    eachLineValues[1], // customerID
                    eachLineValues[2], // fullName
                    eachLineValues[3], // gender
                    eachLineValues[4], // phoneNumber
                    eachLineValues[5], // date
                    eachLineValues[6], // time
                    eachLineValues[7], // doctorID
                    eachLineValues[8], // specialRequest
                    eachLineValues[9]  // status
            );
            appointments.add(newRow);
        }
        return appointments;
    }
}
