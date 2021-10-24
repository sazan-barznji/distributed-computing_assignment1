//package se450_assignment;
import java.io.*;
import java.net.*;


public class Client {
    public static void main(String[] args) {
		try{
			 Socket s= new Socket ("127.0.0.1",9999);
			 InputStream in= s.getInputStream();
			 OutputStream out= s.getOutputStream();
			 
			 DataInputStream din= new  DataInputStream(in);
			 DataOutputStream dout= new  DataOutputStream(out);
			
			 dout.writeUTF("hello this is assignment 1 of distrbuted computing.");
			
			
			 BufferedReader inFromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
	            int num= inFromClient.read();
	            System.out.println("this is the number of vowels"+num);
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		

	}
    
}
