package assignment;

import java.util.List;

public abstract class User {
    private String id;
    private String fullName;
    private String ic;
    private String email;
    private String dob;
    private String gender;
    private String phoneNumber;
    private String nationality;
    
    public User() {}

    public User(String id, String fullName, String ic, String email, String dob,
                String gender, String phoneNumber, String nationality) {
        this.id = id;
        this.fullName = fullName;
        this.ic = ic;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public String toString() {
        return id + "," + fullName + "," + ic + "," + email + "," +
               dob + "," + gender + "," + phoneNumber + "," + nationality;
    }
    
    public static boolean checkLogin(String user_ID, String password) {
        FileHandler passwordFile = new FileHandler("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\password.txt");
        List<String> lines = passwordFile.readFile();

        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length == 2) {
                String fileID = parts[0];
                String filePassword = parts[1];

                if (fileID.equals(user_ID) && filePassword.equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}

