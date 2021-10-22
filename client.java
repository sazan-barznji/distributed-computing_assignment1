package se450_assignment;
import java.net.*;
import java.io.*;

public class client {

	public static void main(String[] args) {
		try{
			Socket s= new Socket ("127.0.0.1",4321);
			 InputStream in= s.getInputStream();
			 OutputStream out= s.getOutputStream();
			 
			 DataInputStream din= new  DataInputStream(in);
			 DataOutputStream dout= new  DataOutputStream(out);
			
			 dout.writeUTF(" hello this is assignment 1 of distrbuted computing. ");
			
			
			
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
