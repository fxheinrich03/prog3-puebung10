package chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static chat.Kommunikation.nachrichtEmpfangen;

/**
* Server eines ganz einfachen Chats
*/
public class Server {
	/**
	 * erstellt ein Objekt der Klasse
	 */
	public Server() {}
/**
* Port, unter dem der Server auf eingehenden Verbindungen wartet
*/
	public static int ANMELDEPORT = 7777;
/**
* startet den Server, wartet auf eingehende Verbindungen vom Client
* und chattet mit ihm
 * @throws ClassNotFoundException 
*/
	private void verbindungAnnehmenUndChatten()
	{
		ServerSocket seso = null;
		Socket so = null;
		
		try {
			seso = new ServerSocket(ANMELDEPORT);
			so = seso.accept();
		} catch (IOException e) {
				e.printStackTrace();		
		} 
			
		try
		{
			InputStream ein = so.getInputStream();		
			OutputStream aus = so.getOutputStream();

			Nachricht nachricht = nachrichtEmpfangen(ein);
			System.out.println(nachricht);

			String text = "Antwort vom Server: Hallo zurück";
			Kommunikation.nachrichtSenden(aus, text, "Server");

		}catch(IOException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
			seso.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
/**
* startet den Server
* @param args wird nicht verwendet
*/
	public static void main(String[] args)
	{
		Server server = new Server();
		server.verbindungAnnehmenUndChatten();
	}

}
