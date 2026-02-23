package assignment;

public class PriceList {
    
    public static double getConsultationPrice(String consultation) {
        switch (consultation) {
            case "General Checkup": return 50.0;
            case "Specialist Visit": return 100.0;
            case "Emergency": return 150.0;
            case "Follow Up": return 60.0;
            default: return 0.0;
        }
    }

    public static double getMedicationPrice(String medication) {
        switch (medication) {
            case "Paracetamol": return 10.0;
            case "Insulin": return 80.0;
            case "Antibiotics": return 30.0;
            case "Cough Syrup": return 20.0;
            case "Painkillers": return 25.0;
            case "Antihistamine": return 15.0;
            case "Vitamins": return 12.0;
            case "Steroids": return 60.0;
            default: return 0.0;
        }
    }
    
    private String normalizeConsultation(String s) {
    if (s == null) return "General Checkup";
    switch (s) {
        case "Item 1": return "General Checkup";
        case "Item 2": return "Specialist Visit";
        case "Item 3": return "Emergency";
        default:       return s;
    }
}
}
