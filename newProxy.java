//package se450_assignment;
import java.net.*;
import java.io.*;

public class newProxy
{
	public static void main(String[] args) throws IOException {
		try{
			ServerSocket server = new ServerSocket(9999);
			while(true){
				Socket c2p = server.accept();
				System.out.println("A client connected to the Proxy");
				Socket p2serverA = new Socket("127.0.0.1", 1111);
				Socket p2serverE = new Socket("127.0.0.1", 2222);
				Socket p2serverI = new Socket("127.0.0.1", 3333);
				Socket p2serverO = new Socket("127.0.0.1", 4444);
				Socket p2serverU = new Socket("127.0.0.1", 5555);

				Thread clientThread = new Thread(new Runnable (){
						public void run(){
							try {
								final DataInputStream c2pIn = new DataInputStream(c2p.getInputStream()) ;
                                final DataOutputStream c2pOut = new DataOutputStream(c2p.getOutputStream()) ;

								ServersInfo ServerOneInfo = new ServersInfo(p2serverA);
								
                                
								final DataInputStream p2serverAIn = ServerOneInfo ;
								final DataOutputStream p2serverAOut =new DataOutputStream(p2serverA.getOutputStream()) ;

								final DataInputStream p2serverEIn = new DataInputStream(p2serverE.getInputStream());
								final DataOutputStream p2serverEOut =new DataOutputStream(p2serverE.getOutputStream());

								Thread t1 = new Thread(new Runnable(){
										public void run(){
											String b;
											try{
												while( (b=c2pIn.readLine()) != null ){
													p2serverAOut.writeUTF(b);
													p2serverAOut.flush();

													p2serverEOut.writeUTF(b);
													p2serverEOut.flush();


												}
											}catch(Exception ex){
												ex.printStackTrace();
											}
										}
									});
								t1.start();

								Thread t2 = new Thread(new Runnable(){
										public void run(){
											String b;
											try{
												while( (b=p2serverAIn.readLine()) != null ){
													c2pOut.writeUTF(b);
													c2pOut.flush();


												}
												
											}catch(Exception ex){
												ex.printStackTrace();
											}
										}
									});
								t2.start();

							}catch(Exception ex){
								ex.printStackTrace();
							}
						}

					});
				clientThread.start();

			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
