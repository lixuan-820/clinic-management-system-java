package assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Appointment {
    private String appointmentID;
    private String customerID;
    private String fullName;
    private String gender;
    private String phoneNumber;
    private String date;              
    private String time;
    private String doctorID;
    private String specialRequest;
    private String status;

    public Appointment(String appointmentID, String customerID, String fullName, String gender,
                       String phoneNumber, String date, String time, String doctorID,
                       String specialRequest, String status) {
        this.appointmentID = appointmentID;
        this.customerID = customerID;
        this.fullName = fullName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.time = time;
        this.doctorID = doctorID;
        this.specialRequest = specialRequest;
        this.status = status;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
public static List<Appointment> loadAppointmentsForDoctor(String doctorId) {
    FileHandler fh = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\appointment_history.txt");
    List<String> rows = fh.readFile();
    List<Appointment> result = new ArrayList<>();

    for (String line : rows) {
        String[] p = line.split(";");
        if (p.length >= 10) {
            String fileDoctorId = p[7];
            if(fileDoctorId.equals(doctorId)){
                Appointment appt = new Appointment(
                    p[0], // ApptID
                    p[1], // CustomerID
                    p[2], // CustomerName
                    p[3], // Gender
                    p[4], // Phone
                    p[5], // Date
                    p[6], // Time
                    p[7], // DoctorID
                    p[8], // Request
                    p[9]  // Status
                );

                if (appt.getDoctorID().equalsIgnoreCase(doctorId) 
                        && appt.getStatus().equalsIgnoreCase("In-Queue")) {
                    result.add(appt);
                }
            }
        }
    }
    return result;
}

public static List<Appointment> loadAppointmentsHistoryForDoctor(String doctorId) {
    FileHandler fh = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\appointment_history.txt");
    List<String> rows = fh.readFile();
    List<Appointment> result = new ArrayList<>();

    for (String line : rows) {
        String[] p = line.split(";");
        if (p.length >= 10) {
            String fileDoctorId = p[7];
            if(fileDoctorId.equals(doctorId)){
                Appointment appt = new Appointment(
                    p[0], // ApptID
                    p[1], // CustomerID
                    p[2], // CustomerName
                    p[3], // Gender
                    p[4], // Phone
                    p[5], // Date
                    p[6], // Time
                    p[7], // DoctorID
                    p[8], // Request
                    p[9]  // Status
                );

                if (appt.getDoctorID().equalsIgnoreCase(doctorId) 
                        && appt.getStatus().equalsIgnoreCase("Completed") || appt.getStatus().equalsIgnoreCase("Cancelled")) {
                    result.add(appt);
                }
            }
        }
    }
    return result;
}

public static void loadAppointments(JTable table, List<Appointment> appointments) {
    String[] cols = {
        "Appointment ID","Customer ID","Full Name","Gender","Phone Number",
        "Date","Time","Doctor ID","Special Request","Status"
    };

    DefaultTableModel model = new DefaultTableModel(cols, 0);

    for (Appointment appt : appointments) {
        model.addRow(new Object[]{
            appt.getAppointmentID(),
            appt.getCustomerID(),
            appt.getFullName(),
            appt.getGender(),
            appt.getPhoneNumber(),
            appt.getDate(),
            appt.getTime(),
            appt.getDoctorID(),
            appt.getSpecialRequest(),
            appt.getStatus()
        });
    }

    table.setModel(model);
    table.setRowSorter(new TableRowSorter<>(model)); // enable sort/search
}

    private static final Path FILE = Path.of("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\appointment_request.txt");
    private static final Path HIST_FILE = Path.of("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\appointment_history.txt");
    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    
    private static void ensureParentDir() throws java.io.IOException {
        Path parent = FILE.getParent();
        if (parent != null) Files.createDirectories(parent);
    }
    
    private static boolean endsWithNewline(Path file) throws java.io.IOException {
        long size = Files.size(file);
        if (size == 0) return true;
        try (SeekableByteChannel ch = Files.newByteChannel(file, StandardOpenOption.READ)) {
            ch.position(size - 1);
            ByteBuffer buf = ByteBuffer.allocate(1);
            ch.read(buf);
            byte last = buf.array()[0];
            return last == '\n' || last == '\r';
        }
    }

    public void save() throws java.io.IOException {
        ensureParentDir(); //make sure data/ exists

        boolean needExtraNewline = Files.exists(FILE)
                && Files.size(FILE) > 0
                && !endsWithNewline(FILE);

        try (BufferedWriter bw = Files.newBufferedWriter(
                FILE, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {

            if (needExtraNewline) {
                bw.newLine();
            }
            bw.write(this.toFileString());
            bw.newLine();
        }
    }
    
    public String toFileString() {
        // id;cust;full;gender;phone;date;time;userId;special;status
        String safeSpecial = specialRequest == null ? "" : //if special request is null, use " "
                specialRequest.replace(';', ',').replace("\r", " ").replace("\n", " ").trim();
        return String.join(";",
                nullToEmpty(appointmentID),
                nullToEmpty(customerID),
                nullToEmpty(fullName),
                nullToEmpty(gender),
                nullToEmpty(phoneNumber),
                nullToEmpty(date),
                nullToEmpty(time),
                nullToEmpty(doctorID),
                safeSpecial,
                nullToEmpty(status)
        );
    }
    
    private static String nullToEmpty(String s) { return s == null ? "" : s; }

    
    public static synchronized String nextId() throws java.io.IOException {
        if (!Files.exists(FILE)) return "A001";
        String last = null;
        try (BufferedReader br = Files.newBufferedReader(FILE, StandardCharsets.UTF_8)) {
            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                if (first) {
                    first = false;
                    String low = line.trim().toLowerCase();
                    // if you ever add a header like "appointmentID;...", skip it
                    if (low.startsWith("appointmentid;")) continue;
                }
                if (!line.isBlank()) last = line;
            }
        }
        if (last == null) return "A001";
        String[] parts = last.split(";", -1);
        if (parts.length == 0) return "A001";
        String prev = parts[0];
        int n = 0;
        try { n = Integer.parseInt(prev.replaceAll("\\D", "")); } catch (NumberFormatException ignored) {}
        return String.format("A%03d", n + 1);
    }
    
    public static String normalizeTo10(String[] r) {
        // r comes from request file (9 or 10 columns)
        String id      = r.length > 0 ? r[0].trim() : "";
        String cust    = r.length > 1 ? r[1].trim() : "";
        String full    = r.length > 2 ? r[2].trim() : "";
        String gender  = r.length > 3 ? r[3].trim() : "";
        String phone   = r.length > 4 ? r[4].trim() : "";
        String date    = r.length > 5 ? r[5].trim() : "";
        String time    = r.length > 6 ? r[6].trim() : "";
        String userId, special, status;

        if (r.length >= 10) {
            userId  = r[7].trim();
            special = r[8].trim();
            status  = r[9].trim();
        } else { // 9 columns: no userId in request row
            userId  = "";               // fill empty userId
            special = r[7].trim();
            status  = r[8].trim();
        }
        return String.join(";", id, cust, full, gender, phone, date, time, userId, special, status);
    }
    
    private static void appendLine(Path file, String line) throws java.io.IOException {
        ensureParentDir(file);
        try (var bw = Files.newBufferedWriter(
                file, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            bw.write(line);
            bw.newLine();
        }
    }
    
    private static void ensureParentDir(Path file) throws java.io.IOException {
        Path parent = file.getParent();
        if (parent != null) Files.createDirectories(parent);
    }
    
    public static void moveRowToHistory(String[] r, String finalStatus) throws java.io.IOException {
        // set status
        if (r.length >= 10) {
            r[9] = finalStatus;
        } else if (r.length >= 9) {
            r[8] = finalStatus;
        }
        String line10 = normalizeTo10(r);
        appendLine(HIST_FILE, line10);
    }
}

    
