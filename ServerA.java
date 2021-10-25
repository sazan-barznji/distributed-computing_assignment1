//package se450_assignment;
import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.List;

public class ServerA {
    public static void main(String[] args) {
        try {
            int counter = 1;

            List<InetAddress> clients = new LinkedList<InetAddress>();

            // When a client connects, check the list, if the ip is availble.
            // if the ip is not avilable, then add the ip to the linked list, and run the vowls
            // else if it is available in the list, then run the word counting function, and remove the ip in the list

            ServerSocket ss = new ServerSocket(8080);
            while(true){
                Socket s = ss.accept();// establishes connection
                InetAddress ipAddress = s.getLocalAddress();
                clients.add(ipAddress);

                

                System.out.println("A proxy Node connected");
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = (String) dis.readUTF();
    
                int numberOfVowls = vowelcounter(str);
                System.out.println("Number Of Vowel a = " + numberOfVowls);
    
                 DataOutputStream dout= new DataOutputStream (s.getOutputStream());
                 dout.writeInt(numberOfVowls);
    
                int numberOfWords= countWordsInSentence(str);
                dout.writeInt(numberOfWords);
    
                ss.close();
            }
            
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int vowelcounter (String str) {
		int count=0;
		for (int i=0; i<str.length();i++) {
			if (str.charAt(i)=='a') {
				count++;
			}
		}
	
		return count;
    }
    private static int countWordsInSentence(String input) {
        int wordCount = 0;
    
        if (input.trim().equals("")) {
            return wordCount;
        }
        else {
            wordCount = 1;
        }
    
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            String str = new String("" + ch);
            if (i+1 != input.length() && str.equals(" ") && !(""+ input.charAt(i+1)).equals(" ")) {
                wordCount++;
            }
        }
    
        return wordCount;
    }
}