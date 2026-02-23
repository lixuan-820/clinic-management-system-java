package assignment;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Payment {
    
    private static final Path PAYMENT_FILE = Path.of("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\payment.txt");
    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    
    private Payment() {}
    
    private String paymentID;
    private String appointmentID;
    private String customerID;
    private String fullName;
    private String date;
    private double totalAmount;
    private String doctorID;
    private String[] consultation;
    private double[] consultationPrice;
    private String[] medication;
    private double[] medicationPrice;
    private String feedback;
    private String paymentMethod;
    private double amountPaid;
    private double balance;
    
    private static FileHandler paymentFile;

        public Payment(String paymentID, String appointmentID, String customerID, String fullName,
                   String date, double totalAmount, String doctorID, String[] consultation,
                   double[] consultationPrice, String[] medication, double[] medicationPrice,
                   String feedback, String paymentMethod, double amountPaid, double balance) {
        this.paymentID = paymentID;
        this.appointmentID = appointmentID;
        this.customerID = customerID;
        this.fullName = fullName;
        this.date = date;
        this.totalAmount = totalAmount;
        this.doctorID = doctorID;
        this.consultation = consultation;
        this.consultationPrice = consultationPrice;
        this.medication = medication;
        this.medicationPrice = medicationPrice;
        this.feedback = feedback;
        this.paymentMethod = paymentMethod;
        this.amountPaid = amountPaid;
        this.balance = balance;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String[] getConsultation() {
        return consultation;
    }

    public void setConsultation(String[] consultation) {
        this.consultation = consultation;
    }

    public double[] getConsultationPrice() {
        return consultationPrice;
    }

    public void setConsultationPrice(double[] consultationPrice) {
        this.consultationPrice = consultationPrice;
    }

    public String[] getMedication() {
        return medication;
    }

    public void setMedication(String[] medication) {
        this.medication = medication;
    }

    public double[] getMedicationPrice() {
        return medicationPrice;
    }

    public void setMedicationPrice(double[] medicationPrice) {
        this.medicationPrice = medicationPrice;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public String toString() {
    return paymentID + ";" + appointmentID + ";" + customerID + ";" + fullName + ";" +
           date + ";" + totalAmount + ";" + doctorID + ";" +
           Arrays.toString(consultation).replaceAll("\\s+", "") + ";" +
           Arrays.toString(consultationPrice).replaceAll("\\s+", "") + ";" +
           Arrays.toString(medication).replaceAll("\\s+", "") + ";" +
           Arrays.toString(medicationPrice).replaceAll("\\s+", "") + ";" +
           (feedback == null ? "" : feedback) + ";" +
           (paymentMethod == null ? "" : paymentMethod) + ";" +
           (amountPaid == 0.0 ? "" : amountPaid) + ";" +
           (balance == 0.0 ? "" : balance);
}

    public void save() {
        FileHandler fh = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\payment.txt");
        fh.appendLine(toString());
    }
    
    public static class AppointmentRow {
        public String appointmentID, customerID, fullName, date, doctorID;
    }
    
    public static AppointmentRow loadAppointmentByID(String apptID) {
        FileHandler fh = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\appointment_history.txt");
        for (String line : fh.readFile()) {
            String[] p = line.split(";");
            // Ap001;C001;John Doe;Male;0123456789;2025/09/04;10:30;D001;No request;InQueue
            if (p.length >= 10 && p[0].equalsIgnoreCase(apptID)) {
                AppointmentRow r = new AppointmentRow();
                r.appointmentID = p[0];
                r.customerID    = p[1];
                r.fullName      = p[2];
                r.date          = p[5];
                r.doctorID      = p[7];
                return r;
            }
        }
        return null; // not found
    }
    public static final class FeedbackRow {
        private final String doctorId;
        private final String feedback;
        private final String date;   // yyyy/MM/dd

        public FeedbackRow(String doctorId, String feedback, String date) {
            this.doctorId = nz(doctorId);
            this.feedback = nz(feedback);
            this.date     = nz(date);
        }
        public String doctorId() { return doctorId; }
        public String feedback() { return feedback; }
        public String date()     { return date; }
    }

    /** Detailed row for charge history. */
    public static final class ChargeRow {
        private final String paymentId;
        private final String appointmentId;
        private final String customerId;
        private final String date;              // yyyy/MM/dd
        private final String totalAmount;
        private final String doctorId;
        private final String consultation;
        private final String consultationPrice;
        private final String medication;
        private final String medicationPrice;
        private final String paymentMethod;
        private final String amountPaid;
        private final String balance;

        public ChargeRow(
                String paymentId, String appointmentId, String customerId, String date,
                String totalAmount, String doctorId, String consultation, String consultationPrice,
                String medication, String medicationPrice, String paymentMethod,
                String amountPaid, String balance) {

            this.paymentId         = nz(paymentId);
            this.appointmentId     = nz(appointmentId);
            this.customerId        = nz(customerId);
            this.date              = nz(date);
            this.totalAmount       = nz(totalAmount);
            this.doctorId          = nz(doctorId);
            this.consultation      = nz(consultation);
            this.consultationPrice = nz(consultationPrice);
            this.medication        = nz(medication);
            this.medicationPrice   = nz(medicationPrice);
            this.paymentMethod     = nz(paymentMethod);
            this.amountPaid        = nz(amountPaid);
            this.balance           = nz(balance);
        }

        public String paymentId()         { return paymentId; }
        public String appointmentId()     { return appointmentId; }
        public String customerId()        { return customerId; }
        public String date()              { return date; }
        public String totalAmount()       { return totalAmount; }
        public String doctorId()          { return doctorId; }
        public String consultation()      { return consultation; }
        public String consultationPrice() { return consultationPrice; }
        public String medication()        { return medication; }
        public String medicationPrice()   { return medicationPrice; }
        public String paymentMethod()     { return paymentMethod; }
        public String amountPaid()        { return amountPaid; }
        public String balance()           { return balance; }
    }

    public static List<FeedbackRow> loadFeedbacks(String filterCustomerId) {
        List<FeedbackRow> out = new ArrayList<>();
        if (!Files.exists(PAYMENT_FILE)) return out;

        try (var br = Files.newBufferedReader(PAYMENT_FILE, StandardCharsets.UTF_8)) {
            String line; boolean first = true;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;

                // skip header if present
                if (first) {
                    first = false;
                    if (line.trim().toLowerCase().startsWith("paymentid;")) continue;
                }

                String[] r = line.split(";", -1);
                if (r.length < 12) continue;

                String cId      = r[2].trim();
                String date     = normalizeDate(r[4].trim());
                String doctorId = r[6].trim();
                String feedback = r[11].trim();

                if (feedback.isEmpty()) continue;
                if (hasFilter(filterCustomerId) && !filterCustomerId.equalsIgnoreCase(cId)) continue;

                out.add(new FeedbackRow(doctorId, feedback, date));
            }
        } catch (Exception ignored) {}
        return out;
    }

    public static List<ChargeRow> loadCharges(String filterCustomerId) {
        List<ChargeRow> out = new ArrayList<>();
        if (!Files.exists(PAYMENT_FILE)) return out;

        try (var br = Files.newBufferedReader(PAYMENT_FILE, StandardCharsets.UTF_8)) {
            String line; boolean first = true;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;

                // skip header if present
                if (first) {
                    first = false;
                    if (line.trim().toLowerCase().startsWith("paymentid;")) continue;
                }

                String[] r = line.split(";", -1);
                if (r.length < 15) continue;

                String paymentId   = r[0].trim();
                String apptId      = r[1].trim();
                String customerId  = r[2].trim();
                String date        = normalizeDate(r[4].trim());
                String total       = nvlNum(r[5]);
                String doctorId    = r[6].trim();
                String consultation= r[7].trim();
                String consultP    = nvlNum(r[8]);
                String medication  = r[9].trim();
                String medP        = nvlNum(r[10]);
                String payMethod   = r[12].trim();
                String amountPaid  = nvlNum(r[13]);
                String balance     = nvlNum(r[14]);

                if (hasFilter(filterCustomerId) && !filterCustomerId.equalsIgnoreCase(customerId)) continue;

                out.add(new ChargeRow(
                        paymentId, apptId, customerId, date,
                        total, doctorId, consultation, consultP,
                        medication, medP, payMethod, amountPaid, balance
                ));
            }
        } catch (Exception ignored) {}
        return out;
    }

    private static boolean hasFilter(String s) { return s != null && !s.isBlank(); }

    private static String normalizeDate(String s) {
        if (s == null || s.isBlank()) return "";
        if (s.contains("/")) return s;                // already yyyy/MM/dd
        try { return LocalDate.parse(s).format(DF); } // from yyyy-MM-dd
        catch (Exception ignored) { return s; }
    }

    private static String nvlNum(String s) {
        if (s == null) return "0";
        s = s.trim();
        return s.isEmpty() ? "0" : s;
    }

    private static String nz(String s) { return (s == null) ? "" : s; }
}
