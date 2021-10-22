import java.net.*;
import java.io.*;

public class ProxyNode
{
	public static void main(String[] args) {
		try{
			ServerSocket server = new ServerSocket(3333);
			while(true){
				Socket c2p = server.accept();
				Socket p2s = new Socket("127.0.0.1", 4444);

				Thread clientThread = new Thread(new Runnable (){
						public void run(){
							try {
								final DataInputStream c2pIn = new DataInputStream(c2p.getInputStream()) ;
                                final DataOutputStream c2pOut = new DataOutputStream(c2p.getOutputStream()) ;
                                
								final DataInputStream p2sIn = new DataInputStream(p2s.getInputStream()) ;
								final DataOutputStream p2sOut =new DataOutputStream(p2s.getOutputStream()) ;

								Thread t1 = new Thread(new Runnable(){
										public void run(){
											String b;
											try{
												while( (b=c2pIn.readLine()) != null ){
													p2sOut.writeUTF(b);
													p2sOut.flush();
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
												while( (b=p2sIn.readLine()) != null ){
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
