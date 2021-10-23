package se450_assignment;
import java.io.*;
import java.net.*;

public class ServerE {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2222);
            Socket s = ss.accept();// establishes connection
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = (String) dis.readUTF();

            int numberOfVowls = vowelcounter(str);
            System.out.println("Number Of Vowel E = " + numberOfVowls);
            
            DataOutputStream dout= new DataOutputStream (s.getOutputStream());
            dout.writeInt(numberOfVowls);
            
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int vowelcounter (String str) {
		int count=0;
		for (int i=0; i<str.length();i++) {
			if (str.charAt(i)=='e') {
				count++;
			}
		}
	
		return count;
	}
}