import java.io.*;
import java.net.*;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.util.*;

public class CustomeClient {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a path of a PDF file ");
		String path = input.nextLine();
		
		//Loading an existing document
	      File file = new File(path);
	      PDDocument document = Loader.loadPDF(file);
	      //Instantiate PDFTextStripper class
	      PDFTextStripper pdfStripper = new PDFTextStripper();
	      //Retrieving text from PDF document
	      String text = pdfStripper.getText(document);
	      //System.out.println(text);
	     
	      //Closing the document
	      document.close();
          try {
            Socket s = new Socket("127.0.0.1", 1234);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());
            dout.writeUTF(text);
            dout.flush();           
            dout.close();
            s.close();
            
            int b;
            while ((b = din.readInt()) != 0) {
                System.out.println(b);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

	}

}
//https://pdfbox.apache.org/download.html