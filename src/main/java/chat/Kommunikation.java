package chat;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.*;
import java.time.Instant;

/**
 * Klasse für die Kommunikation in einem Chat
 */
public class Kommunikation {
	/**
	 * sendet eine Nachricht an den Partner
	 * @param out OutputStream, der zum Chatpartner führt
	 * @param text zu sendende Nachricht
	 */
	public static void nachrichtSenden(OutputStream out, String text, String absender) throws IOException {
		ObjectOutputStream oout = new ObjectOutputStream(out);
		Instant time = Instant.from(Instant.now());

		Nachricht nachricht = new Nachricht(text, absender, time);
		oout.writeObject(nachricht);
	}
	
	/**
	 * empfängt eine Nachricht vom Partner (blockierend)
	 * @param in dem InputStream vom Chatpartner
	 * @return empfangene Nachricht
	 */
	public static Nachricht nachrichtEmpfangen(InputStream in) throws IOException, ClassNotFoundException {
		ObjectInputStream oin = new ObjectInputStream(in);
		return (Nachricht) oin.readObject();
	}
}
