package chat;

import java.io.*;
import java.time.Instant;

public class Nachricht implements Serializable {
    private String text;
    private String absender;
    private Instant zeitstempel;

    public Nachricht(String text, String absender, Instant zeitstempel) {
        this.text = text;
        this.absender = absender;
        this.zeitstempel = zeitstempel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAbsender() {
        return absender;
    }

    public void setAbsender(String absender) {
        this.absender = absender;
    }

    public Instant getZeitstempel() {
        return zeitstempel;
    }

    public void setZeitstempel(Instant zeitstempel) {
        this.zeitstempel = zeitstempel;
    }

    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        DataOutputStream dout = new DataOutputStream(out);
        dout.writeUTF(text);
        dout.writeUTF(absender);
        dout.writeUTF(zeitstempel.toString());
    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        DataInputStream din = new DataInputStream(in);
        this.text = din.readUTF();
        this.absender = din.readUTF();
        this.zeitstempel = Instant.parse(din.readUTF());
    }

    public String toString() {
        return "Text: " + text + "\n" +
                "Absender: " + absender + "\n" +
                "Zeitstempel: " + zeitstempel;
    }
}
