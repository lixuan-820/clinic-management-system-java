package assignment;

import java.time.*;
import javax.swing.JOptionPane;

public class DateValidation {
    public static boolean isValidDate(int year, int month, int day) {
        try {
            LocalDate.of(year, month, day); 
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    public static boolean isFutureDate(int year, int month, int day) {
        LocalDate selected = LocalDate.of(year, month, day);
        return selected.isAfter(LocalDate.now());
    }
    
    public static boolean reportDate(String startDate, String endDate) {
        String[] date1 = startDate.split("-");
        String[] date2 = endDate.split("-");

        int Year1 = Integer.parseInt(date1[0]);
        int Month1 = Integer.parseInt(date1[1]);
        int Day1 = Integer.parseInt(date1[2]);
        
        int Year2 = Integer.parseInt(date2[0]);
        int Month2 = Integer.parseInt(date2[1]);
        int Day2 = Integer.parseInt(date2[2]);
                
        if (!DateValidation.isValidDate(Year1, Month1, Day1)) {
            JOptionPane.showMessageDialog(null, "Invalid start date selected! Please choose a valid date.");
            return false;
        }

        if (LocalDate.of(Year1, Month1, Day1).isAfter(LocalDate.now())) {
            JOptionPane.showMessageDialog(null, "The start date of report cannot be in the future!");
            return false;
        }

        if (!DateValidation.isValidDate(Year2, Month2, Day2)) {
            JOptionPane.showMessageDialog(null, "Invalid end date selected! Please choose a valid date.");
            return false;
        }

        if (LocalDate.of(Year2, Month2, Day2).isAfter(LocalDate.now())) {
            JOptionPane.showMessageDialog(null, "The end date of report cannot be in the future!");
            return false;
        }

        if (!LocalDate.of(Year1, Month1, Day1).isBefore(LocalDate.of(Year2, Month2, Day2)) && !LocalDate.of(Year1, Month1, Day1).isEqual(LocalDate.of(Year2, Month2, Day2))) {
            JOptionPane.showMessageDialog(null, "The start date must before or same with the end date!");
            return false;
        }
        
        return true;
    }
}
