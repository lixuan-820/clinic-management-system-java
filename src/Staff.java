package assignment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;

public class Staff extends Employee{

    private FileHandler customerFile;
    private FileHandler passwordFile;
    private FileHandler doctorAvailabilityFile;
    private FileHandler appointmentRequestFile;
    private FileHandler appointmentHistoryFile;
    private FileHandler paymentFile;
    private AutoGenerateID customerIDGen;
    private AutoGenerateID appointmentIDGen;
    private AutoGenerateID paymentIDGen;

    public Staff() {
        super();
        this.passwordFile = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\password.txt");
    }
    
    public Staff(String id, String fullName, String ic, String email,
             String dob, String gender, String phoneNumber, String nationality,
             double salary) {
        super(id, fullName, ic, email, dob, gender, phoneNumber, nationality, "Staff", salary);

        this.customerFile = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\customer.txt");
        this.passwordFile = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\password.txt");
        this.doctorAvailabilityFile = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\doctor_availability.txt");
        this.appointmentRequestFile = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\appointment_request.txt");
        this.appointmentHistoryFile = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\appointment_history.txt");
        this.paymentFile = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\payment.txt");

        this.customerIDGen = new AutoGenerateID(customerFile, "C");
        this.appointmentIDGen = new AutoGenerateID("A", appointmentRequestFile, appointmentHistoryFile);
        this.paymentIDGen = new AutoGenerateID(paymentFile, "P");
    }
    
    public String generateCustomerID(){
        return customerIDGen.generateID();
    }
    
    public void createCustomer(Customer customer) {
        List<String> lines = customerFile.readFile();
        lines.add(String.join(";", new String[]{
            customer.getCustomerID(),
            customer.getFullName(),
            customer.getIc(),
            customer.getEmail(),
            customer.getDob(),
            customer.getGender(),
            customer.getPhoneNumber(),
            customer.getNationality()
        }));
        customerFile.writeFile(lines);
        JOptionPane.showMessageDialog(null, "Customer "+customer.getCustomerID()+" created successfully!");
    }
     
