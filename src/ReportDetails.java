package assignment;

import java.util.List;

public class ReportDetails {
    private List<String[]> rows;
    private String[] reportValues;

    public ReportDetails(List<String[]> rows, String[] reportValues) {
        this.rows = rows;
        this.reportValues = reportValues;
    }

    public void setRows(List<String[]> rows) {
        this.rows = rows;
    }
    
    public List<String[]> getRows() {
        return rows;
    }

    public String[] getReportValues() {
        return reportValues;
    }

    public void setReportValues(String[] reportValues) {
        this.reportValues = reportValues;
    }
}