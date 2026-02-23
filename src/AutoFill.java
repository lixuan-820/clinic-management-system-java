package assignment;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AutoFill {
    private FileHandler fileHandler;
    
    public AutoFill(String filePath){
        this.fileHandler = new FileHandler(filePath);
    }
    
    public void applyAutoFill(String inputID, int idColumnIndex, JTextField[] fields, int[] columnMapping){
        if(inputID.isEmpty()){
            return;
        }
        
        List<String> lines = fileHandler.readFile();

        for (String line : lines) {
            String[] parts = line.split(";", -1);

            if (parts.length > idColumnIndex && parts[idColumnIndex].equalsIgnoreCase(inputID.trim())) {
                for (int i = 0; i < fields.length && i < columnMapping.length; i++) {
                    int col = columnMapping[i];
                    if(col < parts.length){
                        fields[i].setText(parts[col].trim());
                    }
                    else{
                        fields[i].setText("");
                    }
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "ID not found: " +inputID);
    }
}
