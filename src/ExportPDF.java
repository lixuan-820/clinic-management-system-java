
package assignment;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;
import java.io.IOException;
import javax.swing.*;

public class ExportPDF {
    
    public Table createTable(JTable jTable) {
        try {
            int columnCount = jTable.getColumnCount();
            float columnWidths[] = new float[columnCount];
            Table table = new Table(UnitValue.createPercentArray(columnWidths));
            table.useAllAvailableWidth();

            // add table header
            for (int i = 0; i < columnCount; i++) {
                table.addCell(jTable.getColumnName(i));
            }

            // add table data
            for (int row = 0; row < jTable.getRowCount(); row++) {
                for (int col = 0; col < columnCount; col++) {
                    table.addCell(String.valueOf(jTable.getValueAt(row, col)));
                }
            }

            return table;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error creating table: " + ex.getMessage());
            return null;
        }
    }
        
    public void ExportPDF(String startDate, String endDate, JTable tables[], String tableTitles[], String companyName, String companyLocation, String reportID, String reportCreated,
                                 String completedAppointments, String cancelledAppointments, String totalAppointments, String averageAppointments, 
                                 String busiestDoctor, String numOfPatients, String averageConsultations,
                                 String cashTotal, String cardTotal, String tngTotal, String onlineBankingTotal, String totalRevenue, 
                                 String doctorToCust, String custToDoctor, String custToStaff, String totalReceived) {
    
        Document document = null;
        Paragraph lineSpace = new Paragraph("\n");
        
        try {

            String fileName = "Analyzed Report" + "_" + startDate.replace("-", "") + "-" + endDate.replace("-", "") + ".pdf";
            String desktop = "D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data";

            PdfWriter pw = new PdfWriter(desktop + "\\" + fileName);
            PdfDocument doc = new PdfDocument(pw);
            document = new Document(doc);

            Paragraph title = new Paragraph("Analyzed Report");
            title.setBold();
            title.setFontSize(18);
            document.add(title);
            document.add(lineSpace);

            Paragraph ReportCreated = new Paragraph("Report Created on: " + reportCreated);
            document.add(ReportCreated);
            Paragraph ReportID = new Paragraph("Report ID: " + reportID);
            document.add(ReportID);
            Paragraph CompanyName = new Paragraph("Company Name: " + companyName);
            document.add(CompanyName);
            Paragraph CompanyLocation = new Paragraph("Company Location: " + companyLocation);
            document.add(CompanyLocation);
            Paragraph date = new Paragraph("From: " + startDate.replace("-", "/") + "       To: " + endDate.replace("-", "/"));
            document.add(date);
            document.add(lineSpace);
            
            // Apointment Details 
            Paragraph titleAppointment = new Paragraph(tableTitles[0]);
            titleAppointment.setBold();
            document.add(titleAppointment);
            Table table = createTable(tables[0]);
            document.add(table);
            document.add(new Paragraph("Completed Appointments: " + completedAppointments));
            document.add(new Paragraph("Cancelled Appointments: " + cancelledAppointments));
            document.add(new Paragraph("Total Appointments: " + totalAppointments));
            document.add(new Paragraph("Average Appointments Per Day: " + averageAppointments));
            document.add(lineSpace);
            
            Paragraph titleDoctor = new Paragraph(tableTitles[1]);
            titleDoctor.setBold();
            document.add(titleDoctor);
            Table table1 = createTable(tables[1]);
            document.add(table1);
            document.add(new Paragraph("Busiest Doctor: " + busiestDoctor + " -- " + numOfPatients + " patient(s)"));
            document.add(new Paragraph("Average Consultations Per Doctor: " + averageConsultations));
            document.add(lineSpace);
            
            // Payment Details
            Paragraph titlePayment = new Paragraph(tableTitles[2]);
            titlePayment.setBold();
            document.add(titlePayment);
            Table table2 = createTable(tables[2]);
            document.add(table2);
            document.add(new Paragraph("Payment Method Breakdown").setBold());
            document.add(new Paragraph("Cash Total (RM): " + cashTotal));
            document.add(new Paragraph("Debit/Credit Card Total (RM): " + cardTotal));
            document.add(new Paragraph("E-wallet (TNG) Total (RM): " + tngTotal));
            document.add(new Paragraph("Online Banking Total (RM): " + onlineBankingTotal));
            document.add(new Paragraph("Overall").setBold());
            document.add(new Paragraph("Total Revenue (RM): " + totalRevenue));
            document.add(lineSpace);
        
            // Feedback Details
            Paragraph titleFeedback = new Paragraph(tableTitles[3]);
            titleFeedback.setBold();
            document.add(titleFeedback);
            Table table3 = createTable(tables[3]);
            document.add(table3);
            document.add(new Paragraph("Total Comments from Customers to Doctors: " + custToDoctor));
            document.add(new Paragraph("Total Comments from Customers to Staff: " + custToStaff));
            document.add(new Paragraph("Total Feedback from Doctors to Customers: " + doctorToCust));
            document.add(new Paragraph("Total Feedback & Comments Received: " + totalReceived));
            
            document.close();
            JOptionPane.showMessageDialog(null,"Analyzed Report PDF exported successfully!");
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error exporting PDF: " + ex.getMessage());
        }
    }
}
