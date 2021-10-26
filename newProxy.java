
//package se450_assignment;
import java.net.*;
import java.io.*;

public class newProxy {
	public static void main(String[] args) throws IOException {
		try {
			ServerSocket server = new ServerSocket(1234);
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

							Thread t1 = new Thread(new Runnable() {
								public void run() {
									String b = "";
									try {
										while ((b = c2pIn.readUTF()) != null) {

											ServerOneInfo.doWrite().writeUTF(b);
											ServerOneInfo.doWrite().flush();
										}
									} catch (Exception ex) {

										try {
											Thread.sleep(4000);
										} catch (Exception e) {
											System.out.println(e.getMessage());
										}
										System.out.println(ex.getMessage());

									}

									try {
										while ((b = ServerOneInfo.doRead().readUTF()) != null) {
											c2pOut.writeUTF(b);
											c2pOut.flush();
										}

									} catch (Exception ex) {
										ex.printStackTrace();
									}

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
										try {
											Thread.sleep(4000);
										} catch (Exception e) {
											System.out.println(e.getMessage());
										}
										System.out.println(ex.getMessage());
									}

									try {
										while ((b = ServerTwoInfo.doRead().readUTF()) != null) {
											c2pOut.writeUTF(b);
											c2pOut.flush();
										}

									} catch (Exception ex) {
										ex.printStackTrace();
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
										try {
											Thread.sleep(4000);
										} catch (Exception e) {
											System.out.println(e.getMessage());
										}
										System.out.println(ex.getMessage());
									}

									try {
										while ((b = ServerThreeInfo.doRead().readUTF()) != null) {
											c2pOut.writeUTF(b);
											c2pOut.flush();
										}

									} catch (Exception ex) {
										ex.printStackTrace();
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
										try {
											Thread.sleep(4000);
										} catch (Exception e) {
											System.out.println(e.getMessage());
										}
										System.out.println(ex.getMessage());
									}

									try {
										while ((b = ServerFourInfo.doRead().readUTF()) != null) {
											c2pOut.writeUTF(b);
											c2pOut.flush();
										}

									} catch (Exception ex) {
										ex.printStackTrace();
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
										try {
											Thread.sleep(4000);
										} catch (Exception e) {
											System.out.println(e.getMessage());
										}
										System.out.println(ex.getMessage());
									}

									try {
										while ((b = ServerFiveInfo.doRead().readUTF()) != null) {
											c2pOut.writeUTF(b);
											c2pOut.flush();
										}

									} catch (Exception ex) {
										ex.printStackTrace();
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

}