    public void editCustomer(Customer customer) {
        List<String> lines = customerFile.readFile();
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith(customer.getCustomerID() + ";")) {
                lines.set(i, String.join(";", new String[]{
                    customer.getCustomerID(),
                    customer.getFullName(),
                    customer.getIc(),
                    customer.getEmail(),
                    customer.getDob(),
                    customer.getGender(),
                    customer.getPhoneNumber(),
                    customer.getNationality()
                }));
                break;
            }
        }
        customerFile.writeFile(lines);
    }
    
    public void deleteCustomer(String customerID) {
        List<String> lines = customerFile.readFile();
        List<String> updatedCustomer = new ArrayList<>();
        for (String line : lines) {
            if (!line.startsWith(customerID + ";")) {
                updatedCustomer.add(line);
            }
        }
        customerFile.writeFile(updatedCustomer);

        List<String> passwordLines = passwordFile.readFile();
        List<String> updatedPassword = new ArrayList<>();
        for (String line2 : passwordLines) {
            if (!line2.startsWith(customerID + ";")) {
                updatedPassword.add(line2);
            }
        }
        passwordFile.writeFile(updatedPassword);
    }
    
    public void removeCreatedCustomer(String customerID) {
        List<String> lines = customerFile.readFile();
        List<String> updated = new ArrayList<>();
        for (String line : lines) {
            if (!line.startsWith(customerID + ";")) {
                updated.add(line);
            }
        }
        customerFile.writeFile(updated);
    }
    
    public List<Customer> loadCustomers() {
        List<Customer> customers = new ArrayList<>();
        List<String> lines = customerFile.readFile();
        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length >= 8) {
                customers.add(new Customer(parts[0], parts[1], parts[2], parts[3],
                        parts[4], parts[5], parts[6], parts[7]));
            }
        }
        return customers;
    }
    
    public void setCustomerPassword(String customerID, String password) {
        passwordFile.appendLine(customerID + ";" + password);
    }
    
    public List<Doctor> loadDoctors(String employeeFilePath) {
        List<Doctor> doctors = new ArrayList<>();
        FileHandler employeeFile = new FileHandler(employeeFilePath);
        List<String> lines = employeeFile.readFile();

        for (String line : lines) {
            String[] parts = line.split(";", -1);
            if (parts.length >= 10 && "Doctor".equalsIgnoreCase(parts[0].trim())) {
                doctors.add(new Doctor(
                    parts[1].trim(),  // id
                    parts[2].trim(),  // fullName
                    parts[3].trim(),  // ic
                    parts[4].trim(),  // email
                    parts[5].trim(),  // dob
                    parts[6].trim(),  // gender
                    parts[7].trim(),  // phone
                    parts[8].trim(),  // nationality
                    Double.parseDouble(parts[9].trim()) // salary
                ));
                System.out.println("Loaded doctor: " + parts[1] + " " + parts[2]);
            }
        }
        return doctors;
    }
    
    public List<DoctorAvailability> loadDoctorAvailability() {
        List<DoctorAvailability> list = new ArrayList<>();
        for (String line : doctorAvailabilityFile.readFile()) {
             if (line.isBlank()) continue;
        String[] parts = line.split(";", -1); // use tab if your file is tab-separated
        if (parts.length < 5) continue;        // skip malformed lines
        DoctorAvailability d = new DoctorAvailability(
            parts[0], parts[1], parts[2], parts[3], parts[4]
        );
        list.add(d);
        }    
        return list;
    }
    
    public List<Appointment> viewAppointment() {
        List<Appointment> appointments = new ArrayList<>();
        List<String> lines = appointmentRequestFile.readFile();
        for (String line : lines) {
            String[] parts = line.split(";", -1);
            if (parts.length >= 10) {
                appointments.add(new Appointment(parts[0], parts[1], parts[2], parts[3],
                        parts[4], parts[5], parts[6], parts[7], parts[8], parts[9]));
            }
        }
        return appointments;
    }
    
    public String generateAppointmentID() {
        return appointmentIDGen.generateID();
    }
    
    public boolean checkDoctorAvailability(Appointment app) {
        List<String> doctorLines = doctorAvailabilityFile.readFile();
        for(String line : doctorLines) {
            String[] parts = line.split(";", -1);
            if(parts.length >= 5 && parts[0].equals(app.getDoctorID()) &&
               parts[3].equals(app.getDate()) && parts[4].equals(app.getTime())) {
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Selected doctor is not available at this date and time.");
        return false;
    }

    public void refreshAllDoctorAvailability(String doctorFilePath, int restHour) {
        DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        List<Doctor> doctors = loadDoctors(doctorFilePath);

        Set<String> bookedSlots = new HashSet<>();
        List<String> appointmentLines = appointmentHistoryFile.readFile();

        for (String line : appointmentLines) {
            String[] parts = line.split(";", -1);  // split into columns
            if (parts.length >= 10) { // make sure we have enough columns
                String status = parts[9].trim();
                if ("In-Queue".equalsIgnoreCase(status) || "Completed".equalsIgnoreCase(status)) {
                    String doctorId = parts[7].trim();
                    String date = parts[5].trim();
                    String time = parts[6].trim();
                    bookedSlots.add(doctorId + ";" + date + ";" + time);
                }
            }
        }

        // Read current doctor availability
        List<String> lines = doctorAvailabilityFile.readFile();
        LocalDate today = LocalDate.now();

        // Remove expired slot
        lines.removeIf(line -> {
            String[] parts = line.split(";", -1);
            if (parts.length < 5) return false;
            try {
                LocalDate slotDate = LocalDate.parse(parts[3].trim(), DATE_FORMAT);
                return slotDate.isBefore(today);
            } catch (Exception e) {
                return false;
            }
        });

        LocalDate lastDate = today.plusDays(6);

        Set<String> validDoctorIds = new HashSet<>();
        for (Doctor doctor : doctors) {
            if (doctor != null && doctor.getId() != null) {
                validDoctorIds.add(doctor.getId());
            }
        }

        lines.removeIf(l -> {
            String[] parts = l.split(";", -1);
            if (parts.length < 1) return false;
            String doctorId = parts[0].trim();
            return !validDoctorIds.contains(doctorId);
        });

        for (Doctor doctor : doctors) {
            if (doctor == null || doctor.getId() == null) continue;

            lines.removeIf(l -> {
                String[] parts = l.split(";", -1);
                return parts.length >= 1 && parts[0].equals(doctor.getId());
            });

            for (LocalDate loopDate = today; !loopDate.isAfter(lastDate); loopDate = loopDate.plusDays(1)) {
                String dateStr = loopDate.format(DATE_FORMAT);

                for (int hour = 9; hour < 20; hour++) {
                    if (hour == restHour) continue;
                    String time = String.format("%02d:00", hour);

                    String slotKey = doctor.getId() + ";" + dateStr + ";" + time;
                    if (bookedSlots.contains(slotKey)) {
                        continue;
                    }

                    lines.add(String.join(";", new String[]{
                            doctor.getId(),
                            doctor.getFullName(),
                            doctor.getGender(),
                            dateStr,
                            time
                    }));
                }
            }
        }

        lines.sort((a, b) -> {
            String[] pa = a.split(";", -1);
            String[] pb = b.split(";", -1);

            int cmp = pa[0].compareTo(pb[0]);
            if (cmp != 0) return cmp;

            cmp = pa[3].compareTo(pb[3]);
            if (cmp != 0) return cmp;

            return pa[4].compareTo(pb[4]);
        });

        doctorAvailabilityFile.writeFile(lines);
    }
    
    public boolean bookAppointment(Appointment app){
        if(!checkDoctorAvailability(app)) return false;
        updateAppointmentRequestFile(app, "Book");
        updateAppointmentHistoryFile(app, "Book");
        removeDoctorSlot(app.getDoctorID(), app.getDate(), app.getTime());
        JOptionPane.showMessageDialog(null, "Appointment " + app.getAppointmentID() + " booked successfully.");
        return true;
    }
    
    public boolean cancelAppointment(Appointment app){
        String doctorId = app.getDoctorID();
        String date = app.getDate();
        String time = app.getTime();

        updateAppointmentRequestFile(app, "Cancel");
        updateAppointmentHistoryFile(app, "Cancel");
        returnDoctorSlot(doctorId, date, time);
        JOptionPane.showMessageDialog(null, "Appointment " + app.getAppointmentID() + " cancelled.");
        return true;
    }
    
     public boolean approveAppointment(Appointment app){
        updateAppointmentRequestFile(app, "Approve");
        updateAppointmentHistoryFile(app, "Approve");
        removeDoctorSlot(app.getDoctorID(), app.getDate(), app.getTime());
        JOptionPane.showMessageDialog(null,"Appointment "+app.getAppointmentID()+" approved.");
        return true;
    }

    public boolean rejectAppointment(Appointment app){
        updateAppointmentRequestFile(app, "Reject");
        returnDoctorSlot(app.getDoctorID(), app.getDate(), app.getTime());
        JOptionPane.showMessageDialog(null,"Appointment "+app.getAppointmentID()+" rejected.");
        return true;
    }
    
    private void updateAppointmentRequestFile(Appointment app, String action){
        List<String> lines = appointmentRequestFile.readFile();
        if(action.equals("Book")){
            app.setStatus("Approved");
            lines.add(app.toFileString());
        }else if(action.equals("Cancel")){
            List<String> updated = new ArrayList<>();
            for(String line: lines){
                if(!line.startsWith(app.getAppointmentID()+";")){
                    updated.add(line);
                }
            }
            lines = updated;
        }else if(action.equals("Reject")){
            List<String> updated = new ArrayList<>();
            for (String line : lines) {
                String[] parts = line.split(";", -1);
                if (parts[0].equals(app.getAppointmentID()) && parts[parts.length - 1].equals("Pending")) {
                    app.setStatus("Rejected");
                    updated.add(app.toFileString());
                } else {
                    updated.add(line);
                }
            }
            lines = updated;
        }else if(action.equals("Approve")){
            List<String> updated = new ArrayList<>();
            for (String line : lines) {
                String[] parts = line.split(";", -1);
                if (parts[0].equals(app.getAppointmentID()) && parts[parts.length - 1].equals("Pending")) {
                    app.setStatus("Approved");
                    updated.add(app.toFileString());
                } else {
                    updated.add(line);
                }
            }
            lines = updated;
        }
        appointmentRequestFile.writeFile(lines);
    }
    
    private void updateAppointmentHistoryFile(Appointment app, String action){
        List<String> historyLines = appointmentHistoryFile.readFile();
        List<String> updated = new ArrayList<>();
        boolean found = false;

        if(action.equals("Book") || action.equals("Approve")){
            app.setStatus("In-Queue");
            historyLines.add(app.toFileString());
            appointmentHistoryFile.writeFile(historyLines);
        }else if(action.equals("Cancel")){
            for(String line: historyLines){
                String[] parts = line.split(";", -1);
                if(parts[0].equals(app.getAppointmentID()) && parts[parts.length-1].equals("In-Queue")){
                    parts[parts.length-1] = "Cancelled";
                    updated.add(String.join(";", parts));
                    found = true;
                } else {
                    updated.add(line);
                }
            }
            
            if(!found){
                app.setStatus("Cancelled");
                updated.add(app.toFileString());
            }
            
            appointmentHistoryFile.writeFile(updated);
        }
    }
    
    private void removeDoctorSlot(String doctorID, String date, String time){
        List<String> lines = doctorAvailabilityFile.readFile();
        List<String> updated = new ArrayList<>();
        for(String line: lines){
            String[] parts = line.split(";", -1);
            if(!(parts[0].equals(doctorID) && parts[3].equals(date) && parts[4].equals(time))){
                updated.add(line);
            }
        }
        doctorAvailabilityFile.writeFile(updated);
    }

    private void returnDoctorSlot(String doctorID, String date, String time){
        List<String> lines = doctorAvailabilityFile.readFile();
        String doctorName = "", doctorGender = "";
        boolean alreadyExists = false;

        for(String line: lines){
            String[] parts = line.split(";", -1);
            if(parts[0].equals(doctorID)){
                doctorName = parts[1];
                doctorGender = parts[2];
            }
            if(parts.length >= 5 && parts[0].equals(doctorID) && parts[3].equals(date) && parts[4].equals(time)){
                alreadyExists = true;
            }
        }

        if(!doctorID.isEmpty() && !doctorName.isEmpty() && !alreadyExists){
            String slotLine = doctorID + ";" + doctorName + ";" + doctorGender + ";" + date + ";" + time;
            doctorAvailabilityFile.appendLine(slotLine);
        }
    }
    
    public List<String> getAvailableDates(){
        List<String> lines = doctorAvailabilityFile.readFile();
        Set<String> dateSet = new TreeSet<>();
        for(String line: lines){
            String[] parts = line.split(";",-1);
            if(parts.length>3) dateSet.add(parts[3]);
        }
        return new ArrayList<>(dateSet);
    }

    public List<String> getAvailableTimes(String date){
        List<String> lines = doctorAvailabilityFile.readFile();
        Set<String> timeSet = new TreeSet<>();
        for(String line: lines){
            String[] parts = line.split(";",-1);
            if(parts.length>4 && parts[3].equals(date)) timeSet.add(parts[4]);
        }
        return new ArrayList<>(timeSet);
    }

    public List<String> getAvailableDoctors(String date, String time){
        List<String> lines = doctorAvailabilityFile.readFile();
        Set<String> doctorSet = new LinkedHashSet<>();
        for(String line: lines){
            String[] parts = line.split(";",-1);
            if(parts.length>2 && parts[3].equals(date) && parts[4].equals(time)) doctorSet.add(parts[1]);
        }
        return new ArrayList<>(doctorSet);
    }
    
    public void savePayment(Payment payment) {
        List<String> lines = paymentFile.readFile();
        List<String> updated = new ArrayList<>();
        boolean updatedFlag = false;

        for (String line : lines) {
            String[] parts = line.split(";", -1);
            if (parts.length >= 15 && parts[1].equals(payment.getAppointmentID())) {
                updated.add(payment.toString());
                updatedFlag = true;
            } else {
                updated.add(line);
            }
        }
        if (!updatedFlag) {
            updated.add(payment.toString());
        }
        paymentFile.writeFile(updated);
    }
    
    public List<Payment> loadPendingAppointment() {
        List<String> lines = paymentFile.readFile();
        List<Payment> pending = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(";", -1);
            if (parts.length >= 6 && parts[0].isEmpty()) {
                Payment p = new Payment(
                    "", parts[1], parts[2], parts[3], parts[4],
                    Double.parseDouble(parts[5]), parts[6], new String[]{}, new double[]{},
                    new String[]{}, new double[]{}, "", "", 0.0, 0.0
                );
                pending.add(p);
            }
        }
        return pending;
    }
    
    public List<Payment> loadCompletedPayment() {
        List<String> lines = paymentFile.readFile();
        List<Payment> completed = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(";", -1);
            if (parts.length >= 15 && !parts[0].isEmpty()) {
                Payment p = new Payment(
                    parts[0], parts[1], parts[2], parts[3], parts[4],
                    Double.parseDouble(parts[5]), parts[6],
                    parts[7].replace("[", "").replace("]", "").split(","),
                    parseDoubleArray(parts[8]),
                    parts[9].replace("[", "").replace("]", "").split(","),
                    parseDoubleArray(parts[10]),
                    parts[11], parts[12],
                    Double.parseDouble(parts[13]),
                    Double.parseDouble(parts[14])
                );
                completed.add(p);
            }
        }
        return completed;
    }
     
    private double[] parseDoubleArray(String text) {
        if (text == null || text.trim().length() <= 2) return new double[]{};
        String[] strArr = text.replace("[", "").replace("]", "").split(",");
        double[] arr = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Double.parseDouble(strArr[i].trim());
        }
        return arr;
    }
    
    public double calculateBalance(double totalAmount, double amountPaid) {
        return amountPaid - totalAmount;
    }

    public Payment confirmPayment(String appointmentID, String customerID, String fullName,
                                  String date, double totalAmount, double amountPaid,
                                  String paymentMethod) {
        String paymentID = paymentIDGen.generateID();
        double balance = calculateBalance(totalAmount, amountPaid);

         List<String> lines = paymentFile.readFile();
        String doctorID = "";
        String[] consultation = new String[]{};
        double[] consultationPrice = new double[]{};
        String[] medication = new String[]{};
        double[] medicationPrice = new double[]{};
        String feedback = "";

        for (String line : lines) {
            String[] parts = line.split(";", -1);
            if (parts.length >= 15 && parts[1].equals(appointmentID)) {
                doctorID = parts[6];
                consultation = parts[7].replace("[", "").replace("]", "").split(",");
                consultationPrice = parseDoubleArray(parts[8]);
                medication = parts[9].replace("[", "").replace("]", "").split(",");
                medicationPrice = parseDoubleArray(parts[10]);
                feedback = parts[11];
                break;
            }
        }

        Payment payment = new Payment(paymentID, appointmentID, customerID, fullName, date,
                totalAmount, doctorID, consultation, consultationPrice,
                medication, medicationPrice, feedback,
                paymentMethod, amountPaid, balance);

        savePayment(payment);
        return payment;
    }
}
