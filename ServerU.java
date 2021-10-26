
//package se450_assignment;
import java.io.*;
import java.net.*;

public class ServerU {
    public static void main(String[] args) throws IOException {

       
        try {
            ServerSocket ss = new ServerSocket(5555);
            while(true){
                Socket s = ss.accept();
                
                
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dout= new DataOutputStream (s.getOutputStream());
                String str = (String) dis.readUTF();
                

                Thread vowlCountingThread = new Thread(new Runnable() {
					public void run() {
                        int numberOfVowls = vowelcounter(str);
                        try {
                            dout.writeInt(numberOfVowls);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                vowlCountingThread.start();

                Thread wordCountingThread = new Thread(new Runnable() {
                    SplitText splitTextObject = new SplitText();

                    String thePart = splitTextObject.spiltText(str, 5);

					public void run() {
                        int numberOfWords= countWordsInSentence(thePart);
                        try {
                            dout.writeInt(numberOfWords);
                        } catch (IOException e) {
                            
                            e.printStackTrace();
                        }
                    }
                });
                wordCountingThread.start();
                ss.close();
            }
            
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int vowelcounter (String str) {
		int count=0;
		for (int i=0; i<str.length();i++) {
			if (str.charAt(i)=='u') {
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