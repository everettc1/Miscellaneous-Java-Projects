// Name: Corey Everett
// Date: November 1st, 2018
// Program: SMTP Mail Server
// Purpose: The purpose of this program is to contact an email server, issue a command to the server, take the response and react accordingly,
// throw an exception if unexpected return occurs.

import java.io.*;
import java.net.*;

public class SMTPServerLab6Client {

	public static void main(String[] args) throws Exception {
		   {
			      // Establish a TCP connection with the Gmail server. 
			      Socket socket = new Socket("172.217.197.26", 25);

			      // Create a BufferedReader to read a line at a time.
			      InputStream is = socket.getInputStream();
			      InputStreamReader isr = new InputStreamReader(is);
			      BufferedReader br = new BufferedReader(isr);

			      // Read greeting from the server.
			      String response = br.readLine();
			      System.out.println(response);
			      if (!response.startsWith("220")) {
			         throw new Exception("220 reply not received from server.");
			      }

			      // Get a reference to the socket's output stream.
			      OutputStream os = socket.getOutputStream();

			      // Send HELO command and get server response.
			      String command = "HELO gmail\r\n";
			      System.out.print(command);
			      os.write(command.getBytes("US-ASCII"));
			      response = br.readLine();
			      System.out.println(response);
			      if (!response.startsWith("250")) {
			         throw new Exception("250 reply not received from server.");
			      }

			      // Send MAIL FROM command.
			      command = "MAIL FROM: <ceverett9287@gmail.com>\r\n";
			      System.out.print(command);
			      os.write(command.getBytes("US-ASCII"));
			      response = br.readLine();
			      System.out.println(response);
			      if (!response.startsWith("250")) {
			         throw new Exception("250 reply not received from server.");
			      }



			      // Send RCPT TO command.
			      // Your code goes here 
			      command = "RCPT TO: <ceverett9287@gmail.com>\r\n";
			      System.out.print(command);
			      os.write(command.getBytes("US-ASCII"));
			      response = br.readLine();
			      System.out.println(response);
			      if (!response.startsWith("250")) {
			         throw new Exception("250 reply not received from server.");
			      }

			      // Send DATA command.
			      command = "DATA\r\n";
			      System.out.print(command);
			      os.write(command.getBytes("US-ASCII"));
			      response = br.readLine();
			      System.out.println(response);
			      if (!response.startsWith("354")) {
			         throw new Exception("354 reply not received from server.");
			      }
			      
			      // Send message data. 
			      command = "From: <ceverett9287@gmail.com>\r\n";  // FROM
			      System.out.print(command);
			      os.write(command.getBytes("US-ASCII"));
			      
			      command = "To: <drpham.wit@gmail.com>\r\n";   // TO
			      System.out.print(command);
			      os.write(command.getBytes("US-ASCII"));
			      
			      command = "Subject: Corey Everett Lab 6\r\n";  // SUBJECT
			      System.out.print(command);
			      os.write(command.getBytes("US-ASCII"));
			      
			      command = "Hello yes I am emailing you I'm sorry if I spam anything. - Corey Everett\r\n";   // BODY
			      System.out.print(command);
			      os.write(command.getBytes("US-ASCII"));
			      

			      // End with line with a single period.
			      command = ".\r\n";
			      System.out.print(command);
			      os.write(command.getBytes("US-ASCII"));
			      response = br.readLine();
			      System.out.println(response);
			      
			      // Send QUIT command.
			      command = "QUIT\r\n";
			      System.out.print(command);
			      os.write(command.getBytes("US-ASCII"));
			      response = br.readLine();
			      System.out.println(response);
			      if (!response.startsWith("221")) {
			         throw new Exception("221 reply not received from server.");
			      }
		   }
	}
}
