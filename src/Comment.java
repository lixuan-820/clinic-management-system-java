package assignment;

import java.io.BufferedWriter;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Comment {
    private String customerID;
    private String userID;   // Doctor/Staff ID (can be "")
    private String content;
    private String date;     // yyyy/MM/dd

    private static final Path FILE = Path.of("D:\\APU\\Y2S1\\Object Oriented Development by Java\\NetBeansProjects\\Assignment_OODJ_G38\\Assignment_final\\data\\cust_cmt.txt");
    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public Comment(String customerID, String userID, String content, String date) {
        this.customerID = nz(customerID);
        this.userID     = nz(userID);
        this.content    = clean(content);
        this.date       = nz(date);
    }

    public String getCustomerID() { return customerID; }
    public String getUserID()     { return userID; }
    public String getContent()    { return content; }
    public String getDate()       { return date; }
    
    public void setUserID(String userID)     { this.userID = nz(userID); }
    public void setContent(String content)   { this.content = clean(content); }

    private static String nz(String s) { return s == null ? "" : s; }
    private static String clean(String s) {
        if (s == null) return "";
        return s.replace(';', ',').replace("\r", " ").replace("\n", " ").trim();
    }

    private static void ensureDir() throws java.io.IOException {
        Path p = FILE.getParent();
        if (p != null) Files.createDirectories(p);
    }

    private static boolean endsWithNewline(Path file) throws java.io.IOException {
        long size = Files.size(file);
        if (size == 0) return true;
        try (SeekableByteChannel ch = Files.newByteChannel(file, StandardOpenOption.READ)) {
            ch.position(size - 1);
            ByteBuffer buf = ByteBuffer.allocate(1);
            ch.read(buf);
            byte last = buf.array()[0];
            return last == '\n' || last == '\r';
        }
    }

    private String toFileString() {
        return String.join(";", customerID, userID, content, date);
    }

    /** Create for today (yyyy/MM/dd). */
    public static Comment ofToday(String customerID, String userID, String content) {
        return new Comment(customerID, userID, content, LocalDate.now().format(DF));
    }

    /** Append one comment row (newline-safe). */
    public synchronized void save() throws java.io.IOException {
        ensureDir();

        boolean needExtraNewline = Files.exists(FILE)
                && Files.size(FILE) > 0
                && !endsWithNewline(FILE);

        try (BufferedWriter bw = Files.newBufferedWriter(
                FILE, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {

            if (needExtraNewline) {
                bw.newLine();        // ensure record boundary
            }
            bw.write(toFileString());
            bw.newLine();
        }
    }

    /** Load all comments, optionally filtered by customer ID. */
    public static List<Comment> loadAll(String filterCustomerId) {
        List<Comment> out = new ArrayList<>();
        if (!Files.exists(FILE)) return out;

        try {
            for (String line : Files.readAllLines(FILE, StandardCharsets.UTF_8)) {
                if (line == null || line.isBlank()) continue;

                // tolerate optional header
                String low = line.trim().toLowerCase();
                if (low.startsWith("customerid;")) continue;

                String[] r = line.split(";", -1);
                if (r.length < 4) continue;

                String cid  = r[0].trim();
                String uid  = r[1].trim();
                String cmt  = r[2].trim();
                String date = r[3].trim();

                if (filterCustomerId != null && !filterCustomerId.isBlank()
                        && !cid.equalsIgnoreCase(filterCustomerId)) {
                    continue;
                }
                out.add(new Comment(cid, uid, cmt, date));
            }
        } catch (Exception ignored) {}
        return out;
    }
}
