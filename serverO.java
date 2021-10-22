package se450_assignment;

import java.net.*;
import java.io.*;

public class serverO {

	public static void main(String[] args) {
		int port= 4321; 
		try {
			ServerSocket conn= new ServerSocket(port);
			while (1==1) {
				Socket s= conn.accept();
				System.out.println("client is connected");
				
				Thread t= new Thread();
				t.start();
				
				DataInputStream  input = new DataInputStream(s.getInputStream());
				DataOutputStream out= new DataOutputStream(s.getOutputStream());
				
				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
	            String clientpara = inFromClient.readLine();	           
				System.out.println("Received: " + clientpara);
				
				
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
