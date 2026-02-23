package assignment;

public class MedicalRecord {
    private String recordID;
    private String appointmentID;
    private String doctorID;
    private String consultation;
    private String medication;

    public MedicalRecord(String recordID, String appointmentID, String doctorID,
                         String consultation, String medication) {
        this.recordID = recordID;
        this.appointmentID = appointmentID;
        this.doctorID = doctorID;
        this.consultation = consultation;
        this.medication = medication;
    }

    public String getConsultation() { return consultation; }
}
