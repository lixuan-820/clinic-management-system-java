package assignment;

import java.util.List;

public class AutoGenerateID {
    private FileHandler[] fileHandles;
    private String firstLetter;
    
    public AutoGenerateID(FileHandler fileHandle, String firstLetter) {
        this.fileHandles = new FileHandler[]{fileHandle};
        this.firstLetter = firstLetter;
    }

    public AutoGenerateID(String firstLetter, FileHandler... fileHandles) {
        this.fileHandles = fileHandles;
        this.firstLetter = firstLetter;
    }

    private int getLastNum() {
        int lastNumber = 0;

        for (FileHandler fileHandle : fileHandles) {
            List<String> lines = fileHandle.readFile();

            for (String line : lines) {
                if (line == null || line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(";");
                if (parts.length > 0) {
                    String id = parts[0].trim();
                    if (id.startsWith(firstLetter)) {
                        try {
                            int num = Integer.parseInt(id.substring(firstLetter.length()));
                            if (num > lastNumber) {
                                lastNumber = num;
                            }
                        } catch (NumberFormatException e) {
                            
                        }
                    }
                }
            }
        }
        return lastNumber;
    }
    
        public String generateID(){
        int nextNumber = getLastNum() + 1;
        return String.format("%s%03d", firstLetter, nextNumber);
    }
}