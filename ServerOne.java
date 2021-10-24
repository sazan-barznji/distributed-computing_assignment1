//package se450_assignment;
import java.io.*;
import java.net.*;


public class ServerOne{

    public static void main(String[] args) {
		int port= 4444; 
		try {
			ServerSocket conn= new ServerSocket(port);
			while (1==1) {
				Socket s= conn.accept();
				System.out.println("client is connected");
				
				// Thread t= new Thread();
				// t.start();
				
				DataInputStream  input = new DataInputStream(s.getInputStream());
				DataOutputStream out= new DataOutputStream(s.getOutputStream());
				
				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
	            String clientpara = inFromClient.readLine();	           
				System.out.println("Received: " + clientpara);
				int count=vowelcounter(clientpara);
				out.writeInt(count);
			
				
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}
	public static int vowelcounter (String str) {
		int count=0;
		for (int i=0; i<str.length();i++) {
			if (str.charAt(i)=='o') {
				count++;
			}
		}
	
		return count;
	}

}