import java.io.*;
import java.net.*;

public class ServerO {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(4444);
            Socket s = ss.accept();// establishes connection
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = (String) dis.readUTF();

            int numberOfVowls = vowelcounter(str);
            System.out.println("Number Of Vowel o = " + numberOfVowls);
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
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