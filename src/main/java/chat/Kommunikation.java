package chat;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Klasse für die Kommunikation in einem Chat
 */
public class Kommunikation {
	/**
	 * sendet eine Nachricht an den Partner
	 * @param out OutputStream, der zum Chatpartner führt
	 * @param text zu sendende Nachricht
	 */
	public static void nachrichtSenden(OutputStream out, String text)
	{
		
	}
	
	/**
	 * empfängt eine Nachricht vom Partner (blockierend)
	 * @param in dem InputStream vom Chatpartner
	 * @return empfangene Nachricht
	 */
	public static String nachrichtEmpfangen(InputStream in)
	{
		return null;
	}
}
