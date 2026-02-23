package assignment;

public class DoctorAvailability {
    private String doctorID, doctorName, gender, date, availableSlots;
    
    public DoctorAvailability(String doctorID, String doctorName, String gender, String date, String availableSlots) {
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.gender = gender;
        this.date = date;
        this.availableSlots = availableSlots;
    }

    public String getDoctorID() { return doctorID; }
    public String getDoctorName() { return doctorName; }
    public String getGender() { return gender; }
    public String getDate() { return date; }
    public String getAvailableSlots() { return availableSlots; }

    @Override
    public String toString() {
        return doctorID + " " + date + " " + availableSlots;
    }
}
