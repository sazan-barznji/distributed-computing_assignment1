
//package se450_assignment;
import java.net.*;
import java.io.*;

public class newProxy {
	public static void main(String[] args) throws IOException {
		try {
			ServerSocket server = new ServerSocket(9999);
			while (true) {
				Socket c2p = server.accept();
				System.out.println("A client connected to the Proxy");
				Socket p2serverA = new Socket("127.0.0.1", 1111);
				Socket p2serverE = new Socket("127.0.0.1", 2222);
				Socket p2serverI = new Socket("127.0.0.1", 3333);
				Socket p2serverO = new Socket("127.0.0.1", 4444);
				Socket p2serverU = new Socket("127.0.0.1", 5555);

				Thread clientThread = new Thread(new Runnable() {
					public void run() {
						try {
							final DataInputStream c2pIn = new DataInputStream(c2p.getInputStream());
							final DataOutputStream c2pOut = new DataOutputStream(c2p.getOutputStream());

							ServersInfo ServerOneInfo = new ServersInfo(p2serverA);

							ServersInfo ServerTwoInfo = new ServersInfo(p2serverE);
							ServersInfo ServerThreeInfo = new ServersInfo(p2serverI);
							ServersInfo ServerFourInfo = new ServersInfo(p2serverO);
							ServersInfo ServerFiveInfo = new ServersInfo(p2serverU);

							// final DataInputStream p2serverAIn = new
							// DataInputStream(p2serverA.getInputStream()) ;
							// final DataOutputStream p2serverAOut =new
							// DataOutputStream(p2serverA.getOutputStream()) ;

							// final DataInputStream p2serverEIn = new
							// DataInputStream(p2serverE.getInputStream());
							// final DataOutputStream p2serverEOut =new
							// DataOutputStream(p2serverE.getOutputStream());

							// Thread t1 = new Thread(new Runnable(){
							// public void run(){
							// String b;
							// try{
							// while( (b=c2pIn.readLine()) != null ){

							// ServerOneInfo.doWrite().writeUTF(b);
							// ServerOneInfo.doWrite().flush();

							// ServerTwoInfo.doWrite().writeUTF(b);
							// ServerTwoInfo.doWrite().flush();

							// ServerThreeInfo.doWrite().writeUTF(b);
							// ServerThreeInfo.doWrite().flush();

							// ServerFourInfo.doWrite().writeUTF(b);
							// ServerFourInfo.doWrite().flush();

							// ServerFiveInfo.doWrite().writeUTF(b);
							// ServerFiveInfo.doWrite().flush();

							// }
							// }catch(Exception ex){
							// ex.printStackTrace();
							// }
							// }
							// });
							// t1.start();

							// Thread t2 = new Thread(new Runnable(){
							// public void run(){
							// String b;
							// try{
							// while( (b=ServerOneInfo.doRead().readLine()) != null ){
							// c2pOut.writeUTF(b);
							// c2pOut.flush();

							// }

							// }catch(Exception ex){
							// ex.printStackTrace();
							// }
							// }
							// });
							// t2.start();

							Thread t1 = new Thread(new Runnable() {
								public void run() {
									String b = "";
									try {
										while ((b = c2pIn.readUTF()) != null) {

											ServerOneInfo.doWrite().writeUTF(b);
											ServerOneInfo.doWrite().flush();
										}
									} catch (Exception ex) {
										ex.printStackTrace();
									}

									try {
										while ((b = ServerOneInfo.doRead().readUTF()) != null) {
											c2pOut.writeUTF(b);
											c2pOut.flush();
										}

									} catch (Exception ex) {
										ex.printStackTrace();
									}

									// spliting occurs here which the sting is b
									String theText = spiltText(b,1);
									try {
										ServerOneInfo.doWrite().writeUTF(theText);
									} catch (IOException e) {
										e.printStackTrace();
									}
									// send the part one to serverA
									// get the request again, and send back to the client

								}
							});
							t1.start();
							Thread t2 = new Thread(new Runnable() {
								public void run() {
									String b = "";
									try {
										while ((b = c2pIn.readUTF()) != null) {

											ServerTwoInfo.doWrite().writeUTF(b);
											ServerTwoInfo.doWrite().flush();
										}
									} catch (Exception ex) {
										ex.printStackTrace();
									}

									try {
										while ((b = ServerTwoInfo.doRead().readUTF()) != null) {
											c2pOut.writeUTF(b);
											c2pOut.flush();
										}

									} catch (Exception ex) {
										ex.printStackTrace();
									}

									String theText = spiltText(b,2);
									try {
										ServerTwoInfo.doWrite().writeUTF(theText);
									} catch (IOException e) {
										e.printStackTrace();
									}

								}
							});
							t2.start();
							Thread t3 = new Thread(new Runnable() {
								public void run() {
									String b = "";
									try {
										while ((b = c2pIn.readUTF()) != null) {

											ServerThreeInfo.doWrite().writeUTF(b);
											ServerThreeInfo.doWrite().flush();
										}
									} catch (Exception ex) {
										ex.printStackTrace();
									}

									try {
										while ((b = ServerThreeInfo.doRead().readUTF()) != null) {
											c2pOut.writeUTF(b);
											c2pOut.flush();
										}

									} catch (Exception ex) {
										ex.printStackTrace();
									}

									String theText = spiltText(b,3);
									try {
										ServerThreeInfo.doWrite().writeUTF(theText);
									} catch (IOException e) {
										e.printStackTrace();
									}

								}
							});
							t3.start();
							Thread t4 = new Thread(new Runnable() {
								public void run() {
									String b = "";
									try {
										while ((b = c2pIn.readUTF()) != null) {

											ServerFourInfo.doWrite().writeUTF(b);
											ServerFourInfo.doWrite().flush();
										}
									} catch (Exception ex) {
										ex.printStackTrace();
									}

									try {
										while ((b = ServerFourInfo.doRead().readUTF()) != null) {
											c2pOut.writeUTF(b);
											c2pOut.flush();
										}

									} catch (Exception ex) {
										ex.printStackTrace();
									}

									String theText = spiltText(b,4);
									try {
										ServerFourInfo.doWrite().writeUTF(theText);
									} catch (IOException e) {
										e.printStackTrace();
									}

								}
							});
							t4.start();
							Thread t5 = new Thread(new Runnable() {
								public void run() {
									String b = "";
									try {
										while ((b = c2pIn.readUTF()) != null) {

											ServerFiveInfo.doWrite().writeUTF(b);
											ServerFiveInfo.doWrite().flush();
										}
									} catch (Exception ex) {
										ex.printStackTrace();
									}

									try {
										while ((b = ServerFiveInfo.doRead().readUTF()) != null) {
											c2pOut.writeUTF(b);
											c2pOut.flush();
										}

									} catch (Exception ex) {
										ex.printStackTrace();
									}

									String theText = spiltText(b,5);
									try {
										ServerFiveInfo.doWrite().writeUTF(theText);
									} catch (IOException e) {
										e.printStackTrace();
									}

								}
							});
							t5.start();

						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}

				});
				clientThread.start();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String spiltText(String theText, int Server) {

		int stringLength = theText.length();

		int partPerServer = stringLength / 5;

		boolean hasReminder = false;
		int theReminder = 0;

		String partOne;
		String partTwo;
		String partThree;
		String partFour;
		String partFive;

		// System.out.println("Total Length: " + stringLength);
		// System.out.println("each part " + partPerServer);

		if (stringLength % 5 != 0) {
			hasReminder = true;
			theReminder = stringLength % 5;
		}

		// System.out.println("total each part " + ((partPerServer * 5) + theReminder));

		partOne = theText.substring(0, partPerServer);

		partTwo = theText.substring(partPerServer, (partPerServer * 2));

		partThree = theText.substring((partPerServer * 2), (partPerServer * 3));

		partFour = theText.substring((partPerServer * 3), (partPerServer * 4));

		if (hasReminder) {
			partFive = theText.substring((partPerServer * 4), ((partPerServer * 5) + theReminder));
		} else {
			partFive = theText.substring((partPerServer * 4), (partPerServer * 5));
		}

		if (Server == 1) {
			return partOne;
		} else if (Server == 2) {
			return partTwo;
		} else if (Server == 3) {
			return partThree;
		} else if (Server == 4) {
			return partFour;
		} else {
			return partFive;
		}

	}
}
