
package assignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GenerateReportContents {
    
    private FileHandler appointment = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\appointment_history.txt");
    private FileHandler payment_feedback = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\payment.txt");
    private FileHandler comment = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\cust_cmt.txt");
    
    public ReportDetails generateAppointmentReport(String startDate, String endDate) {
        List<String[]> rows = new ArrayList<>();
        List<String> allLines = appointment.readFile();
        int totalCompleted = 0;
        int totalCancelled = 0;
        int totalInQueue = 0;
        int totalAppointments = 0;
        double averageAppointments = 0.0;
        
        for (String line : allLines) {
            String[] eachLineValues = line.split(";");
            LocalDate appointmentDate = LocalDate.parse(eachLineValues[5].replace("/", "-"));
            String status = eachLineValues[9];

            if (!appointmentDate.isBefore(LocalDate.parse(startDate)) && !appointmentDate.isAfter(LocalDate.parse(endDate))) {
                rows.add(new String[]{eachLineValues[0], eachLineValues[1], eachLineValues[5], eachLineValues[6], eachLineValues[7], eachLineValues[8], status});

                if (status.equals("Completed")) {
                    totalCompleted++;
                } else if (status.equals("Cancelled")) {
                    totalCancelled++;
                }
                else if (status.equals("In-queue")) {
                    totalInQueue++;
                }
                totalAppointments++;
            }
        }

        long days = java.time.temporal.ChronoUnit.DAYS.between(LocalDate.parse(startDate), LocalDate.parse(endDate)) + 1;
        averageAppointments = Math.round((totalAppointments / (double) days) * 100) / 100.0;

        String[] reportValues = {String.valueOf(totalCompleted), String.valueOf(totalCancelled), String.valueOf(totalAppointments), String.valueOf(averageAppointments), String.valueOf(totalInQueue)};
        ReportDetails appointmentReport = new ReportDetails(rows, reportValues);
        return appointmentReport;
    }
    
    public ReportDetails generateDoctorPerformance(String startDate, String endDate) {
        List<String[]> rows = new ArrayList<>();
        List<String> allLines = appointment.readFile();

        String[] doctorIDs = new String[100];
        int[] consultationCount = new int[100];
        int index = 0, totalConsultations = 0;

        for (String line : allLines) {
            String[] eachLineValues = line.split(";");
            LocalDate appointmentDate = LocalDate.parse(eachLineValues[5].replace("/", "-"));
            String status = eachLineValues[9];
            String doctorID = eachLineValues[7];

            if (!appointmentDate.isBefore(LocalDate.parse(startDate)) && !appointmentDate.isAfter(LocalDate.parse(endDate)) && status.equals("Completed")) {
                boolean found = false;
                for (int i = 0; i < index; i++) {
                    if (doctorIDs[i].equals(doctorID)) {
                        consultationCount[i]++;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    doctorIDs[index] = doctorID;
                    consultationCount[index] = 1;
                    index++;
                }
                totalConsultations++;
            }
        }

        for (int i = 0; i < index; i++) {
            rows.add(new String[]{doctorIDs[i], String.valueOf(consultationCount[i])});
        }

        String[] reportValues;
        if (index > 0) {
            int max = consultationCount[0];
            for (int i = 1; i < index; i++) {
                if (consultationCount[i] > max) {
                    max = consultationCount[i];
                }
            }

            List<String> busiestDoctors = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                if (consultationCount[i] == max) {
                    busiestDoctors.add(doctorIDs[i]);
                }
            }

            String busiestDoctorStr = String.join(", ", busiestDoctors);
            String numOfPatients = String.valueOf(max);
            double averageConsultations = Math.round((totalConsultations / (double) index) * 100) / 100.0;

            reportValues = new String[]{busiestDoctorStr, numOfPatients, String.valueOf(averageConsultations)};
        } else {
            reportValues = new String[]{"null", "0", "0"};
        }

        return new ReportDetails(rows, reportValues);
    }
    
    public ReportDetails generateRevenueReport(String startDate, String endDate) {
        List<String[]> rows = new ArrayList<>();
        List<String> allLines = payment_feedback.readFile();

        String methods[] = {"Cash", "Debit/Credit Card", "Touch N Go", "Online Banking"};
        double totalMethodRevenue[] = new double[4];
        double totalRevenue = 0;

        for (String line : allLines) {
            String[] eachLineValues = line.split(";", -1);
            LocalDate paymentDate = LocalDate.parse(eachLineValues[4].replace("/", "-"));

            if (!paymentDate.isBefore(LocalDate.parse(startDate)) && !paymentDate.isAfter(LocalDate.parse(endDate))) {
                rows.add(new String[]{eachLineValues[0], eachLineValues[1], eachLineValues[12], eachLineValues[5], eachLineValues[4]}); 

                for (int i = 0; i < methods.length; i++) {
                    if (eachLineValues[12].equals(methods[i])) {
                        totalMethodRevenue[i] += Double.parseDouble(eachLineValues[5]);
                        break;
                    }
                }
                totalRevenue += Double.parseDouble(eachLineValues[5]);
            }
        }

        String[] reportValues = {String.valueOf(totalMethodRevenue[0]), // Cash
                                 String.valueOf(totalMethodRevenue[1]), // Card
                                 String.valueOf(totalMethodRevenue[2]), // TnG
                                 String.valueOf(totalMethodRevenue[3]),  // Online
                                 String.valueOf(totalRevenue)};

        return new ReportDetails(rows, reportValues);
    }

    public ReportDetails generateFeedbackAndCommentsReport(String startDate, String endDate) {
        List<String[]> rows = new ArrayList<>();
        int doctorToCust = 0, custToDoctor = 0, custToStaff = 0, totalReceived = 0;

        List<String> allLines1 = payment_feedback.readFile();
        for (String line : allLines1) {
            String[] eachLineValues = line.split(";", -1);
            LocalDate paymentDate = LocalDate.parse(eachLineValues[4].replace("/", "-"));

            if (!paymentDate.isBefore(LocalDate.parse(startDate)) && !paymentDate.isAfter(LocalDate.parse(endDate))) {
                rows.add(new String[]{eachLineValues[6], eachLineValues[2], eachLineValues[11], eachLineValues[4]}); 
                doctorToCust++;
                totalReceived++;
            }
        }

        List<String> allLines2 = comment.readFile();
        for (String line : allLines2) {
            String[] eachLineValues = line.split(";");
            LocalDate commentDate = LocalDate.parse(eachLineValues[3].replace("/", "-"));

            if (!commentDate.isBefore(LocalDate.parse(startDate)) && !commentDate.isAfter(LocalDate.parse(endDate))) {
                rows.add(new String[]{eachLineValues[0], eachLineValues[1], eachLineValues[2], eachLineValues[3]}); 

                if (eachLineValues[1].startsWith("D")) custToDoctor++;
                else if (eachLineValues[1].startsWith("S")) custToStaff++;
                totalReceived++;
            }
        }

        String[] reportValues = {String.valueOf(doctorToCust),
                                 String.valueOf(custToDoctor),
                                 String.valueOf(custToStaff),
                                 String.valueOf(totalReceived)};

        return new ReportDetails(rows, reportValues);
    }
}
