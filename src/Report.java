package assignment;

public class Report {   // container
    private String companyName;        
    private String companyLocation;   
    private String reportCreatedOn; 
    private int reportID;             
    private String startDate;    
    private String endDate;     

    private ReportDetails appointmentReport;
    private ReportDetails doctorReport;
    private ReportDetails revenueReport;
    private ReportDetails feedbackReport;

    public Report(String companyName, String companyLocation, String reportCreatedOn,
                  int reportID, String startDate, String endDate,
                  ReportDetails appointmentReport,
                  ReportDetails doctorReport,
                  ReportDetails revenueReport,
                  ReportDetails feedbackReport) {
        this.companyName = companyName;
        this.companyLocation = companyLocation;
        this.reportCreatedOn = reportCreatedOn;
        this.reportID = reportID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.appointmentReport = appointmentReport;
        this.doctorReport = doctorReport;
        this.revenueReport = revenueReport;
        this.feedbackReport = feedbackReport;
    }

    public String getCompanyName() { 
        return companyName; 
    }
    
    public void setCompanyName(String companyName) { 
        this.companyName = companyName; 
    }

    public String getCompanyLocation() { 
        return companyLocation; 
    }
    
    public void setCompanyLocation(String companyLocation) { 
        this.companyLocation = companyLocation; 
    }

    public String getReportCreatedOn() { 
        return reportCreatedOn; 
    }
    
    public void setReportCreatedOn(String reportCreatedOn) { 
        this.reportCreatedOn = reportCreatedOn; 
    }

    public int getReportID() { 
        return reportID; 
    }
    
    public void setReportID(int reportID) { 
        this.reportID = reportID; 
    }

    public String getStartDate() { 
        return startDate; 
    }
    
    public void setStartDate(String startDate) { 
        this.startDate = startDate; 
    }

    public String getEndDate() { 
        return endDate; 
    }
    
    public void setEndDate(String endDate) { 
        this.endDate = endDate; 
    }

    public ReportDetails getAppointmentReport() { 
        return appointmentReport; 
    }
    
    public void setAppointmentReport(ReportDetails appointmentReport) { 
        this.appointmentReport = appointmentReport; 
    }

    public ReportDetails getDoctorReport() { 
        return doctorReport; 
    }
    
    public void setDoctorReport(ReportDetails doctorReport) { 
        this.doctorReport = doctorReport; 
    }

    public ReportDetails getRevenueReport() { 
        return revenueReport; 
    }
    
    public void setRevenueReport(ReportDetails revenueReport) { 
        this.revenueReport = revenueReport; 
    }

    public ReportDetails getFeedbackReport() { 
        return feedbackReport; 
    }
    
    public void setFeedbackReport(ReportDetails feedbackReport) { 
        this.feedbackReport = feedbackReport; 
    }

    @Override
    public String toString() {
        return "Analyzed Report\n" +
               "Company Name: " + companyName + "\n" +
               "Company Location: " + companyLocation + "\n" +
               "Report Created On: " + reportCreatedOn + "\n" +
               "Report ID: " + reportID + "\n" +
               "Start Date: " + startDate + "\n" +
               "End Date: " + endDate + "\n" +
               "Appointment Rows: " + (appointmentReport != null ? appointmentReport.getRows().size() : 0) + "\n" +
               "Doctor Rows: " + (doctorReport != null ? doctorReport.getRows().size() : 0) + "\n" +
               "Revenue Rows: " + (revenueReport != null ? revenueReport.getRows().size() : 0) + "\n" +
               "Feedback Rows: " + (feedbackReport != null ? feedbackReport.getRows().size() : 0);
    }
}
